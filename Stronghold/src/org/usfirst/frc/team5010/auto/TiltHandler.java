package org.usfirst.frc.team5010.auto;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TiltHandler {
	private Accelerometer accel;
	public enum TiltState { FLOOR_LEVEL, UP_RAMP, ON_OBSTACLE, DOWN_RAMP };
	private TiltState state = TiltState.FLOOR_LEVEL;
	private final double tilted = 0.8;
	
	public TiltHandler() {
		accel = new BuiltInAccelerometer(Accelerometer.Range.k4G);
	}
	
	public double getXAxis() {
		return accel.getX();
	}
	public double getYAxis() {
		return accel.getY();
	}
	public double getZAxis() {
		return accel.getZ();
	}
	
	public void update() {
		if ( getZAxis() < tilted ) {
			switch(state) {
				case FLOOR_LEVEL: state = TiltState.UP_RAMP; break;
				case ON_OBSTACLE: state = TiltState.DOWN_RAMP; break;
			default:
				break;
			}
		} else if ( getZAxis() > tilted ) {
			switch(state) {
			case UP_RAMP: state = TiltState.ON_OBSTACLE; break;
			case DOWN_RAMP: state = TiltState.FLOOR_LEVEL; break;
			default:
				break;
			}
		}
		SmartDashboard.putString("Tilt State", state.toString());
	}
}

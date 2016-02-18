package org.usfirst.frc.team5010.boulder;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BoulderCapture {
private DoubleSolenoid arms;
private DoubleSolenoid.Value initialValue;

public BoulderCapture(){
	arms = new DoubleSolenoid(1 , 0);
	initialValue = arms.get();
	if(initialValue == DoubleSolenoid.Value.kForward){
		armState = armState.HIGH_GOAL;
	}else{
		armState = armState.CAPTURE;
	}
	arms.set(DoubleSolenoid.Value.kOff);
}

	
	
	public enum ArmState {
		CAPTURE, HIGH_GOAL
	};
	private ArmState armState = ArmState.CAPTURE;

	public void doCapture() {

	}

	public void moveDown() {
		switch (armState) {
		case CAPTURE: {
			break;

		}
		case HIGH_GOAL: {
			armState = ArmState.CAPTURE;
			arms.set(DoubleSolenoid.Value.kReverse);

			break;
		}
		default:
			break;
		}
		SmartDashboard.putString("Capture Arm", armState.toString());

	}

	public void moveUp() {
		switch (armState) {
		case CAPTURE: {
			armState = ArmState.HIGH_GOAL;
			arms.set(DoubleSolenoid.Value.kForward);

			break;

		}
		case HIGH_GOAL: {
			break;
		}
		default:
			break;
		}
		SmartDashboard.putString("Capture Arm", armState.toString());

	}

	public ArmState getArmState() {
		return armState;
	}

	public void disable() {
		arms.set(DoubleSolenoid.Value.kOff);
		
	}

}

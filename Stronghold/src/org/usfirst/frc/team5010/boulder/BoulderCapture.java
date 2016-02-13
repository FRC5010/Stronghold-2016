package org.usfirst.frc.team5010.boulder;

import org.usfirst.frc.team5010.boulder.BoulderCapture.ArmState;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BoulderCapture {
private DoubleSolenoid arms;

public BoulderCapture(){
	arms = new DoubleSolenoid(1 , 0);
	arms.set(DoubleSolenoid.Value.kOff);
}
	// TODO: Add Solenoid class and call set function in apropos places in moveUp/Down
	
	public enum ArmState {
		CAPTURE, HIGH_GOAL
	};

	// TODO: Initialize this by detecting actual state from Robot
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

}

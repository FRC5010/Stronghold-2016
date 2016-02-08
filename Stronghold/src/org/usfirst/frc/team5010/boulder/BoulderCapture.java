package org.usfirst.frc.team5010.boulder;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BoulderCapture {

	// TODO: Add Solenoid class and call set function in apropos places in moveUp/Down
	
	private enum ArmState {
		CAPTURE, LOW_GOAL, HIGH_GOAL
	};

	// TODO: Initialize this by detecting actual state from Robot
	private ArmState armState = ArmState.CAPTURE;

	public void doCapture() {

	}

	public void moveDown() {
		switch (armState) {
		case LOW_GOAL:
			break;
		case CAPTURE: {
			armState = ArmState.LOW_GOAL;
			break;

		}
		case HIGH_GOAL: {
			armState = ArmState.CAPTURE;
			break;
		}
		default:
			break;
		}
		SmartDashboard.putString("Capture Arm", armState.toString());

	}

	public void moveUp() {
		switch (armState) {
		case LOW_GOAL: {
			armState = ArmState.CAPTURE;
			break;
			}
		case CAPTURE: {
			armState = ArmState.HIGH_GOAL;
			break;

		}
		case HIGH_GOAL: {
			break;
		}
		default:
			break;
		}
		SmartDashboard.putString("Capture Arm", armState.toString());
		// TODO Auto-generated method stub

	}

}

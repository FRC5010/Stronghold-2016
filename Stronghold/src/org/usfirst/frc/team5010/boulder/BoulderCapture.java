package org.usfirst.frc.team5010.boulder;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BoulderCapture {

	private enum ArmState {
		CAPTURE, LOW_GOAL, HIGH_GOAL
	};

	private ArmState armState;

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

package org.usfirst.frc.team5010.oi;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.Joystick;

/**
 * JoystickManager class that will be used during processing for determining
 * which joystick is controlling an action.
 * 
 * @since January 19, 2016
 *
 */
public class JoystickManager {
	private ArrayList<BaseJoystick> joystickUsed = new ArrayList<BaseJoystick>();
	private XboxJoystick driver = new XboxJoystick(new Joystick(0));
	private XboxJoystick operator = new XboxJoystick(new Joystick(1));
	/**
	 * Function for initializing the individual joysticks and adding them to a
	 * controlling structure.
	 */
	public void initController() {
		//joystickUsed.add(new XboxJoystick(new Joystick(0)));
		//joystickUsed.add(new LogAttackJoystick(new Joystick(1)));

	}

	/**
	 * Function for controlling the individual joysticks and having them update
	 * their individual tracking statuses.
	 */
	public void updateStatus() {
//		if (joystickUsed != null && joystickUsed.size() > 0) {
//			for (int x = 0; x < joystickUsed.size(); x++) {
//				JoystickController controller = joystickUsed.get(x);
//				controller.updateStatus();
//			}
			driver.updateStatus();
			operator.updateStatus();
//		}
	}

	public double tankDriveLeft() {
//		XboxJoystick left = (XboxJoystick) joystickUsed.get(0);
		return driver.LYaxisValue();
	}

	public double tankDriveRight() {
//		XboxJoystick right = (XboxJoystick) joystickUsed.get(0);
		return driver.RYaxisValue();
	}
	
	/// TODO Remove??? 2/4/16
//	public double getLYAxisValue() {
//		return driver.LYaxisValue();
//	}
//	
//	public double getRYAxisValue() {
//		return driver.RYaxisValue();
//	}
//	public double elevatorMovement() {
//	return operator.LYaxisValue();
//	}
//	public double defenseArm() { 
//		return operator.RYaxisValue();
//	}
//	public double tankDriveLeft() {
//		return driver.LYaxisValue();
//	}
//	public double tankDriveRight() {
//		return driver.RYaxisValue();
//	}
	// TODO Remove??? 2/4/16
//	public boolean selectCastleScale() {
//		return operator.isBButtonPressed();
//	}
//	public boolean liftRobot() {
//		return operator.isYButtonPressed();
//	}
	
	/**
	 * Spin up the boulder intake wheels.
	 * @return double
	 */
	public double spinBoulderWheels() {
		return operator.LYaxisValue();
	}
	
	/**
	 * Move the intake arm up and down.
	 * @return double
	 */
	public double moveIntakeArmUpDown() {
		return operator.RYaxisValue();
	}
	
	/**
	 * Piston punch out.
	 * @return boolean
	 */
	public boolean pistonPuncher() {
		return operator.isAButtonPressed();
	}
	
	/**
	 * Spin boulder intakearm wheels in.
	 * @return boolean
	 */
	public boolean CaptureBoulder() {
		return operator.isLBButtonPressed();
	}
	
	/**
	 * Spin boulder intakearm wheels out.
	 * @return boolean
	 */
	public boolean ShootBoulder() {
		return operator.isRBButtonPressed();
	}
}
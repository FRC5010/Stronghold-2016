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
//		}
	}

	public boolean isArmThingFired() {
		LogAttackJoystick joySt = (LogAttackJoystick) joystickUsed.get(1);
		return joySt.isButtonPressed(1);
	}

	public double getLeftDriver() {
//		XboxJoystick left = (XboxJoystick) joystickUsed.get(0);
		return driver.LYaxisValue();
	}

	public double getRightDriver() {
//		XboxJoystick right = (XboxJoystick) joystickUsed.get(0);
		return driver.RYAxisValue();
	}
	
	public double getLYAxisValue() {
		return driver.LYaxisValue();
	}
	
	public double getRYAxisValue() {
		return driver.RYAxisValue();
	}
	
	public boolean moveCastleArmUp() {
		return driver.isXButtonPressed();
	}
	public boolean moveCastleArmDown() {
		return driver.isYButtonPressed();
	}
	public boolean moveCamtiltIn() {
		return driver.isLBButtonPressed();
	}
	public boolean moveCamtiltOut() {
		return driver.isRBButtonPressed();
	}
}
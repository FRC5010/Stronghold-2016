package org.usfirst.frc.team5010.oi;

/**
 * Joystick implementation class for Logitech Attack joystick.
 * @since January 19, 2016
 *
 */
public class LogAttackJoystick 
	implements JoystickController
{

	@Override
	public boolean isButtonPressed(int buttonNbr) {
		// TODO Tyler&Gautam&Juan.  Compare current and previous tracking arrays to determine
		// if specific button pressed.
		return false;
	}

	@Override
	public boolean isButtonReleased(int buttonNbr) {
		// TODO Tyler&Gautam&Juan.  Compare current and previous tracking arrays to determine
		// if specific button released.
		return false;
	}

	@Override
	public void updateStatus() {
		// TODO Tyler&Gautam&Juan.  Update current tracking status.
	}

}

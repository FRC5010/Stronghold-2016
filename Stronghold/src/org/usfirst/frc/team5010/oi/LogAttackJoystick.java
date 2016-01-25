package org.usfirst.frc.team5010.oi;

import edu.wpi.first.wpilibj.Joystick;

/**
 * Joystick implementation class for Logitech Attack joystick.
 * @since January 19, 2016
 *
 */
public class LogAttackJoystick extends LogitechJoystick
	implements JoystickController
{
public LogAttackJoystick(Joystick attack){
	super(attack);
	
}
	@Override
	public boolean isButtonPressed(int buttonNbr) {
		// TODO Tyler&Gautam&Juan.  Compare current and previous tracking arrays to determine
		// if specific button pressed.
		
		
		return super.isButtonPressed(buttonNbr);
	}

	@Override
	public boolean isButtonReleased(int buttonNbr) {
		// TODO Tyler&Gautam&Juan.  Compare current and previous tracking arrays to determine
		// if specific button released.
		return super.isButtonPressed(buttonNbr);
	}

	@Override
	public void updateStatus() {
		// TODO Tyler&Gautam&Juan.  Update current tracking status.
		super.updateStatus();
	}

}

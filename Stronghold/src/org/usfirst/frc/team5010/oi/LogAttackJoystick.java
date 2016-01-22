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
	/**
	 * Constructor override.
	 * @param joyStick Joystick
	 */
	public LogAttackJoystick(Joystick joyStick){
		super(joyStick);
	}

	@Override
	public boolean isButtonPressed(int buttonNbr) {
		return super.isButtonPressed(buttonNbr);
	}

	@Override
	public boolean isButtonReleased(int buttonNbr) {
		return super.isButtonReleased(buttonNbr);
	}

	@Override
	public void updateStatus() {
		super.updateStatus();
	}

}

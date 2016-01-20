package org.usfirst.frc.team5010.oi;

import edu.wpi.first.wpilibj.Joystick;

public class LogXtremeJoystick extends LogitechJoystick 
	implements JoystickController
{
	private Joystick joyStick;

	public LogXtremeJoystick(Joystick joyStick) {
		super(joyStick);
		joyStick = joyStick;
	}

	public boolean isButton12Pressed() {
		return joyStick.getRawButton(12);

	}

	public double sliderValue() {
		return joyStick.getRawAxis(3);

	}

	@Override
	public boolean isButtonPressed(int buttonNbr) {
		// TODO Anika&Kiren.  Compare current and previous tracking arrays to determine
		// if specific button pressed.
		return false;
	}

	@Override
	public boolean isButtonReleased(int buttonNbr) {
		// TODO Anika&Kiren.  Compare current and previous tracking arrays to determine
		// if specific button released.
		return false;
	}

	@Override
	public void updateStatus() {
		// TODO Anika&Kiren.  Update current tracking status.
	}

}

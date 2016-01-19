package org.usfirst.frc.team5010.oi;

import edu.wpi.first.wpilibj.Joystick;

public class LogXtremeJoystick extends LogitechJoystick {
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

}

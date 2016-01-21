package org.usfirst.frc.team5010.oi;

import edu.wpi.first.wpilibj.Joystick;

public class LogXtremeJoystick extends LogitechJoystick implements JoystickController {
	private Joystick joyStick;
	private boolean button12Status;
	private boolean button12Previous;
	private double sliderStatus;

	public LogXtremeJoystick(Joystick joyStick) {
		super(joyStick);
		this.joyStick = joyStick;
	}

	public boolean isButton12Pressed() {
		return isButtonPressed(12);

	}

	public double sliderValue() {
		return sliderStatus;

	}

	@Override
	public boolean isButtonPressed(int buttonNbr) {
		if (buttonNbr == 12) {
			return (button12Status == button12Previous);
		} else {
			return super.isButtonPressed(buttonNbr);
		}
	}

	@Override
	public boolean isButtonReleased(int buttonNbr) {
		return !isButtonPressed(buttonNbr);
	}

	@Override
	public void updateStatus() {
		super.updateStatus();
		button12Previous = button12Status;
		button12Status = joyStick.getRawButton(12);
		sliderStatus = sliderValue();
	}

}

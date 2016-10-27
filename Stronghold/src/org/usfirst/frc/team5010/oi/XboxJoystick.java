package org.usfirst.frc.team5010.oi;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class XboxJoystick extends BaseJoystick implements JoystickController {

	private enum ButtonEvents {
		NO_EVENT, PRESSED, RELEASED

	};

	private ButtonEvents[] events = new ButtonEvents[12];

	private Joystick joyStick = null;
	private boolean[] currentButtonStatus = new boolean[12];
	private boolean[] previousButtonStatus = new boolean[12];

	/**
	 * Constructor override. k
	 * 
	 * @param joyStk
	 *            Joystick
	 */

	public XboxJoystick(Joystick joyStick) {
		super();
		this.joyStick = joyStick;
		for (int i = 1; i < 12; i++) {
			events[i] = ButtonEvents.NO_EVENT;
		}
	}

	public boolean isAButtonPressed() {
		// return isButtonPressed(1);
		return isEvent(ButtonEvents.PRESSED, 1);

	}

	public boolean isBButtonPressed() {
		return joyStick.getRawButton(2);

	}

	public boolean isXButtonPressed() {
		return joyStick.getRawButton(3);

	}

	public boolean isYButtonPressed() {
		// return isButtonPressed(4);
		return isEvent(ButtonEvents.PRESSED, 4);

	}

	public boolean isLBButtonPressed() {
		return joyStick.getRawButton(5);

	}

	public boolean isRBButtonPressed() {
		// return joyStick.getRawButton(6);
		return isEvent(ButtonEvents.PRESSED, 6);
	}

	public boolean isBackButtonPressed() {
		return joyStick.getRawButton(7);

	}

	public boolean isStartButtonPressed() {
		return joyStick.getRawButton(8);

	}

	public boolean isLStickButtonPressed() {
		return joyStick.getRawButton(9);

	}

	public boolean isRStickButtonPressed() {
		return joyStick.getRawButton(10);

	}

	public double LXaxisValue() {
		return joyStick.getRawAxis(0);

	}

	public double LYaxisValue() {
		return joyStick.getRawAxis(1);

	}

	public double LTrigValue() {
		return joyStick.getRawAxis(2);

	}

	public double RTrigValue() {
		return joyStick.getRawAxis(3);

	}

	public double RXaxisValue() {
		return joyStick.getRawAxis(4);

	}

	public double RYaxisValue() {
		return joyStick.getRawAxis(5);

	}

	public int POVValue() {
		return joyStick.getPOV(0);
	}

	private boolean isEvent(ButtonEvents expected, int buttonNbr) {
		if (expected == events[buttonNbr]) {
			events[buttonNbr] = ButtonEvents.NO_EVENT; // reset event
			return true;
		} else
			return false;
	}

	@Override
	public boolean isButtonPressed(int buttonNbr) {
		return isEvent(ButtonEvents.PRESSED, buttonNbr);
	}

	@Override
	public boolean isButtonReleased(int buttonNbr) {
		return isEvent(ButtonEvents.RELEASED, buttonNbr);
	}

	@Override
	public void updateStatus() {
		// Since there are only 10 buttons (and start at 1), only process 1 -
		// 11.
		for (int i = 1; i < 11; ++i) {
			currentButtonStatus[i] = joyStick.getRawButton(i);
			// If these are unequal, an evant has occured.
			if (currentButtonStatus[i] != previousButtonStatus[i]) {
				// update previous status so it only registers once
				previousButtonStatus[i] = currentButtonStatus[i];
				// record which event we detected
				if (currentButtonStatus[i] == true) {
					events[i] = ButtonEvents.PRESSED;// the event for this
														// button is labeled,
														// PRESSED
					SmartDashboard.putNumber("Button Pressed", i);
				} else {
					events[i] = ButtonEvents.RELEASED;
					SmartDashboard.putNumber("Button Released", i);
				}
			}
		}
	}

	public boolean isRBButtonReleased() {
		// return isButtonReleased(6);
		return isEvent(ButtonEvents.RELEASED, 6);
	}

}

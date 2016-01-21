package org.usfirst.frc.team5010.oi;

/**
 * Joystick controller interface that will need to be implemented
 * by all Joystick classes.
 * @since January 19, 2016
 */
public interface JoystickController {

	/**
	 * Function that will be called in the Joystick implementation classes
	 * to determine when the button was pressed.
	 * @param buttonNbr int
	 * @return boolean
	 */
	public boolean isButtonPressed(int buttonNbr);
	
	/**
	 * Function that will be called in the Joystick implementation classes
	 * to determine when the button is released.
	 * @param buttonNbr int
	 * @return boolean
	 */
	public boolean isButtonReleased(int buttonNbr);
	
	/**
	 * Function that will be called for the Joystick implementation
	 * classes to update their tracking structure.
	 */
	public void updateStatus();
}

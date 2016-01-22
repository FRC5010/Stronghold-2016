package org.usfirst.frc.team5010.oi;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.Joystick;

/**
 * JoystickManager class that will be used during processing for determining
 * which joystick is controlling an action.
 * @since January 19, 2016
 *
 */
public class JoystickManager {
	private ArrayList<JoystickController> joystickUsed = new ArrayList<JoystickController>();

	/**
	 * Function for initializing the individual joysticks and adding
	 * them to a controlling structure.
	 */
	public void initController()
	{
		joystickUsed.add(new XboxJoystick(new Joystick(0)));
		joystickUsed.add(new LogAttackJoystick(new Joystick(1)));
	}
	
	/**
	 * Function for controlling the individual joysticks and having them
	 * update their individual tracking statuses.
	 */
	public void updateStatus()
	{
		if (joystickUsed != null && joystickUsed.size() > 0)
		{
			for (int x = 0; x < joystickUsed.size(); x++)
			{
				JoystickController controller = joystickUsed.get(x);
				controller.updateStatus();
			}
		}
	}
}

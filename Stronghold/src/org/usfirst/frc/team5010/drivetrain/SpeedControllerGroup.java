package org.usfirst.frc.team5010.drivetrain;

import edu.wpi.first.wpilibj.SpeedController;

/**
 * Controlling class for grouping together the speed controllers used to
 * drive the main chassis.
 * @since January 23, 2016
 *
 */
public class SpeedControllerGroup {
	private SpeedController num1 = null;
	private SpeedController num2 = null;

	public SpeedControllerGroup(SpeedController num1, SpeedController num2) {
		this.num1 = num1;
		this.num2 = num2;
	}

	public SpeedControllerGroup(SpeedController num1) {
		this.num1 = num1;
	}
	
	public double get() {
		return num1.get();
	}

	public void set(double d) {
		num1.set(d);
		if (num2 != null)
		{
			num2.set(d);
		}
	}

	public void disable() {
		num1.disable();
		if (num2 != null)
		{
			num2.disable();
		}
	}

}
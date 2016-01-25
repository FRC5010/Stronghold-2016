package org.usfirst.team5010.drivetrain;

import edu.wpi.first.wpilibj.SpeedController;

public class SpeedControllerGroup {
	private SpeedController num1;
	private SpeedController num2;
	private SpeedController num3;

	public SpeedControllerGroup(SpeedController num1) {
		this.num1 = num1;
	}

	public SpeedControllerGroup(SpeedController num1, SpeedController num2) {
		this.num1 = num1;
		this.num2 = num2;

	}

	public void disable() {
		num1.disable();
		if (num2 != null) {
			num2.disable();
		}
	}

	public double get() {
		return num1.get();
	}

	public void set(double speed) {
		num1.set(speed);
		if (num2 != null)
			num2.set(speed);

	}
}

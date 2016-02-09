package org.usfirst.frc.team5010.boulder;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BoulderWheels {

	// TODO: Add SmartDashboard output to functions to see values

	private Victor motorLeft;
	private Victor motorRight;
	private final double DEAD_ZONE = 0.2;

	public BoulderWheels() {
		this.motorLeft = new Victor(2);
		this.motorRight = new Victor(3);
		SmartDashboard.putNumber("Intake", 0.35);
		SmartDashboard.putNumber("Outtake", 1.0);
	}

	// Use if you want to control with joystick
	private double scaleInputsToPower(double input) {
		double power = 0.0;
		if (Math.abs(input) > DEAD_ZONE) {
			if (input < 0) {
				power = (input + DEAD_ZONE) / (1.0 - DEAD_ZONE);
			} else {
				power = (input - DEAD_ZONE) / (1.0 - DEAD_ZONE);
			}
		}
		return Math.pow(power, 3.0);
	}

	public void SpinIntake() {
		double power = SmartDashboard.getNumber("Intake");
		motorLeft.set(-power);
		motorRight.set(power);
	}

	public void SpinOuttake() {
		double power = SmartDashboard.getNumber("Outtake");
		motorLeft.set(power);
		motorRight.set(-power);
	}

	public void Stop() {
		motorLeft.set(0);
		motorRight.set(0);
	}
}

package org.usfirst.frc.team5010.boulder;

import edu.wpi.first.wpilibj.Victor;

public class BoulderWheels {

	// TODO: Add SmartDashboard output to functions to see values
	
	private Victor motorLeft;
	private Victor motorRight;
	
	public BoulderWheels() {
		this.motorLeft = new Victor(2);
		this.motorRight = new Victor(3);
	}
	
	public void SpinIntake(double power) {
		motorLeft.set(power);
		motorRight.set(-power);
	}
	public void SpinOuttake(double power) {
		motorLeft.set(-power);
		motorRight.set(power);
	}
	public void Stop() {
		motorLeft.set(0);
		motorRight.set(0);
	}
}

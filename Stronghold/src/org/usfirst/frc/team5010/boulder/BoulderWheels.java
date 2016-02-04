package org.usfirst.frc.team5010.boulder;

import edu.wpi.first.wpilibj.Victor;

public class BoulderWheels {

	private Victor motorLeft;
	private Victor motorRight;
	
	public BoulderWheels() {
		this.motorLeft = new Victor(8);
		this.motorRight = new Victor(9);
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

package org.usfirst.frc.team5010.boulder;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BoulderWheels {

	private Victor motorLeft;
	private Victor motorRight;
//	private final double DEAD_ZONE = 0.2;

	public BoulderWheels() {
		this.motorLeft = new Victor(2);
		this.motorRight = new Victor(3);
		SmartDashboard.putNumber("Intake", 0.35 );
		SmartDashboard.putNumber("FastIntake", -0.8);
		SmartDashboard.putNumber("HighShot", 1.0);
	}

	public void captureBoulder() {
		double power = SmartDashboard.getNumber("Intake");
		motorLeft.set(-power);
		motorRight.set(power);
	}

	public void highShot() {
		double power = SmartDashboard.getNumber("HighShot");
		shootBoulder(power);
	}
	
	public void fastIntake() {
		double power = SmartDashboard.getNumber("FastIntake");
		shootBoulder(power);
	}
	
	private void shootBoulder(double power) {
		motorLeft.set(power);
		motorRight.set(-power);
	}

	public void Stop() {
		stopLeftWheel();
		stopRightWheel();
	}
	public void stopLeftWheel() {
		double currentLPower = motorLeft.get(); // Get the current power
													// setting
		double powerToArrestMom = -(currentLPower / 2); // that's momentum, not
														// your Mom!
		// You may have to play with this calculation in order to get the
		// stopping just right
		// Maybe just raise the 2 to a 3 or 4, possibly a fractional value. It
		// will take some experimentation

		if (powerToArrestMom < 0) {
			for (double rLPower = 0; rLPower > powerToArrestMom; rLPower -= 0.01) {
				motorLeft.set(rLPower); // Gradually give more power to stop
											// the wheels
			}
		} else {
			for (double rLPower = 0; rLPower < powerToArrestMom; rLPower += 0.01) {
				motorLeft.set(rLPower);
			}
		}
		// Now that mom is arrested, set power to wheel to 0.
		motorLeft.set(0);
	}

	public void stopRightWheel() {
		double currentRPower = motorRight.get(); // Get the current power
													// setting
		double powerToArrestMom = -(currentRPower / 2); // that's momentum, not
														// your Mom!
		// You may have to play with this calculation in order to get the
		// stopping just right
		// Maybe just raise the 2 to a 3 or 4, possibly a fractional value. It
		// will take some experimentation

		if (powerToArrestMom < 0) {
			for (double rRPower = 0; rRPower > powerToArrestMom; rRPower -= 0.01) {
				motorRight.set(rRPower); // Gradually give more power to stop
											// the wheels
			}
		} else {
			for (double rRPower = 0; rRPower < powerToArrestMom; rRPower += 0.01) {
				motorRight.set(rRPower);
			}
		}
		// Now that mom is arrested, set power to wheel to 0.
		motorRight.set(0);
	}
}

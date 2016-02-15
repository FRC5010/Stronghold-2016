package org.usfirst.frc.team5010.drivetrain;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Primary class for controlling drive train.
 * 
 * @since January 23, 2016
 *
 */
public class DriveTrainManager implements PIDOutput {

	// Define drive channels
	private final int leftMotorChannel = 0;
	private final int rightMotorChannel = 1;

	private Victor leftMotor1 = null;
	private Victor rightMotor1 = null;
	private boolean isFullPower = false;
	private final double autoPowerLevel = 0.75;
	private final double DEAD_ZONE = 0.2;

	private static final DriveTrainManager driveTrainInstance = new DriveTrainManager();

	/**
	 * Factory method to always return the same instance.
	 * 
	 * @return DriveTrainManager
	 */
	public static DriveTrainManager getInstance() {
		return driveTrainInstance;
	}

	/**
	 * Default constructor.
	 */
	public DriveTrainManager() {
	}

	public void roboInit() {
		leftMotor1 = new Victor(leftMotorChannel);
		rightMotor1 = new Victor(rightMotorChannel);
	}

	public void setForward(double power) {
		if (Math.abs(power) > DEAD_ZONE) {
			if (!isFullPower) {
				power = Math.pow(power, 4.0);
				powerLeftAuton(power);
				powerRightAuton(power);
			}
		} else {
			powerLeftAuton(0);
			powerRightAuton(0);
		}
	}

	public void setIsFullPower(boolean enabled) {
		if (enabled) {
			isFullPower = true;
		} else {
			isFullPower = false;
		}
	}

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

	public void powerLeftNormal(double power) {
		power = scaleInputsToPower(power);
		leftMotor1.set(power);
		SmartDashboard.putNumber("Left power:", leftMotor1.get());
	}

	public void powerRightNormal(double power) {
		power = scaleInputsToPower(power);
		rightMotor1.set(power);
		SmartDashboard.putNumber("Right power:", rightMotor1.get());
	}

	public boolean isFullPower() {
		return isFullPower;
	}

	public void stopLeftWheel() {
		double currentLPower = leftMotor1.get(); // Get the current power
													// setting
		double powerToArrestMom = -(currentLPower / 2); // that's momentum, not
														// your Mom!
		// You may have to play with this calculation in order to get the
		// stopping just right
		// Maybe just raise the 2 to a 3 or 4, possibly a fractional value. It
		// will take some experimentation

		if (powerToArrestMom < 0) {
			for (double rLPower = 0; rLPower > powerToArrestMom; rLPower -= 0.01) {
				leftMotor1.set(rLPower); // Gradually give more power to stop
											// the wheels
			}
		} else {
			for (double rLPower = 0; rLPower < powerToArrestMom; rLPower += 0.01) {
				leftMotor1.set(0);
			}
		}
		// Now that mom is arrested, set power to wheel to 0.
	}

	@Override
	public void pidWrite(double output) {
		// TODO Figure out what to write for pidWrite if anything.

	}

}

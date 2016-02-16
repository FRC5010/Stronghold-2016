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

	public void robotInit() {
		leftMotor1 = new Victor(leftMotorChannel);
		rightMotor1 = new Victor(rightMotorChannel);
	}

	private double scaleInputsToPower(double input) {
		double power = 0.0;
		if (Math.abs(input) > DEAD_ZONE) {
			if (input < 0) {
				power = (input + DEAD_ZONE) / (1.0 - DEAD_ZONE);
			} else {
				power = (input - DEAD_ZONE) / (1.0 - DEAD_ZONE);
			}
		} else {
			stop();
		}
		return Math.pow(power, 3.0);
	}
// Stop function.  Copy into BoulderWheels. 2/15/16 
	public void stop() {
		Runnable task = () -> {
			stopLeftWheel();
		};
		Thread stopLeft = new Thread(task);
		stopLeft.start();
		stopRightWheel();
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
// TODO: copy both stopLeftWheel() and stopRightWheel() into BoulderWheels.  2/15/16
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
				leftMotor1.set(rLPower);
			}
		}
		// Now that mom is arrested, set power to wheel to 0.
		leftMotor1.set(0);
	}

	public void stopRightWheel() {
		double currentRPower = rightMotor1.get(); // Get the current power
													// setting
		double powerToArrestMom = -(currentRPower / 2); // that's momentum, not
														// your Mom!
		// You may have to play with this calculation in order to get the
		// stopping just right
		// Maybe just raise the 2 to a 3 or 4, possibly a fractional value. It
		// will take some experimentation

		if (powerToArrestMom < 0) {
			for (double rRPower = 0; rRPower > powerToArrestMom; rRPower -= 0.01) {
				rightMotor1.set(rRPower); // Gradually give more power to stop
											// the wheels
			}
		} else {
			for (double rRPower = 0; rRPower < powerToArrestMom; rRPower += 0.01) {
				rightMotor1.set(rRPower);
			}
		}
		// Now that mom is arrested, set power to wheel to 0.
		rightMotor1.set(0);
	}

	@Override
	public void pidWrite(double output) {
		// TODO Figure out what to write for pidWrite if anything.

	}

}

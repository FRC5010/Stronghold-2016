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
	// TODO: Add smartdashboard output

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

	public void powerLeftAuton(double power) {
		power = scaleInputsToPower(power);
		leftMotor1.set(power * autoPowerLevel);
		SmartDashboard.putNumber("Left power:", leftMotor1.get());
	}

	public void powerRightAuton(double power) {
		power = scaleInputsToPower(power);
		rightMotor1.set(power * autoPowerLevel);
		SmartDashboard.putNumber("Right power:", rightMotor1.get());
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

	@Override
	public void pidWrite(double output) {
		// TODO Figure out what to write for pidWrite.

	}

}

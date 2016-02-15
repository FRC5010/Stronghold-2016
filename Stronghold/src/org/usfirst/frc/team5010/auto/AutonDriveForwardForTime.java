package org.usfirst.frc.team5010.auto;

import org.usfirst.frc.team5010.drivetrain.AutonDriver;
import org.usfirst.frc.team5010.drivetrain.DriveTrainManager;

import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutonDriveForwardForTime extends AutonDriver implements AutoModeStep {
	private Gyro headingGyro = null;
	private long autonStartTime;
	private long FORWARDTIME = 2000;
	private DriveTrainManager driveTrain;
	private boolean accomplished = false;

	public AutonDriveForwardForTime(DriveTrainManager driveTrain, Gyro gyro, long timeToDrive) {
		this.driveTrain = driveTrain;
		this.headingGyro = gyro;
		this.FORWARDTIME = timeToDrive;
		SmartDashboard.putString("Auton Task:", "Ctr AutonDriveForwardForTime");
	}

	@Override
	public void startStep() {		
		autonStartTime = System.currentTimeMillis();
		SmartDashboard.putString("Auton Task:", "Start AutonDriveForwardForTime");
	}

	@Override
	public void update() {
		SmartDashboard.putString("Auton Task:", "Update AutonDriveForwardForTime");
		double angle = headingGyro.getAngle();
		double curve = -angle * 0.03;

		if (System.currentTimeMillis() < autonStartTime + FORWARDTIME) {
			driveForward(0.50, curve);
		} else {
			driveTrain.powerLeftAuton(0);
			driveTrain.powerRightAuton(0);
			accomplished = true;
		}
		SmartDashboard.putNumber("Gyro Key", headingGyro.getAngle());

	}

	@Override
	public boolean accomplished() {
		return accomplished;
	}

	/**
	 * Determine which side needs more power.
	 * 
	 * @param powerLevel
	 *            double
	 * @param curve
	 *            double
	 */
	private void driveForward(double powerLevel, double gyroOffset) {
		double leftOutput, rightOutput;

		if (gyroOffset < 0) {
			double value = Math.log(-gyroOffset);
			double ratio = (value - 0.5) / (value + 0.5);
			if (ratio == 0) {
				ratio = .0000000001;
			}

			leftOutput = powerLevel / ratio;
			rightOutput = powerLevel;
		} else if (gyroOffset > 0) {
			double value = Math.log(gyroOffset);
			double ratio = (value - 0.5) / (value + 0.5);
			if (ratio == 0) {
				ratio = .0000000001;
			}

			leftOutput = powerLevel;
			rightOutput = powerLevel / ratio;
		} else {
			leftOutput = powerLevel;
			rightOutput = powerLevel;
		}

		SmartDashboard.putNumber("powerLeftAuton", leftOutput);
		SmartDashboard.putNumber("powerRightAuton", rightOutput);

		driveTrain.powerLeftAuton(leftOutput);
		driveTrain.powerRightAuton(rightOutput);
	}
}

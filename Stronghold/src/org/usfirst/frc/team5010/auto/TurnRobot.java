package org.usfirst.frc.team5010.auto;

import org.usfirst.frc.team5010.drivetrain.DriveTrainManager;

import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TurnRobot implements AutoModeStep {
private DriveTrainManager driveTrain;
private double angle;
private Gyro gyro;
private boolean accomplished = false;

public TurnRobot( DriveTrainManager driveTrain, double angle, Gyro gyro) { 
	this.driveTrain = driveTrain;
	this.angle = angle;
	this.gyro = gyro;
}
	@Override
	public void startStep() {

	}

	@Override
	public void update() {
		double currentAngle = gyro.getAngle();
		if (currentAngle != angle) {
			turnRobot( 0.5, currentAngle - angle );
		}
		else {
			accomplished = true;
		}

	}

	@Override
	public boolean accomplished() {
		return accomplished;
	}
	private void turnRobot(double powerLevel, double gyroOffset) {
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

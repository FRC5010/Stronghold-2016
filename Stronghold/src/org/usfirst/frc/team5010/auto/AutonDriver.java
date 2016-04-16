package org.usfirst.frc.team5010.auto;

import org.usfirst.frc.team5010.drivetrain.DriveTrainManager;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutonDriver {

	protected DriveTrainManager driveTrain;

	public AutonDriver(DriveTrainManager driveTrain) {
		this.driveTrain = driveTrain;
	}

	public void steer(double powerLevel, double gyroOffset) {
		double leftOutput, rightOutput;
			gyroOffset *= -0.03;
			
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

		driveTrain.powerLeftNormal(-leftOutput);
		driveTrain.powerRightNormal(rightOutput);

	}

	public void stop() {
		//driveTrain.stop();
	}
}

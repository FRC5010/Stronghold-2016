package org.usfirst.frc.team5010.drivetrain;

public class AutonDriver {
	
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
	
}

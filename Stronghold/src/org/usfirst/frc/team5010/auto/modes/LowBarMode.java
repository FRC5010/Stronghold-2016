package org.usfirst.frc.team5010.auto.modes;

import org.usfirst.frc.team5010.auto.steps.AutonDriveForwardForTime;
import org.usfirst.frc.team5010.auto.steps.MoveArm;
import org.usfirst.frc.team5010.boulder.BoulderHandler;
import org.usfirst.frc.team5010.drivetrain.DriveTrainManager;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class LowBarMode extends SuperAutonMode implements AutoModeInterface {
	private Gyro headingGyro = null;

		public LowBarMode() {
			headingGyro = new ADXRS450_Gyro();
		}

		@Override
		public void initAuton(DriveTrainManager driveTrain, BoulderHandler boulderHandler) {
			numberOfSteps = 3;
			currentStepIndex = 0;
			super.initAuton(driveTrain, boulderHandler);
			steps[0] = new MoveArm(boulderHandler, true);
			steps[1] = new MoveArm(boulderHandler, false);
			steps[2] = new AutonDriveForwardForTime(driveTrain, headingGyro, 6000);
			steps[0].startStep();	
		}
		
		@Override
		public void run() {
			super.run();
		}
}

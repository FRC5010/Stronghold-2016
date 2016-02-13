package org.usfirst.frc.team5010.auto;

import org.usfirst.frc.team5010.boulder.BoulderHandler;
import org.usfirst.frc.team5010.drivetrain.DriveTrainManager;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SuperAutonMode implements AutoModeInterface {
	int numberOfSteps = 2;
	AutoModeStep[] steps = new AutoModeStep[numberOfSteps];
	int currentStepIndex = 0;
	 DriveTrainManager driveTrain;
	 BoulderHandler boulderHandler;

	@Override
	public void run() {
		if (currentStepIndex < numberOfSteps) {
			AutoModeStep currentStep = steps[currentStepIndex];
			if (!currentStep.accomplished()) {
				currentStep.update();
			}
			if (currentStep.accomplished()) {
				currentStepIndex++;
				if (currentStepIndex < numberOfSteps) {
					steps[currentStepIndex].startStep();
				}
			}
		} else {
			SmartDashboard.putString("Auton Task:", "SpyBot Complete");
		}
	}

	@Override
	public void initAuton(DriveTrainManager driveTrain, BoulderHandler boulderHandler) {
		this.driveTrain = driveTrain;
		this.boulderHandler = boulderHandler;
		currentStepIndex = 0;
		steps = new AutoModeStep[numberOfSteps];
		// TODO Auto-generated method stub

	}

}

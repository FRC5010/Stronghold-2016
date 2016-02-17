package org.usfirst.frc.team5010.auto.modes;

import org.usfirst.frc.team5010.auto.steps.AutoModeStep;
import org.usfirst.frc.team5010.boulder.BoulderHandler;
import org.usfirst.frc.team5010.drivetrain.DriveTrainManager;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SuperAutonMode implements AutoModeInterface {
	int numberOfSteps = 2;
	AutoModeStep[] steps;
	int currentStepIndex = 0;
	 DriveTrainManager driveTrain;
	 BoulderHandler boulderHandler;
	 boolean enabled;

	@Override
	public void run() {
		if (enabled && currentStepIndex < numberOfSteps) {
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
			SmartDashboard.putString("Auton Task:", "Auton Complete");
		}
	}

	@Override
	public void initAuton(DriveTrainManager driveTrain, BoulderHandler boulderHandler) {
		this.driveTrain = driveTrain;
		this.boulderHandler = boulderHandler;
		currentStepIndex = 0;
		steps = new AutoModeStep[numberOfSteps];
		enabled = true;

	}

	@Override
	public void stop() {
		enabled = false;
		
	}

}

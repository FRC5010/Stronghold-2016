package org.usfirst.frc.team5010.auto.modes;

import org.usfirst.frc.team5010.auto.steps.ShootHighGoal;
import org.usfirst.frc.team5010.boulder.BoulderHandler;
import org.usfirst.frc.team5010.drivetrain.DriveTrainManager;



public class SpybotManager extends SuperAutonMode implements AutoModeInterface {

	/**
	 * Default constructor.
	 */
	public SpybotManager() {

	}

	@Override
	public void initAuton(DriveTrainManager driveTrain, BoulderHandler boulderHandler) {
		numberOfSteps = 1;
		currentStepIndex = 0;
		super.initAuton(driveTrain, boulderHandler);
		steps[0] = new ShootHighGoal(boulderHandler);
		steps[0].startStep();
	}

	@Override
	public void run() {
		super.run();
	}
}

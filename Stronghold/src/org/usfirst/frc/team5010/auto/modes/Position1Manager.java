package org.usfirst.frc.team5010.auto.modes;

import org.usfirst.frc.team5010.auto.DistanceHandler;
import org.usfirst.frc.team5010.auto.TiltHandler;
import org.usfirst.frc.team5010.auto.steps.AutoModeStep;
import org.usfirst.frc.team5010.auto.steps.AutonDriveForwardForTime;
import org.usfirst.frc.team5010.auto.steps.MoveArm;
import org.usfirst.frc.team5010.auto.steps.ShootHighGoal;
import org.usfirst.frc.team5010.auto.steps.TurnRobot;
import org.usfirst.frc.team5010.boulder.BoulderHandler;
import org.usfirst.frc.team5010.drivetrain.DriveTrainManager;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class Position1Manager extends SuperAutonMode implements AutoModeInterface {
	private Gyro headingGyro = null;
//	private BoulderHandler boulderHndlr;

	//private AutoModeStep[] steps = new AutoModeStep[numberOfSteps];

	public Position1Manager() {
		headingGyro = new ADXRS450_Gyro();
	}

	@Override
	public void initAuton(DriveTrainManager driveTrain, BoulderHandler boulderHandler) {
		numberOfSteps = 1;
		currentStepIndex = 0;
		super.initAuton(driveTrain, boulderHandler);
		steps[0] = new AutonDriveForwardForTime(driveTrain, headingGyro, 6000);
		steps[0].startStep();

	}

	@Override
	public void run() {
		super.run();
	}
}

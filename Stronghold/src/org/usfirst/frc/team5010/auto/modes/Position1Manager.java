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
	private TiltHandler accel;
	private DistanceHandler ranger;
	private BoulderHandler boulderHndlr;

	private AutoModeStep[] steps = new AutoModeStep[numberOfSteps];

	public Position1Manager(BoulderHandler boulderHndlr) {
		headingGyro = new ADXRS450_Gyro();
		accel = new TiltHandler();
		ranger = new DistanceHandler();
		this.boulderHndlr = boulderHndlr;
	}

	@Override
	public void initAuton(DriveTrainManager driveTrain, BoulderHandler boulderHandler) {
		numberOfSteps = 5;
		currentStepIndex = 0;
		super.initAuton(driveTrain, boulderHandler);
		steps[0] = new MoveArm(boulderHndlr, false);
		steps[1] = new AutonDriveForwardForTime(driveTrain, headingGyro, 2000);
		steps[2] = new TurnRobot(driveTrain, 90, headingGyro);
		steps[3] = new AutonDriveForwardForTime(driveTrain, headingGyro, 2000);
		steps[4] = new TurnRobot(driveTrain, 0, headingGyro);
		steps[5] = new ShootHighGoal(boulderHandler);
		steps[0].startStep();

	}

}

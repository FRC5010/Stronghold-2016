package org.usfirst.frc.team5010.auto;

import org.usfirst.frc.team5010.boulder.BoulderHandler;
import org.usfirst.frc.team5010.drivetrain.DriveTrainManager;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class Position1Manager extends SuperAutonMode implements AutoModeInterface {
	private Gyro headingGyro = null;
	private TiltHandler accel;
	private DistanceHandler ranger;

	private int numberOfSteps = 2;
	private AutoModeStep[] steps = new AutoModeStep[numberOfSteps];
	private int currentStepIndex = 0;

	public Position1Manager() {
		headingGyro = new ADXRS450_Gyro();
		accel = new TiltHandler();
		ranger = new DistanceHandler();
	}

	@Override
	public void initAuton(DriveTrainManager driveTrain, BoulderHandler boulderHandler) {
		numberOfSteps = 5;
		currentStepIndex = 0;
		super.initAuton(driveTrain, boulderHandler);
		steps[0] = new AutonDriveForwardForTime(driveTrain, headingGyro, 2000);
		steps[1] = new TurnRobot(driveTrain, 90, headingGyro);
		steps[2] = new AutonDriveForwardForTime(driveTrain, headingGyro, 2000);
		steps[3] = new TurnRobot(driveTrain, 0, headingGyro);
		steps[4] = new ShootHighGoal(boulderHandler);
		steps[0].startStep();

	}

}

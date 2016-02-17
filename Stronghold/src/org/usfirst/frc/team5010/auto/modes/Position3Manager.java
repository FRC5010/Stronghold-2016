package org.usfirst.frc.team5010.auto.modes;

import org.usfirst.frc.team5010.auto.DistanceHandler;
import org.usfirst.frc.team5010.auto.TiltHandler;
import org.usfirst.frc.team5010.auto.steps.AutoModeStep;
import org.usfirst.frc.team5010.auto.steps.AutonDriveForwardForTime;
import org.usfirst.frc.team5010.auto.steps.ShootHighGoal;
import org.usfirst.frc.team5010.boulder.BoulderHandler;
import org.usfirst.frc.team5010.drivetrain.DriveTrainManager;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class Position3Manager extends SuperAutonMode implements AutoModeInterface {
	private Gyro headingGyro = null;
	private TiltHandler accel;
	private DistanceHandler ranger;

	public Position3Manager() {
		headingGyro = new ADXRS450_Gyro();
		accel = new TiltHandler();
		ranger = new DistanceHandler();
	}

	@Override
	public void initAuton(DriveTrainManager driveTrain, BoulderHandler boulderHandler) {
		numberOfSteps = 2;
		currentStepIndex = 0;
		super.initAuton(driveTrain, boulderHandler);
		steps[0] = new AutonDriveForwardForTime(driveTrain, headingGyro, 2000);
		steps[1] = new ShootHighGoal(boulderHandler);
		steps[0].startStep();

	}

}

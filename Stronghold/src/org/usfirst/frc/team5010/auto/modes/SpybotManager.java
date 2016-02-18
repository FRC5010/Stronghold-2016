package org.usfirst.frc.team5010.auto.modes;

import org.usfirst.frc.team5010.auto.DistanceHandler;
import org.usfirst.frc.team5010.auto.TiltHandler;
import org.usfirst.frc.team5010.auto.steps.AutonDriveForwardForTime;
import org.usfirst.frc.team5010.auto.steps.ShootBoulderLowGoal;
import org.usfirst.frc.team5010.boulder.BoulderHandler;
import org.usfirst.frc.team5010.drivetrain.DriveTrainManager;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SpybotManager extends SuperAutonMode implements AutoModeInterface {
	private Gyro headingGyro = null;
	private TiltHandler accel;
	private DistanceHandler ranger;

	/**
	 * Default constructor.
	 */
	public SpybotManager() {
		headingGyro = new ADXRS450_Gyro();
		accel = new TiltHandler();
		ranger = new DistanceHandler();
	}

	@Override
	public void initAuton(DriveTrainManager driveTrain, BoulderHandler boulderHandler) {
		currentStepIndex = 0;
		numberOfSteps = 2;
		super.initAuton(driveTrain, boulderHandler);
		steps[0] = new AutonDriveForwardForTime(driveTrain, headingGyro, 2000);
		steps[1] = new ShootBoulderLowGoal(boulderHandler);
		steps[0].startStep();
	}

	@Override
	public void run() {
		SmartDashboard.putNumber("Range", ranger.getRange());
		super.run();
	}
}

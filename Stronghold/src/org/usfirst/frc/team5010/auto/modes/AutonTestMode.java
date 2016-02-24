package org.usfirst.frc.team5010.auto.modes;

import org.usfirst.frc.team5010.auto.DistanceHandler;
import org.usfirst.frc.team5010.auto.TiltHandler;
import org.usfirst.frc.team5010.auto.steps.DriveForwardUntilDistance;
import org.usfirst.frc.team5010.boulder.BoulderHandler;
import org.usfirst.frc.team5010.drivetrain.DriveTrainManager;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class AutonTestMode extends SuperAutonMode implements AutoModeInterface {
	private Gyro headingGyro = null;
	private TiltHandler accel;
	private DistanceHandler ranger;


	@Override
	public void initAuton(DriveTrainManager driveTrain, BoulderHandler boulderHandler) {
		super.initAuton(driveTrain, boulderHandler);
		headingGyro = new ADXRS450_Gyro();
		accel = new TiltHandler();
		ranger = new DistanceHandler();
		steps[0] = new DriveForwardUntilDistance(driveTrain, ranger,headingGyro, 24);
		steps[0].startStep();
	}
}

package org.usfirst.frc.team5010.auto.steps;

import org.usfirst.frc.team5010.auto.AutonDriver;
import org.usfirst.frc.team5010.auto.DistanceHandler;
import org.usfirst.frc.team5010.drivetrain.DriveTrainManager;

import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveForwardUntilDistance extends AutonDriver implements AutoModeStep {
	private DistanceHandler ranger = null;
	private Gyro headingGyro = null;
	private long DISTANCE = 2000;
	private boolean accomplished = false;

	public DriveForwardUntilDistance(DriveTrainManager driveTrainMgr, DistanceHandler ranger, Gyro headingGyro,
			long range) {
		super(driveTrainMgr);
		this.ranger = ranger;
		this.headingGyro = headingGyro;
		this.DISTANCE = range;
	}

	@Override
	public void startStep() {
		headingGyro.reset();
	}

	@Override
	public void update() {
		SmartDashboard.putString("Auton Task:", "Update AutonDriveForwardUntilTiltState");
		double angle = headingGyro.getAngle();

		if (DISTANCE < ranger.getRange()) {
			steer(0.50, angle);
		} else {
			stop();
			accomplished = true;
		}
		SmartDashboard.putNumber("Gyro Key", headingGyro.getAngle());

	}

	

	@Override
	public boolean accomplished() {
		return accomplished;
	}

}

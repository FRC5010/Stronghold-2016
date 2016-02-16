package org.usfirst.frc.team5010.auto;

import org.usfirst.frc.team5010.drivetrain.AutonDriver;
import org.usfirst.frc.team5010.drivetrain.DriveTrainManager;

import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutonDriveForwardForTime extends AutonDriver implements AutoModeStep {
	private Gyro headingGyro = null;
	private long autonStartTime;
	private long FORWARDTIME = 2000;
	private boolean accomplished = false;

	public AutonDriveForwardForTime(DriveTrainManager driveTrain, Gyro gyro, long timeToDrive) {
		super(driveTrain);
		this.headingGyro = gyro;
		this.FORWARDTIME = timeToDrive;
		SmartDashboard.putString("Auton Task:", "Ctr AutonDriveForwardForTime");
	}

	@Override
	public void startStep() {		
		autonStartTime = System.currentTimeMillis();
		SmartDashboard.putString("Auton Task:", "Start AutonDriveForwardForTime");
	}

	@Override
	public void update() {
		SmartDashboard.putString("Auton Task:", "Update AutonDriveForwardForTime");
		double angle = headingGyro.getAngle();
		double curve = -angle * 0.03;

		if (System.currentTimeMillis() < autonStartTime + FORWARDTIME) {
			steer(0.50, curve);
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

	/**
	 * Determine which side needs more power.
	 * 
	 * @param powerLevel
	 *            double
	 * @param curve
	 *            double
	 */

}

package org.usfirst.frc.team5010.auto.steps;

import org.usfirst.frc.team5010.auto.AutonDriver;
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
		headingGyro.reset();
	}

	@Override
	public void update() {
		SmartDashboard.putString("Auton Task:", "Update AutonDriveForwardForTime");
		double angle = headingGyro.getAngle();
		

		if (System.currentTimeMillis() < autonStartTime + FORWARDTIME) {
			steer(0.50, angle);
		} else {
			driveTrain.powerBothNormal(0);
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

package org.usfirst.frc.team5010.auto.steps;

import org.usfirst.frc.team5010.auto.AutonDriver;
import org.usfirst.frc.team5010.auto.TiltHandler;
import org.usfirst.frc.team5010.drivetrain.DriveTrainManager;

import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveForwardUntilTiltState extends AutonDriver implements AutoModeStep {
	private Gyro gyro;
	private TiltHandler tiltHndlr;
	private TiltHandler.TiltState state;
	private boolean accomplished;
	public DriveForwardUntilTiltState(DriveTrainManager driveTrain, Gyro gyro, TiltHandler tiltHndlr, TiltHandler.TiltState state) {
		super(driveTrain);
		this.gyro = gyro;
		this.tiltHndlr = tiltHndlr;
		this.state = state;
		accomplished = false;
	}

	@Override
	public void startStep() {
		gyro.reset();

	}

	@Override
	public void update() {
		SmartDashboard.putString("Auton Task:", "Update AutonDriveForwardUntilTiltState");
		double angle = gyro.getAngle();
		

		if (state != tiltHndlr.GetState()) {
			steer(0.50, angle);
		} else {
			stop();
			accomplished = true;
		}
		SmartDashboard.putNumber("Gyro Key", gyro.getAngle());

	}

	@Override
	public boolean accomplished() {
		return accomplished;
	}

}

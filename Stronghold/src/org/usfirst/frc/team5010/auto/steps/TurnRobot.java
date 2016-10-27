package org.usfirst.frc.team5010.auto.steps;

import org.usfirst.frc.team5010.auto.AutonDriver;
import org.usfirst.frc.team5010.drivetrain.DriveTrainManager;

import edu.wpi.first.wpilibj.interfaces.Gyro;

public class TurnRobot extends AutonDriver implements AutoModeStep {
private double angle;
private Gyro gyro;
private boolean accomplished = false;

public TurnRobot( DriveTrainManager driveTrain, double angle, Gyro gyro) { 
	super(driveTrain);
	this.angle = angle;
	this.gyro = gyro;
	}
	@Override
	public void startStep() {
		gyro.reset();
	}

	@Override
	public void update() {
		double currentAngle = gyro.getAngle();
		if (currentAngle != angle) {
			steer( 0.5, angle - currentAngle );
		}
		else {
			accomplished = true;
			stop();
		}

	}

	@Override
	public boolean accomplished() {
		return accomplished;
	}
}

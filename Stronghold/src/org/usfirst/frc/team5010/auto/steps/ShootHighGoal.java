package org.usfirst.frc.team5010.auto.steps;

import org.usfirst.frc.team5010.boulder.BoulderHandler;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ShootHighGoal implements AutoModeStep {
	private long startTime;
	private long moveCaptureUp = 0;
	private long spinWheelTimeOffset = 1000;
	private long shootBoulderOffset = 2000;
	private long retractShooterOffset = 3000;
	private long stopWheelsOffset = 4000;
	private boolean accomplished = false;
	private BoulderHandler boulderHandler;

	public ShootHighGoal(BoulderHandler boulderHandler) {
		this.boulderHandler = boulderHandler;
	}

	@Override
	public void startStep() {
		SmartDashboard.putString("Auton Task:", "Start ShootBoulderLowGoal");
		startTime = System.currentTimeMillis();
		spinWheelTimeOffset += startTime;
		shootBoulderOffset += startTime;
		retractShooterOffset += startTime;
		stopWheelsOffset += startTime;
		moveCaptureUp += startTime;

	}

	@Override
	public void update() {
		SmartDashboard.putString("Auton Task:", "Updating ShootBoulderHighGoal");
		long currentTime = System.currentTimeMillis();
		if (currentTime > moveCaptureUp && currentTime < spinWheelTimeOffset) {
			boulderHandler.moveCaptureUp();
		}
		if (currentTime > spinWheelTimeOffset && currentTime < stopWheelsOffset) {
			boulderHandler.highShotWheels();
		}
		if (currentTime > shootBoulderOffset && currentTime < retractShooterOffset) {
			boulderHandler.shootBoulder();
			SmartDashboard.putString("ShootHighGoal", "works");
		}
		if (currentTime > retractShooterOffset && currentTime < stopWheelsOffset) {
			boulderHandler.retractShooter();
		}
		if (currentTime > stopWheelsOffset) {
			boulderHandler.stopWheels();
			// boulderHandler.moveCaptureDown();
			accomplished = true;
		}

	}

	@Override
	public boolean accomplished() {
		return accomplished;
	}

}

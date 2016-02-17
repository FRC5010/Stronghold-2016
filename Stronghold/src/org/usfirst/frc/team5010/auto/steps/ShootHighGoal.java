package org.usfirst.frc.team5010.auto.steps;

import org.usfirst.frc.team5010.boulder.BoulderHandler;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ShootHighGoal implements AutoModeStep {
	private long startTime;
	private long moveCaptureUp = 0;
	private long spinWheelTimeOffset = 500;
	private long shootBoulderOffset = 1000;
	private long retractShooterOffset = 1500;
	private long stopWheelsOffset = 2000;
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
		} else if (currentTime > spinWheelTimeOffset && currentTime < stopWheelsOffset) {
			boulderHandler.highShotWheels();
		} else if (currentTime > shootBoulderOffset && currentTime < retractShooterOffset) {
			boulderHandler.shootBoulder();
		} else if (currentTime > retractShooterOffset && currentTime < stopWheelsOffset) {
			boulderHandler.retractShooter();
		} else if (currentTime > stopWheelsOffset) {
			boulderHandler.stopWheels();
			boulderHandler.moveCaptureDown();
			accomplished = true;
		}

	}

	@Override
	public boolean accomplished() {
		return accomplished;
	}

}

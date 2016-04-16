package org.usfirst.frc.team5010.auto.steps;

import org.usfirst.frc.team5010.boulder.BoulderHandler;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ShootBoulderLowGoal implements AutoModeStep {
	private long startTime;
	private long moveCaptureDown = 0;
	private long spinWheelTimeOffset = 1000;
	private long shootBoulderOffset = 2000;
	private long retractShooterOffset = 2500;
	private long stopWheelsOffset = 3000;
	private boolean accomplished = false;
	
	BoulderHandler handler;
	
	public ShootBoulderLowGoal(BoulderHandler handler) {
		this.handler = handler;
	}
	
	@Override
	public void startStep() {
		SmartDashboard.putString("Auton Task:", "Start ShootBoulderLowGoal");
		startTime = System.currentTimeMillis();
		moveCaptureDown += startTime;
		spinWheelTimeOffset += startTime;
		shootBoulderOffset += startTime;
		retractShooterOffset += startTime;
		stopWheelsOffset += startTime;
	}

	@Override
	public void update() {
		SmartDashboard.putString("Auton Task:", "Updating ShootBoulderLowGoal");
		long currentTime = System.currentTimeMillis();
		if ( currentTime > moveCaptureDown && currentTime < stopWheelsOffset ) {
			handler.moveCaptureDown();
		} else 
		if ( currentTime > spinWheelTimeOffset && currentTime < stopWheelsOffset ) {
			handler.lowShotWheels();
		} else
		if ( currentTime > shootBoulderOffset && currentTime < retractShooterOffset) {
			handler.shootBoulder();
		} else
		if ( currentTime > retractShooterOffset && currentTime < stopWheelsOffset) {
			handler.retractShooter();
		} else
		if ( currentTime > stopWheelsOffset ) {
			handler.stopWheels();
			accomplished = true;
		}
	}

	@Override
	public boolean accomplished() {
		return accomplished;
	}

}

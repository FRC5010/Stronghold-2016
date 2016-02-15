package org.usfirst.frc.team5010.auto;

import org.usfirst.frc.team5010.boulder.BoulderHandler;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ShootBoulderLowGoal implements AutoModeStep {
	private long startTime;
	private long spinWheelTimeOffset = 0;
	private long shootBoulderOffset = 1000;
	private long retractShooterOffset = 1500;
	private long stopWheelsOffset = 2000;
	private boolean accomplished = false;
	
	BoulderHandler handler;
	
	public ShootBoulderLowGoal(BoulderHandler handler) {
		this.handler = handler;
	}
	
	@Override
	public void startStep() {
		SmartDashboard.putString("Auton Task:", "Start ShootBoulderLowGoal");
		startTime = System.currentTimeMillis();
		spinWheelTimeOffset += startTime;
		shootBoulderOffset += startTime;
		retractShooterOffset += startTime;
		stopWheelsOffset += startTime;
	}

	@Override
	public void update() {
		SmartDashboard.putString("Auton Task:", "Updating ShootBoulderLowGoal");
		long currentTime = System.currentTimeMillis();
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

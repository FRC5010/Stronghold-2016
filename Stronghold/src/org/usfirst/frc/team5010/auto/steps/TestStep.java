package org.usfirst.frc.team5010.auto.steps;

import org.usfirst.frc.team5010.auto.DistanceHandler;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TestStep implements AutoModeStep {
 private DistanceHandler distanceHandler;

public TestStep ( DistanceHandler distanceHandler) {
	 this.distanceHandler = distanceHandler;
 }
	@Override
	public void startStep() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		SmartDashboard.putNumber("Range", distanceHandler.getRange());
		
	}

	@Override
	public boolean accomplished() {
		// TODO Auto-generated method stub
		return false;
	}

}

package org.usfirst.team5010.drivetrain;

import edu.wpi.first.wpilibj.Victor;

public class DriveTrainManager {
	private SpeedControllerGroup leftmotors;
	private SpeedControllerGroup rightmotors;
	private Victor victor1L;
	private Victor victor2L;
	private Victor victor1R;
	private Victor victor2R;
	
	public DriveTrainManager(){
		victor1L = new Victor(0);
		victor2L = new Victor(0);
		victor1R = new Victor(0);
		victor2R = new Victor(0);
		
		leftmotors = new SpeedControllerGroup(victor1L, victor2L);
		rightmotors = new SpeedControllerGroup(victor1R, victor2R);
		
	}
}

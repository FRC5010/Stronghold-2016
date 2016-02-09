package org.usfirst.frc.team5010.auto;

import org.usfirst.frc.team5010.drivetrain.DriveTrainManager;

/**
 * @author jebor
 *
 */
public interface AutoModeInterface {

	public void run(DriveTrainManager driveTrain);
	
	public void initAuton();
}

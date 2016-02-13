package org.usfirst.frc.team5010.auto;

import org.usfirst.frc.team5010.boulder.BoulderHandler;
import org.usfirst.frc.team5010.drivetrain.DriveTrainManager;

/**
 * @author jebor
 *
 */
public interface AutoModeInterface {

	public void run();
	
	public void initAuton(DriveTrainManager driveTrain, BoulderHandler boulderHandler);
}

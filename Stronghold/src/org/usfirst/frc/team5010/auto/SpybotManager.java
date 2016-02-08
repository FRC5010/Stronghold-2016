package org.usfirst.frc.team5010.auto;

import org.usfirst.frc.team5010.drivetrain.DriveTrainManager;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class SpybotManager extends AutoModeManager {
	private Gyro headingGyro = null;
	private long autonStartTime;
	private long FORWARDTIME = 2000;
	
	/**
	 * Default constructor.
	 */
	public SpybotManager() {
	}
	
	@Override
	public void initAuton() {
		autonStartTime = System.currentTimeMillis();
		headingGyro = new ADXRS450_Gyro();
	}
	
	@Override
	public void run(DriveTrainManager driveTrain) {
		double angle = headingGyro.getAngle();
		double curve = -angle * 0.03;

		if (System.currentTimeMillis() < autonStartTime + FORWARDTIME)
		{
			driveForward(driveTrain, 0.50, curve);
		}
		else
		{
			driveTrain.powerLeftAuton(0);
			driveTrain.powerRightAuton(0);
		}
//      while (isAutonomous()) {
//         double angle = gyro.getAngle(); // get current heading
//         myRobot.drive(-1.0, -angle*Kp); // drive towards heading 0
//         Timer.delay(0.004);
//      }
	}
	
	/**
	 * @param driveTrain DriveTrainManager
	 * @param powerLevel double
	 * @param curve double
	 */
	private void driveForward(DriveTrainManager driveTrain, 
			double powerLevel, double gyroOffset) 
	{
	    double leftOutput, rightOutput;

    	if (gyroOffset < 0) {
    		double value = Math.log(-gyroOffset);
    		double ratio = (value - 0.5) / (value + 0.5);
    		if (ratio == 0) {
    			ratio = .0000000001;
	        }
    		
    		leftOutput = powerLevel / ratio;
    		rightOutput = powerLevel;
		} 
	    else if (gyroOffset > 0) {
	    	double value = Math.log(gyroOffset);
	    	double ratio = (value - 0.5) / (value + 0.5);
	    	if (ratio == 0) {
	    		ratio = .0000000001;
	    	}
	   
	    	leftOutput = powerLevel;
	    	rightOutput = powerLevel / ratio;
	    } else {
	        leftOutput = powerLevel;
	        rightOutput = powerLevel;
	    }
	    
		driveTrain.powerLeftAuton(leftOutput);
		driveTrain.powerRightAuton(rightOutput);
	}
}

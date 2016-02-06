package org.usfirst.frc.team5010.auto;

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
	public void run() {
//        while (isAutonomous()) {
//            double angle = gyro.getAngle(); // get current heading
//            myRobot.drive(-1.0, -angle*Kp); // drive towards heading 0
//            Timer.delay(0.004);
//        }
//        myRobot.drive(0.0, 0.0);
		if (System.currentTimeMillis() < autonStartTime + FORWARDTIME)
		{
			// drivetrain forward
		}
		else
		{
			// drivetrain forward 0
		}
	}
}

package org.usfirst.frc.team5010.drivetrain;

import org.usfirst.frc.team5010.oi.JoystickManager;
import org.usfirst.frc.team5010.robot.LogicManager;

public class TankDriver implements LogicManager {

	private JoystickManager joystickMgr;
	private DriveTrainManager driveTrainMgr;
	private final double DEAD_ZONE = 0.1;

	public TankDriver(JoystickManager joystickMgr, DriveTrainManager driveTrainMgr) {

		this.driveTrainMgr = driveTrainMgr;
		this.joystickMgr = joystickMgr;
	}

	@Override
	public void update() {
		// logicManager.updateRobotDriving(); - put this code in a LogicManager
		double lPower = joystickMgr.tankDriveLeft();
		lPower = scaleInputsToPower(lPower);
		driveTrainMgr.powerLeftNormal(lPower);

		double rPower = joystickMgr.tankDriveRight();
		rPower = scaleInputsToPower(rPower);
		driveTrainMgr.powerRightNormal(-rPower);

	}

	private double scaleInputsToPower(double input) {
		double power = 0.0;
		if (Math.abs(input) > DEAD_ZONE) {
			if (input < 0) {
				power = (input + DEAD_ZONE) / (1.0 - DEAD_ZONE);
			} else {
				power = (input - DEAD_ZONE) / (1.0 - DEAD_ZONE);
			}
		} else {
			//driveTrainMgr.stop();
		}
			return Math.pow(power, 3.0);
	}
}

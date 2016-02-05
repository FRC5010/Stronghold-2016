package org.usfirst.frc.team5010.drivetrain;

import org.usfirst.frc.team5010.oi.JoystickManager;
import org.usfirst.frc.team5010.robot.LogicManager;

public class TankDriver implements LogicManager {
	//TODO: Add smart dashboard output
	
	private JoystickManager joystickMgr;
	private DriveTrainManager driveTrainMgr;

	public TankDriver(JoystickManager joystickMgr, DriveTrainManager driveTrainMgr) {

		this.driveTrainMgr = driveTrainMgr;
		this.joystickMgr = joystickMgr;
	}

	@Override
	public void update() {
		// logicManager.updateRobotDriving(); - put this code in a LogicManager
		double lPower = joystickMgr.tankDriveLeft();
		driveTrainMgr.powerLeftNormal(lPower);

		double rPower = joystickMgr.tankDriveRight();
		driveTrainMgr.powerRightNormal(rPower);

	}

}

package org.usfirst.frc.team5010.defenseArm;

import org.usfirst.frc.team5010.oi.JoystickManager;
import org.usfirst.frc.team5010.robot.LogicManager;

public class ElevatorOperator implements LogicManager{
	private JoystickManager joystickManager;
	public ElevatorOperator(JoystickManager joystickMgr){
		joystickManager = joystickMgr;
	}
	@Override
	public void update() {
		this.joystickManager.getLYAxisValue();
		// Figure out what to do with AxisValue;
	}
}


package org.usfirst.frc.team5010.defenseArm;

import org.usfirst.frc.team5010.oi.JoystickManager;
import org.usfirst.frc.team5010.robot.LogicManager;

public class DefenseArmOperator implements LogicManager{
	private JoystickManager JoystickManager;
	public DefenseArmOperator(JoystickManager joystickMgr){
		joystickMgr = JoystickManager;
	}
	@Override
	public void update() {
		this.JoystickManager.getRYAxisValue();
		// TODO FIgure out what to do with AxisValue;
	}
}

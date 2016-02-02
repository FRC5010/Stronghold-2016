package org.usfirst.frc.team5010.scalingArm;

import org.usfirst.frc.team5010.oi.JoystickManager;
import org.usfirst.frc.team5010.robot.LogicManager;

public class Camtilt implements LogicManager {
	private JoystickManager joystickManager;
	public Camtilt(JoystickManager joystickMgr) {
		joystickManager = joystickMgr;
		
	
	}
	@Override
	public void update() {
		if (joystickManager.moveCamtiltIn()) {
		// TODO write code to moveCamtilt else 	
		
		} else {
			if (joystickManager.moveCamtiltOut()) {
			//TODO write code to moveCametilt out
			}	
		}
	}
}

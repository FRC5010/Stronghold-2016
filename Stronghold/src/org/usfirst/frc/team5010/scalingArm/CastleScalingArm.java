package org.usfirst.frc.team5010.scalingArm;

import org.usfirst.frc.team5010.oi.JoystickManager;
import org.usfirst.frc.team5010.robot.LogicManager;

public class CastleScalingArm implements LogicManager {
	private JoystickManager joystickManager;
	public CastleScalingArm (JoystickManager joystickManager) {
		this.joystickManager = joystickManager;
		
		
	}
	@Override
	public void update() {
		if (this.joystickManager.moveCastleArmDown()) {
			//TODO write code for moveCastleArmDown
			
		if (this.joystickManager.moveCastleArmUp() ) {
			//TODO write code for moveCastleUp
		}
		}
		
		
		
		
		
	}
}


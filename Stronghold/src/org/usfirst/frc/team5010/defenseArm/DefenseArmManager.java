//TODO Remove??? 2/4/16

package org.usfirst.frc.team5010.defenseArm;

import org.usfirst.frc.team5010.oi.JoystickManager;
import org.usfirst.frc.team5010.robot.LogicManager;

public class DefenseArmManager implements LogicManager {
	private DefenseArmOperator defenseArmOper;
	private JoystickManager joystickMgr;
	private boolean isDefenseAxisMoved;

	public DefenseArmManager (JoystickManager joystickMgr, DefenseArmOperator defenseArmOper) {
		this.defenseArmOper = defenseArmOper;
		this.joystickMgr = joystickMgr;
	}

	@Override
	public void update() {
		if ( isDefenseAxisMoved ) {
			
		}
		// TODO Auto-generated method stub
		
	}
	
}

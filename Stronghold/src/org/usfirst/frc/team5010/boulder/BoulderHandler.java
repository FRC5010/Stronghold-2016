package org.usfirst.frc.team5010.boulder;

import org.usfirst.frc.team5010.oi.JoystickManager;
import org.usfirst.frc.team5010.robot.LogicManager;

public class BoulderHandler implements LogicManager {
	private JoystickManager joystickMgr;
	private BoulderCapture bouldrCptr;
	private BoulderShooter bouldrShtr;
	private BoulderWheels bouldrWhls;
	private final double DEAD_ZONE = 0.2;
	
	public BoulderHandler(JoystickManager joystickMgr) {
		this.joystickMgr = joystickMgr;
		this.bouldrCptr = new BoulderCapture();
		this.bouldrShtr = new BoulderShooter();
		this.bouldrWhls = new BoulderWheels();
	}

	// TODO: Add smartdashboard output to update function to see which option is being used.
	
	@Override
	public void update() {
		if ( joystickMgr.moveBoulderIntakeUp() ) {
			bouldrCptr.moveUp();
		}else if( joystickMgr.moveBoulderIntakeDown() ){
			bouldrCptr.moveDown(); 
		}
		// Shooter will not fire unless there is at least some power to wheels
		boolean isShootBoulderPressed = joystickMgr.ShootBoulder();
		if (isShootBoulderPressed) {
			bouldrShtr.doShooter();
		} else if (joystickMgr.RetractShooter()) {
			bouldrShtr.retract();
		}

		double builderWheelInput = joystickMgr.spinBoulderWheels();
		if (builderWheelInput < -DEAD_ZONE) {
			bouldrWhls.SpinIntake(builderWheelInput);
		} else {
			if (builderWheelInput > DEAD_ZONE) {
				bouldrWhls.SpinIntake(builderWheelInput);			
			}
		}

	}
}

package org.usfirst.frc.team5010.boulder;

import org.usfirst.frc.team5010.oi.JoystickManager;
import org.usfirst.frc.team5010.robot.LogicManager;

public class BoulderHandler implements LogicManager {
	private JoystickManager joystickMgr;
	private BoulderCapture bouldrCptr;
	private BoulderShooter bouldrShtr;
	private BoulderWheels bouldrWhls;

	public BoulderHandler(JoystickManager joystickMgr, BoulderCapture bouldrCptr, BoulderShooter bouldrShtr,
			BoulderWheels bouldrWhls) {
		this.joystickMgr = joystickMgr;
		this.bouldrCptr = bouldrCptr;
		this.bouldrShtr = bouldrShtr;
		this.bouldrWhls = bouldrWhls;
	}

	// TODO: Add smartdashboard output to update function to see which option is being used.
	
	@Override
	public void update() {
		double upDown = joystickMgr.moveIntakeArmUpDown();
		if ( upDown > 0.1) {
			bouldrCptr.moveUp();
		}else if( upDown < -0.1){
			bouldrCptr.moveDown(); 
		}
		boolean isCaptureBoulderPressed = joystickMgr.CaptureBoulder();
		if (isCaptureBoulderPressed) {
			bouldrWhls.SpinIntake(1.0);
		} else {
			boolean isShootBoulderPressed = joystickMgr.ShootBoulder();
			if (isShootBoulderPressed) {
				bouldrWhls.SpinOuttake(1.0);
				bouldrShtr.doShooter();
			}
			// TODO Auto-generated method stub

		}

	}
}

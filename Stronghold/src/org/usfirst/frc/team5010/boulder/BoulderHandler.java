package org.usfirst.frc.team5010.boulder;

import org.usfirst.frc.team5010.oi.JoystickManager;
import org.usfirst.frc.team5010.robot.LogicManager;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BoulderHandler implements LogicManager {
	private JoystickManager joystickMgr;
	private BoulderCapture bouldrCptr;
	private BoulderShooter bouldrShtr;
	private BoulderWheels bouldrWhls;

	public BoulderHandler(JoystickManager joystickMgr) {
		this.joystickMgr = joystickMgr;
		this.bouldrCptr = new BoulderCapture();
		this.bouldrShtr = new BoulderShooter();
		this.bouldrWhls = new BoulderWheels();
		SmartDashboard.putString("Boulder Wheels", "Off");
		bouldrWhls.Stop();
	}

	@Override
	public void update() {
		if (joystickMgr.moveBoulderIntakeUp()) {
			moveCaptureUp();
		} else if (joystickMgr.moveBoulderIntakeDown()) {
			moveCaptureDown();
		}
		// Shooter will not fire unless there is at least some power to wheels
		boolean isShootBoulderPressed = joystickMgr.ShootBoulder();
		if (isShootBoulderPressed) {
			shootBoulder();
		} else if (joystickMgr.RetractShooter()) {
			retractShooter();
		}

		if (joystickMgr.captureBoulderWheels()) {
			if (!joystickMgr.highShotWheels() && !joystickMgr.lowShotWheels()) {
				SmartDashboard.putString("Boulder Wheels", "Capturing");
				bouldrWhls.captureBoulder();
			}
		} else {
			if (joystickMgr.highShotWheels() && !joystickMgr.lowShotWheels()) {
				highShotWheels();
			} else {
				if (joystickMgr.lowShotWheels()) {
					lowShotWheels();
				} else {
					stopWheels();
				}
			}
		}

	}
	
	public void shootBoulder() {
		bouldrShtr.doShooter();
		SmartDashboard.putString("shootBoulder", "works");
	}
	
	public void retractShooter() {
		bouldrShtr.retract();
	}
	
	public void lowShotWheels() {
		SmartDashboard.putString("Boulder Wheels", "LowShot");
		bouldrWhls.fastIntake();
	}
	
	public void highShotWheels() {
		SmartDashboard.putString("Boulder Wheels", "HighShot");
		bouldrWhls.highShot();
	}
	
	public void stopWheels() {
		SmartDashboard.putString("Boulder Wheels", "Off");
		bouldrWhls.Stop();
	}
	
	public void moveCaptureUp() {
		bouldrCptr.moveUp();
	}
	
	public void moveCaptureDown() {
		bouldrCptr.moveDown();
	}
	
	public BoulderCapture.ArmState getCaptureState() {
		return bouldrCptr.getArmState();
	}
	public void disable() {
		bouldrWhls.Stop();
		bouldrCptr.disable();
		bouldrShtr.retract();
	}
}

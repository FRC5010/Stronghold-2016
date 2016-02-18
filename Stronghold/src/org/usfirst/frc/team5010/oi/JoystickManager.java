package org.usfirst.frc.team5010.oi;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * JoystickManager class that will be used during processing for determining
 * which joystick is controlling an action.
 * 
 * @since January 19, 2016
 *
 */
public class JoystickManager {

	private XboxJoystick driver = new XboxJoystick(new Joystick(0));
	private XboxJoystick operator = new XboxJoystick(new Joystick(1));
	// private XboxJoystick operator = new XboxJoystick(new Joystick(1));

	/**
	 * Function for initializing the individual joysticks and adding them to a
	 * controlling structure.
	 */
	public void initController() {

	}

	/**
	 * Function for controlling the individual joysticks and having them update
	 * their individual tracking statuses.
	 */
	public void updateStatus() {
		driver.updateStatus();
		operator.updateStatus();
	}

	public double tankDriveLeft() {
		double LYaxisValue = 0;
		LYaxisValue = driver.LYaxisValue();
		SmartDashboard.putNumber("Tank Drive Left:", LYaxisValue);
	
		return LYaxisValue;
		
	}

	public double tankDriveRight() {
		double RYaxisValue = 0;
		RYaxisValue = driver.RYaxisValue();
		SmartDashboard.putNumber("Tank Drive Right:", RYaxisValue);

		return RYaxisValue;
		
	}

	/**
	 * Spin up the boulder intake wheels.
	 * 
	 * @return double
	 */
	public double spinBoulderWheels() {
		double LYaxisValue = 0;
		LYaxisValue = operator.LYaxisValue();
		SmartDashboard.putNumber("Boulder Wheel Spin", LYaxisValue);
		return LYaxisValue;
	}

	public boolean captureBoulderWheels() {
		boolean spinIn = false;
		spinIn = operator.RTrigValue() > 0.5;
		SmartDashboard.putBoolean("Boulder Wheels Spinning Inward", spinIn);
		return spinIn;
	}
	
	public boolean highShotWheels() {
		boolean spinOut = false;
		spinOut = operator.LTrigValue() > 0.5;
		SmartDashboard.putBoolean("Boulder Wheels Spinning Outward", spinOut);
		return spinOut;
	}

	/**
	 * Piston punch out.
	 * 
	 * @return boolean
	 */
	public boolean pistonPuncher() {
		boolean aButtonValue = false;
		aButtonValue = operator.isAButtonPressed();
		SmartDashboard.putBoolean("Piston Punch Value", aButtonValue);
		return aButtonValue;
	}

	/**
	 * Spin boulder intakearm wheels in.
	 * 
	 * @return boolean
	 */
	public boolean CaptureBoulder() {
		boolean lBButtonValue = false;
		lBButtonValue = operator.isLBButtonPressed();
		SmartDashboard.putBoolean("Capture Boulder Value", lBButtonValue);
		return lBButtonValue;
	}

	/**
	 * Spin boulder intakearm wheels out.
	 * 
	 * @return boolean
	 */
	public boolean ShootBoulder() {
		boolean rBButtonValue = false;
		rBButtonValue = operator.isRBButtonPressed();
		SmartDashboard.putBoolean("Shoot Boulder Value", rBButtonValue);
		return rBButtonValue;
	}
	
	/**
	 * Move boulder launcher between positions.
	 * 
	 * @return boolean
	 */
	public boolean moveBoulderIntakeUp() {
		boolean moveUp = false;
		moveUp = operator.isYButtonPressed();
		SmartDashboard.putBoolean("Intake Move Up", moveUp);
		return moveUp;
	}

	/**
	 * Move boulder launcher between positions.
	 * 
	 * @return boolean
	 */
	public boolean moveBoulderIntakeDown() {
		boolean moveDown = false;
		moveDown = operator.isAButtonPressed();
		SmartDashboard.putBoolean("Intake Move Down", moveDown);
		return moveDown;
	}

	public boolean RetractShooter() {
		boolean rBButtonValue = false;
		rBButtonValue = operator.isRBButtonReleased();
		SmartDashboard.putBoolean("Shoot Boulder Value", rBButtonValue);
		return rBButtonValue;
	}

	public boolean lowShotWheels() {
		boolean lBButtonValue = false;
		lBButtonValue = operator.isLBButtonPressed();
		SmartDashboard.putBoolean("Shoot Boulder Value", lBButtonValue);
		return lBButtonValue;
	}
}
 
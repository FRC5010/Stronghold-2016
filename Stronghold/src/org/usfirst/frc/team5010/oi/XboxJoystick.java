package org.usfirst.frc.team5010.oi;

import edu.wpi.first.wpilibj.Joystick;

public class XboxJoystick {
	private Joystick joyStick = null;

	/**
	 * Default constructor.
	 * 
	 * @param joyStk
	 *            Joystick
	 */
	public XboxJoystick(Joystick joyStick) {
		super();
		this.joyStick = joyStick;
	}

	public boolean isAButtonPressed() {
		return joyStick.getRawButton(1);
		
	}

	public boolean isBButtonPressed() {
		return joyStick.getRawButton(2);
		
	}

	public boolean isXButtonPressed() {
		return joyStick.getRawButton(3);
		
	}

	public boolean isYButtonPressed() {
		return joyStick.getRawButton(4);
		
	}
	
	public boolean isLBButtonPressed() {
		return joyStick.getRawButton(5);
		
	}
	
	public boolean isRBButtonPressed() {
		return joyStick.getRawButton(6);
		
	}
	
	public boolean isBackButtonPressed() {
		return joyStick.getRawButton(7);
		
	}
		
	public boolean isStartButtonPressed() {
		return joyStick.getRawButton(8);
		
	}
	
	public boolean isLStickButtonPressed() {
		return joyStick.getRawButton(9);
		
	}	
	
	public boolean isRStickButtonPressed() {
		return joyStick.getRawButton(10);
		
	}
	
	public double LXaxisValue(){
		return joyStick.getRawAxis(0);
		
	}
	
	public double LYaxisValue(){
		return joyStick.getRawAxis(1);
		
	}
	
	public double LTrigValue(){
		return joyStick.getRawAxis(2);
		
	}
	
	public double RTrigValue(){
		return joyStick.getRawAxis(3);
		
	}
	
	public double RXaxisValue(){
		return joyStick.getRawAxis(4);
		
	}
	
	public double RYAxisValue(){
		return joyStick.getRawAxis(5);
		
	}
	
	
	
}

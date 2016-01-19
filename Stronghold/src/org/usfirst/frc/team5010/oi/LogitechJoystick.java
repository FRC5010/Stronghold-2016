package org.usfirst.frc.team5010.oi;

import edu.wpi.first.wpilibj.Joystick;

public class LogitechJoystick {
	private Joystick joyStick = null;
	public LogitechJoystick(Joystick joyStick){
		super();
		this.joyStick = joyStick;
	}
	public boolean isTriggerPressed(){
		return joyStick.getRawButton(1);
	}
	public boolean isThumb2ButtonPressed(){
		return joyStick.getRawButton(2);
		
	}
	
	public boolean isButton3Pressed(){
		return joyStick.getRawButton(3);
		
	}
	
	public boolean isButton4Pressed(){
		return joyStick.getRawButton(4);
		
	}
	
	public boolean isButton5Pressed(){
		return joyStick.getRawButton(5);
		
	}
	
	public boolean isButton6Pressed(){
		return joyStick.getRawButton(6);
		
	}
	
	public boolean isButton7Pressed(){
		return joyStick.getRawButton(7);
		
	}
	
	public boolean isButton8Pressed(){
		return joyStick.getRawButton(8);
		
	}
	
	public boolean isButton9Pressed(){
		return joyStick.getRawButton(9);
		
	}
	
	public boolean isButton10Pressed(){
		return joyStick.getRawButton(10);
		
	}
	
	public boolean isButton11Pressed(){
		return joyStick.getRawButton(11);
		
	}
	
	public double XaxisValue(){
		return joyStick.getRawAxis(0);
		
	}
	
	public double YaxisValue(){
	    return joyStick.getRawAxis(1);
	    
	}
	
	public double ZaxisValue(){
		return joyStick.getRawAxis(2);
				
	}
	
}

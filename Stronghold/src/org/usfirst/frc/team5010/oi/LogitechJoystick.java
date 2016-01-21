package org.usfirst.frc.team5010.oi;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.Joystick;

public class LogitechJoystick implements JoystickController {
	private Joystick joyStick = null;
	private ArrayList<Boolean> currentStatus = new ArrayList<>(13);
	private ArrayList<Boolean> previousStatus = new ArrayList<>(13);
	private ArrayList<Double> currentAxis = new ArrayList<>(3);
	
	public LogitechJoystick(Joystick joyStick){
		super();
		this.joyStick = joyStick;
		for(int i = 1; i < 12; ++i) {
			currentStatus.add(false);
			previousStatus.add(false);
		}
		for(int i = 0; i < 3; ++i) {
			currentAxis.add(0.0);
		}
	}
	public boolean isTriggerPressed(){
		return isButtonPressed(1);
	}
	public boolean isThumb2ButtonPressed(){
		return isButtonPressed(2);
		
	}
	
	public boolean isLaunchButtonPressed(){
		return isButtonPressed(3);
		
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
	@Override
	public boolean isButtonPressed(int buttonNbr) {
		return(currentStatus.get(buttonNbr) == previousStatus.get(buttonNbr));
	}
	@Override
	public boolean isButtonReleased(int buttonNbr) {
		return !isButtonPressed(buttonNbr);
		
	}
	@Override
	public void updateStatus() {
		for(int i = 1; i < 12; ++i){
			previousStatus.set(i, currentStatus.get(i));
			currentStatus.set(i, joyStick.getRawButton(i));
		}
		for(int i = 0; i < 3; ++i) {
			currentAxis.set(i, joyStick.getRawAxis(i));
		}
	}
	
}

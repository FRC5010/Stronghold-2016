package org.usfirst.frc.team5010.oi;

import edu.wpi.first.wpilibj.Joystick;

public abstract class LogitechJoystick extends BaseJoystick
	implements JoystickController {
	
	private Joystick joyStick = null;
	private boolean[] currentButtonStatus = new boolean[12];
	private boolean[] previousButtonStatus = new boolean[12];
	private double[] currentAxis = new double[3];
	
	public LogitechJoystick(Joystick joyStick){
		super();
		this.joyStick = joyStick;
		for(int i = 0; i < 12; ++i) {
			currentButtonStatus[i] = false;
			previousButtonStatus[i] = false;
		}
		for(int i = 0; i < 3; ++i) {
			currentAxis[i] = 0.0;
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
		if (currentButtonStatus[buttonNbr] 
				&& currentButtonStatus[buttonNbr] != previousButtonStatus[buttonNbr])
		{
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isButtonReleased(int buttonNbr) {
		if (!currentButtonStatus[buttonNbr]
				&& currentButtonStatus[buttonNbr] != previousButtonStatus[buttonNbr])
		{
			return true;
		}
		return false;
	}
	
	@Override
	public void updateStatus() {
		// Since there are only 11 buttons (and start at 1), only process 1 - 11.
		for(int i = 1; i < 12; ++i){
			previousButtonStatus[i] = currentButtonStatus[i];
			currentButtonStatus[i] = joyStick.getRawButton(i);
		}
		
		for(int i = 0; i < 3; ++i) {
			currentAxis[i] = joyStick.getRawAxis(i);
		}
	}
	
}

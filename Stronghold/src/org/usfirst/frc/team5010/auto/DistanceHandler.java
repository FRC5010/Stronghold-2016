package org.usfirst.frc.team5010.auto;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DistanceHandler {
	AnalogInput rangerIn;
	private final double voltsToInches = 1;
	
	public DistanceHandler() {
		rangerIn = new AnalogInput(0);
		SmartDashboard.putNumber("Volts To Inches", voltsToInches);
	}
	
	public double getRange() {
		SmartDashboard.getNumber("Volts To Inches", voltsToInches);
		double value = rangerIn.getValue() * voltsToInches;
		return value;
	}
}

package org.usfirst.frc.team5010.boulder;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BoulderShooter {

	public void doShooter() {
		SmartDashboard.putString("Shooter:", "PEW! PEW!");
		
	}

	public void retract() {
		SmartDashboard.putString("Shooter:", "WAITING!");
		
	}

}

package org.usfirst.frc.team5010.boulder;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BoulderShooter {
	private Solenoid shooter;
	public BoulderShooter(){
		shooter = new Solenoid(2);
		shooter.set(false);
	}

	public void doShooter() {
		SmartDashboard.putString("Shooter:", "PEW! PEW!");
		shooter.set(true);
	}

	public void retract() {
		SmartDashboard.putString("Shooter:", "WAITING!");
		shooter.set(false);
		
	}

}

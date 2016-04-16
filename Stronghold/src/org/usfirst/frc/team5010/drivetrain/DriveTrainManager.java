package org.usfirst.frc.team5010.drivetrain;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Primary class for controlling drive train.
 * 
 * @since January 23, 2016
 *
 */
public class DriveTrainManager implements PIDOutput {

	// Define drive channels
	private final int leftMotor1Channel = 4;
	private final int leftMotor2Channel = 0;
	private final int rightMotorChannel = 1;


	private Victor leftMotor1 = null;
	private Talon leftMotor2 = null;
	private Victor rightMotor1 = null;
	
	

	private static final DriveTrainManager driveTrainInstance = new DriveTrainManager();

	/**
	 * Factory method to always return the same instance.
	 * 
	 * @return DriveTrainManager
	 */
	public static DriveTrainManager getInstance() {
		return driveTrainInstance;
	}

	/**
	 * Default constructor.
	 */
	public DriveTrainManager() {
	}

	public void robotInit() {
		leftMotor1 = new Victor(leftMotor1Channel);
		leftMotor2 = new Talon(leftMotor2Channel);
		
		rightMotor1 = new Victor(rightMotorChannel);
	}

	// Stop function. Copy into BoulderWheels. 2/15/16
//	public void stop() {
//		Runnable task = () -> {
//			stopLeftWheel();
//		};
//		Thread stopLeft = new Thread(task);
//		stopLeft.start();
//		stopRightWheel();
//	}

	public void powerLeftNormal(double power) {
		leftMotor1.set(power);
		leftMotor2.set(power);
		SmartDashboard.putNumber("Left power1:", leftMotor1.get());
		SmartDashboard.putNumber("left power2:", leftMotor2.get());
		
		
	}

	public void powerRightNormal(double power) {
		rightMotor1.set(power);
		SmartDashboard.putNumber("Right power:", rightMotor1.get());
	}
	public void powerBothNormal(double power) {
		powerLeftNormal(-power);
		powerRightNormal(power);
	}

	//TODO FIX left side
//	public void stopLeftWheel() {
//		double currentLPower = leftMotor1.get();// Get the current power										
//		// setting
//		double powerToArrestMom = -(currentLPower / 2); // that's momentum, not
//														// your Mom!
//		// You may have to play with this calculation in order to get the
//		// stopping just right
//		// Maybe just raise the 2 to a 3 or 4, possibly a fractional value. It
//		// will take some experimentation
//
//		if (powerToArrestMom < 0) {
//			for (double rLPower = 0; rLPower > powerToArrestMom; rLPower -= 0.01) {
//				leftMotor1.set(rLPower); // Gradually give more power to stop
//				leftMotor2.set(rLPower);		// the wheels
//			}
//		} else {
//			for (double rLPower = 0; rLPower < powerToArrestMom; rLPower += 0.01) {
//				leftMotor1.set(rLPower);
//				leftMotor2.set(rLPower);
//			}
//		}
//		// Now that mom is arrested, set power to wheel to 0.
//		leftMotor1.set(0);
//	}

//	public void stopRightWheel() {
//		double currentRPower = rightMotor1.get(); // Get the current power
//													// setting
//		double powerToArrestMom = -(currentRPower / 2); // that's momentum, not
//														// your Mom!
//		// You may have to play with this calculation in order to get the
//		// stopping just right
//		// Maybe just raise the 2 to a 3 or 4, possibly a fractional value. It
//		// will take some experimentation
//
//		if (powerToArrestMom < 0) {
//			for (double rRPower = 0; rRPower > powerToArrestMom; rRPower -= 0.01) {
//				rightMotor1.set(rRPower); // Gradually give more power to stop
//											// the wheels
//			}
//		} else {
//			for (double rRPower = 0; rRPower < powerToArrestMom; rRPower += 0.01) {
//				rightMotor1.set(rRPower);
//			}
//		}
//		// Now that mom is arrested, set power to wheel to 0.
//		rightMotor1.set(0);
//	}

	@Override
	public void pidWrite(double output) {


	}

}
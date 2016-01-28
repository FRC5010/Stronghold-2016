package org.usfirst.frc.team5010.drivetrain;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Primary class for controlling drive train.
 * @since January 23, 2016
 *
 */
public class DriveTrainManager implements PIDOutput {
    private Victor leftMotor1 = new Victor(0);
//    private final Victor leftMotor2 = new Victor(2);
    private Victor rightMotor1 = new Victor(1);
//    private final Victor rightMotor2 = new Victor(3);
    private AnalogInput channel = new AnalogInput(1);
    private AnalogGyro gyro = new AnalogGyro(channel);
    private PIDController pid = new PIDController(.1, 0, 0, gyro, this);
    private SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftMotor1);
    private SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightMotor1);
    private boolean isPIDing = false;
    
    private static final DriveTrainManager driveTrainInstance = new DriveTrainManager();

    /**
     * Factory method to always return the same instance.
     * @return DriveTrainManager
     */
    public static DriveTrainManager getInstance()
    {
    	return driveTrainInstance;
    }

    /**
     * Default constructor.
     */
    public DriveTrainManager(){
		gyro.setPIDSourceType(PIDSourceType.kRate);	// TODO Question the use of this value
		pid.setOutputRange(-1, 1);
		pid.enable();
    }

    public void setForward(double power){
		if(!isPIDing){
		    powerLeftAuton(power);
		    powerRightAuton(power);
		}
		else {
			powerLeftNormal(power);
			powerRightNormal(power);
		}
    }

    public void setGyroAngle(double point){
    	pid.setSetpoint(point);
    }
    
    public void resetGyro(){
		double error = pid.getError();
		gyro.reset();
		pid.setSetpoint(-error);
    }

    public void setPIDEnable(boolean enabled){
		if (enabled){
		    isPIDing = true;
		}
		else{
		    isPIDing = false;
		}
    }

    public void powerLeftAuton(double power){
    	leftMotors.set(power);
    	SmartDashboard.putNumber("Left power:", leftMotors.get());
    }
 
    public void powerRightAuton(double power) {
    	rightMotors.set(power);
    	SmartDashboard.putNumber("Right power:", rightMotors.get());
    }
    
    public void powerLeftNormal(double power){
		leftMotors.set(power);
		SmartDashboard.putNumber("Left power:", leftMotors.get());
    }

    public void powerRightNormal(double power){
		rightMotors.set(power);
		SmartDashboard.putNumber("Right power:", rightMotors.get());
    }
    
    public boolean isPIDing(){
    	return isPIDing;
    }

	@Override
	public void pidWrite(double output) {
		// TODO Figure out what to write for pidWrite.
		
	}
    
}

package org.usfirst.frc.team5010.drivetrain;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Primary class for controlling drive train.
 * @since January 23, 2016
 *
 */
public class DriveTrainManager implements PIDOutput {
	// Define drive channels
	private final int leftMotorChannel = 1;
	private final int rightMotorChannel = 2;
	private final int gyroChannel = 2;
	
	
    private Victor leftMotor1 = null;//new Victor(leftMotorChannel);
//    private final Victor leftMotor2 = new Victor(2);
    private Victor rightMotor1 = null;//new Victor(rightMotorChannel);
//    private final Victor rightMotor2 = new Victor(3);
//    private AnalogInput channel = new AnalogInput(gyroChannel);
//    private Gyro gyro = new Gyro(channel);
//    private PIDController pid = new PIDController(.1, 0, 0, gyro, this);
    private SpeedControllerGroup leftMotors;
    private SpeedControllerGroup rightMotors;
    private boolean isFullPower = false;
    private final double autoPowerLevel = 0.75;
    
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
//		gyro.setPIDSourceParameter(PIDSource.PIDSourceParameter.kRate);	// TODO Question the use of this value
//		pid.setOutputRange(-1, 1);
//		pid.enable();
    }

    public void teleopInit() {
    	leftMotor1 = new Victor(leftMotorChannel);
    	rightMotor1 = new Victor(rightMotorChannel);
    }
    
    public void setForward(double power){
		if(!isFullPower){
		    powerLeftAuton(power);
		    powerRightAuton(power);
		}
		else {
			powerLeftNormal(power);
			powerRightNormal(power);
		}
    }

    public void setGyroAngle(double point){
//    	pid.setSetpoint(point);
    }
    
    public void resetGyro(){
//		double error = pid.getError();
//		gyro.reset();
//		pid.setSetpoint(-error);
    }

    public void setIsFullPower(boolean enabled){
		if (enabled){
		    isFullPower = true;
		}
		else{
		    isFullPower = false;
		}
    }

    public void powerLeftAuton(double power){
    	leftMotor1.set(power * autoPowerLevel);
    	SmartDashboard.putNumber("Left power:", leftMotor1.get());
    }
 
    public void powerRightAuton(double power) {
    	rightMotor1.set(power * autoPowerLevel);
    	SmartDashboard.putNumber("Right power:", rightMotor1.get());
    }
    
    public void powerLeftNormal(double power){
		leftMotor1.set(power);
		SmartDashboard.putNumber("Left power:", leftMotor1.get());
    }

    public void powerRightNormal(double power){
		rightMotor1.set(power);
		SmartDashboard.putNumber("Right power:", rightMotor1.get());
    }
    
    public boolean isFullPower(){
    	return isFullPower;
    }

	@Override
	public void pidWrite(double output) {
		// TODO Figure out what to write for pidWrite.
		
	}
    
}


package org.usfirst.frc.team5010.robot;

import org.usfirst.frc.team5010.auto.AutoModeManager;
import org.usfirst.frc.team5010.drivetrain.DriveTrainManager;
import org.usfirst.frc.team5010.drivetrain.TankDriver;
import org.usfirst.frc.team5010.oi.JoystickManager;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	AutoModeManager autoMgr;
	JoystickManager joystickMgr = null;
	DriveTrainManager driveTrain = null;
	private TankDriver tankDriver;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		// Initialize auto mode manager
		AutoModeManager.init();

		// Initialize joystick control
		joystickMgr = new JoystickManager();
		joystickMgr.initController();

		driveTrain = new DriveTrainManager();
		SmartDashboard.putNumber("name", 3.1415);
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the
	 * switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	public void autonomousInit() {
		autoMgr = AutoModeManager.get();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		autoMgr.run();
	}

	@Override
	public void teleopInit() {
		// TODO Auto-generated method stub
		driveTrain.teleopInit();
		tankDriver = new TankDriver(joystickMgr, driveTrain);
	} 

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		joystickMgr.updateStatus();
		tankDriver.update();
		// logicManager.updateButtons();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {

	}

}

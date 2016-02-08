
package org.usfirst.frc.team5010.robot;

import org.usfirst.frc.team5010.auto.AutoModeManager;
import org.usfirst.frc.team5010.boulder.BoulderHandler;
import org.usfirst.frc.team5010.drivetrain.DriveTrainManager;
import org.usfirst.frc.team5010.drivetrain.TankDriver;
import org.usfirst.frc.team5010.oi.JoystickManager;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	// TODO: Add classes and initialize boulder handler in teleopInit
	
	private AutoModeManager autoMgr;
	private JoystickManager joystickMgr = null;
	private DriveTrainManager driveTrain = null;
	private BoulderHandler boulderHndlr = null;
	private TankDriver tankDriver;
	CameraServer server;
	
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
		
		server = CameraServer.getInstance();
        server.setQuality(100);
        server.startAutomaticCapture("cam0");
    
		driveTrain = new DriveTrainManager();
		driveTrain.roboInit();
		tankDriver = new TankDriver(joystickMgr, driveTrain);
		
		boulderHndlr = new BoulderHandler(joystickMgr);
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
		autoMgr.initAuton();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		while (isAutonomous() && isEnabled())
		{
    	    try {
    	    	Thread.sleep(5);
    	    }
    	    catch (InterruptedException ie) {
    	    	//do nothing
    	    }

    	    autoMgr.run(driveTrain);
		}
	}

	@Override
	public void teleopInit() {
		// TODO Auto-generated method stub
		
	} 

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		joystickMgr.updateStatus();
		tankDriver.update();
		boulderHndlr.update();
		// logicManager.updateButtons();
		
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {

	}

}

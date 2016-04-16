package org.usfirst.frc.team5010.auto.modes;

import org.usfirst.frc.team5010.boulder.BoulderHandler;
import org.usfirst.frc.team5010.drivetrain.DriveTrainManager;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoModeManager implements AutoModeInterface {
	// Static parts of the class that are used to determine
	// what kind of sub-class to create.
	private static final String spybotMode = "Spy-Bot Mode";
	private static final String position1 = "Position One";
	private static final String position2 = "Position Two";
	private static final String position3 = "Position Three";
	private static final String position4 = "Position Four";
	private static final String position5 = "Position Five";
	private static final String testMode = "Test Mode";
	
	private static final String lowBarMode = "Low Bar";

	private static String modeSelected;
	private static SendableChooser chooser;
	private static AutoModeInterface instance = null;

	// Static init function called by robotInit()
	public static void init() {
		chooser = new SendableChooser();
		chooser.addDefault(spybotMode, spybotMode);
		chooser.addDefault(lowBarMode, lowBarMode);
		chooser.addObject("Go straight", position1);
		//chooser.addObject(position2, position2);
		//chooser.addObject(position3, position3);
		//chooser.addObject(position4, position4);
		//chooser.addObject(position5, position5);
		chooser.addObject("do nothing", testMode);

		SmartDashboard.putData("Auto modes", chooser);
	}

	// Auto-mode type chooser called by autonomousInit()
	public static AutoModeInterface get() {
		if (instance == null) {
			modeSelected = (String) chooser.getSelected();
			System.out.println("Auto mode selected: " + modeSelected);

			switch (modeSelected) {
			case spybotMode:
				instance = new SpybotManager();
				break;
			case position1:
				instance = new Position1Manager();
				break;
			case position2:
				// instance =  new Position2Manager();
				break;
			case position3:
				 instance =  new Position3Manager();
				break;
			case position4:
				// instance =  new Position4Manager();
				break;
			case position5:
				// instance =  new Position5Manager();
				break;
			case testMode:
				instance = new AutonTestMode();
				break;
			case lowBarMode:
				instance = new LowBarMode();
				break;
			default: // Something went wrong with mode selection
				// return this class to do nothing in auto mode
				instance = new AutoModeManager();
			}
		}
		return instance;
	}

	@Override
	public void run() {

	}

	@Override
	public void initAuton(DriveTrainManager driveTrain, BoulderHandler boulderHndlr) {
		
	}

	@Override
	public void stop() {
		
	}
}

package org.usfirst.frc.team5010.auto;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoModeManager {
	// Static parts of the class that are used to determine
	// what kind of sub-class to create.
	private static final String spybotMode = "Spy-Bot Mode";
	private static final String position2 = "Position Two";
	private static final String position3 = "Position Three";
	private static final String position4 = "Position Four";
	private static final String position5 = "Position Five";

	private static String modeSelected;
	private static SendableChooser chooser;
	private static AutoModeManager instance = null;

	// Static init function called by robotInit()
	public static void init() {
		chooser = new SendableChooser();
		chooser.addDefault(spybotMode, spybotMode);
		chooser.addObject(position2, position2);
		chooser.addObject(position3, position3);
		chooser.addObject(position4, position4);
		chooser.addObject(position5, position5);

		SmartDashboard.putData("Auto modes", chooser);
	}

	// Auto-mode type chooser called by autonomousInit()
	public static AutoModeManager get() {
		if (instance == null) {
			modeSelected = (String) chooser.getSelected();
			System.out.println("Auto mode selected: " + modeSelected);

			switch (modeSelected) {
			case spybotMode:
				instance = new SpybotManager();
			case position2:
				// instance =  new Position2Manager();
				break;
			case position3:
				// instance =  new Position3Manager();
				break;
			case position4:
				// instance =  new Position4Manager();
				break;
			case position5:
				// instance =  new Position5Manager();
				break;
			default: // Something went wrong with mode selection
				// return this class to do nothing in auto mode
				instance = new AutoModeManager();
			}
		}
		return instance;
	}

	public void run() {

	}
}

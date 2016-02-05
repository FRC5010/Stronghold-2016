//TODO Remove??? 2/4/16

package org.usfirst.frc.team5010.scalingArm;

import org.usfirst.frc.team5010.oi.JoystickManager;

public class HeightAdjusterManager {
	private Camtilt cmtlt;
	private CastleScalingArm caslteScalArm;
	private HeightAdjusterListener heightAdjusterLstnr;
	private JoystickManager joystickMgr;

	public HeightAdjusterManager (JoystickManager joystickMgr, HeightAdjusterListener heightAdjusterLstnr, CastleScalingArm castleScalArm, Camtilt cmtlt) {
this.joystickMgr = joystickMgr;
this.heightAdjusterLstnr = heightAdjusterLstnr;
this.caslteScalArm = castleScalArm;
this.cmtlt = cmtlt;
}
}

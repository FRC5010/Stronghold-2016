package org.usfirst.frc.team5010.auto.steps;

import org.usfirst.frc.team5010.boulder.BoulderHandler;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MoveArm implements AutoModeStep {
	private long autonStartTime;
	private long FORWARDTIME = 2000;
	private BoulderHandler boulderHndlr;
	private boolean upDown;
	private boolean accomplished = false;

	public MoveArm(BoulderHandler boulderHndlr, boolean upDown) {
		this.boulderHndlr = boulderHndlr;
		this.upDown = upDown;
	}

	@Override
	public void startStep() {
		SmartDashboard.putBoolean("UpDown", upDown);
		autonStartTime = System.currentTimeMillis();
		FORWARDTIME += autonStartTime;

	}

	@Override
	public void update() {
		if (upDown) {
			boulderHndlr.moveCaptureUp();
			if (System.currentTimeMillis() > FORWARDTIME)
				accomplished = true;
		} else {
			boulderHndlr.moveCaptureDown();
			if (System.currentTimeMillis() > FORWARDTIME)
				accomplished = true;
		}
		
	}

	@Override
	public boolean accomplished() {
		return accomplished;
	}

}

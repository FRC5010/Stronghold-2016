package org.usfirst.frc.team5010.auto.steps;

import org.usfirst.frc.team5010.boulder.BoulderHandler;

public class MoveArm implements AutoModeStep {
	private BoulderHandler boulderHndlr;
	private boolean upDown;
	private boolean accomplished = false;

	public MoveArm(BoulderHandler boulderHndlr, boolean upDown) {
		this.boulderHndlr = boulderHndlr;
		this.upDown = upDown;
	}

	@Override
	public void startStep() {
		if (upDown) {
			boulderHndlr.moveCaptureUp();
		} else {
			boulderHndlr.moveCaptureDown();
		}
		accomplished = true;

	}

	@Override
	public void update() {

	}

	@Override
	public boolean accomplished() {
		return accomplished;
	}

}

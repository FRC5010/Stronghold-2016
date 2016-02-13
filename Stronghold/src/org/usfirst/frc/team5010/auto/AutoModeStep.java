package org.usfirst.frc.team5010.auto;

public interface AutoModeStep {
	public void startStep();
	public void update();
	public boolean accomplished();
}

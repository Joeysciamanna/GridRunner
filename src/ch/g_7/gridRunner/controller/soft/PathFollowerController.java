package ch.g_7.gridRunner.controller.soft;

import java.util.Random;
import java.util.Vector;

import ch.g_7.gridEngine.base.Dimension;
import ch.g_7.gridEngine.base.Position;
import ch.g_7.gridRunner.base.Controlable;
import ch.g_7.gridRunner.base.Startable;
import ch.g_7.gridRunner.bot.pathprovider.BasicStepProvider;
import ch.g_7.gridRunner.bot.pathprovider.StepProvider;
import ch.g_7.gridRunner.fields.controlable.Player;

public class PathFollowerController extends SoftController implements Runnable, Startable{

	private final static int SPEED = 500;
	private StepProvider stepProvider;
	private boolean run;
	
	public PathFollowerController(Controlable player, StepProvider stepProvider) {
		super(player);
		this.stepProvider = stepProvider;
	}

	@Override
	public void run() {
		try {
			while(run) {
				control();
				Thread.sleep(SPEED);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	protected void control() {
		Dimension next = stepProvider.next();
		if(next!=null) {
			controlable.move(next);
		}
	}

	@Override
	public void start() {
		if(!run) {
			run=true;
			Thread t = new Thread(this);
			t.start();
		}
	}


	@Override
	public void stop() {
		run = false;
	}

}

package ch.g_7.gridRunner.controller.bot;

import java.util.Random;
import java.util.Vector;

import ch.g_7.gridEngine.base.Dimension;
import ch.g_7.gridEngine.base.Position;
import ch.g_7.gridRunner.base.Controlable;
import ch.g_7.gridRunner.base.Startable;
import ch.g_7.gridRunner.bot.pathprovider.BasicStepProvider;
import ch.g_7.gridRunner.bot.pathprovider.StepProvider;
import ch.g_7.gridRunner.controller.Controller;
import ch.g_7.gridRunner.field.controlable.Player;

public class PathFollowerController extends Controller<Controlable> implements Runnable, Startable{

	private final static int SPEED = 500;
	private StepProvider stepProvider;
	private boolean run;
	
	public PathFollowerController(Controlable player) {
		super(player);
	}

	public PathFollowerController(Controlable player,StepProvider stepProvider) {
		super(player);
		setStepProvider(stepProvider);
	}

	
	public void setStepProvider(StepProvider stepProvider) {
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
		if(!run && stepProvider!=null) {
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

package ch.g_7.gridRunner.controller.bot;

import ch.g_7.gridEngine.base.Dimension;
import ch.g_7.gridEngine.core.FieldGrid;
import ch.g_7.gridRunner.base.Startable;
import ch.g_7.gridRunner.controller.bot.aim.AimProvider;
import ch.g_7.gridRunner.controller.bot.search.Searcher;
import ch.g_7.gridRunner.controller.bot.step.RefreshingSearchPathStepProvider;
import ch.g_7.gridRunner.field.controlable.Bot;

public class FollowController extends BotController implements Runnable{

	private static final int SPEED = 200;
	private RefreshingSearchPathStepProvider stepProvider;
	private boolean run;
	
	public FollowController(Bot controlable, AimProvider aimProvider, FieldGrid grid, Searcher searcher) {
		super(controlable);
		stepProvider = new RefreshingSearchPathStepProvider(searcher, aimProvider);
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
			stepProvider.start();
			run=true;
			Thread t = new Thread(this);
			t.start();
		}
	}


	@Override
	public void stop() {
		run = false;
		stepProvider.stop();
	}

	@Override
	public String getControllerName() {
		return "FollowController";
	}
}

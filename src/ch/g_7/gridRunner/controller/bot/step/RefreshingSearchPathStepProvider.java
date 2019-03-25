package ch.g_7.gridRunner.controller.bot.step;

import java.util.ArrayList;

import ch.g_7.gridEngine.base.Dimension;
import ch.g_7.gridEngine.base.Localizable;
import ch.g_7.gridEngine.field.Field;
import ch.g_7.gridEngine.field.building.FieldCode;
import ch.g_7.gridRunner.base.Startable;
import ch.g_7.gridRunner.controller.bot.aim.AimProvider;
import ch.g_7.gridRunner.controller.bot.search.Coordinate;
import ch.g_7.gridRunner.controller.bot.search.Searcher;
import ch.g_7.gridRunner.field.controlable.Player;

public class RefreshingSearchPathStepProvider extends BasicStepProvider implements Startable{

	private static final int SLEEP_TIME = 2000;
	private Searcher searcher;
	private Refresher refresher;
	private AimProvider aimProvider;
	
	public RefreshingSearchPathStepProvider(Searcher searcher, AimProvider aimProvider) {
		super(searcher.solve());
		this.searcher = searcher;
		this.aimProvider = aimProvider;
	}

	@Override
	public void start() {
		if(refresher==null) {
			refresher = new Refresher();
			Thread t = new Thread(refresher);
			refresher.run = true;
			t.start();
		}
	}

	@Override
	public void stop() {
		if(refresher!=null) {
			refresher.run = false;
			refresher = null;
		}
	}

	private class Refresher implements Runnable{
		
		private boolean run;
		
		@Override
		public void run() {
			while(run) {
				try {
					Thread.sleep(SLEEP_TIME);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				searcher.setAim(aimProvider.getAim());
				Coordinate c = searcher.solve();
				setCoordinates(c);
			}
		}
	}

}

package ch.g_7.gridRunner.bot.pathprovider;

import java.util.ArrayList;

import ch.g_7.gridEngine.base.Dimension;
import ch.g_7.gridEngine.base.Localizable;
import ch.g_7.gridEngine.field.Field;
import ch.g_7.gridEngine.field.building.FieldCode;
import ch.g_7.gridRunner.base.Startable;
import ch.g_7.gridRunner.bot.search.Coordinate;
import ch.g_7.gridRunner.bot.search.Searcher;
import ch.g_7.gridRunner.field.controlable.Player;

public class RefreshingSearchPathProvider extends BasicStepProvider implements Startable{

	
	private static final int SLEEP_TIME = 2000;
	private Searcher searcher;
	private Refresher refresher;
	
	public RefreshingSearchPathProvider(Searcher searcher) {
		super(searcher.solve());
		this.searcher = searcher;
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
				searcher.setAim(getAim());
				Coordinate c = searcher.solve();
				setCoordinates(c);
			}
		}

		private Field<?> getAim(){
			ArrayList<Field<?>> aims = searcher.getGrid().getNearestFieldsWhere(new FieldCode("PLAYER"),searcher.getStart().getPosition());
			for (Field<?> field : aims) {
				if(!((Player)field).isBot()) {
					return field;
				}
			}
			return aims.get(0);
		}
	}

}

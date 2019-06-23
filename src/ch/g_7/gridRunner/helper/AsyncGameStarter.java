package ch.g_7.gridRunner.helper;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JComponent;
import javax.swing.JPanel;

import ch.g_7.gridEngine.core.FieldGrid;
import ch.g_7.gridEngine.helper.Calculator;
import ch.g_7.gridEngine.helper.Lambda;
import ch.g_7.gridRunner.controller.Controller;
import ch.g_7.gridRunner.gameCreation.GameCreator;
import ch.g_7.gridRunner.gameCreation.GameInstace;
import ch.g_7.gridRunner.gui.Window;
import ch.g_7.gridRunner.inventory.Inventory;

public class AsyncGameStarter extends TimerTask{

	private GameCreator creator;
	private GameInstace game;
	private JComponent panel;
	private Timer timer;
	private Lambda<Void, AsyncGameStarter> onGameStart;
	
	public AsyncGameStarter(JComponent panel,GameCreator creator) {
		this.panel = panel;
		this.creator = creator;
	}

	public void startStarting() {
		timer = new Timer();
		creator.create();
		timer.schedule(this, 100);
		
	}
	
	@Override
	public void run() {
		game = creator.getGame();
		while (game == null) {
			game = creator.getGame();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		FieldGrid grid = game.getGrid();
		panel.setLayout(null);
		grid.getPanel().setLocation(0, 0);
		panel.add(grid.getPanel());

		Dimension gridSize = Calculator.calcSize(grid.getMapSizeInFields(), grid.getFieldSize());
		Inventory inventory = new Inventory(new Dimension(gridSize.width, grid.getFieldSize().height));
		inventory.getPanel().setLocation(new Point(0, gridSize.height));
		panel.add(inventory.getPanel());
		panel.setSize(new Dimension(gridSize.width, gridSize.height + grid.getFieldSize().height));
		game.activate();
		
		for(Controller c : game.getControllers()) {
			Window.addController(c);
		}
		
		if(onGameStart != null) {
			onGameStart.apply(this);
		}
		timer.cancel();
	}
	
	public GameInstace getGame() {
		return game;
	}
	
	public void onGameStart(Lambda<Void, AsyncGameStarter> l) {
		onGameStart = l;
	}
}

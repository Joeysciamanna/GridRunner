package ch.g_7.gridRunner.gui.main;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ch.g_7.gridEngine.core.FieldGrid;
import ch.g_7.gridEngine.field.building.FieldCreationRegister;
import ch.g_7.gridEngine.helper.Calculator;
import ch.g_7.gridRunner.fields.creation.GridRunnerFieldFactory;
import ch.g_7.gridRunner.gameInstantiation.GameCreationEvent;
import ch.g_7.gridRunner.gameInstantiation.GameCreator;
import ch.g_7.gridRunner.gameInstantiation.GameInstace;
import ch.g_7.gridRunner.inventory.Inventory;

public class GameScreen extends Screen<JPanel>{

	private JPanel panel = new JPanel();
	
	public GameScreen() {
		panel.setLayout(null);
	}
	
	@Override
	public JPanel getPanel() {
		return panel;
	}

	public void start(GameInstace game) {
		FieldGrid grid = game.getGrid();
		grid.getPanel().setLocation(new Point(0, 0));
		panel.add(grid.getPanel());
		
		Dimension gridSize = Calculator.calcSize(grid.getMapSizeInFields(), grid.getFieldSize());
		
		Inventory inventory = new Inventory(new Dimension(gridSize.width, grid.getFieldSize().height));
		inventory.getPanel().setLocation(new Point(0, gridSize.height));
		panel.add(inventory.getPanel());
	
		Window.getInstance().addKeyListener(game.getController1());
		Window.getInstance().addKeyListener(game.getController2());
		
		game.activateControllers();
		
		panel.updateUI();
	}
}

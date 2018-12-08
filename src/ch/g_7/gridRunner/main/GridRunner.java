package ch.g_7.gridRunner.main;

import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JFrame;
import ch.g_7.gridEngine.core.FieldGrid;
import ch.g_7.gridEngine.field.building.FieldCreationRegister;
import ch.g_7.gridEngine.helper.Calculator;
import ch.g_7.gridRunner.fields.building.GridRunnerFieldFactory;
import ch.g_7.gridRunner.gameCreation.GameCreationEvent;
import ch.g_7.gridRunner.gameCreation.GameCreator;
import ch.g_7.gridRunner.gameCreation.GameInstace;
import ch.g_7.gridRunner.inventory.Inventory;

public class GridRunner {

	public static void main(String[] args) {
		FieldCreationRegister.setDefaultFactory(new GridRunnerFieldFactory());
		
		JFrame window = new JFrame("Grid Runner");
		window.getContentPane().setLayout(null);
		
		GameInstace game = GameCreator.getNewGame(new GameCreationEvent(false,"map1"));
		
		FieldGrid grid = game.getGrid();
		grid.getPanel().setLocation(new Point(0, 0));
		window.add(grid.getPanel());
		
		Dimension gridSize = Calculator.calcSize(grid.getMapSizeInFields(), grid.getFieldSize());
		
		Inventory inventory = new Inventory(new Dimension(gridSize.width, grid.getFieldSize().height));
		inventory.getPanel().setLocation(new Point(0, gridSize.height));
		window.add(inventory.getPanel());
	
		window.addKeyListener(game.getController1());
		window.addKeyListener(game.getController2());
		
		game.activateControllers();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}

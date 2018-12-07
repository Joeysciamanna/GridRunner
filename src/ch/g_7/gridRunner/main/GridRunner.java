package ch.g_7.gridRunner.main;

import java.awt.Dimension;
import java.awt.Point;
import java.io.File;

import javax.swing.JFrame;

import ch.g_7.gridEngine.core.FieldGrid;
import ch.g_7.gridEngine.field.building.FieldCreationRegister;
import ch.g_7.gridEngine.helper.Calculator;
import ch.g_7.gridEngine.stream.MapReader;
import ch.g_7.gridRunner.fields.building.GridRunnerFieldFactory;
import ch.g_7.gridRunner.inventory.Inventory;

public class GridRunner {

	public static void main(String[] args) {
		FieldCreationRegister.setDefaultFactory(new GridRunnerFieldFactory());
		
		JFrame window = new JFrame("Grid Runner");
		window.getContentPane().setLayout(null);
		
		FieldGrid grid = new MapReader(new File("resources/maps/map1.xml")).read().getGrid();
		grid.getPanel().setLocation(new Point(0, 0));
		window.add(grid.getPanel());
		
		Dimension gridSize = Calculator.calcSize(grid.getMapSize(), grid.getFieldSize());
		
		Inventory inventory = new Inventory(new Dimension(gridSize.width, grid.getFieldSize().height));
		inventory.getPanel().setLocation(new Point(0, gridSize.height));
		window.add(inventory.getPanel());
		
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}

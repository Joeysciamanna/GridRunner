package ch.g_7.gridRunner.gui;

import ch.g_7.gridEngine.field.building.FieldCreationRegister;
import ch.g_7.gridRunner.fieldCreation.GridRunnerFieldFactory;
import ch.g_7.gridRunner.gui.home.ConfigPane;
import ch.g_7.gridRunner.gui.home.HomeMenue;
import ch.g_7.gridRunner.gui.home.MainPane;
import static ch.g_7.gridRunner.gui.Window.*;

import java.awt.Color;

public class Test {

	public static Window window;
	
	public static void main(String[] args) {
		FieldCreationRegister.setDefaultFactory(new GridRunnerFieldFactory());
		init();
		HomeMenue homeMenue = HomeMenue.getInstance();
		MainPane mainPane = MainPane.getInstance();
		ConfigPane configPane = ConfigPane.getInstance();
		homeMenue.addButton("Home", mainPane.getPanel());
		homeMenue.addButton("Config", configPane.getPanel());
		
		
		setScreen(homeMenue.getPanel(),mainPane.getPanel());
		show();

		
		
//		JFrame frame = new JFrame("");
//		frame.setLayout(null);
//		frame.setSize(1024,800);
//		frame.add(MainPane.getInstance().getPanel());
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
	}
}

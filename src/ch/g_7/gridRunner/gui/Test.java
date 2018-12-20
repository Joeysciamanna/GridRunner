package ch.g_7.gridRunner.gui;

import ch.g_7.gridRunner.gui.home.ConfigPane;
import ch.g_7.gridRunner.gui.home.HomeMenue;
import ch.g_7.gridRunner.gui.home.MainPane;

public class Test {

	public static void main(String[] args) {
		
		HomeMenue homeMenue = HomeMenue.getInstance();
		MainPane mainPane = MainPane.getInstance();
		ConfigPane configPane = ConfigPane.getInstance();
		homeMenue.addButton("Home", mainPane.getPanel());
		homeMenue.addButton("Config", configPane.getPanel());
		
		
		Window.init();
		Window.setScreen(homeMenue.getPanel(),mainPane.getPanel());
	}
}

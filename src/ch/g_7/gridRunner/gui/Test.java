package ch.g_7.gridRunner.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ch.g_7.gridRunner.gui.home.ConfigPane;
import ch.g_7.gridRunner.gui.home.HomeMenue;
import ch.g_7.gridRunner.gui.home.MainPane;
import static ch.g_7.gridRunner.gui.Window.*;

import java.awt.Color;

public class Test {

	public static Window window;
	
	public static void main(String[] args) {
		window = Window.getInstance();
		window.show();
//		HomeMenue homeMenue = HomeMenue.getInstance();
		MainPane mainPane = MainPane.getInstance();
//		ConfigPane configPane = ConfigPane.getInstance();
//		homeMenue.addButton("Home", mainPane.getPanel());
//		homeMenue.addButton("Config", configPane.getPanel());
		
		
//		setScreen(homeMenue.getPanel(),mainPane.getPanel());
		JPanel test = new JPanel();
		test.setBackground(Color.green);
		test.setSize(100,100);
		
		window.setScreen(test);
		
		
//		JFrame frame = new JFrame("");
//		frame.setLayout(null);
//		frame.setSize(1024,800);
//		frame.add(MainPane.getInstance().getPanel());
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
	}
}

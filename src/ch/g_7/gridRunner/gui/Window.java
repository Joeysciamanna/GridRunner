package ch.g_7.gridRunner.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ch.g_7.gridRunner.controller.Controller;

public class Window {

	private static JFrame jFrame;
	
	public static void init() {
		jFrame = new JFrame("GridRunner");
		jFrame.setFocusable(true);
		jFrame.setLayout(null);
	}
	
	public static void switchMainPanel(JPanel mainPanel) {
		setScreen((JPanel) jFrame.getContentPane().getComponentAt(0, 0), mainPanel);
	}

	public static void setScreen(JPanel panel) {
		clear();
		jFrame.setSize(panel.getWidth()+16, panel.getHeight()+39);
		panel.setLocation(0, 0);
		jFrame.getContentPane().add(panel);
		update();
	}
	
	public static void setScreen(JPanel menue, JPanel mainPanel) {
		clear();
		menue.setLocation(0, 0);
		mainPanel.setLocation(menue.getWidth(),0);
		jFrame.setSize(menue.getWidth()+mainPanel.getWidth()+16, (mainPanel.getHeight()>menue.getHeight()?mainPanel.getHeight():menue.getHeight())+39);
		jFrame.getContentPane().add(menue);
		jFrame.getContentPane().add(mainPanel);
		update();
	}
	
	private static void clear() {
		if(jFrame.getContentPane().getComponentCount()>0) {
			jFrame.getContentPane().removeAll();	
		}
	}
	
	public static void update() {
		jFrame.repaint();
	}
	
	public static void show() {
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
	}
	
	public static void addController(Controller controller) {
		jFrame.addKeyListener(controller);
	}
	
}



















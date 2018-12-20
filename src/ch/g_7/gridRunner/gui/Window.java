package ch.g_7.gridRunner.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window {

	private JFrame jFrame;
	private static Window instance;
	
	private Window() {
		jFrame = new JFrame("GridRunner");
		jFrame.setLayout(null);
	}

	public void setScreen(JPanel panel) {
//		clear();
		//jFrame.setSize(panel.getWidth()+16, panel.getHeight()+39);
//		panel.setLocation(0, 0);
		jFrame.add(panel);
	}

	public void switchMainPanel(JPanel mainPanel) {
		setScreen((JPanel) jFrame.getComponentAt(0, 0), mainPanel);
	}
	
	public void setScreen(JPanel menue, JPanel mainPanel) {
		clear();
		menue.setLocation(0, 0);
		mainPanel.setLocation(menue.getWidth(),0);
		jFrame.setSize(menue.getWidth()+mainPanel.getWidth()+16, (mainPanel.getHeight()>menue.getHeight()?mainPanel.getHeight():menue.getHeight())+39);
		jFrame.add(menue);
		jFrame.add(mainPanel);
	}
	
	private void clear() {
		if(jFrame.getComponentCount()>0) {
			jFrame.removeAll();	
		}
	}
	
	public void update() {
		jFrame.repaint();
	}
	
	public void show() {
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
	}
	
	public static Window getInstance() {
		if(instance==null) {
			instance = new Window();
		}
		return instance;
	}
}



















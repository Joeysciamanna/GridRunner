package ch.g_7.gridRunner.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window {

	private static JFrame jFrame;
	
	public static void init() {
		jFrame = new JFrame("GridRunner");
		jFrame.setLayout(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
	}

	public static void setScreen(JPanel panel) {
		clear();
		panel.setLocation(0, 0);
		jFrame.setSize(panel.getWidth()+16, panel.getHeight()+39);
		jFrame.add(panel);
	}

	public static void switchMainPanel(JPanel mainPanel) {
		setScreen((JPanel) jFrame.getComponentAt(0, 0), mainPanel);
	}
	
	public static void setScreen(JPanel menue, JPanel mainPanel) {
		clear();
		menue.setLocation(0, 0);
		mainPanel.setLocation(menue.getWidth(),0);
		jFrame.setSize(menue.getWidth()+mainPanel.getWidth()+16, (mainPanel.getHeight()>menue.getHeight()?mainPanel.getHeight():menue.getHeight())+39);
		jFrame.add(menue);
		jFrame.add(mainPanel);
	}
	
	private static void clear() {
		jFrame.removeAll();
	}
	
}

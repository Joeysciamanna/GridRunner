package ch.g_7.gridRunner.gui.main;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainScreen extends JPanel {

	public MainScreen(JP) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(GUISize.WINDOW_HEIGHT,GUISize.WINDOW_WIDTH);
		frame.add(new MainScreen());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

package ch.g_7.gridRunner.gui.main;

import java.awt.Color;

import javax.swing.JPanel;

public class ConfigView extends View<JPanel>{

	private JPanel panel = new JPanel();
	private static ConfigView instance;
	
	private ConfigView() {
		panel.setBackground(Color.GREEN);
		getPanel().setLocation(GUISize.MENUE_WIDTH,0);
		getPanel().setSize(GUISize.WINDOW_CONTENT_WIDTH-GUISize.MENUE_WIDTH, GUISize.WINDOW_CONTENT_HEIGHT);
	}
	

	public static View<JPanel> getInstance() {
		if(instance == null) {
			instance = new ConfigView();
		}
		return instance;
	}
	
	@Override
	public JPanel getPanel() {
		return panel;
	}

}

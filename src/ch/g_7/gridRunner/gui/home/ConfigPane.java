package ch.g_7.gridRunner.gui.home;

import java.awt.Color;

import javax.swing.JPanel;

import ch.g_7.gridEngine.base.PanelWrapper;

public class ConfigPane implements PanelWrapper<JPanel>{

	private JPanel panel;
	private static ConfigPane instance;
	
	private ConfigPane() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(700,700);
		panel.setBackground(Color.yellow);
	}
	
	@Override
	public JPanel getPanel() {
		return panel;
	}

	public static ConfigPane getInstance() {
		if (instance == null) {
			instance = new ConfigPane();
		}
		return instance;
	}
}

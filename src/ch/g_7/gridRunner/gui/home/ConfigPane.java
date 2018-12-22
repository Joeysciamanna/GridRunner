package ch.g_7.gridRunner.gui.home;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;

import javax.swing.JPanel;

import ch.g_7.gridEngine.base.PanelWrapper;
import ch.g_7.gridEngine.stream.MapReader;

public class ConfigPane implements PanelWrapper<JPanel>{

	private JPanel panel;
	private static ConfigPane instance;
	
	private ConfigPane() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(800,800);
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

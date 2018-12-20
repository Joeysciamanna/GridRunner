package ch.g_7.gridRunner.gui.home;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import ch.g_7.gridEngine.base.PanelWrapper;

public class MainPane implements PanelWrapper<JPanel>{

	private JPanel panel;
	private static MainPane instance;
	
	private MainPane() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(700,800);
		panel.setBackground(Color.ORANGE);
	}
	
	@Override
	public JPanel getPanel() {
		return panel;
	}

	public static MainPane getInstance() {
		if (instance == null) {
			instance = new MainPane();
		}
		return instance;
	}
}

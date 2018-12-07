package ch.g_7.gridRunner.inventory;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import ch.g_7.gridEngine.base.PanelWrapper;

public class Inventory implements PanelWrapper<JPanel>{

	JPanel panel = new JPanel();
	
	public Inventory(Dimension size) {
		panel.setSize(size);
		panel.setBackground(Color.GRAY);
	}
	
	@Override
	public JPanel getPanel() {
		return panel;
	}

}

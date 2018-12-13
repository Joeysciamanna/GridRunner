package ch.g_7.gridRunner.gui.main;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import ch.g_7.gridEngine.base.PanelWrapper;

public class MenuePanel implements PanelWrapper<JPanel> {

	private JPanel panel = new JPanel();
	
	public MenuePanel(MenueButton... buttons) {
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setLocation(0,0);
		panel.setSize(GUISize.MENUE_WIDTH,GUISize.WINDOW_CONTENT_HEIGHT);
		panel.setBackground(new Color(77, 77, 77));
		this.addButtons(buttons);
	}

	
	public void addButtons(MenueButton...buttons) {
		for (MenueButton button : buttons) {
			panel.add(button.getPanel());
		}
	}
	
	
	@Override
	public JPanel getPanel() {
		return panel;
	}
}

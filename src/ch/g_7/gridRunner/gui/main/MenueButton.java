package ch.g_7.gridRunner.gui.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.plaf.ButtonUI;

import ch.g_7.gridEngine.base.PanelWrapper;
import ch.g_7.gridRunner.resources.Image;

public class MenueButton implements PanelWrapper<JButton>{

	private JButton button;
	private View<?> view;
	
	public MenueButton(HomeScreen homeScreen, View<?> view, String name) {
		button = new JButton(name);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				homeScreen.setView(view);
			}
		});
		button.setMaximumSize(new Dimension(GUISize.MENUE_WIDTH,GUISize.MENUE_BUTTON_HEIGHT));
		button.setContentAreaFilled(false); 
		button.setFocusPainted(false); 
		button.setOpaque(false);
		button.setBackground(new Color(77,77,77));
		button.setBorder(BorderFactory.createLineBorder(new Color(50,50,50)));
		button.updateUI();
	}
	
	@Override
	public JButton getPanel() {
		return button;
	}

}

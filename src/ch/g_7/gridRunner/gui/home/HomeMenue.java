package ch.g_7.gridRunner.gui.home;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import ch.g_7.gridEngine.base.PanelWrapper;
import ch.g_7.gridRunner.gui.Window;

public class HomeMenue implements PanelWrapper<JPanel>{

	private JPanel panel;
	private static HomeMenue instance;
	
	private HomeMenue() {
		this.panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(300,800);
		panel.setPreferredSize(new Dimension(700,700));
		panel.setBackground(Color.white);
	}
	
	
	public void addButton(String name,JPanel switchingPanel) {
		JButton button = new JButton(name);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Window.switchMainPanel(switchingPanel);
			}
		});
		button.setLocation(0, panel.getComponentCount()*50);
		button.setSize(300,50);
		panel.add(button);
	}
	
	
	@Override
	public JPanel getPanel() {
		return panel;
	}

	public static HomeMenue getInstance() {
		if(instance == null) {
			instance = new HomeMenue();
		}
		return instance;
	}
	
}

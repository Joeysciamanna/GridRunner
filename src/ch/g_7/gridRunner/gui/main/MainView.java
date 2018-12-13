package ch.g_7.gridRunner.gui.main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ch.g_7.gridRunner.gameInstantiation.GameCreationEvent;
import ch.g_7.gridRunner.gameInstantiation.GameCreator;
import ch.g_7.gridRunner.gameInstantiation.GameInstace;
import ch.g_7.gridRunner.resources.Image;

public class MainView extends View<JLabel>{

	private JLabel panel = new JLabel();
	private static MainView instance;
	
	
	private MainView() {
		panel.setIcon(new ImageIcon(Image.MAIN_VIEW.getPath()));
		panel.setLocation(GUISize.MENUE_WIDTH,0);
		panel.setSize(GUISize.WINDOW_CONTENT_WIDTH-GUISize.MENUE_WIDTH, GUISize.WINDOW_CONTENT_HEIGHT);
		
		JButton startGame = new JButton("Start!");
		startGame.setLocation(640, 706);
		startGame.setSize(128, 64);
		startGame.setBorderPainted(false); 
		//startGame.setContentAreaFilled(false); 
		startGame.setFocusPainted(false); 
		//startGame.setOpaque(false);
		startGame.setBackground(new Color(150,49,48));
		startGame.updateUI();
		startGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GameScreen screen = new GameScreen();
				Window.getInstance().setScreen(screen);
				screen.start(GameCreator.getNewGame(new GameCreationEvent(true,"map1")));
			}
		});
		panel.add(startGame);
	}
	
	@Override
	public JLabel getPanel() {
		return panel;
	}

	public static View<JLabel> getInstance() {
		if(instance == null) {
			instance = new MainView();
		}
		return instance;
	}
}
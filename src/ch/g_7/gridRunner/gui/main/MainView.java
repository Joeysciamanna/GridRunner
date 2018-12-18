package ch.g_7.gridRunner.gui.main;

import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ch.g_7.gridEngine.helper.Lambda;
import ch.g_7.gridRunner.gameInstantiation.GameCreationEvent;
import ch.g_7.gridRunner.gameInstantiation.GameCreator;
import ch.g_7.gridRunner.gameInstantiation.GameInstace;
import ch.g_7.gridRunner.gameInstantiation.GameRunner;
import ch.g_7.gridRunner.resources.Image;

public class MainView extends View<JLabel> {

	private JLabel panel = new JLabel();
	private static MainView instance;
	private JLabel loadingLabel;
	
	private MainView() {
		panel.setIcon(new ImageIcon(Image.MAIN_VIEW.getPath()));
		panel.setLocation(GUISize.MENUE_WIDTH,0);
		panel.setSize(GUISize.WINDOW_CONTENT_WIDTH-GUISize.MENUE_WIDTH, GUISize.WINDOW_CONTENT_HEIGHT);
		
		JButton startGame = new JButton();
		startGame.setLocation(640, 704);
		startGame.setSize(128, 64);
		startGame.setBorderPainted(false); 

		startGame.setFocusPainted(false); 
		startGame.setBackground(new Color(150,49,48));
		startGame.setIcon(new ImageIcon(Image.START.getPath()));
		startGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setLoading(true);
				GameScreen screen = new GameScreen();
				
				GameRunner gameRunner = new GameRunner();
				gameRunner.onActive(new Lambda<Void, GameRunner>() {
					@Override
					public Void apply(GameRunner arg0) {
						Window.getInstance().setScreen(screen);
						Window.getInstance().addKeyListener(arg0.getGame().getController1());
						Window.getInstance().addKeyListener(arg0.getGame().getController2());
						return null;
					}
				});
				gameRunner.setPanel(screen.getPanel());
				gameRunner.startNewGame(new GameCreationEvent(false,"map1"));
			}
		});
		panel.add(startGame);
		
		loadingLabel = new JLabel();
		loadingLabel.setLocation(128, 256);
		loadingLabel.setSize(128,128);
		panel.add(loadingLabel);

		startGame.updateUI();
	}

	public void setLoading(boolean b) {
		if(b) {
			loadingLabel.setIcon(new ImageIcon(Image.LOADING.getPath()));
		}else {
			loadingLabel.setIcon(null);
		}
		loadingLabel.updateUI();
		getPanel().updateUI();
		Window.getInstance().repaint();
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
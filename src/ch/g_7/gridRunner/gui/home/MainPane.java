package ch.g_7.gridRunner.gui.home;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JPanel;

import ch.g_7.gridEngine.base.PanelWrapper;
import ch.g_7.gridEngine.core.FieldGrid;
import ch.g_7.gridEngine.helper.Lambda;
import ch.g_7.gridRunner.gameCreation.GameCreationEvent;
import ch.g_7.gridRunner.gameCreation.GameCreatorProducer;
import ch.g_7.gridRunner.helper.AsyncGameStarter;
import ch.g_7.gridRunner.identification.ClientIdProvider;

public class MainPane implements PanelWrapper<JPanel>{

	private JPanel panel;
	private static MainPane instance;
	
	private MainPane() {
		panel = new JPanel();
		AsyncGameStarter gameStarter = new AsyncGameStarter(panel,GameCreatorProducer.getGameCreator(new GameCreationEvent(true,"homeMap",1,ClientIdProvider.getClientId())));
		gameStarter.onGameStart(new Lambda<Void, AsyncGameStarter>() {
			@Override
			public Void apply(AsyncGameStarter o) {
				FieldGrid grid = o.getGame().getGrid();
				panel.setSize(new Dimension(grid.getPanel().getSize()));
				return null;
			}
		});
		gameStarter.startStarting();
//		panel.setLayout(null);
		panel.setSize(800,800);
//		panel.setBackground(Color.ORANGE);
		
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

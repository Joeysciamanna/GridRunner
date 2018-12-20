package ch.g_7.gridRunner.main;

import java.awt.Dimension;
import java.awt.Point;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ch.g_7.gridEngine.core.FieldGrid;
import ch.g_7.gridEngine.field.building.FieldCreationRegister;
import ch.g_7.gridEngine.helper.Calculator;
import ch.g_7.gridEngine.helper.Lambda;
import ch.g_7.gridRunner.fieldCreation.GridRunnerFieldFactory;
import ch.g_7.gridRunner.gameCreation.GameCreationEvent;
import ch.g_7.gridRunner.gameCreation.GameCreator;
import ch.g_7.gridRunner.gameCreation.GameCreatorProducer;
import ch.g_7.gridRunner.gameCreation.GameInstace;
import ch.g_7.gridRunner.helper.AsyncGameStarter;
import ch.g_7.gridRunner.inventory.Inventory;

public class GridRunner {

	public static void main(String[] args) {
		
		FieldCreationRegister.setDefaultFactory(new GridRunnerFieldFactory());
		
		JFrame window = new JFrame("Grid Runner");
		window.getContentPane().setLayout(null);
		
		JPanel gameContainer = new JPanel();
		AsyncGameStarter gameStarter = new AsyncGameStarter(gameContainer,GameCreatorProducer.getGameCreator(new GameCreationEvent(false,"map1")));
		

		
		gameContainer.setLocation(new Point(0, 0));
		window.add(gameContainer);
		window.setSize(gameContainer.getSize());
		

	

		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		gameStarter.onGameStart(new Lambda<Void, AsyncGameStarter>() {
			@Override
			public Void apply(AsyncGameStarter o) {
				FieldGrid grid = o.getGame().getGrid();
				window.setSize(new Dimension(grid.getPanel().getWidth()+16, grid.getPanel().getWidth() + grid.getFieldSize().height+39));
				return null;
			}
		});
		gameStarter.startStarting();
	}
}

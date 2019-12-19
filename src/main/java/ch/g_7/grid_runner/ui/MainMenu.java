package ch.g_7.grid_runner.ui;

import ch.g_7.graphite.base.ui.UIButton;
import ch.g_7.graphite.base.ui.UIRootContainer;
import ch.g_7.graphite.base.ui.layout.CenterLayoutPanel;
import ch.g_7.graphite.base.ui.layout.DontCareLayoutPanel;
import ch.g_7.graphite.base.ui.util.UIMouseEvent;
import ch.g_7.graphite.base.ui.util.UIMouseListner;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.util.Color;

public final class MainMenu extends UIRootContainer {

	private static MainMenu instance;
	
	private MainMenu(Window window) {
		super(window);
	}

	public static MainMenu getInstance(Window window) {
		if(instance == null) {
			instance = new MainMenu(window);
		}
		return instance;
	}

	@Override
	public void init() {
		super.init();
		
		CenterLayoutPanel centering = new CenterLayoutPanel();
		centering.setColor(Color.getColor(0, 255, 255));
		add(centering);

		DontCareLayoutPanel buttons = new DontCareLayoutPanel();
		buttons.getPreferedWidth().reset().addPW(33);
		buttons.getPreferedHeight().reset().addPW(33).addPixel(50);
		buttons.setColor(Color.getColor(255, 0, 255));
		centering.set(buttons);

		
		UIButton startGame = new UIButton();
		startGame.getPreferedHeight().reset().addPixel(15).addPF(15);
		startGame.setColor(Color.getColor(255, 0, 0));
		buttons.add(startGame);



		
		
		
		
	}
	
	
}

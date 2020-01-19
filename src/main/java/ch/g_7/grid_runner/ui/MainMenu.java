package ch.g_7.grid_runner.ui;

import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.ui.UIButton;
import ch.g_7.graphite.ui.layout.CenterLayoutPanel;
import ch.g_7.graphite.ui.layout.ListLayoutPanel;
import ch.g_7.graphite.ui.layout.SpaceSharingLayoutPanel;
import ch.g_7.graphite.ui.scene.Scene;
import ch.g_7.graphite.ui.scene.SceneNavigator;
import ch.g_7.graphite.ui.util.UIMouseEvent;
import ch.g_7.graphite.ui.util.UIMouseListner;
import ch.g_7.graphite.util.Color;

public final class MainMenu extends Scene {

	public MainMenu(SceneNavigator navigator, Window window) {
		super(navigator, window);
	}

	@Override
	protected void onOpen() {

		SpaceSharingLayoutPanel sharingLayoutPanel = new SpaceSharingLayoutPanel();
		this.add(sharingLayoutPanel);

		ListLayoutPanel optionPanel = new ListLayoutPanel(ListLayoutPanel.X_AXIS);
		optionPanel.setColor(Color.getColor(0, 255, 0));
		optionPanel.getPreferedHeight().reset().addPF(5).addPixel(20);
		optionPanel.getPlaceHolder().reset().addPixel(5);
		sharingLayoutPanel.setMainPanel(optionPanel, SpaceSharingLayoutPanel.BUTTOM);

		UIButton wikiButton = new UIButton();
		wikiButton.getPreferedWidth().reset().add(wikiButton.getMaxHeight());
		wikiButton.setColor(Color.getColor(100, 100, 100));
		optionPanel.add(wikiButton);

		CenterLayoutPanel buttonPanel = new CenterLayoutPanel();
		buttonPanel.setColor(Color.getColor(0, 255, 255));
		sharingLayoutPanel.setAdjustablePanel(buttonPanel);

		ListLayoutPanel buttonsPanel = new ListLayoutPanel(ListLayoutPanel.Y_AXIS);
		buttonsPanel.setColor(Color.getColor(0, 0, 255));
		buttonsPanel.getPlaceHolder().addPixel(20).addPF(5);
		buttonsPanel.getPreferedWidth().reset().addPixel(100).addPF(20);
		buttonsPanel.getPreferedHeight().reset().addPixel(50).addPF(20);
		buttonPanel.set(buttonsPanel);

		UIButton startGame = new UIButton();
		startGame.getPreferedHeight().reset().addPixel(20).addPF(10);
		startGame.setColor(Color.getColor(255, 255, 0));
		startGame.addMouseListner(new UIMouseListner() {
			
			@Override
			public void onRelease(UIMouseEvent event) {}
			
			@Override
			public void onClick(UIMouseEvent event) {
				navigator.close(Scenes.MAIN_MENU);
			}
		});
		buttonsPanel.add(startGame);

	}
	
	

}

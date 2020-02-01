package ch.g_7.grid_runner.ui;

import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.ui.UIButton;
import ch.g_7.graphite.ui.layout.CenterLayoutPanel;
import ch.g_7.graphite.ui.layout.ListLayoutPanel;
import ch.g_7.graphite.ui.layout.SpaceSharingLayoutPanel;
import ch.g_7.graphite.ui.scene.SceneNavigator;
import ch.g_7.graphite.util.Color;
import ch.g_7.grid_runner.common.Images;
import ch.g_7.util.common.IIdentifier;

public final class MainScene extends BaseScene {

	public MainScene(SceneNavigator navigator, Window window) {
		super(navigator, window);
	}


	@Override
	protected void initView() {

		SpaceSharingLayoutPanel sharingLayoutPanel = new SpaceSharingLayoutPanel();
		this.add(sharingLayoutPanel);

		ListLayoutPanel optionPanel = new ListLayoutPanel(ListLayoutPanel.X_AXIS);
		optionPanel.setColor(Color.getColor(0, 255, 0));
		optionPanel.getPreferedHeight().reset().addPF(2).addPixel(25);
		optionPanel.getPlaceHolder().reset().addPixel(5);
		sharingLayoutPanel.setMainPanel(optionPanel, SpaceSharingLayoutPanel.BUTTOM);

		UIButton settingsButton = new UIButton();
		settingsButton.getPreferedWidth().reset().add(settingsButton.getMaxHeight());
		settingsButton.setColor(Color.getColor(100, 100, 100));
		optionPanel.add(settingsButton);
		registerButton(Button.SETTINGS, settingsButton);

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
		buttonsPanel.add(startGame);
		startGame.getPreferedHeight().reset().addPixel(20).addPF(10);
		startGame.setTexture(Images.START_GAME_BUTTON);
		registerButton(Button.START_GAME, startGame);
		
		
		UIButton exitGame = new UIButton();
		buttonsPanel.add(exitGame);
		exitGame.getPreferedHeight().reset().addPixel(20).addPF(10);
		exitGame.setTexture(Images.EXIT_GAME_BUTTON);
		registerButton(Button.EXIT_GAME, exitGame);
		
	}

	public static enum Button implements IIdentifier<Button>{
		START_GAME, SETTINGS, EXIT_GAME
	}

}

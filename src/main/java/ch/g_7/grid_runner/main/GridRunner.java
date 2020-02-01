package ch.g_7.grid_runner.main;

import java.io.IOException;

import ch.g_7.graphite.core.Application;
import ch.g_7.graphite.ui.scene.SceneNavigator;
import ch.g_7.grid_runner.ui.GameScene;
import ch.g_7.grid_runner.ui.MainScene;
import ch.g_7.grid_runner.ui.SceneType;
import ch.g_7.util.helper.AppInitializer;
import ch.g_7.util.logging.Logger;



public class GridRunner extends Application {

	private final static String ENV_APP_PATH = System.getenv("APPDATA") + "/GridRunner/";

	private final static Logger LOGGER = Logger.getInstance();

	
	private GridRunner() {
		super("Grid Runner");
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		AppInitializer appInitializer = new AppInitializer(ENV_APP_PATH, new Object() {});
		appInitializer.setDebugMode(true);
		appInitializer.initLogger();
		appInitializer.addConsoleLoggers();
		appInitializer.addFileLoggers();
		appInitializer.initDefaultPropFiles("properties.prop");
		appInitializer.addDefaultAppConfigParams();
		
		new GridRunner().start();
	}

	@Override
	public void init() {
		
		SceneNavigator navigator = new SceneNavigator(getDimension());
		
		MainScene mainMenu = new MainScene(navigator, getWindow());
		navigator.registerScene(SceneType.MAIN_MENU, mainMenu);
		mainMenu.addButtonListner(MainScene.Button.START_GAME, (e)->navigator.goTo(SceneType.GAME));
		mainMenu.addButtonListner(MainScene.Button.EXIT_GAME, (e)->stop());
		
		GameScene gameScene = new GameScene(navigator, getWindow());
		navigator.registerScene(SceneType.GAME, gameScene);
		
		
		navigator.goTo(SceneType.MAIN_MENU);

	
		
		getWindow().setVisible(true);
		getWindow().setSize(500, 500);
	}
	
	@Override
	public void close() {
		try {
			LOGGER.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		super.close();
	}
}

package ch.g_7.grid_runner.main;

import java.io.IOException;

import ch.g_7.graphite.core.Application;
import ch.g_7.graphite.ui.scene.Scene;
import ch.g_7.graphite.ui.scene.SceneNavigator;
import ch.g_7.grid_runner.ui.MainMenu;
import ch.g_7.grid_runner.ui.Scenes;
import ch.g_7.util.helper.AppInitializer;
import ch.g_7.util.logging.Logger;



public class GridRunner extends Application {

	private final static String ENV_APP_PATH = System.getenv("APPDATA") + "/GridRunner/";

	private final static Logger LOGGER = Logger.getInstance();

	
	private GridRunner() {
		super("Grid Runner");
	}

	public static void main(String[] args) throws IOException {

		AppInitializer appInitializer = new AppInitializer(ENV_APP_PATH, new Object() {});
		appInitializer.setDebugMode(true);
		appInitializer.initLogger();
		appInitializer.addConsoleLogWriters();
		appInitializer.initProperties("properties.prop");
		appInitializer.addDefaultConfigParams();
		
		new GridRunner().start();
	
	}

	@Override
	public void init() {
		
		SceneNavigator navigator = new SceneNavigator(getDimension());
		
		MainMenu mainMenu = new MainMenu(navigator, getWindow());
		navigator.addScene(Scenes.MAIN_MENU, mainMenu);
		navigator.goTo(Scenes.MAIN_MENU);
		
		
		
		
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

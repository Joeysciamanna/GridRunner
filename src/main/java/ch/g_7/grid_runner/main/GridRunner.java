package ch.g_7.grid_runner.main;

import java.io.IOException;

import ch.g_7.graphite.core.Application;
import ch.g_7.graphite.rendering.RenderClass;
import ch.g_7.grid_runner.ui.MainMenu;
import ch.g_7.util.helper.IOUtil;
import ch.g_7.util.helper.Properties;
import ch.g_7.util.logging.LogLevel;
import ch.g_7.util.logging.Logger;
import ch.g_7.util.logging.StreamWriter;

public class GridRunner extends Application {

	private final static String ENV_APP_PATH = System.getenv("APPDATA") + "/GridRunner/";

	private final static Logger LOGGER = Logger.getInstance();
	private static Properties PROPERTIES;

	private GridRunner() {
		super("Grid Runner");
	}

	public static void main(String[] args) throws IOException {

		
		
		
		// Init logger
		Thread.setDefaultUncaughtExceptionHandler(LOGGER);
		LOGGER.addWriter(new StreamWriter(System.err, "ERR_CONSOLE", LogLevel.FATAL, LogLevel.WARNING, LogLevel.ERROR));
		LOGGER.addWriter(new StreamWriter(System.out, "DEB_CONSOLE", LogLevel.values()));
		StreamWriter errorWriter = new StreamWriter(IOUtil.getExternalOutputStream(ENV_APP_PATH + "error.log"), "ERR_FILE", LogLevel.FATAL, LogLevel.WARNING, LogLevel.ERROR);
		StreamWriter debugWriter = new StreamWriter(IOUtil.getExternalOutputStream(ENV_APP_PATH + "debug.log"), "DEB_FILE", LogLevel.values());
		LOGGER.addWriter(errorWriter);
		LOGGER.addWriter(debugWriter);

		
		// Init properties
		String properties = "";
		if (!IOUtil.doesFileExist(ENV_APP_PATH + "properties.prop")) {
			LOGGER.log(LogLevel.DEBUG, "No existing properties file, new will be created");
			properties = IOUtil.readInternalString("properties.prop", new Object() {});
			IOUtil.writeExternalString(ENV_APP_PATH + "properties.prop", properties);
		} else {
			LOGGER.log(LogLevel.DEBUG, "existing properties file found");
			properties = IOUtil.readExternalString(ENV_APP_PATH + "properties.prop");
		}
		PROPERTIES = Properties.read(properties);

		
		
		
		
		
		
		
		
		
		new GridRunner().start();
	
	}

	@Override
	protected void initGame() {

		getDimension().addObj(MainMenu.getInstance(getWindow()), RenderClass.UI);
		
		System.out.println("test");
		
		
		getWindow().setVisible(true);
		getWindow().setSize(500, 500);
	}
	
	@Override
	protected void close() {
		try {
			LOGGER.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		super.close();
	}
}

package ch.g_7.grid_runner.main;

import java.io.IOException;
import java.io.OutputStream;

import ch.g_7.graphite.core.Application;
import ch.g_7.util.helper.IOUtil;
import ch.g_7.util.helper.Properties;
import ch.g_7.util.logging.LogLevel;
import ch.g_7.util.logging.Logger;
import ch.g_7.util.logging.StreamWriter;
import ch.g_7.util.task.SecureRunner;

public class GridRunner extends Application {

	private final static String ENV_APP_PATH = System.getenv("APPDATA") + "/GridRunner/";

	private final static Logger LOGGER = Logger.getInstance();
	private static Properties PROPERTIES;

	private GridRunner() {
		super("Grid Runner");
	}

	public static void main(String[] args) throws IOException {

		//TODO StackOverflowError in IOUtil readExternalString
		//TODO Stream Writer -> Constructor(LogLevel... levels)
		//ev IOUtil -> IOUtils
		
		
		
		
		
		// Init logger
		Thread.setDefaultUncaughtExceptionHandler(LOGGER);
		LOGGER.addWriter(new StreamWriter(System.err, "ERR_LOGGER", LogLevel.FATAL, LogLevel.ERROR));
		StreamWriter writer = new StreamWriter(IOUtil.getExternalOutputStream(ENV_APP_PATH + "log.txt"), "ENV_LOGGER", LogLevel.values());
		LOGGER.addWriter(writer);

		
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

		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void initGame() {

		getWindow().setVisible(true);
		getWindow().setSize(500, 500);
	}
}

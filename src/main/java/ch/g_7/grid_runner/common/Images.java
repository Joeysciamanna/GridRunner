package ch.g_7.grid_runner.common;

import java.nio.file.Path;
import java.nio.file.Paths;

import ch.g_7.graphite.base.texture.Image;
import ch.g_7.graphite.base.texture.Sprite;
import ch.g_7.graphite.base.texture.TextureUtil;
import ch.g_7.util.task.SecureRunner;

public class Images {

	public final static Image UI_SPRITE = loadImage("ui.png");
	public final static Sprite START_GAME_BUTTON = loadSprite(UI_SPRITE, 0, 0, 64, 16);
	public final static Sprite EXIT_GAME_BUTTON = loadSprite(UI_SPRITE, 0, 32, 64, 16);			
			

	private static Sprite loadSprite(Image image, int x, int y, int width, int height) {
		return TextureUtil.loadSprite(image, x, y, width, height);
	}
			
	private static Image loadImage(String path) {
		Path _path = Paths.get("src/main/resources/" + path);
		Path absolutePath = _path.toAbsolutePath();
		return new SecureRunner<Void, Image>(() -> TextureUtil.loadImage(absolutePath.toString())).get();
	}

}

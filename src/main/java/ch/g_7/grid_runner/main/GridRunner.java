package ch.g_7.grid_runner.main;

import org.joml.Vector2i;

import ch.g_7.graphite.base.ui.util.MouseManager;
import ch.g_7.graphite.core.Application;
import ch.g_7.graphite.util.Color;
import ch.g_7.grid_runner.field.Field;
import ch.g_7.grid_runner.rendering.FieldRenderClass;

public class GridRunner extends Application {

	public GridRunner() {
		super("Grid Runner");
	}

	public static void main(String[] args) {
		new GridRunner().start();
	}

	@Override
	protected void initGame() {
		
		int width = 2;
		int height = 3;
		FieldRenderClass renderClass = new FieldRenderClass(width, height);
		
		for(int x = 0; x < width; x++) {
			
			for(int y = 0; y < height; y++) {
				
				Field field = new Field();
				field.setColor(Color.getColor(255/width*x, 255-255/height*y, 255/(width*height)*x*y));
				field.setPosition(new Vector2i(x, y));
				getDimension().addObj(field, renderClass);
				
	
			}
		
		}
		
		getWindow().setVisible(true);
		getWindow().setSize(500, 500);
	}
}

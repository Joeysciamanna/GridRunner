package ch.g_7.grid_runner.rendering;

import ch.g_7.graphite.rendering.RenderClass;
import ch.g_7.grid_runner.field.Field;

public class FieldRenderClass extends RenderClass<Field>{

	private final int width, height;
	
	
	
	public FieldRenderClass(int width, int height) {
		super(new FieldRenderer(width, height), "FIELDS_" + width + "x" + height,  width * height);
		this.width = width;
		this.height = height;
	}
	


	
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	
}

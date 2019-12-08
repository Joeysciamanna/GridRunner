package ch.g_7.grid_runner.rendering;

import ch.g_7.graphite.rendering.RenderClass;
import ch.g_7.grid_runner.base.FieldGrid;

public class FieldRenderClass extends RenderClass<FieldGrid>{

	
	public FieldRenderClass() {
		super(new FieldRenderer(), "FIELDS", 20);
	}
	
	
	
}

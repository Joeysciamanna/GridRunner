package ch.g_7.grid_runner.rendering;

import java.util.List;

import org.joml.Matrix4f;
import org.joml.Vector3f;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.rendering.ITransformation;
import ch.g_7.graphite.rendering.renderer.BasicRenderer;
import ch.g_7.graphite.rendering.shaderprogram.EntityShaderProgram;
import ch.g_7.grid_runner.base.FieldGrid;
import ch.g_7.grid_runner.base.field.Field;

public class FieldRenderer extends BasicRenderer<EntityShaderProgram, FieldGrid> implements ITransformation<Field>{

	
	
	private Matrix4f viewMatrix;
	private Field field;
	
	private int width, height;
	
//	private float maxX;
	private float minX;
//	private float maxY = 1.8f;
	private float minY;
	
	private float fieldSize;
	
	public FieldRendereri) {
		super(new EntityShaderProgram());

		
		
		
		viewMatrix = new Matrix4f();
	}
	

	
	@Override
	protected void renderAll(List<FieldGrid> renderables) {
		if(!renderables.isEmpty()) {
			prepareFor(renderables.get(0));
			for (Field field : renderables.get(0).getFields()) {
				render(field, this);
			}
		}
	}
	
	public void prepareFor(FieldGrid fieldGrid) {
		
	}
	
	@Override
	public void prepareFor(Field r) {
		this.field = r;
	}
	
	@Override
	protected void prepareTransformation(Window window, Camera camera) {
		viewMatrix.identity();
		viewMatrix.translate((float) -camera.getPosition().x(), (float) -camera.getPosition().y(),
				(float) -camera.getPosition().z());
	}



	public Matrix4f getViewMatrix() {
		Matrix4f viewCurr = new Matrix4f(viewMatrix);
		
		float xPos =      (field.getX() * 2f / width  + minX) - 1f;
		float yPos = 1f - (field.getPosition().y() * 2f / height + minY);
		
		return viewCurr.translate(new Vector3f(xPos,yPos , 0)).scale(fieldSize);
	}





	
	
}

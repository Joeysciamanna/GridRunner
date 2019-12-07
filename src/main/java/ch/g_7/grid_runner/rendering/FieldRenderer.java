package ch.g_7.grid_runner.rendering;

import java.util.List;

import org.joml.Matrix4f;
import org.joml.Vector3f;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.rendering.ITransformation;
import ch.g_7.graphite.rendering.renderer.BasicRenderer;
import ch.g_7.graphite.rendering.shaderprogram.EntityShaderProgram;
import ch.g_7.grid_runner.field.Field;

public class FieldRenderer extends BasicRenderer<EntityShaderProgram, Field> implements ITransformation<Field>{

	private Matrix4f viewMatrix;
	private Field field;
	
	private int height;
	private int width;
	
//	private float maxX;
	private float minX;
//	private float maxY = 1.8f;
	private float minY;
	
	private float fieldSize;
	
	public FieldRenderer(int width, int height) {
		super(new EntityShaderProgram());
		this.width = width;
		this.height = height;
		
		this.fieldSize = 2f / (width > height ? width : height);
		
		if(width > height) {
//			maxY += (width-height)*fieldSize/2;
			minY += (width-height)*fieldSize/2;
		}else if(width < height) {
//			maxX += (height-width)*fieldSize/2;
			minX += (height-width)*fieldSize/2;
		}
		
		
		
		
		viewMatrix = new Matrix4f();
	}
	
	@Override
	protected void renderAll(List<Field> renderables) {
		for (Field field : renderables) {
			render(field, this);
		}
	}
	
	
	@Override
	protected void prepareTransformation(Window window, Camera camera) {
		viewMatrix.identity();
		viewMatrix.translate((float) -camera.getPosition().x(), (float) -camera.getPosition().y(),
				(float) -camera.getPosition().z());
	}

	public void prepareFor(Field r) {
		this.field = r;
	}

	public Matrix4f getViewMatrix() {
		Matrix4f viewCurr = new Matrix4f(viewMatrix);
		
		float xPos =      (field.getPosition().x() * 2f / width  + minX) - 1f;
		float yPos = 1f - (field.getPosition().y() * 2f / height + minY);
		
		return viewCurr.translate(new Vector3f(xPos,yPos , 0)).scale(fieldSize);
	}



	
	
}

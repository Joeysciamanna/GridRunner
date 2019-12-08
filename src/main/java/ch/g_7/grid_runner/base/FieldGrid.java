package ch.g_7.grid_runner.base;

import java.util.List;

import ch.g_7.graphite.rendering.Renderable;
import ch.g_7.grid_runner.base.field.Field;

public class FieldGrid implements Renderable{

	
	private int width, height;
	private List<FieldStack> fieldStacks;
	
	
	public FieldGrid(int width, int height) {
		this.width = width;
		this.height = height;
	}

	
	
	public void put(Field field, int x, int y) {
		if(x > 0 && x < width && y > 0 && y < height) {
			fieldStacks.add(field);
			field.setPosition(x, y);
			
		}
	}
	
	


	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}




	public List<FieldStack> getFieldStacks() {
		return fieldStacks;
	}}

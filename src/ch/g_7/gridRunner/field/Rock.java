package ch.g_7.gridRunner.field;

import ch.g_7.gridEngine.field.Field;
import ch.g_7.gridEngine.field.building.FieldCode;
import ch.g_7.gridRunner.resources.Image;

public class Rock extends BasicGridRunnerField{

	public Rock() {
		super(Image.ROCK);
	}

	@Override
	public synchronized boolean canFieldGetAdded(Field<?> f) {
		return false;
	}
	
	@Override
	public FieldCode getCode() {
		return new FieldCode("ROCK", "-");
	}
}

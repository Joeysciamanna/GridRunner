package ch.g_7.gridRunner.fields;

import ch.g_7.gridEngine.field.building.FieldCode;
import ch.g_7.gridRunner.resources.Image;

public class Grass extends BasicGridRunnerField{

	public Grass() {
		super(Image.GRASS);
	}

	@Override
	public FieldCode getCode() {
		return new FieldCode("GRASS", "-");
	}
}

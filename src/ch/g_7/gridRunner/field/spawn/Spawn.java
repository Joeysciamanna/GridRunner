package ch.g_7.gridRunner.field.spawn;

import ch.g_7.gridEngine.field.building.FieldCode;
import ch.g_7.gridRunner.field.BasicGridRunnerField;
import ch.g_7.gridRunner.resources.Image;

public class Spawn extends BasicGridRunnerField{

	private String[] codeArgs;
	
	public Spawn(String... codeArgs) {
		super(Image.VOID);
		this.codeArgs = codeArgs;
	}

	@Override
	public FieldCode getCode() {
		return new FieldCode("SPAWN",codeArgs);
	}
	
	public SpawnData getSpawnData() {
		return new SpawnData(getPosition(), codeArgs);
	}
}

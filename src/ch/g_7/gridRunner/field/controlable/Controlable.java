package ch.g_7.gridRunner.field.controlable;

import java.util.Vector;

import ch.g_7.gridEngine.base.Dimension;
import ch.g_7.gridEngine.base.Position;
import ch.g_7.gridEngine.core.FieldGrid;

public interface Controlable {

	public boolean move(Dimension d);
	
	public boolean isBot();

	public Position getPosition();

}

package ch.g_7.gridRunner.field;

import java.awt.Point;

import javax.swing.ImageIcon;

import ch.g_7.gridEngine.field.ImagedField;
import ch.g_7.gridEngine.field.building.FieldCode;
import ch.g_7.gridRunner.resources.Image;

public abstract class BasicGridRunnerField extends ImagedField{

	protected Image image;
	
	public BasicGridRunnerField(Image image) {
		super(new ImageIcon(image.getPath()));
		this.image = image;
	}

	
	public void setIcon(Image image) {
		setImage(new ImageIcon(image.getPath()));
		this.image = image;
	}

	
}

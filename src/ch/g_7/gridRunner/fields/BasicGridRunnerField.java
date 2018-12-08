package ch.g_7.gridRunner.fields;

import javax.swing.ImageIcon;

import ch.g_7.gridEngine.field.ImagedField;
import ch.g_7.gridEngine.field.building.FieldCode;
import ch.g_7.gridRunner.resources.Image;

public abstract class BasicGridRunnerField extends ImagedField{

	public BasicGridRunnerField(Image image) {
		super(image.getPath());
	}

	public void doDamage() {
		
	}
	
	public void setIcon(Image image) {
		panel.setIcon(new ImageIcon(image.getPath()));
	}

	@Override
	public FieldCode getCode() {
		return super.getCode();
	}
}

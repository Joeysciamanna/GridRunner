package ch.g_7.gridRunner.fields;

import java.awt.Point;

import javax.swing.ImageIcon;

import ch.g_7.gridEngine.field.ImagedField;
import ch.g_7.gridEngine.field.building.FieldCode;
import ch.g_7.gridRunner.resources.Image;

public abstract class BasicGridRunnerField extends ImagedField{

	protected Image image;
	
	public BasicGridRunnerField(Image image) {
		super(image.getPath());
	}

	public void doDamage() {
		
	}
	
	public void setIcon(Image image) {
		this.image = image;
		panel.setIcon(null);
		panel.setIcon(new ImageIcon(image.getPath()));
	}

	@Override
	public FieldCode getCode() {
		return super.getCode();
	}
	
	public void setPosition(Point pos) {
		stack.removeField(this);
		stack.getPanel().updateUI();
		stack.getGrid().getStack(pos).addField(this);
	}
}

package ch.g_7.gridRunner.server.player;

import javax.swing.ImageIcon;

import ch.g_7.gridEngine.base.Dimension;
import ch.g_7.gridEngine.base.Position;
import ch.g_7.gridEngine.core.FieldStack;
import ch.g_7.gridRunner.fields.controlable.Player;

public class VirtualPlayer extends Player{

	public VirtualPlayer(int player) {
		super(player);
	}

	@Override
	public void setPosition(Position position) {
		stack.removeField(this);
		stack.getGrid().getStackAt(position).addField(this);
	}
	
	@Override
	public boolean move(Dimension d) {
		Position newPosition = getPosition().increase(d);
		if (!stack.getGrid().contains(newPosition)) {
			return false;
		}
		FieldStack newStack = stack.getGrid().getStackAt(newPosition);
		if (newStack.canFieldGetAdded(this) && stack.canFieldGetRemoved(this)) {
			stack.onLeave(this);
			setPosition(newPosition);
			stack.onAdd(this);
			return true;
		}
		return false;
	}

	@Override
	public void updatePanel() {}
	@Override
	public void updateGUI() {}
	public void setImage(ImageIcon image) {}
}

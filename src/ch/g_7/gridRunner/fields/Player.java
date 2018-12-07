package ch.g_7.gridRunner.fields;

import java.awt.Dimension;
import ch.g_7.gridEngine.base.Movable;
import ch.g_7.gridRunner.resources.Image;

public class Player extends BasicGridRunnerField implements Movable{

	public Player() {
		super(Image.PLAYER1);
	}

	@Override
	public boolean moveUp(int d) {
		return move(new Dimension(0, -d));
	}
	
	@Override
	public boolean moveDown(int d) {
		return move(new Dimension(0, d));
	}
	
	@Override
	public boolean moveLeft(int d) {
		return move(new Dimension(-d, 0));
	}
	
	@Override
	public boolean moveRight(int d) {
		return move(new Dimension(d, 0));
	}
}

package ch.g_7.gridRunner.controller.bot.search;

import ch.g_7.gridEngine.base.Position;

public class Coordinate extends Position{

	private Coordinate parent;
	
	public Coordinate(Position p, Coordinate parent) {
		super(p.getX(), p.getY());
		this.parent = parent;
	}
	
	public Coordinate(Position p) {
		super(p.getX(), p.getY());
	}
	
	public Coordinate(int x, int y, Coordinate parent) {
		super(x , y);
		this.parent = parent;
	}

	public Coordinate getParent() {
		return parent;
	}
	
}

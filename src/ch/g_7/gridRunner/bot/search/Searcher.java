package ch.g_7.gridRunner.bot.search;

import java.util.ArrayList;

import ch.g_7.gridEngine.base.Dimension;
import ch.g_7.gridEngine.base.Position;
import ch.g_7.gridEngine.core.FieldGrid;
import ch.g_7.gridEngine.field.Field;

public abstract class Searcher {

	protected ArrayList<Coordinate> visited;
	protected FieldGrid grid;
	protected Field<?> start;
	protected Field<?> aim;
	
	public Searcher(FieldGrid grid, Field<?> start, Field<?> aim) {
		this.visited = new ArrayList<>();
		this.grid = grid;
		this.start = start;
		this.aim = aim;
	}
	
	public abstract Coordinate solve();
	
	protected ArrayList<Coordinate> getChildren(Coordinate c){
		ArrayList<Coordinate> coordinates = new ArrayList<>();
		for(Dimension d : Dimension.DIRECTIONS) {
			Coordinate coordinate = new Coordinate(c.increase(d),c);
			if(grid.contains(coordinate) && grid.getStackAt(coordinate).canFieldGetAdded(start) && !isVisited(coordinate)) {
				coordinates.add(coordinate);
			}
		}
		return coordinates;
	}
	
	protected void setVisited(Coordinate c) {
		visited.add(c);
	}
	
	protected boolean isVisited(Coordinate c) {
		return visited.contains(c);
	}
	
	protected void reset() {
		visited = new ArrayList<>();
	}
}

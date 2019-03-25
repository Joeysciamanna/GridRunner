package ch.g_7.gridRunner.controller.bot.search;

import java.util.LinkedList;
import java.util.Queue;
import ch.g_7.gridEngine.core.FieldGrid;
import ch.g_7.gridEngine.field.Field;

public class BreadthFirstSearcher extends Searcher{

	public BreadthFirstSearcher(FieldGrid grid, Field<?> start, Field<?> aim) {
		super(grid, start, aim);
	}
	
	@Override
	public Coordinate solve() {
		reset();
		Queue<Coordinate> coordinates = new LinkedList<>();

		coordinates.add(new Coordinate(this.start.getPosition()));

		while (!coordinates.isEmpty()) {
			Coordinate c = coordinates.poll();
			if (c.equals(aim.getPosition())) {
				return c;
			}
			for (Coordinate childCoordinate : getChildren(c)) {
				coordinates.add(childCoordinate);
				setVisited(childCoordinate);
			}
		}
		return null;
	}
}

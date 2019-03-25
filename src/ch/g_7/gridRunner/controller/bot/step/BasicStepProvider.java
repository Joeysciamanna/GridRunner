package ch.g_7.gridRunner.controller.bot.step;

import java.util.LinkedList;
import java.util.Queue;

import ch.g_7.gridEngine.base.Dimension;
import ch.g_7.gridEngine.base.Position;
import ch.g_7.gridRunner.controller.bot.search.Coordinate;

public class BasicStepProvider implements StepProvider{

	private LinkedList<Dimension> coordinates;
	
	public BasicStepProvider(Coordinate c) {
		setCoordinates(c);
	}
	
	protected void setCoordinates(Coordinate c) {
		coordinates = new LinkedList<>();
		while (c!=null) {
			if(c.getParent()!=null) {
				coordinates.push(c.difference(c.getParent()));
			}
			c = c.getParent();
		}
	}

	public Dimension next() {
		return coordinates.poll();
	}

}

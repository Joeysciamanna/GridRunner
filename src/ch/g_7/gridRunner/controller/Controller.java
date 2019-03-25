package ch.g_7.gridRunner.controller;

import ch.g_7.gridRunner.field.controlable.Controlable;

public class Controller<T extends Controlable> {

	protected T controlable;
	
	public Controller(T controlable) {
		this.controlable = controlable;
		controlable.setBot(true);
	}
}

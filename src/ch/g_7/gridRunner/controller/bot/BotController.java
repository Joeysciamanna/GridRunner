package ch.g_7.gridRunner.controller.bot;

import ch.g_7.gridRunner.base.Startable;
import ch.g_7.gridRunner.controller.Controller;
import ch.g_7.gridRunner.field.controlable.Bot;

public abstract class BotController<T extends Bot> extends Controller<T> implements Startable{

	public BotController(T controlable) {
		super(controlable);
	}

}

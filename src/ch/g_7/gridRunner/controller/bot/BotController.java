package ch.g_7.gridRunner.controller.bot;

import ch.g_7.gridRunner.base.Startable;
import ch.g_7.gridRunner.controller.Controller;
import ch.g_7.gridRunner.field.controlable.Bot;

public abstract class BotController extends Controller<Bot> implements Startable{

	public BotController(Bot controlable) {
		super(controlable);
	}

	public abstract String getControllerName();
}

package ch.g_7.gridRunner.controller.bot;

import ch.g_7.gridEngine.core.FieldGrid;
import ch.g_7.gridRunner.base.Startable;
import ch.g_7.gridRunner.controller.Controller;
import ch.g_7.gridRunner.controller.bot.aim.AimProvider;
import ch.g_7.gridRunner.field.controlable.Bot;
import ch.g_7.gridRunner.field.controlable.Controlable;
import ch.g_7.gridRunner.field.controlable.Player;

public abstract class AdvancedBotController<T extends Bot> extends BotController<T>{

	private AimProvider aimProvider;
	protected FieldGrid grid;
	
	public AdvancedBotController(T controlable, AimProvider aimProvider, FieldGrid grid) {
		super(controlable);
		this.aimProvider = aimProvider;
		this.grid = grid;
	}
	
	public Player getAim() {
		return aimProvider.getAim();
	}

	
	
	
}

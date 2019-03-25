package ch.g_7.gridRunner.controller.bot.aim;

import ch.g_7.gridRunner.field.controlable.Player;

public class BasicAimProvider implements AimProvider{

	private Player aim;
	
	public BasicAimProvider(Player aim) {
		this.aim = aim;
	}
	
	@Override
	public Player getAim() {
		return aim;
	}

}

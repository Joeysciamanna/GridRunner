package ch.g_7.gridRunner.controller.bot.creation;

import java.util.Random;

import ch.g_7.gridRunner.base.Controlable;
import ch.g_7.gridRunner.bot.pathprovider.RefreshingSearchPathProvider;
import ch.g_7.gridRunner.bot.search.BreadthFirstSearcher;
import ch.g_7.gridRunner.controller.Controller;
import ch.g_7.gridRunner.controller.bot.BounceController;
import ch.g_7.gridRunner.controller.bot.PathFollowerController;
import ch.g_7.gridRunner.field.controlable.Bot;
import ch.g_7.gridRunner.field.controlable.Player;

public class BotControllerFactory {
	
	public static Controller<?> getBotController(Bot bot, String botControllerName){
		switch (botControllerName) {
		case "BounceController":
			return new BounceController(bot);
		case "PathFollowerController":
			return new PathFollowerController(bot,new RefreshingSearchPathProvider(new BreadthFirstSearcher(bot.getGrid(), bot, bot)));
		default:
			return getBotController(bot,randomBotControllerName());
		}
	}

	public static Controller<?> getBotController(Bot bot){
		return getBotController(bot, bot.getCode().getAdditionalArguments().length > 2 ? bot.getCode().getAdditionalArguments()[2] : randomBotControllerName());
	}
	
	private static String randomBotControllerName() {
		String[] bots = {"BounceController","PathFollowerController"};
		return bots[new Random().nextInt(bots.length)];
	}
}

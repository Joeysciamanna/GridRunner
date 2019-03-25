package ch.g_7.gridRunner.controller.bot.creation;

import java.util.Random;

import ch.g_7.gridRunner.controller.Controller;
import ch.g_7.gridRunner.controller.bot.BotController;
import ch.g_7.gridRunner.controller.bot.BounceController;
import ch.g_7.gridRunner.controller.bot.FollowController;
import ch.g_7.gridRunner.controller.bot.aim.NearestAimProvider;
import ch.g_7.gridRunner.controller.bot.search.BreadthFirstSearcher;
import ch.g_7.gridRunner.field.controlable.Bot;

public class BotControllerFactory {
	
	public static BotController<?> getBotController(Bot bot, String botControllerName){
		switch (botControllerName) {
		case "BounceController":
			return new BounceController(bot);
		case "BreadthFirstSearcher":
			return new FollowController(bot, new NearestAimProvider(bot, bot.getGrid()), bot.getGrid(), new BreadthFirstSearcher(bot.getGrid(), bot, bot));
		default:
			return getBotController(bot,randomBotControllerName());
		}
	}

	public static BotController<?> getBotController(Bot bot){
		return getBotController(bot, bot.getCode().getAdditionalArguments().length > 2 ? bot.getCode().getAdditionalArguments()[2] : randomBotControllerName());
	}
	
	private static String randomBotControllerName() {
		String[] bots = {"BounceController","BreadthFirstSearcher"};
		return bots[new Random().nextInt(bots.length)];
	}
}

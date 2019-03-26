package ch.g_7.gridRunner.controller.bot.creation;

import java.util.Random;

import ch.g_7.gridEngine.core.FieldGrid;
import ch.g_7.gridRunner.controller.Controller;
import ch.g_7.gridRunner.controller.bot.BotController;
import ch.g_7.gridRunner.controller.bot.BounceController;
import ch.g_7.gridRunner.controller.bot.FollowController;
import ch.g_7.gridRunner.controller.bot.aim.NearestAimProvider;
import ch.g_7.gridRunner.controller.bot.search.BreadthFirstSearcher;
import ch.g_7.gridRunner.field.controlable.Bot;

public class BotControllerFactory {
	
	public static BotController getBotController(String botControllerName,Bot bot, FieldGrid grid){
		switch (botControllerName) {
		case "BounceController":
			return new BounceController(bot, grid);
		case "BreadthFirstSearcher":
			return new FollowController(bot, new NearestAimProvider(bot, grid),grid, new BreadthFirstSearcher(grid, bot, bot));
		default:
			return getBotController(randomBotControllerName(),bot,grid);
		}
	}
	
	private static String randomBotControllerName() {
		String[] bots = {"BounceController","BreadthFirstSearcher"};
		return bots[new Random().nextInt(bots.length)];
	}
}

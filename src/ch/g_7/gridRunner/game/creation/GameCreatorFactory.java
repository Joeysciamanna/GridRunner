package ch.g_7.gridRunner.game.creation;

import ch.g_7.gridRunner.game.Game;
import ch.g_7.gridRunner.game.OfflineGame;
import ch.g_7.gridRunner.game.creation.creator.GameCreator;
import ch.g_7.gridRunner.game.creation.creator.OfflineGameCreator;
import ch.g_7.gridRunner.game.creation.creator.OnlineGameCreator;
import ch.g_7.gridRunner.game.creation.creator.ServersideGameCreator;
import ch.g_7.gridRunner.game.creation.event.GameCreationEvent;
import ch.g_7.gridRunner.game.creation.event.OnlineGameCreationEvent;

public class GameCreatorFactory {

	public static <T extends GameCreationEvent,V extends Game> GameCreator<?, ?> getGameCreatorFor(T event){
		if(!event.isOnline() && !event.isSimulated()) {
			return new OfflineGameCreator(event);
		}else if(event.isOnline() && !event.isSimulated()) {
			return new OnlineGameCreator((OnlineGameCreationEvent) event);
		}else if(event.isSimulated()) {
			return new ServersideGameCreator(event);
		}
		return null;
	}
}

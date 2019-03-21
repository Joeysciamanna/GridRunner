package ch.g_7.gridRunner.game.creation;

import ch.g_7.gridRunner.game.Game;
import ch.g_7.gridRunner.game.OfflineGame;
import ch.g_7.gridRunner.game.creation.creator.GameCreator;
import ch.g_7.gridRunner.game.creation.creator.OfflineGameCreator;
import ch.g_7.gridRunner.game.creation.creator.SimulatedGameCreator;
import ch.g_7.gridRunner.game.creation.event.GameCreationEvent;

public class GameCreatorFactory {

	@SuppressWarnings("unchecked")
	public static <T extends GameCreationEvent,V extends Game> GameCreator<V, T> getGameCreatorFor(T event){
		if(!event.isOnline()) {
			return (GameCreator<V, T>) new OfflineGameCreator(event);
		}else if(event.isSimulated()) {
			return (GameCreator<V, T>) new SimulatedGameCreator(event);
		}
		return null;
	}
}

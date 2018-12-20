package ch.g_7.gridRunner.gameCreation;

public class GameCreatorProducer {

	public static GameCreator getGameCreator(GameCreationEvent event) {
		GameInstace game = new GameInstace();
		if (event.isLocal()) {
			return new LocalGameCreator(event);
		} else {
			return new OnlineGameCreator(event);
		}

	}

}

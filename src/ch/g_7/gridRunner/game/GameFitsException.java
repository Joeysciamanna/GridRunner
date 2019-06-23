package ch.g_7.gridRunner.game;

public class GameFitsException extends RuntimeException{

	public GameFitsException() {
		super("The loaded Map doesnt fit the requirements of the event");
	}
}

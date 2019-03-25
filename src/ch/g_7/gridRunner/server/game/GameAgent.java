package ch.g_7.gridRunner.server.game;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

import ch.g_7.gridRunner.game.creation.event.OnlineGameCreationEvent;

public interface GameAgent extends Remote, Serializable {

	public OnlineGameCreationEvent getGame(int clientId) throws RemoteException;

	public void start() throws RemoteException;
}

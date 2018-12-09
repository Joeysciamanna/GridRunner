package ch.g_7.gridRunner.connection;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import ch.g_7.gridRunner.server.Agent;
import ch.g_7.gridRunner.server.controller.ControllerAgent;
import ch.g_7.gridRunner.server.game.GameAgent;
import ch.g_7.gridRunner.server.id.ClientIdAgent;

public class ServerConnectionEstablisher{

	private static final String DOMAIN = "rmi://localhost:1109/";
	
	private static GameAgent gameAgent;
	private static ControllerAgent controllerAgent;
	private static ClientIdAgent clientIdAgent;
	
	public static ControllerAgent getControllerAgent() throws RemoteException, NotBoundException {
		if(controllerAgent==null) {
			try {
				controllerAgent = (ControllerAgent) Naming.lookup(DOMAIN+Agent.CONTROLLER.getName());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return controllerAgent;
	}
	
	public static GameAgent getGameAgent() throws RemoteException, NotBoundException {
		if(gameAgent==null) {
			try {
				gameAgent = (GameAgent) Naming.lookup(DOMAIN+Agent.GAME.getName());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return gameAgent;
	}
	
	public static ClientIdAgent getClientIdAgent() throws RemoteException, NotBoundException {
		if(clientIdAgent==null) {
			try {
				clientIdAgent = (ClientIdAgent) Naming.lookup(DOMAIN+Agent.CLIENT_ID.getName());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return clientIdAgent;
	}
}

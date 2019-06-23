package ch.g_7.gridRunner.game;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ch.g_7.gridRunner.controller.SynchronizedController;
import ch.g_7.gridRunner.field.controlable.Controlable;
import ch.g_7.gridRunner.server.game.GameAgent;
import ch.g_7.gridRunner.server.player.PlayerAgent;

public class OnlineGame extends OfflineGame{

	private ArrayList<PlayerAgent> agents;
	private GameAgent gameAgent;
	
	public OnlineGame() {
		agents = new ArrayList<>();
	}

	
	public void addPlayerAgend(PlayerAgent playerAgent, Controlable controlable) {
		addStartable(new SynchronizedController(controlable, playerAgent));
	}


	public ArrayList<PlayerAgent> getAgents() {
		return agents;
	}

	public void addAgents(PlayerAgent agent) {
		agents.add(agent);
	}
	
	public void setGameAgent(GameAgent gameAgent) {
		this.gameAgent = gameAgent;
	}
	
	@Override
	public void start() {
		super.start();
		try {
			gameAgent.start();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
}

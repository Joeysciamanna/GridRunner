package ch.g_7.gridRunner.game;

import java.util.ArrayList;

import ch.g_7.gridRunner.server.Server;
import ch.g_7.gridRunner.server.agent.Agent;
import ch.g_7.gridRunner.server.player.PlayerAgentImpl;
import ch.g_7.gridRunner.server.player.ServersidePlayer;

public class ServersideGame extends Game {

	private ArrayList<PlayerAgentImpl> agents;
	
	public ServersideGame() {
		agents = new ArrayList<>();
	}

	public ArrayList<PlayerAgentImpl> getAgends() {
		return agents;
	}

	@Override
	public ServersidePlayer getPlayer(int i) {
		return (ServersidePlayer) super.getPlayer(i);
	}

	public void addAgend(PlayerAgentImpl agend) {
		agents.add(agend);
	}

	
	public void bind() {
		for (Agent agent : agents) {
			Server.bind(agent);
		}
	}
	
	public void unbind() {
		for (Agent agent : agents) {
			Server.unbind(agent);
		}
	}

}

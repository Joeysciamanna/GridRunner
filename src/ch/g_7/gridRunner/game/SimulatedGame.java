package ch.g_7.gridRunner.game;

import java.util.ArrayList;

import ch.g_7.gridRunner.server.Server;
import ch.g_7.gridRunner.server.agent.Agent;
import ch.g_7.gridRunner.server.player.VirtualPlayer;
import ch.g_7.gridRunner.server.player.VirtualPlayerAgent;
import ch.g_7.gridRunner.server.player.VirtualPlayerAgentImpl;

public class SimulatedGame extends Game {

	private ArrayList<VirtualPlayerAgentImpl> agents;

	public SimulatedGame() {
		agents = new ArrayList<>();
	}

	public ArrayList<VirtualPlayerAgentImpl> getAgends() {
		return agents;
	}

	@Override
	public VirtualPlayer getPlayer(int i) {
		return (VirtualPlayer) super.getPlayer(i);
	}

	public void addAgend(VirtualPlayerAgentImpl agend) {
		agents.add(agend);
	}

	@Override
	public void start() {
		for (Agent agent : agents) {
			Server.bind(agent);
		}
		super.start();
	}
	
	@Override
	public void stop() {
		for (Agent agend : agents) {
			Server.unbind(agend);
		}
		super.stop();
	}

}

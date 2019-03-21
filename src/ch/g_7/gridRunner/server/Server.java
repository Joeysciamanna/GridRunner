package ch.g_7.gridRunner.server;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import ch.g_7.gridEngine.field.building.FieldCreationRegister;
import ch.g_7.gridRunner.server.agent.Agent;

public class Server {

	private static Registry registry;

	public static void main(String[] args) {
		FieldCreationRegister.setDefaultFactory(new ServerGridRunnerFieldFactory());
		try {
			registry = LocateRegistry.createRegistry(1109);

			


		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void bind(Agent agent) {
		try {
			registry.rebind(agent.getName(), agent);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public static void unbind(Agent agent) {
		try {
			registry.unbind(agent.getName());
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
}

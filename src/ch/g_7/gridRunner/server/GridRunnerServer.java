package ch.g_7.gridRunner.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class GridRunnerServer extends UnicastRemoteObject {

	private static final long serialVersionUID = 1L;

	protected GridRunnerServer() throws RemoteException {
		try {

			Registry reg = LocateRegistry.createRegistry(1109);
			reg.bind("controllerAgent", new ControllerAgentImpl());
		} catch (Exception e) {

			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();

		}
	}

	public static void main(String[] args) {
		try {
			GridRunnerServer gridRunnerServer = new GridRunnerServer();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}

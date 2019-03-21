package ch.g_7.gridRunner.connection;

import java.lang.invoke.MethodHandles.Lookup;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import ch.g_7.gridRunner.server.player.VirtualPlayerAgent;

public class ServerConnectionProvider {

private static final String DOMAIN = "rmi://localhost:1109/";
	
	private static VirtualPlayerAgent virtualPlayerAgent;

	
	public static VirtualPlayerAgent getPlayerStatusAgent() {
		if(virtualPlayerAgent==null) {
			virtualPlayerAgent = (VirtualPlayerAgent) lookup("name");
		}
		return virtualPlayerAgent;
	}

	private static Remote lookup(String name) {
		try {
			return Naming.lookup(DOMAIN+name);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw new RuntimeException(e);
		}
	}
	
}

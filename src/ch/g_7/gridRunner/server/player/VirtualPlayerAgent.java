package ch.g_7.gridRunner.server.player;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

import ch.g_7.gridEngine.base.Dimension;
import ch.g_7.gridEngine.base.Position;
import ch.g_7.gridRunner.base.Controlable;

public interface VirtualPlayerAgent extends Remote, Serializable {
	
	public boolean move(Dimension d) throws RemoteException;
	
	public boolean isBot() throws RemoteException;
	
	public void setBot(boolean b) throws RemoteException;

	public Position getPosition() throws RemoteException;
}

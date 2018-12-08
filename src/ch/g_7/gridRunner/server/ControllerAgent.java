package ch.g_7.gridRunner.server;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

import ch.g_7.gridRunner.PlayerKeyListner.ControlEvent;

public interface ControllerAgent extends Remote, Serializable{

	public void control(ControlEvent event) throws RemoteException;
}

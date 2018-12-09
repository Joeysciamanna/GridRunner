package ch.g_7.gridRunner.server.controller;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import ch.g_7.gridRunner.PlayerKeyListner.ControlEvent;
import ch.g_7.gridRunner.id.ClientId;

public interface ControllerAgent extends Remote, Serializable{

	public void registerControl(ControlEvent controlEvent) throws RemoteException;

	public ArrayList<Integer> getControls(ClientId id) throws RemoteException;
}

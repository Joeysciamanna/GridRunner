package ch.g_7.gridRunner.server.controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import ch.g_7.gridRunner.PlayerKeyListner.ControlEvent;
import ch.g_7.gridRunner.id.ClientId;

public class ControllerAgentImpl extends UnicastRemoteObject implements ControllerAgent{

	private static final long serialVersionUID = 931970509182459785L;
	
	private Map<Integer, ArrayList<Integer>> controls = new HashMap<>();
	
	public ControllerAgentImpl() throws RemoteException {
		super();
	}

	@Override
	public synchronized void registerControl(ControlEvent controlEvent) throws RemoteException {
		int id = controlEvent.getAppliedTo().getId();
		//System.out.println("Registering Controlls for: " + id);
		if(controls.containsKey(id)) {
			controls.get(id).add(controlEvent.getControl());
		}else {
			controls.put(id, new ArrayList<>());
			controls.get(id).add(controlEvent.getControl());
		}
	}

	@Override
	public synchronized ArrayList<Integer> getControls(ClientId client) throws RemoteException {
		int id = client.getId();
		
		if(controls.containsKey(id)) {
			//System.out.println("Sending controls to: " + id);
			ArrayList<Integer> control = controls.get(id);
			controls.remove(id);
			return control;
		}
		return new ArrayList<>();
	}
	
}

package ch.g_7.gridRunner.PlayerKeyListner;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import ch.g_7.gridRunner.fields.Player;
import ch.g_7.gridRunner.helper.KeySet;
import ch.g_7.gridRunner.server.controller.ControllerAgent;

public class LocalKeyController extends KeyController {

	private ControllerAgent controllerAgent;
	private ArrayList<Integer> controls = new ArrayList<>();
	
	public LocalKeyController(Player player, KeySet keySet, ControllerAgent controllerAgent) {
		super(player, keySet);
		this.controllerAgent = controllerAgent;
	}

	@Override
	protected void control() {
		if (up) {
			controls.add(KeySet.WASD.getUp());
			player.moveUp(1);
		}
		if (left) {
			controls.add(KeySet.WASD.getLeft());
			player.moveLeft(1);
		}
		if (down) {
			controls.add(KeySet.WASD.getDown());
			player.moveDown(1);
		}
		if (right) {
			controls.add(KeySet.WASD.getRight());
			player.moveRight(1);
		}
		execRegisterdControls();
	}

	private void execRegisterdControls() {
		ArrayList<Integer> execControls = new ArrayList<>();
		for (Integer c : controls) {
			try {
				controllerAgent.registerControl(new ControlEvent(c, player.getCleintId()));
				execControls.add(controls.indexOf(c));
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		for (Integer i : execControls) {
			controls.remove(i);
		}
		
	}

}

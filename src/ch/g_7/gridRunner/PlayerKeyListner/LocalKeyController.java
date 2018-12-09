package ch.g_7.gridRunner.PlayerKeyListner;

import java.rmi.RemoteException;

import ch.g_7.gridRunner.fields.Player;
import ch.g_7.gridRunner.helper.KeySet;
import ch.g_7.gridRunner.server.controller.ControllerAgent;

public class LocalKeyController extends KeyController {

	private ControllerAgent controllerAgent;

	public LocalKeyController(Player player, KeySet keySet, ControllerAgent controllerAgent) {
		super(player, keySet);
		this.controllerAgent = controllerAgent;
	}

	@Override
	protected void control() {
		if (up) {
			try {
				controllerAgent.registerControl(new ControlEvent(KeySet.WASD.getUp(),player.getCleintId()));
			} catch (RemoteException e) {
				System.out.println("Error at Sending Controls,tryiing again");
				try {
					controllerAgent.registerControl(new ControlEvent(KeySet.WASD.getUp(),player.getCleintId()));
				} catch (RemoteException e1) {
					System.out.println("Error at Sending Controls");
				}
			}
			player.moveUp(1);
		}
		if (left) {
			try {
				controllerAgent.registerControl(new ControlEvent(KeySet.WASD.getLeft(),player.getCleintId()));
			} catch (RemoteException e) {
				System.out.println("Error at Sending Controls,tryiing again");
				try {
					controllerAgent.registerControl(new ControlEvent(KeySet.WASD.getLeft(),player.getCleintId()));
				} catch (RemoteException e1) {
					System.out.println("Error at Sending Controls");
				}
			}
			player.moveLeft(1);
		}
		if (down) {
			try {
				controllerAgent.registerControl(new ControlEvent(KeySet.WASD.getDown(),player.getCleintId()));
			} catch (RemoteException e) {
				System.out.println("Error at Sending Controls,tryiing again");
				try {
					controllerAgent.registerControl(new ControlEvent(KeySet.WASD.getDown(),player.getCleintId()));
				} catch (RemoteException e1) {
					System.out.println("Error at Sending Controls");
				}
			}
			player.moveDown(1);
		}
		if (right) {
			try {
				controllerAgent.registerControl(new ControlEvent(KeySet.WASD.getRight(),player.getCleintId()));
			} catch (RemoteException e) {
				System.out.println("Error at Sending Controls,tryiing again");
				try {
					controllerAgent.registerControl(new ControlEvent(KeySet.WASD.getRight(),player.getCleintId()));
				} catch (RemoteException e1) {
					System.out.println("Error at Sending Controls");
				}
			}
			player.moveRight(1);
		}
	}

}

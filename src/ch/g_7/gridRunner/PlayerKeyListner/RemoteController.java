package ch.g_7.gridRunner.PlayerKeyListner;

import java.awt.event.KeyEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;

import ch.g_7.gridRunner.fields.Player;
import ch.g_7.gridRunner.helper.KeySet;
import ch.g_7.gridRunner.id.ClientId;
import ch.g_7.gridRunner.server.controller.ControllerAgent;

public class RemoteController extends PlayerController{

	private ControllerAgent controllerAgent;
	
	public RemoteController(Player player,ControllerAgent controllerAgent) {
		super(player);
		this.controllerAgent = controllerAgent;
	}


	
	@Override
	public void run() {
		while(run) {
			try {
				ArrayList<Integer> controls = controllerAgent.getControls(player.getCleintId());
				if(!controls.isEmpty()) {
					System.out.println("Exec. Controlls for: " + player.getCleintId().getId() + "  (" + controls.get(0) + (controls.size()>1?"... ":"") + ")");
					for (Integer control:controls) {
						switch (control) {
						case KeyEvent.VK_W:
							player.moveUp(1);
							break;
						case KeyEvent.VK_A:
							player.moveLeft(1);
							break;
						case KeyEvent.VK_S:
							player.moveDown(1);
							break;
						case KeyEvent.VK_D:
							player.moveRight(1);
							break;
						}
						player.f
					}					
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}
}

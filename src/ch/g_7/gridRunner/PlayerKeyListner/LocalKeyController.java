package ch.g_7.gridRunner.PlayerKeyListner;

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
		try {
		if (up) {
			controllerAgent.registerControl(new ControlEvent(KeySet.WASD.getUp(),player.getCleintId()));
			player.moveUp(1);
		}
		if (left) {
			controllerAgent.registerControl(new ControlEvent(KeySet.WASD.getLeft(),player.getCleintId()));
			player.moveLeft(1);
		}
		if (down) {
			controllerAgent.registerControl(new ControlEvent(KeySet.WASD.getDown(),player.getCleintId()));
			player.moveDown(1);
		}
		if (right) {
			controllerAgent.registerControl(new ControlEvent(KeySet.WASD.getRight(),player.getCleintId()));
			player.moveRight(1);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}

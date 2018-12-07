package ch.g_7.gridRunner.PlayerKeyListner;

import ch.g_7.gridRunner.fields.Player;
import ch.g_7.gridRunner.helper.KeySet;

public class LocalKeyController extends KeyController{

	public LocalKeyController(Player player,KeySet keySet,RemoteController remoteController) {
		super(player, keySet);
	}

}

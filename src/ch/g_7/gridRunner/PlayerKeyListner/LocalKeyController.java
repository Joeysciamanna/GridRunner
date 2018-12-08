package ch.g_7.gridRunner.PlayerKeyListner;

import java.awt.event.KeyEvent;
import java.rmi.RemoteException;

import ch.g_7.gridRunner.fields.Player;
import ch.g_7.gridRunner.helper.KeySet;
import ch.g_7.gridRunner.id.ClientId;
import ch.g_7.gridRunner.id.Identifiable;
import ch.g_7.gridRunner.server.ControllerAgent;

public class LocalKeyController extends KeyController implements Identifiable {

	private ClientId id;
	private ControllerAgent rci;

	public LocalKeyController(Player player, KeySet keySet, ClientId id ,ControllerAgent rci) {
		super(player, keySet);
		this.id = id;
		this.rci = rci;
	}

	@Override
	public ClientId getId() {
		return id;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		try {
			rci.control(new ControlEvent(id, e, ActionEvent.KEY_PRESSED,keySet));
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		super.keyPressed(e);
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		try {
			rci.control(new ControlEvent(id, e, ActionEvent.KEY_RELEASED,keySet));
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		super.keyReleased(e);
	}

}

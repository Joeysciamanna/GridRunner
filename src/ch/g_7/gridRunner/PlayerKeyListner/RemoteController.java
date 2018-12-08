package ch.g_7.gridRunner.PlayerKeyListner;

import java.awt.event.KeyEvent;
import ch.g_7.gridRunner.fields.Player;
import ch.g_7.gridRunner.helper.KeySet;
import ch.g_7.gridRunner.id.ClientId;
import ch.g_7.gridRunner.id.Identifiable;

public class RemoteController extends PlayerController implements Identifiable{

	private ClientId id;
	
	public RemoteController(Player player,ClientId id) {
		super(player);
		this.id = id;
	}


	@Override
	public ClientId getId() {
		return id;
	}


	public void keyPressed(KeyEvent e,KeySet keySet) {	
		int keyCode = e.getKeyCode();
		
		if(keySet.getUp() == keyCode) {
			up = true;
		}else if(keySet.getLeft() == keyCode) {
			left = true;
		}else if(keySet.getDown() == keyCode) {
			down = true;
		}else if(keySet.getRight() == keyCode) {
			right = true;
		}
		control();
	}

	public void keyReleased(KeyEvent e,KeySet keySet) {
		int keyCode = e.getKeyCode();
		
		if(keySet.getUp() == keyCode) {
			up = false;
		}else if(keySet.getLeft() == keyCode) {
			left = false;
		}else if(keySet.getDown() == keyCode) {
			down = false;
		}else if(keySet.getRight() == keyCode) {
			right = false;
		}
	}
}

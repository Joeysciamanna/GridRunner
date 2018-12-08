package ch.g_7.gridRunner.PlayerKeyListner;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import ch.g_7.gridRunner.fields.Player;
import ch.g_7.gridRunner.helper.KeySet;

public class KeyController extends PlayerController implements KeyListener{

	protected KeySet keySet;

	public KeyController(Player player, KeySet keySet) {
		super(player);
		this.keySet = keySet;
	}

	@Override
	public void keyPressed(KeyEvent e) {	
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

	@Override
	public void keyReleased(KeyEvent e) {
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
	
	
	
	
	
	
	

	@Override
	public void keyTyped(KeyEvent e) {}

}

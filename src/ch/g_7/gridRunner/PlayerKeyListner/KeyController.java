package ch.g_7.gridRunner.PlayerKeyListner;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import ch.g_7.gridRunner.fields.Player;
import ch.g_7.gridRunner.helper.KeySet;

public class KeyController extends PlayerController implements KeyListener{

	protected KeySet keySet;
	
	public KeyController(Player player,KeySet keySet) {
		super(player);
		this.keySet = keySet;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if(keyCode == keySet.getUp()) {
			player.moveUp(1);
		}else if(keyCode == keySet.getLeft()) {
			player.moveLeft(1);
		}else if(keyCode == keySet.getDown()) {
			player.moveDown(1);
		}else if(keyCode == keySet.getRight()) {
			player.moveRight(1);
		}
	}

	
	
	
	
	
	
	
	
	
	
	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}

}

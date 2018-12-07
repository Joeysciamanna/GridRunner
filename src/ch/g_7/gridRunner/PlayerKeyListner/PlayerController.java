package ch.g_7.gridRunner.PlayerKeyListner;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import ch.g_7.gridRunner.fields.Player;


public abstract class PlayerController{

	protected Player player;
	
	public PlayerController(Player player) {
		this.player = player;
	}
	
}

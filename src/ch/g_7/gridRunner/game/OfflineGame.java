package ch.g_7.gridRunner.game;

import java.awt.event.KeyListener;
import java.util.ArrayList;

public class OfflineGame extends Game{

	private ArrayList<KeyListener> listeners;
	
	public OfflineGame() {
		listeners = new ArrayList<>();
	}
	
	public ArrayList<KeyListener> getListeners() {
		return listeners;
	}

	public void addListner(KeyListener listener) {
		listeners.add(listener);
	}
}

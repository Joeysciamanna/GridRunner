package ch.g_7.gridRunner.controller.human;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.rmi.RemoteException;

import ch.g_7.gridEngine.base.Dimension;
import ch.g_7.gridRunner.helper.KeySet;
import ch.g_7.gridRunner.server.player.PlayerAgent;

public class VirtualKeyController implements KeyListener{

	private final static int SPEED = 100;
	private final static int DELAY = 250;
	private KeySet keySet;
	private KeyExecutor[] keyExecutors = new KeyExecutor[KeyEvent.KEY_LAST];
	
	private PlayerAgent controlable;
	
	public VirtualKeyController(PlayerAgent controlable, KeySet keySet) {
		this.controlable = controlable;
		try {
			controlable.setBot(false);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		this.keySet = keySet;
	}

	private void execute(int keyCode) throws RemoteException {
		if(keyCode == keySet.getUp()) {
			controlable.move(Dimension.UP);
		}else if(keyCode == keySet.getLeft()) {
			controlable.move(Dimension.LEFT);
		}else if(keyCode == keySet.getDown()) {
			controlable.move(Dimension.DOWN);
		}else if(keyCode == keySet.getRight()) {
			controlable.move(Dimension.RIGHT);
		}
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(keyExecutors[e.getKeyCode()] == null) {
			try {
				execute(e.getKeyCode());
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
			createExecutive(e.getKeyCode());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		stopExecutive(e.getKeyCode());
	}

	private void createExecutive(int keyCode) {
		if(keyExecutors[keyCode] == null) {
			keyExecutors[keyCode] = new KeyExecutor(keyCode);
		}
	}
	
	private void stopExecutive(int keyCode) {
		if(keyExecutors[keyCode] != null) {
			keyExecutors[keyCode].run = false;
			keyExecutors[keyCode] = null;
		}
	}

	private class KeyExecutor implements Runnable{
		
		private int keyCode;
		private boolean run = true;
		
		public KeyExecutor(int keyCode) {
			this.keyCode = keyCode;
			Thread t = new Thread(this);
			t.start();
		}
		
		@Override
		public void run() {
			try {
				Thread.sleep(DELAY);
				int i = 0;
				while(run && i < 100) {
					execute(keyCode);
					i++;
					Thread.sleep(SPEED);
				}
			} catch (InterruptedException | RemoteException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
}

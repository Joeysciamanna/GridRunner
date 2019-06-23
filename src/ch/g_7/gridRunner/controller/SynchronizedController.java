package ch.g_7.gridRunner.controller;

import java.rmi.RemoteException;

import ch.g_7.gridRunner.base.Startable;
import ch.g_7.gridRunner.field.controlable.Controlable;
import ch.g_7.gridRunner.server.player.PlayerAgent;

public class SynchronizedController extends Controller<Controlable> implements Startable, Runnable{

	private static final long SLEEP_TIME = 100;
	private PlayerAgent playerAgent;
	private boolean run;
	
	public SynchronizedController(Controlable controlable, PlayerAgent playerAgent) {
		super(controlable);
		this.playerAgent = playerAgent;
	}

	public void run() {
		try {
			while(run) {
				control();
				Thread.sleep(SLEEP_TIME);
			}
		} catch (InterruptedException | RemoteException e) {
			e.printStackTrace();
		}
	}
	
	
	private void control() throws RemoteException {
		controlable.move(playerAgent.getPosition().difference(controlable.getPosition()));
	}

	@Override
	public void start() {
		if(!run) {
			run=true;
			Thread t = new Thread(this);
			t.start();
		}
	}


	@Override
	public void stop() {
		run = false;
	}

	
}

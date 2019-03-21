package ch.g_7.gridRunner.controller;

import java.awt.Point;
import java.util.Random;
import java.util.Vector;

import ch.g_7.gridEngine.base.Dimension;
import ch.g_7.gridEngine.base.Position;
import ch.g_7.gridRunner.base.Startable;
import ch.g_7.gridRunner.fields.controlable.Player;


public class BounceController extends Controller<Player> implements Startable, Runnable{
	
	private final static int SPEED = 200;
	private Dimension direction;
	private boolean run;
	private Random random;
	
	public BounceController(Player player) {
		super(player);
		this.random = new Random();
		this.direction = Dimension.DIRECTIONS[random.nextInt(4)];
	}

	@Override
	public void run() {
		try {
			while(run) {
				control();
				Thread.sleep(SPEED);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected void control() {
		Vector<Dimension> posibilities = new Vector<>();
		
		Position p = controlable.getPosition().increase(direction);
		if(controlable.getGrid().contains(p) && controlable.getGrid().getStackAt(p).canFieldGetAdded(controlable)) {
			posibilities.add(direction);
		}else {
			for(Dimension d : Dimension.DIRECTIONS) {
				p = controlable.getPosition().increase(d);
				if (controlable.getGrid().contains(p) && controlable.getGrid().getStackAt(p).canFieldGetAdded(controlable)) {
					posibilities.add(d);
				}
			}
		}
		
		direction = posibilities.get(random.nextInt(posibilities.size()));
		controlable.move(direction);
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

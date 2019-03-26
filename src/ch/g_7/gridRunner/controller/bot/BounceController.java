package ch.g_7.gridRunner.controller.bot;

import java.awt.Point;
import java.util.Random;
import java.util.Vector;

import ch.g_7.gridEngine.base.Dimension;
import ch.g_7.gridEngine.base.Position;
import ch.g_7.gridEngine.core.FieldGrid;
import ch.g_7.gridRunner.base.Startable;
import ch.g_7.gridRunner.controller.Controller;
import ch.g_7.gridRunner.controller.bot.aim.AimProvider;
import ch.g_7.gridRunner.field.controlable.Bot;
import ch.g_7.gridRunner.field.controlable.Player;


public class BounceController extends BotController implements Runnable{

	private final static int SPEED = 200;
	private Dimension direction;
	private FieldGrid grid;
	private Random random;
	
	private boolean run;
	
	public BounceController(Bot bot, FieldGrid grid) {
		super(bot);
		this.grid = grid;
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
		if(grid.contains(p) && grid.getStackAt(p).canFieldGetAdded(controlable)) {
			posibilities.add(direction);
		}else {
			for(Dimension d : Dimension.DIRECTIONS) {
				p = controlable.getPosition().increase(d);
				if (grid.contains(p) && grid.getStackAt(p).canFieldGetAdded(controlable)) {
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

	@Override
	public String getControllerName() {
		return "BounceControllerp0";
	}

}

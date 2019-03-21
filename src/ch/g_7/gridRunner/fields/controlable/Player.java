package ch.g_7.gridRunner.fields.controlable;

import ch.g_7.gridEngine.base.Dimension;
import ch.g_7.gridEngine.core.FieldGrid;
import ch.g_7.gridEngine.field.building.FieldCode;
import ch.g_7.gridRunner.base.Controlable;
import ch.g_7.gridRunner.fields.BasicGridRunnerField;
import ch.g_7.gridRunner.resources.Image;

public class Player extends BasicGridRunnerField implements Controlable{

	private int playerNr;
	private boolean bot;
	
	public Player(int player) {
		super(Image.PLAYER1_UP);
		this.playerNr = player;
	}

	@Override
	public boolean move(Dimension d) {
		if(d.equals(Dimension.UP)) {
			setIcon(Image.PLAYER1_UP);
		}else if(d.equals(Dimension.LEFT)) {
			setIcon(Image.PLAYER1_LEFT);
		}else if(d.equals(Dimension.DOWN)) {
			setIcon(Image.PLAYER1_DOWN);
		}else if(d.equals(Dimension.RIGHT)) {
			setIcon(Image.PLAYER1_RIGHT);
		}
		return super.move(d);
	}
	
	@Override
	public FieldCode getCode() {
		return new FieldCode("PLAYER",String.valueOf(playerNr));
	}

	public int getPlayerNr() {
		return playerNr;
	}
	
	public FieldGrid getGrid() {
		return stack.getGrid();
	}

	@Override
	public boolean isBot() {
		return bot;
	}

	@Override
	public void setBot(boolean b) {
		bot = b;
	}
	
}

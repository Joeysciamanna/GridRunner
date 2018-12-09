package ch.g_7.gridRunner.fields;

import java.awt.Dimension;
import ch.g_7.gridEngine.base.Movable;
import ch.g_7.gridEngine.core.FieldStack;
import ch.g_7.gridEngine.field.building.FieldCode;
import ch.g_7.gridRunner.id.ClientId;
import ch.g_7.gridRunner.resources.Image;

public class Player extends BasicGridRunnerField implements Movable{

	private ClientId cleintId;
	private int player;
	
	public Player(int player,ClientId cleintId) {
		super(Image.valueOf("PLAYER" + player + "_UP"));
		this.cleintId = cleintId;
		this.player = player;
	}

	@Override
	public boolean moveUp(int d) {
		setIcon(Image.valueOf("PLAYER" + player + "_UP"));
		return move(new Dimension(0, -d));
	}
	
	@Override
	public boolean moveDown(int d) {
		setIcon(Image.valueOf("PLAYER" + player + "_DOWN"));
		return move(new Dimension(0, d));
	}
	
	@Override
	public boolean moveLeft(int d) {
		setIcon(Image.valueOf("PLAYER" + player + "_LEFT"));
		return move(new Dimension(-d, 0));
	}
	
	@Override
	public boolean moveRight(int d) {
		setIcon(Image.valueOf("PLAYER" + player + "_RIGHT"));
		return move(new Dimension(d, 0));
	}
	
	public FieldStack getStack() {
		return stack;
	}
	
	@Override
	public FieldCode getCode() {
		return new FieldCode("PLAYER",String.valueOf(player));
	}

	public void setCleintId(ClientId cleintId) {
		this.cleintId = cleintId;
	}
	
	public ClientId getCleintId() {
		return cleintId;
	}
}

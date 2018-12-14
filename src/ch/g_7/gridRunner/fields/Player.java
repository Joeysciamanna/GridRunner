package ch.g_7.gridRunner.fields;

import java.awt.Dimension;
import ch.g_7.gridEngine.base.Movable;
import ch.g_7.gridEngine.core.FieldStack;
import ch.g_7.gridEngine.field.building.FieldCode;
import ch.g_7.gridRunner.identification.ClientId;
import ch.g_7.gridRunner.playerStatus.PlayerStatus;
import ch.g_7.gridRunner.resources.Image;

public class Player extends BasicGridRunnerField implements Movable{

	private ClientId cleintId;
	private int playerNr;
	
	public Player(int player) {
		super(Image.valueOf("PLAYER" + player + "_UP"));
		this.playerNr = player;
	}

	@Override
	public boolean moveUp(int d) {
		setIcon(Image.valueOf("PLAYER" + playerNr + "_UP"));
		return move(new Dimension(0, -d));
	}
	
	@Override
	public boolean moveDown(int d) {
		setIcon(Image.valueOf("PLAYER" + playerNr + "_DOWN"));
		return move(new Dimension(0, d));
	}
	
	@Override
	public boolean moveLeft(int d) {
		setIcon(Image.valueOf("PLAYER" + playerNr + "_LEFT"));
		return move(new Dimension(-d, 0));
	}
	
	@Override
	public boolean moveRight(int d) {
		setIcon(Image.valueOf("PLAYER" + playerNr + "_RIGHT"));
		return move(new Dimension(d, 0));
	}
	
	@Override
	public FieldCode getCode() {
		return new FieldCode("PLAYER",String.valueOf(playerNr));
	}

	public void setCleintId(ClientId cleintId) {
		this.cleintId = cleintId;
	}
	
	public int getPlayerNr() {
		return playerNr;
	}
	
	public ClientId getCleintId() {
		return cleintId;
	}
	
	public PlayerStatus getPlayerStatus() {
		return new PlayerStatus(getPosition(), image);
	}
	
	public void setPlayerStatus(PlayerStatus status) {
		if(!getPosition().equals(status.getPosition())) {
			setPosition(status.getPosition());
			this.setIcon(status.getImage());
		}
	}
}

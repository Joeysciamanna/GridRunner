package ch.g_7.gridRunner.playerStatus;

import java.awt.Point;
import java.io.Serializable;

import ch.g_7.gridRunner.resources.Image;

public class PlayerStatus implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Point position;
	private Image image;
	
	public PlayerStatus(Point position,Image image) {
		this.position = position;
		this.image = image;
	}
	
	public Image getImage() {
		return image;
	}
	
	public Point getPosition() {
		return position;
	}

	public boolean isValid() {
		return image != null && position != null;
	}

}

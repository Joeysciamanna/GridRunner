package ch.g_7.grid_runner.base.field;

import ch.g_7.graphite.base.mesh.IMesh2d;
import ch.g_7.graphite.base.mesh.MeshFactory2d;
import ch.g_7.graphite.base.texture.Texture;
import ch.g_7.graphite.rendering.Basic2dRenderable;
import ch.g_7.graphite.util.Color;

public class Field implements Basic2dRenderable {

	private static IMesh2d FIELD_MESH = MeshFactory2d.getRectangle(1, 1).build();

	
	private Color color;
	private int x, y;

	public void setColor(Color color) {
		this.color = color;
	}


	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Color getColor() {
		return color;
	}

	public Texture getTexture() {
		return null;
	}

	public IMesh2d getMesh() {
		return FIELD_MESH;
	}

	public void close() {}

	public void init() {
		
	}
	
	
}

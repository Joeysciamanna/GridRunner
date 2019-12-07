package ch.g_7.grid_runner.field;

import org.joml.Vector2i;
import org.joml.Vector3f;
import org.joml.Vector3i;

import ch.g_7.graphite.base.entity.AbstractEntity;
import ch.g_7.graphite.base.mesh.AbstractMesh;
import ch.g_7.graphite.base.mesh.IMesh;
import ch.g_7.graphite.base.mesh.MeshFactory;
import ch.g_7.graphite.base.texture.Texture;
import ch.g_7.graphite.rendering.BasicRenderable;
import ch.g_7.graphite.util.Color;

public class Field implements BasicRenderable {

	private static AbstractMesh FIELD_MESH = MeshFactory.getRectangle(1, 1).build();

	
	private Color color;
	private Vector2i position;

	public void setColor(Color color) {
		this.color = color;
	}

	public void setPosition(Vector2i position) {
		this.position = position;
	}

	public Vector2i getPosition() {
		return position;
	}
	
	public Color getColor() {
		return color;
	}

	public Texture getTexture() {
		return null;
	}

	public IMesh getMesh() {
		return FIELD_MESH;
	}

	public void close() {}

	public void init() {}
	
	
}

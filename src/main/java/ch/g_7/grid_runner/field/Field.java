package ch.g_7.grid_runner.field;

import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Vector3f;
import org.joml.Vector3fc;

import ch.g_7.graphite.entity.mesh.IMesh;
import ch.g_7.graphite.entity.mesh.MeshFactory;
import ch.g_7.graphite.entity.object.IObject;
import ch.g_7.graphite.entity.viewmodel.IViewModel;

public class Field implements IObject {

	private static IMesh mesh = MeshFactory.getRectangle(1, 1).build();
	
	private IViewModel viewModel;
	private Vector3f position;
	private Vector3f rotation;
	private float scale;
	
	@Override
	public Matrix4fc getModelViewMatrix() {
		return new Matrix4f().translate(position).rotateXYZ(rotation).scale(scale);
	}

	public void setViewModel(IViewModel viewModel) {
		this.viewModel = viewModel;
	}

	@Override
	public IViewModel getViewModel() {
		return viewModel;
	}
	
	@Override
	public Vector3fc getPosition() {
		return position;
	}
	
	public void setPosition(Vector3f position) {
		this.position = position;
	}

	@Override
	public Vector3fc getRotation() {
		return rotation;
	}
	
	public void setRotation(Vector3f rotation) {
		this.rotation = rotation;
	}

	@Override
	public float getScale() {
		return scale;
	}
	
	public void setScale(float scale) {
		this.scale = scale;
	}

	@Override
	public void close() {
		viewModel.close();
	}

	@Override
	public void init() {}

	
	

}

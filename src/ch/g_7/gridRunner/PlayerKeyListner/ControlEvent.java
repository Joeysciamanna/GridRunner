package ch.g_7.gridRunner.PlayerKeyListner;

import java.awt.event.KeyEvent;
import java.io.Serializable;

import ch.g_7.gridRunner.helper.KeySet;
import ch.g_7.gridRunner.id.ClientId;

public class ControlEvent implements Serializable{

	private static final long serialVersionUID = -3282450131385015277L;
	
	private int control;
	private ClientId appliedTo;
	
	public ControlEvent(int control,ClientId appliedTo) {
		this.appliedTo = appliedTo;
		this.control = control;
	}
	
	public ClientId getAppliedTo() {
		return appliedTo;
	}
	public int getControl() {
		return control;
	}
}

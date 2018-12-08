package ch.g_7.gridRunner.PlayerKeyListner;

import java.awt.event.KeyEvent;
import java.io.Serializable;

import ch.g_7.gridRunner.helper.KeySet;
import ch.g_7.gridRunner.id.ClientId;

public class ControlEvent implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private ActionEvent actionEvent;
	private ClientId sendFrom;
	private KeyEvent keyEvent;
	private KeySet keySet;
	
	public ControlEvent(ClientId sendFrom,KeyEvent keyEvent,ActionEvent actionEvent,KeySet keySet) {
		this.sendFrom = sendFrom;
		this.keyEvent = keyEvent;
		this.actionEvent = actionEvent;
		this.keySet = keySet;
	}
	
	public ActionEvent getActionEvent() {
		return actionEvent;
	}
	
	public KeyEvent getKeyEvent() {
		return keyEvent;
	}
	
	public ClientId getSender() {
		return sendFrom;
	}
	
	public KeySet getKeySet() {
		return keySet;
	}
}

package ch.g_7.gridRunner.server;

import java.rmi.RemoteException;

import ch.g_7.gridRunner.PlayerKeyListner.ControlEvent;
import ch.g_7.gridRunner.PlayerKeyListner.RemoteController;

public class ControllerAgentImpl implements ControllerAgent{

	private RemoteController controller1;
	private RemoteController controller2;
	
	public ControllerAgentImpl(RemoteController controller1,RemoteController controller2) {
		this.controller1 = controller1;
		this.controller2 = controller2;
	}
	
	public void control(ControlEvent event) throws RemoteException{
		RemoteController controller = null;
		if(event.getSender().equals(controller1.getId())) {
			controller = controller2;
		}else if(event.getSender().equals(controller2.getId())) {
			controller = controller1;
		}
		switch (event.getActionEvent()) {
		case KEY_PRESSED:
			controller.keyPressed(event.getKeyEvent(),event.getKeySet());
			break;
		case KEY_RELEASED:
			controller.keyReleased(event.getKeyEvent(),event.getKeySet());
			break;
		}
	}
}

package ch.g_7.gridRunner.server.lobby;

import java.util.ArrayList;
import java.util.Random;

public class LobbyIdProvider {

	public static ArrayList<Long> ids;
	
	public static long getNewId() {
		long id = new Random().nextLong();
		while(ids.contains(id)) {
			id = new Random().nextLong();
		}
		ids.add(id);
		return id;
	}
	
	public static void setFree(long id) {
		ids.remove(new Long(id));
	}
}

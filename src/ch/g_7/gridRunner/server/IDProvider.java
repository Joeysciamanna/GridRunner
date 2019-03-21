package ch.g_7.gridRunner.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class IDProvider {

	private static Map<String, List<Integer>> idGroups = new HashMap<>();
	private static Random random = new Random();
	
	public static int getId(String groupName) {
		if(!idGroups.containsKey(groupName)) {
			idGroups.put(groupName, new ArrayList<>());
		}
		List<Integer> group = idGroups.get(groupName);
		int id = generateId();
		while (group.contains(id)) {
			id = generateId();
		}
		group.add(id);
		return id;
	}


	private static int generateId() {
		return random.nextInt();
	}
}

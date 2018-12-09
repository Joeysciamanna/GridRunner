package ch.g_7.gridRunner.id;

import java.io.Serializable;

public class ClientId implements Serializable{
	
	private static final long serialVersionUID = 2240429940354299312L;
	
	private int id;
	
	public ClientId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public boolean equals(ClientId id) {
		return id!=null && id.getId() == this.id;
	}
}

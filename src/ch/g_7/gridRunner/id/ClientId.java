package ch.g_7.gridRunner.id;

public class ClientId {
	private int id;
	
	public ClientId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public boolean equals(ClientId id) {
		return id.getId() == this.id;
	}
}

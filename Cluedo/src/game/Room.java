package game;

public class Room {
	private String name;
	private String stair;

	public Room(String name){
		this.name = name;
	}
	public Room(String name, String stair) {
		this.name = name;
		this.stair = stair;

	}

	public String getName() {
		return name;
	}

	public String getStair() {
		if (stair != null) {
			return stair;
		}
		else return null;
	}
}

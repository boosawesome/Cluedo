package game;

public class Weapon {
	private String name;
	private Room room;

	public Weapon(String name, Room room) {
		this.name = name;
		this.room = room;
	}

	public String getName(){
		return name;
	}

	public Room getRoom(){
		return room;
	}
}

package game;

import java.awt.Point;

public class Player {
	private boolean active;
	private String name;
	private Character card;
	private Weapon weapon;
	private Room room;
	private Point location;

	public Player(String name, Weapon weapon, Room room) {
		this.name = name;
		this.weapon = weapon;
		this.room = room;
		this.active = true;
	}

	public void lose() {
		this.active = false;
	}

	public void setRoom(Room newRoom) {
		this.room = newRoom;
		this.location = null;
	}

	public void setLocation(Point coord) {
		this.location = coord;
		this.room = null;
	}

	public boolean getActive() {
		return active;
	}

	public String getName() {
		return name;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public Room getRoom() {
		if (room != null) {
			return room;
		} else {
			return null;
		}
	}

	public Point getLocation() {
		if (location != null) {
			return location;
		} else {
			return null;
		}
	}

	public Character getChar(){
		return card;
	}

}

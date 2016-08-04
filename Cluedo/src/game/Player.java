package game;

import java.awt.Point;

import game.Card.Weapon;

public class Player {
	
	private boolean active;
	private String name;
	private Point location;

	public Player(String name) {
		this.name = name;
		this.active = true;
	}

	public void lose() {
		this.active = false;
	}

	public void setRoom(Room newRoom) {
		this.location = null;
	}

	public void setLocation(Point coord) {
		this.location = coord;
	}

	public boolean getActive() {
		return active;
	}

	public String getName() {
		return name;
	}




	public Point getLocation() {
		if (location != null) {
			return location;
		} else {
			return null;
		}
	}


}

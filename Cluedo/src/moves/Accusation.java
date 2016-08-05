package moves;

import items.*;
import items.Character;
import main.GameOfCluedo;

public class Accusation {

	Character character;
	Weapon weapon;
	Room room;
	
	public Accusation(Character character, Weapon weapon, Room room){
		this.character = character;
		this.weapon = weapon;
		this.room = room;
	}

	public Character getCharacter() {
		return character;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public Room getRoom() {
		return room;
	}
	
	
	
	
	
}

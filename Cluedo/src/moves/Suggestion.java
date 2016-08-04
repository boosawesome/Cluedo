package moves;

import game.*;
import items.*;
import items.Character;

public class Suggestion {
	
	Character character;
	Weapon weapon;
	Room room;
	
	public Suggestion(Character charc, Weapon weapon, Room room){
		this.character = charc;
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

package Moves;

import game.*;
import game.Card.Weapon;
import game.Player;
import game.Room;

public class Suggestion {
	
	Character character;
	Weapon weapon;
	Room room;
	
	public Suggestion(Character charc, Card.Weapon weapon, Room room){
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

package game;

import game.Card.Weapon;

public class Envelope {

Character character;
Weapon weapon;
Room room;

public Envelope(Character character, Weapon weapon, Room room){
	this.character = character;
	this.weapon = weapon;
	this.room = room;
}
	
public boolean checkSolution(Character c, Weapon w, Room r){
	if(c == this.character && w == this.weapon && r == this.room)return true;
	return false;
}
	
	
	
	
	
}

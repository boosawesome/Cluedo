package items;

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

public Character getCharacter() {
	return character;
}


public Weapon getWeapon() {
	return weapon;
}



public Room getRoom() {
	return room;
}

public String toString(){
	return "Murderer: " + character.getName() + " 	Weapon: "+weapon.getName()+"	 Room: "+room.getName();
}



	
	
	
	
	
}

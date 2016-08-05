package game;

import java.awt.Point;
import java.util.ArrayList;

import items.Card;
import items.Character.CharacterToken;
import items.Room;
import main.GameOfCluedo;

public class Player {
	
	private boolean active;
	private String name;
	private Point location;
	private CharacterToken character;
	private ArrayList<Card> hand;
	private Room room = null;
	
	public Player(String name, CharacterToken character, Point location) {
		this.name = name;
		this.active = true;
		this.character = character;
		this.location = location;
		this.hand = new ArrayList<Card>();
	}

	public void lose() {
		this.active = false;
	}

	public void setRoom(Room newRoom) {
		this.location = null;
		this.room = newRoom;
	}

	public void setLocation(Point coord) {
		this.location = coord;
		if(this.room != null){
		GameOfCluedo.getLocation(this.room).removePlayer(this);
		this.room = null;
		}
		
	}

	public boolean getActive() {
		return active;
	}

	public String getName() {
		return name;
	}
	
	public CharacterToken getCharacter(){
		return character;
	}
	
	public void addCard(Card c){
		hand.add(c);
	}
	
	public ArrayList<Card> getHand(){
		return this.hand;
	}
	
	public boolean hasCharacter(String c){
		return c.equals(this.character.name());
	}
	
	public Room getRoom(){
		return this.room;
	}

	public Point getLocation() {
		return this.location;
	}
	
	public String toString(){
		return "Player: "+name+"	Token: "+this.character +"	Location On Board: ["+(int)this.location.getX()+"]["+(int)this.location.getY()+"] "; 
	}


}

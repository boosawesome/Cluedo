package main;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import game.*;
import items.Card;
import items.Character.CharacterToken;
import items.Character;
import items.Room;
import items.Room.RoomToken;
import items.Weapon;
import items.Weapon.WeaponToken;
import moves.Suggestion;

public class GameOfCluedo {
	
	public enum Direction{
		NORTH,SOUTH,EAST,WEST
	}
	
	private Board board;
	private Envelope solution;
	ArrayList<Player> players;
	
	Set<Card> cards = new HashSet<Card>();
	ArrayList<Character> characters;
	ArrayList<Weapon> weapons;
	ArrayList<Room> rooms;
	
	public GameOfCluedo(){
		
		characters.add(new Character(CharacterToken.MISS_SCARLET));
		characters.add(new Character(CharacterToken.COLONEL_MUSTARD));
		characters.add(new Character(CharacterToken.MRS_WHITE));
		characters.add(new Character(CharacterToken.THE_REVEREND_GREEN));
		characters.add(new Character(CharacterToken.MRS_PEACOCK));
		characters.add(new Character(CharacterToken.PROFESSOR_PLUM));
	
		
		weapons.add(new Weapon(WeaponToken.CANDLESTICK));
		weapons.add(new Weapon(WeaponToken.DAGGER));
		weapons.add(new Weapon(WeaponToken.LEAD_PIPE));
		weapons.add(new Weapon(WeaponToken.REVOLVER));
		weapons.add(new Weapon(WeaponToken.ROPE));
		weapons.add(new Weapon(WeaponToken.SPANNER));
		
		
		rooms.add(new Room(RoomToken.BALLROOM));
		rooms.add(new Room(RoomToken.BILLARD_ROOM));
		rooms.add(new Room(RoomToken.CONSERVATORY));
		rooms.add(new Room(RoomToken.DINING_ROOM));
		rooms.add(new Room(RoomToken.HALL));
		rooms.add(new Room(RoomToken.KITCHEN));
		rooms.add(new Room(RoomToken.LIBRARY));
		rooms.add(new Room(RoomToken.LOUNGE));
		rooms.add(new Room(RoomToken.STUDY));
		
		cards.addAll(rooms);
		cards.addAll(weapons);
		cards.addAll(characters);
		
	}
	
	
	public Board getBoard(){
		return board;
	}
	
	
	public Envelope getSolution(){
		return this.solution;
	}
	
	public void movePlayer(int diceRoll, Direction d, Player p){
		int x = (int) p.getLocation().getX();
		int y = (int) p.getLocation().getY();
		
		if(d.equals(Direction.NORTH)){
			y -= diceRoll;
		}else if(d.equals(Direction.SOUTH)){
			y += diceRoll;
		}else if(d.equals(Direction.WEST)){
			x -= diceRoll;
		}else{
			x += diceRoll;
		}
		
		p.setLocation(new Point(x,y));
		
		
	}
	
	
	public void useStairWell(Room room, Player p){
		if(p.getRoom().equals(room) && room.hasStairWell()){
			p.setRoom(board.getRoom(room.getOpposite()));
		}
	}
	
	public void suggest(items.Character c, Weapon w, Room r, Player player){
		Suggestion suggestion = new Suggestion(c, w , r);
		w.setRoom(r);
		
		
		for(Player p : players){
			for(Card card : p.getHand()){
				if(card instanceof Weapon){
					Weapon weapon = (Weapon) card;
					
					if(weapon.equals(w)){
						
						
					}
					
					
					
					
				}else if(card instanceof Room){
					
					
					
				}else{
					
					
					
				}
				
				
			
			}
		}
		
		
		
	}
	
	public void accuse(Character c, Weapon w, Room r, Player player){
		
	}
	
	
	
	
	
	/**
	 * Indicates an attempt to make an invalid move.
	 *
	 */
	public static class InvalidMove extends Exception {
		public InvalidMove(String msg) {
			super(msg);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

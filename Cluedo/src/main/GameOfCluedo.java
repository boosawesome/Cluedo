package main;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import game.*;
import items.Card;
import items.Character.CharacterToken;
import items.Character;
import items.Envelope;
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
	
	List<Card> cards;

	List<Character> characters;
	List<Weapon> weapons;
	List<Room> rooms;
	
	public GameOfCluedo(){
		board = new Board();
		
		
		cards = new ArrayList<Card>();
		characters = new ArrayList<Character>();
		weapons = new ArrayList<Weapon>();
		rooms = new ArrayList<Room>();
		
		characters.add(new Character(CharacterToken.MISS_SCARLETT));
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
		
		Collections.shuffle(characters);
		Collections.shuffle(weapons);
		Collections.shuffle(rooms);
		
		Character c = (Character)getRandomCard(characters);
		Weapon w = (Weapon) getRandomCard(weapons);
		Room r = (Room) getRandomCard(rooms);
		
		characters.remove(c);
		weapons.remove(w);
		rooms.remove(r);
		
		solution = new Envelope(c,w,r);
		
		cards.addAll(rooms);
		cards.addAll(weapons);
		cards.addAll(characters);
		
		Collections.shuffle(cards);
		
		
		
		
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
		c.setRoom(r);
		
		
		for(Player p : players){
			if(p.hasCharacter(c.getName())) p.setRoom(r);
			
			for(Card card : p.getHand()){
				if(card instanceof Weapon){
					Weapon weapon = (Weapon) card;
					
					if(weapon.equals(w) && weapon.getName().equals(w.getName())){
						// do something
						
					}
					
					
				}else if(card instanceof Room){
					Room room = (Room) card;
					if(r.equals(room) && r.getName().equals(room.getName())){
						// do something
					}
					
					
				}else if(card instanceof Character){
					Character character = (Character) card;
					if(character.equals(c) && character.getName().equals(c.getName())){
						// do something
					}
					
				}
				
				
			
			}
		}
		
		
		
	}
	
	public void accuse(Character c, Weapon w, Room r, Player player){
		
	}
	
	public Character getCharacter(String s){
		for(Character c : characters){
			if(c.getName().equals(s)){
				return c;
			}
		}
		return null;
	}
	
	public Weapon getWeapon(String s){
		for(Weapon w : weapons){
			if(w.getName().equals(s)){
				return w;
			}
		}
		return null;
	}
	
	public Room getRoom(String s){
		for(Room r : rooms){
			if(r.getName().equals(s)){
				return r;
			}
		}
		return null;
	}
	
	
	public Card getRandomCard(List<? extends Card> list){
		int size = list.size();
		int item = new Random().nextInt(size); // In real life, the Random object should be rather more shared than this
		int i = 0;
		for(Card c : list)
		{
		    if (i == item){
		    	list.remove(c);
		    	return c;
		    }
		    i = i + 1;
		}
		return null;
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
	
	
	
	
	
	
	public static void main(String[] args){
		GameOfCluedo game = new GameOfCluedo();
		
		
	}
	
	
	
	
	
	
	
	
	
	
}

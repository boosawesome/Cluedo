package main;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

import game.*;
import items.Card;
import items.Character.CharacterToken;
import items.Character;
import items.Envelope;
import items.Location;
import items.Room;
import items.Room.RoomToken;
import items.Weapon;
import items.Weapon.WeaponToken;
import items.WeaponObject;
import moves.Accusation;
import moves.Suggestion;

public class GameOfCluedo {

	public enum Direction{
		NORTH,SOUTH,EAST,WEST
	}

	private Board board;
	private Envelope solution;
	public boolean valid = false;

	List<Card> cards;

	List<Character> characters;
	List<Weapon> weapons;
	List<Room> rooms;

	List<Location> locations;
	List<WeaponObject> objects;
	
	Player refuter = null;

	public GameOfCluedo(){
		board = new Board();
		locations = new ArrayList<Location>();
		objects = new ArrayList<WeaponObject>();

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
		rooms.add(new Room(RoomToken.CONSERVATORY, RoomToken.LOUNGE));
		rooms.add(new Room(RoomToken.DINING_ROOM));
		rooms.add(new Room(RoomToken.HALL));
		rooms.add(new Room(RoomToken.KITCHEN, RoomToken.STUDY));
		rooms.add(new Room(RoomToken.LIBRARY));
		rooms.add(new Room(RoomToken.LOUNGE, RoomToken.CONSERVATORY));
		rooms.add(new Room(RoomToken.STUDY, RoomToken.KITCHEN));

		for(Room rm : rooms){
			locations.add(new Location(rm));
		}

		for(Weapon wp : weapons){
			objects.add(new WeaponObject(wp));
		}

		Collections.shuffle(locations);
		Collections.shuffle(objects);

		for(int i = 0; i < objects.size(); i++){
			locations.get(i).setWeaponObject(objects.get(i));
			objects.get(i).setRoom(locations.get(i).room);
		}

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

	public void movePlayer(int diceRoll, Direction d, Player p, ArrayList<Player> players){
		int x = (int) p.getLocation().getX();
		int y = (int) p.getLocation().getY();

		while(diceRoll != 0){
			if(d.equals(Direction.NORTH)){
				y --;
			}else if(d.equals(Direction.SOUTH)){
				y ++;
			}else if(d.equals(Direction.WEST)){
				x --;
			}else{
				x ++;
			}
			diceRoll--;
			if(!checkValidMove(x,y, p, players)) return;
		}

		if(checkValidMove(x,y,p, players)){
			p.setLocation(new Point(x,y));
			valid = true;
		}



	}

	public boolean isAtDoor(Player p){
		for(Map.Entry<Point, String> entry : board.entrances.entrySet()){
			if(entry.getKey().getX() == p.getLocation().getX() && entry.getKey().getY() == p.getLocation().getY()){
				return true;
			}
		}

		return false;
	}

	public Point getDoor(Player p){
		for(Map.Entry<Point, String> entry : board.entrances.entrySet()){
			if(entry.getKey().getX() == p.getLocation().getX() && entry.getKey().getY() == p.getLocation().getY()){
				return entry.getKey();
			}
		}

		return null;
	}


	public void enterRoom(Player p){
		for(Map.Entry<Point, String> entry : board.entrances.entrySet()){
			if(entry.getKey().getX() == p.getLocation().getX() && entry.getKey().getY() == p.getLocation().getY()){
				Room r = board.getRoom(entry.getValue());
				p.setRoom(r);

				for(Location l : locations){
					if(l.room.equals(p.getRoom())){
						l.addPlayer(p);
						return;
					}
				}
			}
		}

		System.out.println("Cannot enter a room, Player is not at the door\n");
		System.out.println("*************************************************");

	}

	public void exitRoom(Room r, Player p){
		if(p.getRoom() == null || r == null){
			return;
		}

		if(p.getRoom().equals(r)){

			for(Map.Entry<Point, String> entry : board.entrances.entrySet()){

				if(r.getName().equals(entry.getValue())){
					for(Location l : locations){
						if(l.room.equals(r)){
							l.removePlayer(p);
							p.setLocation(entry.getKey());
							return;
						}
					}
				}
			}
		}

	}


	private boolean checkValidMove(int x, int y, Player player, ArrayList<Player> players) {
		if(x < 0 || x > 24 || y < 0 || y > 24){
			System.out.println("Out of Bounds!");
			return false;
		}

		if(player.getLocation() == null)return false; 

		for(Player p : players){
			if(p == player) continue;
			if(p.getLocation() == null) continue;
			if(board.getMap()[x][y].equals("x")&& p.getLocation().getX() == x && p.getLocation().getY() == y){
				System.out.println("Error! Cannot move into that space, Occupied by another Player");
				System.out.println("*************************************************\n\n");
				return false;
			}
		}
		if(board.getMap()[x][y].equals("x") || board.getMap()[x][y].equals("s") ) return true;
		System.out.println("Cannot move into a wall\n\n");
		System.out.println("*************************************************\n\n");

		return false;

	}


	public void useStairWell(Room room, Player p){
		if(p.getRoom().equals(room) && room.hasStairWell()){
			p.setRoom(null);
			Room opposite = board.getRoom(room.getOpposite());
			getLocation(room).removePlayer(p);
			getLocation(opposite).addPlayer(p);
			p.setRoom(opposite);
			System.out.println(p.getName()+ " used the Stairwell to get from "+ room.getName() +" to "+ opposite.getName()+"\n\n\n\n\n");
		}
	}

	public WeaponObject getObject(Weapon weapon){
		for(WeaponObject ob : objects){
			if(ob.getWeapon().equals(weapon)){
				return ob;
			}
		}
		return null;
	}

	public Location getLocation(Room r){
		for(Location l : locations){
			if(l.room.equals(r) || l.room == r){
				return l;
			}
		}
		return null;
	}

	public Card refute(Character c, Weapon w, Room r, Player player, ArrayList<Player> players){

		for(Player p : players){
			if(p == player)continue;
			if(p.hasCharacter(c.getName())){ 
				p.setRoom(r);
				getLocation(r).addPlayer(p);
			}
			
			Collections.shuffle(p.getHand());

			for(Card card : p.getHand()){
				if(card instanceof Weapon){
					Weapon weapon = (Weapon) card;

					if(weapon.equals(w) && weapon.getName().equals(w.getName())){
						refuter = p;
						return weapon;

					}


				}else if(card instanceof Room){
					Room room = (Room) card;
					if(r.equals(room) && r.getName().equals(room.getName())){
						refuter = p;
						return room;
					}


				}else if(card instanceof Character){
					Character character = (Character) card;
					if(character.equals(c) && character.getName().equals(c.getName())){
						refuter = p;
						return character;
					}

				}

			}

		}

		return null;
	}

	public void suggest(Suggestion suggestion, Player player, ArrayList<Player> players){

		Character c = suggestion.getCharacter();
		Weapon w = suggestion.getWeapon();
		Room r = suggestion.getRoom();

		if(player.getRoom() == null && player.getLocation() != null){
			System.out.println("ERROR! Cannot make a suggestion if player is not in a Room!");
		}
		if(!player.getRoom().equals(r) && !getLocation(r).hasPlayer(player)){
			System.out.println("ERROR! Cannot make a suggestion of "+r.getName() + " When "+player.getName()+" is not in"+r.getName());
		}


		Location loc = getLocation(r);
		WeaponObject ob = getObject(w);
		loc.setWeaponObject(ob);
		ob.setRoom(loc.room);
		
		Card result = refute(c,w,r, player, players);
		
		if(refuter != null && result != null){
			
			System.out.println(refuter.getName()+" has refuted your Suggestion");
			System.out.println("************************************\n\n");
			System.out.println(refuter.getName()+" has the "+result.getName()+" card");
			System.out.println("************************************\n\n");
			refuter = null;
		}else if(result == null){
			System.out.println("************************************");
			for(Player play : players){
				System.out.println(play.getName()+" has not been able to refute your suggestion");
			}
			System.out.println("************************************\n\n");
		}
		



	}

	public boolean accuse(Accusation accusation, Player player){
		Character c = accusation.getCharacter();
		Weapon w = accusation.getWeapon();
		Room r = accusation.getRoom();
		
		Character cSolution = this.solution.getCharacter();
		Weapon wSolution = this.solution.getWeapon();
		Room rSolution = this.solution.getRoom();
		
		System.out.println("\n\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(player.getName()+ " accused "+c.getName()+" of the crime in the "+ r.getName()+" room with a"+w.getName());
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n\n");
		if(c.equals(cSolution) && w.equals(wSolution)&&r.equals(rSolution)){
			return true;
		}
		return false;
		
		
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








	/*public static void main(String[] args){
		GameOfCluedo game = new GameOfCluedo();



		for(Location loc : game.locations){

			WeaponObject wp = loc.getWeaponObject();
			String s;
			if(wp == null) s = "";
			else s = loc.getWeaponObject().getName();
			System.out.println("Room: "+ loc.room.getName() +", Weapon: "+ s);
		}

	}*/










}

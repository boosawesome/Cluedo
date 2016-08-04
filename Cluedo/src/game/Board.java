package game;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import items.Room;
import items.Room.RoomToken;

public class Board {
	private List<Room> rooms;
	private Map<Point, String> entrances;
	String[][] map;
	List<Point> startingPositions;

	public Board() {
		rooms = new ArrayList<Room>();
		map = new String[25][25];
		entrances = new HashMap<Point, String>();
		
		
		
		String input = 
							  "/ / / / / / / / / s / / / / / s / / / / / / / / / \n"
							+ "/ / / / / / / x x x / / / / / x x x / / / / / / / \n"
							+ "/ / / / / / x x / / / / / / / / / x x / / / / / / \n"
							+ "/ / / / / / x x / / / / / / / / / x x / / / / / / \n"
							+ "/ / / / / / x x / / / / / / / / / x x / / / / / / \n"
							+ "/ / / / / / x x / / / / / / / / / x x x / / / / / \n"
							+ "/ / / / / / x x / / / / / / / / / x x x x x x x s \n"
							+ "x x x x x x x x / / / / / / / / / x x x x x x x / \n"
							+ "/ x x x x x x x x x x x x x x x x x x / / / / / / \n"
							+ "/ / / / x x x x x x x x x x x x x x / / / / / / / \n"
							+ "/ / / / / / / / x x / / / / / / x x x / / / / / / \n"
							+ "/ / / / / / / / x x / / / / / / x x x / / / / / / \n"
							+ "/ / / / / / / / x x / / / / / / x x x / / / / / / \n"
							+ "/ / / / / / / / x x / / / / / / x x x x x x x x / \n"
							+ "/ / / / / / / / x x / / / / / / x x x / / / / / x \n"
							+ "/ / / / / / / / x x / / / / / / x x / / / / / / / \n"
							+ "/ x x x x x x x x x / / / / / / x x / / / / / / / \n"
							+ "s x x x x x x x x x x x x x x x x x / / / / / / / \n"
							+ "/ x x x x x x x x / / / / / / / x x x / / / / / / \n"
							+ "/ / / / / / / x x / / / / / / / x x x x x x x x s \n"
							+ "/ / / / / / / x x / / / / / / / x x x x x x x x / \n"
							+ "/ / / / / / / x x / / / / / / / x x / / / / / / / \n"
							+ "/ / / / / / / x x / / / / / / / x x / / / / / / / \n"
							+ "/ / / / / / / x x / / / / / / / x x / / / / / / / \n"
							+ "/ / / / / / / s / / / / / / / / / x / / / / / / / \n";

		Scanner scan = new Scanner(input);
		
		int x = 0;
		int y = 0;
		
		while(scan.hasNext()){
			
			if(x == 25){
				x = 0;
				y++;
				if(y == 25) break;
			}
			if(scan.hasNext("\n")){
				scan.nextLine();
			}
			
			map[x][y] = scan.next();
			x++;
			
			
			
		}
		
		startingPositions = new ArrayList<Point>();
		
		startingPositions.add(new Point(7, 24));
		startingPositions.add(new Point(0, 17));
		startingPositions.add(new Point(9,0));
		startingPositions.add(new Point(15,0));
		startingPositions.add(new Point(24,6));
		startingPositions.add(new Point(24,19));
		
		
		rooms.add(new Room(RoomToken.DINING_ROOM));
		rooms.add(new Room(RoomToken.HALL));
		rooms.add(new Room(RoomToken.BALLROOM));
		rooms.add(new Room(RoomToken.BILLARD_ROOM));
		rooms.add(new Room(RoomToken.LIBRARY));
		rooms.add(new Room(RoomToken.KITCHEN, RoomToken.STUDY));
		rooms.add(new Room(RoomToken.STUDY, RoomToken.KITCHEN));
		rooms.add(new Room(RoomToken.CONSERVATORY, RoomToken.LOUNGE));
		rooms.add(new Room(RoomToken.LOUNGE, RoomToken.CONSERVATORY));

		entrances.put(new Point(4, 7), "KITCHEN");
		entrances.put(new Point(6, 18), "LOUNGE");
		entrances.put(new Point(19, 5), "CONSERVATORY");
		entrances.put(new Point(18, 20), "STUDY");
		entrances.put(new Point(8, 12), "DINING_ROOM");
		entrances.put(new Point(6, 16), "DINING_ROOM");
		entrances.put(new Point(18, 8), "BILLIARD_ROOM");
		entrances.put(new Point(23, 12), "BILLIARD_ROOM");
		entrances.put(new Point(21, 12), "LIBRARY");
		entrances.put(new Point(17, 15), "LIBRARY");
		entrances.put(new Point(7, 5), "BALLROOM");
		entrances.put(new Point(9, 8), "BALLROOM");
		entrances.put(new Point(15, 8), "BALLROOM");
		entrances.put(new Point(17, 5), "BALLROOM");
		entrances.put(new Point(11, 17), "HALL");
		entrances.put(new Point(12, 17), "HALL");
		entrances.put(new Point(13, 17), "HALL");
		entrances.put(new Point(16, 20), "HALL");
	}
	
	public Room getRoom(String s){
		for(int i = 0; i < rooms.size(); i++){
			if(rooms.get(i).getName().equals(s)){
				return rooms.get(i);
			}
		}
		return null;
	}

	public String getRoom(Point c) {
		if (entrances.containsKey(c)) {
			return entrances.get(c);
		} else
			return null;
	}
	
	public String[][] getMap(){
		return map;
	}
	
	public List<Point> getStartingPositions(){
		return startingPositions;
	}
	
	public static void main(String[] args){
		Board b = new Board();
		
		for(Point p : b.startingPositions){
			
			System.out.println(b.map[(int)p.getX()][(int)p.getY()]); //print out the positions of players and positions on board to see match
			
		}
		
	}
}
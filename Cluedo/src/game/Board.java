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
	private String[][] map;

	public Board() {
		rooms = new ArrayList<Room>();

		entrances = new HashMap<Point, String>();

		String input = 
				  "/ / / / / / / / / s / / / / / s / / / / / / / / /"
				+ "/ / / / / / / x x x / / / / / x x x / / / / / / /"
				+ "/ / / / / / x x / / / / / / / / / x x / / / / / /"
				+ "/ / / / / / x x / / / / / / / / / x x / / / / / /"
				+ "/ / / / / / x x / / / / / / / / / x x / / / / / /"
				+ "/ / / / / / x x / / / / / / / / / x x x / / / / /"
				+ "/ / / / / / x x / / / / / / / / / x x x x x x x s"
				+ "x x x x x x x x / / / / / / / / / x x x x x x x /"
				+ "/ x x x x x x x x x x x x x x x x x x / / / / / /"
				+ "/ / / / x x x x x x x x x x x x x x / / / / / / /"
				+ "/ / / / / / / / x x / / / / / / x x x / / / / / /"
				+ "/ / / / / / / / x x / / / / / / x x x / / / / / /"
				+ "/ / / / / / / / x x / / / / / / x x x / / / / / /"
				+ "/ / / / / / / / x x / / / / / / x x x x x x x x /"
				+ "/ / / / / / / / x x / / / / / / x x x / / / / / x"
				+ "/ / / / / / / / x x / / / / / / x x / / / / / / /"
				+ "/ x x x x x x x x x / / / / / / x x / / / / / / /"
				+ "s x x x x x x x x x x x x x x x x x / / / / / / /"
				+ "/ x x x x x x x x / / / / / / / x x x / / / / / /"
				+ "/ / / / / / / x x / / / / / / / x x x x x x x x s"
				+ "/ / / / / / / x x / / / / / / / x x x x x x x x /"
				+ "/ / / / / / / x x / / / / / / / x x / / / / / / /"
				+ "/ / / / / / / x x / / / / / / / x x / / / / / / /"
				+ "/ / / / / / / x x / / / / / / / x x / / / / / / /"
				+ "/ / / / / / / s / / / / / / / / / x / / / / / / /";

		Scanner scan = new Scanner(input);
		
		for(int y = 0; y < 25; y++){
			for(int x = 0; x < 25; x++){
				map[x][y] = scan.next();
			}
		}
		
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
}
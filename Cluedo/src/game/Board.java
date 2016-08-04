package game;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Board {
	private List<Room> rooms;
	private Map<Point, String> entrances;
	private String[][] map;

	public Board() {
		rooms = new ArrayList<Room>();

		entrances = new HashMap<Point, String>();

		String input = 
				  " / / / / / / / / / s / / / / / s / / / / / / / / /"
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
		
		
		
		rooms.add(new Room("Dining Room"));
		rooms.add(new Room("Hall"));
		rooms.add(new Room("Ballroom"));
		rooms.add(new Room("Billiard Room"));
		rooms.add(new Room("Library"));
		rooms.add(new Room("Kitchen", "Study"));
		rooms.add(new Room("Study", "Kitchen"));
		rooms.add(new Room("Conservatory", "Lounge"));
		rooms.add(new Room("Lounge", "Conservatory"));

		entrances.put(new Point(4, 7), "Kitchen");
		entrances.put(new Point(6, 18), "Lounge");
		entrances.put(new Point(19, 5), "Conservatory");
		entrances.put(new Point(18, 20), "Study");
		entrances.put(new Point(8, 12), "Dining Room");
		entrances.put(new Point(6, 16), "Dining Room");
		entrances.put(new Point(18, 8), "Billiard Room");
		entrances.put(new Point(23, 12), "Billiard Room");
		entrances.put(new Point(21, 12), "Library");
		entrances.put(new Point(17, 15), "Library");
		entrances.put(new Point(7, 5), "Ballroom");
		entrances.put(new Point(9, 8), "Ballroom");
		entrances.put(new Point(15, 8), "Ballroom");
		entrances.put(new Point(17, 5), "Ballroom");
		entrances.put(new Point(11, 17), "Hall");
		entrances.put(new Point(12, 17), "Hall");
		entrances.put(new Point(13, 17), "Hall");
		entrances.put(new Point(16, 20), "Hall");
	}

	public String getRoom(Point c) {
		if (entrances.containsKey(c)) {
			return entrances.get(c);
		} else
			return null;
	}
}

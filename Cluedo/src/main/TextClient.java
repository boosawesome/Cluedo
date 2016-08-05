package main;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.Point;

import game.*;
import items.*;
import items.Character;
import items.Character.CharacterToken;
import main.GameOfCluedo.Direction;
import moves.Accusation;
import moves.Suggestion;

/**
 * This class contains the code for interfacing with the Cluedo game. It also
 * contains much of the game logic for controlling how the user can interact.
 *
 * @author Andre L. Westerlund
 */
public class TextClient {

	static boolean state = false;

	/**
	 * Get string from System.in
	 */
	private static String inputString(String msg) {
		System.out.print(msg + " ");
		while (1 == 1) {
			BufferedReader input = new BufferedReader(new InputStreamReader(
					System.in));
			try {
				return input.readLine();
			} catch (IOException e) {
				System.out.println("I/O Error ... please try again!");
			}
		}
	}

	/**
	 * Get integer from System.in
	 */
	private static int inputNumber(String msg) {
		System.out.print(msg + " ");
		while (1 == 1) {
			BufferedReader input = new BufferedReader(new InputStreamReader(
					System.in));
			try {
				String v = input.readLine();
				return Integer.parseInt(v);
			} catch (IOException e) {
				System.out.println("Please enter a number!");
			}
		}
	}

	/**
	 * Input player details from System.in
	 */
	private static ArrayList<Player> inputPlayers(int nplayers, GameOfCluedo game) {
		// set up the tokens
		ArrayList<CharacterToken> tokens = new ArrayList<CharacterToken>();
		for(CharacterToken t : CharacterToken.values()) {
			tokens.add(t);
		}

		// now, input data
		ArrayList<Player> players = new ArrayList<Player>();
		int counter = 0;
		for (int i = 0; i < nplayers; i++) {

			String name = inputString("Player #" + (i + 1) + " name?");
			CharacterToken token = tokens.get(counter);
			Point loc = game.getBoard().getStartingPositions().get(i);
			Player play = new Player(name, token, loc);
			System.out.println("Player "+(i + 1)+" is "+ name+", you will be taking the role of "+token.name());
			players.add(play);
			tokens.remove(token);

		}
		return players;
	}

	private static void movePlayer(Player player, GameOfCluedo game, Direction dir, int spaces, ArrayList<Player> players){
		game.movePlayer(spaces, dir, player, players);


	}

	private static void displayInfo(Player p){
		System.out.println("**********  Player Info  **********");
		System.out.println("Token Name: "+ p.getCharacter().name());
		if(p.getRoom() == null && p.getLocation() != null){
			System.out.println("Location of Player : ("+p.getLocation().getX()+", "+ p.getLocation().getY()+")");
		}else{
			System.out.println("Location of Player : "+ p.getRoom().getName());
		}
	}

	private static void roomInfo(Room r, GameOfCluedo game){

		Location loc = game.getLocation(r);
		System.out.println("***********  ROOM INFO  ****************");
		System.out.println("Room Name: "+ r.getName());
		if(r.hasStairWell()){
			System.out.println("Stairwell leads to :" + r.getOpposite());
		}

		if(loc.getWeaponObject() != null){
			System.out.println("Weapon: "+ loc.getWeaponObject().getWeapon().getName());
		}
		else {
			System.out.println("No Weapon in "+r.getName());
		}

		if(loc.getPlayers() == null || loc.getPlayers().size() == 0){
			System.out.println("There are no players inside "+ r.getName());
		}else{
			System.out.println("Players inside "+r.getName());
			for(Player p : loc.getPlayers()){


				System.out.println(p.getName()+" : "+p.getCharacter().name());


			}
		}

		System.out.println("****************************************\n\n");


	}

	private static void displayRoomInfo(GameOfCluedo board){
		ArrayList<Room> rooms = new ArrayList<Room>();

		for(Location loc : board.locations){
			rooms.add(loc.room);
		}


		System.out.println("Rooms in Cluedo: \n");
		for(Room roomName : rooms){
			System.out.println(roomName.getName());
		}
		String rm = inputString("\n\nEnter a room name: ");
		rm = rm.toUpperCase();
		while(board.getBoard().getRoom(rm) == null){
			System.out.println("Invalid Room Name\n\n");
			rm = inputString("Enter a room name: ");
			rm = rm.toUpperCase();
			if(rm.equalsIgnoreCase("exit")) return;
		}

		roomInfo(board.getBoard().getRoom(rm),board);
		System.out.println("\n\n");

	}


	/**
	 * Provide player with set of things they can do. Lets them continue doing
	 * things for as long as they want.
	 */
	private static void playerOptions(Player player, ArrayList<Player> players,GameOfCluedo board) {

		System.out.println("\n\n\n\n\n\n\n\n\n\n***********************************");
		System.out.println("Options for " + player.getName() + ":");
		System.out.println("Suggestion");
		System.out.println("Accusation");
		System.out.println("Take Stairwell");
		System.out.println("Display Cards in Hand");
		System.out.println("Display Player Info");
		System.out.println("Display Information about a Room");
		System.out.println("End Turn");

		while (1 == 1) {
			System.out.println("***********************************");
			String cmd = inputString("[suggest/accuse/stairs/hand/pinfo/rinfo/end]\n\n");
			if (cmd.equals("end")) {
				return;
			}else if(cmd.equals("suggest")){

				if(player.getRoom() == null && player.getLocation() != null){
					System.out.println("ERROR! Cannot make a suggestion if player is not in a Room!");
					continue;
				}

				System.out.println("************ SUGGESTION  ************");
				String charac = inputString("Who was the murderer? (e.g. MISS_SCARLETT)");
				String weapon = inputString("With what weapon? (e.g. LEAD_PIPE, REVOLVER)");
				String room = inputString("In What room? (e.g. STUDY, DINING_ROOM)");


				Character c = board.getBoard().getCharacter(charac);
				Weapon w = board.getBoard().getWeapon(weapon);
				Room r = board.getBoard().getRoom(room);
				
				if(c == null || w == null || r == null){
					System.out.println("Invalid Argument! That Card does not exist!\n\n\n");
					continue;
				}
				

				if(!player.getRoom().equals(r) && !board.getLocation(r).hasPlayer(player)){
					System.out.println("ERROR! Cannot make a suggestion of "+r.getName() + " When "+player.getName()+" is not in"+r.getName());
					continue;
				}

				Suggestion suggest = new Suggestion(c,w,r);

				makeSuggestion(suggest, player, players, board);
				cmd.equals("end");


			}else if(cmd.equals("accuse")){
				System.out.println("Accusation will end everything once and for all!");
				System.out.println("Game ends for you either Wrong or Right");
				String answer = inputString("Are you sure you want to make an Accusation?[y/n]");

				if(answer.equalsIgnoreCase("n")|| answer.equalsIgnoreCase("no")){

				}else if(answer.equalsIgnoreCase("y")|| answer.equalsIgnoreCase("yes")){
					System.out.println("\n\n************ ACCUSATION  ************\n");
					String charac = inputString("Who was the murderer? (e.g. MISS_SCARLETT)");
					String weapon = inputString("With what weapon? (e.g. LEAD_PIPE, REVOLVER)");
					String room = inputString("In What room? (e.g. STUDY, DINING_ROOM)");

					Character c = board.getBoard().getCharacter(charac);
					Weapon w = board.getBoard().getWeapon(weapon);
					Room r = board.getBoard().getRoom(room);

					if(c == null || w == null || r == null){
						System.out.println("Error! Invalid Argument, That card does not exist");
					}

					Accusation accuse = new Accusation(c,w,r);

					boolean result = makeAccusation(accuse, player, board);

					if(result){
						state = true;
						System.out.println("RESULT: ");
						System.out.println("Murderer: "+board.getSolution().getCharacter().getName());
						System.out.println("Weapon: "+board.getSolution().getWeapon().getName());
						System.out.println("Scene: "+board.getSolution().getRoom().getName());

						System.out.println("\n\n**************     "+player.getName()+" IS THE WINNER!!!   ***************");
						System.out.println("GAME OVER!");

					}else{
						System.out.println("RESULT: ");
						System.out.println("\n**************     "+player.getName()+" IS ELIMINATED!!!   ***************");
						player.lose();
						return;
					}



				}


			}else if(cmd.equals("pinfo")){
				displayInfo(player);
			}else if(cmd.equals("rinfo")){
				displayRoomInfo(board);
			}else if(cmd.equals("clues")){

			}else if(cmd.equals("hand")){
				getHand(player);
			}else if(cmd.equals("stairs")){
				System.out.println("*********************************************\n\n");
				if(player.getRoom() != null)
					useStairWell(player.getRoom(),player, board);
				else if(player.getRoom() == null){
					System.out.println("Player "+player.getName()+" is not in a Room");
				}else{
					System.out.println("The "+player.getRoom()+" does not have a Stairwell");
					continue;
				}
			}
			else {
				System.out.println("Invalid command.  Enter 'end' to finish turn.");
			}
		}


	}

	private static void makeSuggestion(Suggestion suggest, Player player, ArrayList<Player> players, GameOfCluedo board) {
		board.suggest(suggest, player, players);

	}

	private static boolean makeAccusation(Accusation accuse, Player player, GameOfCluedo board) {
		return board.accuse(accuse,player);

	}

	private static GameOfCluedo.Direction getDirection(String input){

		if(input.equalsIgnoreCase("North") || input.equalsIgnoreCase("N")){
			return Direction.NORTH;
		}else if(input.equalsIgnoreCase("West") || input.equalsIgnoreCase("W")){
			return Direction.WEST;
		}else if(input.equalsIgnoreCase("South") || input.equalsIgnoreCase("S")){
			return Direction.SOUTH;
		}else if(input.equalsIgnoreCase("East") || input.equalsIgnoreCase("E")){
			return Direction.EAST;
		}else{
			return null;
		}

	}

	private static void getHand(Player p){
		System.out.println(p.getName()+"'s Cards in Hand");
		System.out.println("******************************\n");
		for(Card c : p.getHand()){
			System.out.println(c.getName());
		}
		System.out.println("******************************\n");
	}

	private static void useStairWell(Room r, Player p, GameOfCluedo game){

		game.useStairWell(r, p);


	}

	private static void exitRoom(Room r, Player p, GameOfCluedo game){
		game.exitRoom(r, p);
	}


	public static void main(String[] args){
		GameOfCluedo game = new GameOfCluedo();

		System.out.println("*** WELCOME TO THE GAME OF CLUEDO ***");
		int nplayers = inputNumber("Enter the Number of Players?");

		while(nplayers < 3 || nplayers > 6){
			System.out.println("Error! Can only Play with 3 to 6 players!");
			System.out.println("********************************************\n\n");
			nplayers = inputNumber("Enter the Number of Players?");
		}

		ArrayList<Player> players = inputPlayers(nplayers, game);

		for(Player p : players){
			System.out.println(p.toString());
		}

		Collections.shuffle(game.cards);


		int count = 0;

		for(int i = 0; i < game.cards.size(); i++){

			Card c = game.cards.get(i);
			players.get(count++).addCard(c);
			if(count == nplayers){
				count = 0;
			}
		}



		int turn = 1;
		Dice dice = new Dice();
		while(1 == 1){
			System.out.println("\n********************");
			System.out.println("***** TURN " + turn + " *******");
			System.out.println("********************\n");

			boolean firstTime = true;
			for (Player player : players) {

				if(!player.getActive()){
					continue;
				}

				if (!firstTime) {
					System.out.println("\n********************\n");
				}
				firstTime = false;
				int roll = dice.roll();
				System.out.println(player.getName() + " rolls a " + roll + ".");

				if(player.getRoom() != null){
					String q1 = inputString("Would you like to leave "+player.getRoom().getName());
					if(q1.equalsIgnoreCase("n") || q1.equalsIgnoreCase("no")){
						roll = 0;
					}else{
						exitRoom(player.getRoom(), player, game);
					}
				}



				while(roll != 0){
					System.out.println("Moves left: "+roll);
					String dir = inputString("Enter Direction: (N,S,E,W)");
					Direction direction = getDirection(dir);
					while(direction == null){
						System.out.println("Error! That is not a valid direction!");
						dir = inputString("Enter Direction: (N,S,E,W)");
						direction = getDirection(dir);
					}


					int spaces = inputNumber("How many spaces would you like to move?\n");

					while(spaces < 1 || spaces > roll){
						System.out.println("Error! You can only move within your Dice Roll Range");
						spaces = inputNumber("How many spaces would you like to move?\n");
					}

					movePlayer(player, game, direction, spaces, players);
					if(game.valid == false) continue;
					game.valid = false;
					roll-=spaces;

					if(game.isAtDoor(player)){
						Point point = game.getDoor(player);
						String rmName = game.getBoard().getRoom(point);
						Room room = game.getBoard().getRoom(rmName);
						String rm = inputString("Would you like to enter " + room.getName()+ "? [y/n]");

						if(rm.equalsIgnoreCase("Y") || rm.equalsIgnoreCase("yes")){
							roll = 0;
							game.enterRoom(player);

						}


					}

				}

				playerOptions(player, players,game);
				if(state == true) return; 
			}
			turn++;


		}

	}












}

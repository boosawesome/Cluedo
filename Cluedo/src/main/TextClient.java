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

/**
 * This class contains the code for interfacing with the Cluedo game. It also
 * contains much of the game logic for controlling how the user can interact.
 *
 * @author Andre L. Westerlund
 */
public class TextClient {

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
		if(p.getRoom() == null){
			System.out.println("Location of Player : ("+p.getLocation().getX()+", "+ p.getLocation().getY()+")");
		}else{
			System.out.println("Location of Player : "+ p.getRoom());
		}
	}
	

	
	/**
	 * Provide player with set of things they can do. Lets them continue doing
	 * things for as long as they want.
	 */
	private static void playerOptions(Player player, GameOfCluedo board) {
		System.out.println("Options for " + player.getName() + ":");
		System.out.println("Token Name: "+ player.getCharacter().name());
		System.out.println("Display Info");
		System.out.println("Suggestion");
		System.out.println("Accusation");
		System.out.println("End Turn");
		
		while (1 == 1) {
			String cmd = inputString("[info/end]");
			if (cmd.equals("end")) {
				return;
			}else if(cmd.equals("info")){
				
			}
			 else {
				System.out
						.println("Invalid command.  Enter 'end' to finish turn.");
			}
		}
		
		
		
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
		
		for(int i = 0; i < game.cards.size(); i++){
			
			Card c = game.cards.get(i);
			players.get(i%nplayers).addCard(c);
			game.cards.remove(i);
		}
		
		
		
		int turn = 1;
		Dice dice = new Dice();
		while(1 == 1){
			System.out.println("\n********************");
			System.out.println("***** TURN " + turn + " *******");
			System.out.println("********************\n");
			
			boolean firstTime = true;
			for (Player player : players) {
				if (!firstTime) {
					System.out.println("\n********************\n");
				}
				firstTime = false;
				int roll = dice.roll();
				System.out.println(player.getName() + " rolls a " + roll + ".");
				
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
						Room room = game.getRoom(rmName);
						String rm = inputString("Would you like to enter " + room.getName()+ "? [y/n]");
						
						if(rm.equalsIgnoreCase("Y") || rm.equalsIgnoreCase("yes")){
							roll = 0;
							player.setRoom(room);
							Location loc = GameOfCluedo.getLocation(room);
							loc.addPlayer(player);
							
						}
						
						
					}
				
				}
			}
			turn++;
			
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
}

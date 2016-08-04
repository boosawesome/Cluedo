package main;


import java.io.*;
import java.util.ArrayList;
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
	
	private static void movePlayer(Player player, GameOfCluedo game, Direction dir, int spaces){
		game.movePlayer(spaces, dir, player);
		
		
	}
	

	
	/**
	 * Provide player with set of things they can do. Lets them continue doing
	 * things for as long as they want.
	 */
	private static void playerOptions(Player player, GameOfCluedo board) {
		
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
					String dir = inputString("Enter Direction: (N,W,S,E)");
					Direction direction = getDirection(dir);
					while(direction == null){
						System.out.println("Error! That is not a valid direction!");
						dir = inputString("Enter Direction: (N,W,S,E)");
						direction = getDirection(dir);
					}
					
					
					int spaces = inputNumber("How many spaces would you like to move?\n");
					
					while(spaces < 1 || spaces > roll){
						System.out.println("Error! You can only move within your Dice Roll Range");
						spaces = inputNumber("How many spaces would you like to move?\n");
					}
					
					movePlayer(player, game, direction, spaces);
					roll-=spaces;
					
				
				}
			}
			turn++;
			
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
}

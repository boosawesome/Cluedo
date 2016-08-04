package main;


import java.io.*;
import java.util.ArrayList;

import game.Player;
import items.*;
import items.Character.CharacterToken;

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

		for (int i = 0; i != nplayers; ++i) {
			
			String name = inputString("Player #" + i + " name?");
			CharacterToken token = tokens.get(i);
			//players.add(new Player(name, game.getCharacter(token.name()),  );
			tokens.remove(i);
			
		}
		return players;
	}
	

	
	/**
	 * Provide player with set of things they can do. Lets them continue doing
	 * things for as long as they want.
	 */
	private static void playerOptions(Player player, GameOfCluedo board) {
		
	}
	
	
	public void main(String[] args){
		GameOfCluedo game = new GameOfCluedo();
		
		System.out.println("*** WELCOME TO THE GAME OF CLUEDO ***");
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}

package main;

import game.*;

public class GameOfCluedo {
	
	private Board board;
	
	
	public Board getBoard(){
		return board;
	}
	
	public void movePlayer(int diceRoll, Player p){
		
		
	}
	
	
	public void useStairWell(Room room){
		
		
	}
	
	public void suggest(){
		
		
	}
	
	public void accuse(){
		
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

package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

import main.GameOfCluedo;
import game.Player;

public class Main {
	
	
	
	public static int inputNumber(BoardFrame frame, String message){
		
		while(1 == 1){
		try{
		String players = JOptionPane.showInputDialog(frame, message);
		return Integer.parseInt(players);
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(frame, "Please enter a Number!!!", "", JOptionPane.WARNING_MESSAGE);
		}
		}
	}
	
	/**
	 * Get string from JDialog
	 */
	private static String inputString(BoardFrame frame, String msg) {
		while (1 == 1) {
				JOptionPane pane = new JOptionPane();
				JDialog dialog = pane.createDialog(null, "Input");
				dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
				dialog.setVisible(true);
				String s = pane.showInputDialog(msg);
				if(s.equals("")){
				pane.showMessageDialog(frame, "Please try again", "", JOptionPane.WARNING_MESSAGE);
				continue;
				}
				else return s; 
		}
	}
	
	
	
	public static ArrayList<Player> inputPlayers(BoardFrame frame, int num){
		
		ArrayList<Player> players = new ArrayList<Player>();
		RadioButton selection = new RadioButton();
		JOptionPane pane = new JOptionPane();
		pane.add(selection);

		Object[] options = {"OK"};
		
		for(int i = 1; i <= num; i++){
			
			String name = inputString(frame, "Enter the name of Player "+i+":");
			
			//select character token
			JOptionPane.showOptionDialog(frame, selection,"Select your Token", JOptionPane.ERROR_MESSAGE, 
					JOptionPane.OK_OPTION, null, options, options[0] );
			String s = selection.getSelectedButton();
			
			//when token is selected make sure it is unavailable, (update the dialog)
			JRadioButton button = selection.getRadioButton(s);
			button.setEnabled(false);
			int index = selection.buttons.indexOf(button);
			selection.buttons.get(index).setEnabled(false);
			selection.updatePicture();
			
			JOptionPane.showMessageDialog(frame, "Player "+i+": "+name+" has chosen "+s);
			
			
			
			
			
		}
		
		
		return null;
		
	}
	

	public static void main(String[] args){
		
		GameOfCluedo game = new GameOfCluedo();
		
		BoardFrame frame = new BoardFrame();

		JOptionPane.showMessageDialog(frame, "Welcome to the Game of Cluedo");
		
		int num = inputNumber(frame,"Input number of Players: " );
		while(num < 3 || num > 6 ){
			JOptionPane.showMessageDialog(frame, "Number of Players must be between 3 and 6", "",JOptionPane.WARNING_MESSAGE);
			num = inputNumber(frame,"Input number of Players: " );
		}
		
		ArrayList<Player> players = inputPlayers(frame, num);
		
		
		
		
		while(!game.state){
			
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
}

package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Component;
import javax.swing.Box;

public class BoardFrame extends JFrame {

	private JPanel bottomPanel;
	
	
	
	public BoardFrame(){
		super("Cluedo Board Game");
		this.setSize(500, 500);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu game = new JMenu("Game");
		menuBar.add(file);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		file.add(mntmSave);
		
		JMenuItem mntmLoad = new JMenuItem("Load");
		file.add(mntmLoad);
		menuBar.add(game);
		
		JMenuItem mntmStartNewGame = new JMenuItem("Start New Game");
		game.add(mntmStartNewGame); 
		
		getContentPane().add(menuBar, BorderLayout.PAGE_START);
		
	    
		bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.LIGHT_GRAY);
		bottomPanel.setPreferredSize(new Dimension(0, 150));
		JButton rollDice = new JButton();
		rollDice.setBackground(Color.LIGHT_GRAY);
		ImageIcon dice = new ImageIcon("src/images/dice.png");
		Image d = dice.getImage();
		Image newD = d.getScaledInstance(50, 50, 20);
		ImageIcon d2 = new ImageIcon(newD);
		
		
		rollDice.setIcon(d2);
		rollDice.setMargin(new Insets(0,0,0,0));
				
		JButton endTurn = new JButton("End Turn");
		bottomPanel.add(rollDice);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		bottomPanel.add(rigidArea);
		bottomPanel.add(endTurn);
		getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		
		this.setVisible(true);
	} 
	
	public static void main(String[] args){
		new BoardFrame();
	}
	
	
	
	
	
	
	
	
	
	
	
}

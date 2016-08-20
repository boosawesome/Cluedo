package ui;

import java.awt.BorderLayout;
import java.awt.Canvas;
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

import main.GameOfCluedo;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Component;
import javax.swing.Box;

public class BoardFrame extends JFrame {

	private JPanel bottomPanel;
	private Canvas boardCanvas;
	private GameOfCluedo game;
	
	
	
	public BoardFrame(){
		super("Cluedo Board Game");
		
		game = new GameOfCluedo();
		
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
		
		bottomPanel = new BottomPanel();
	    
		
		getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		bottomPanel.add(rigidArea);
		
		boardCanvas = new BoardCanvas();
		
		add(boardCanvas, BorderLayout.CENTER);
		
		this.setVisible(true);
	} 
	
	public static void main(String[] args){
		new BoardFrame();
	}
	
	
	
	
	
	
	
	
	
	
	
}

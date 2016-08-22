package ui;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import main.GameOfCluedo;
import moves.Accusation;
import moves.Suggestion;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.Border;

import game.Board;
import game.Player;
import items.Card;

import java.awt.Component;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;

public class BoardFrame extends JFrame implements ActionListener, MouseListener {

	private JPanel bottomPanel;
	private JPanel rightPanel;
	private BoardCanvas boardCanvas;
	private GameOfCluedo game;
	
	public ArrayList<JButton> buttons;

	private Board board;
	
	public BoardFrame() {
		super("Cluedo Board Game");

		game = new GameOfCluedo();
		board = game.getBoard();
		buttons  = new ArrayList<JButton>();
		this.setSize(1250, 1035);
		this.setMinimumSize(new Dimension(1250, 1035)); //855 without rightPanel
		setResizable(true);
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
		FlowLayout flow = new FlowLayout();
		flow.setHgap(150);
		bottomPanel.setLayout(flow);
		bottomPanel.setPreferredSize(new Dimension(855, 100));
		bottomPanel.setMinimumSize(new Dimension(855, 100));
		
		JLabel profile = new JLabel("<html>Player Info<br> <br>text to edit</html>");
		
		JButton suggest = new JButton("Suggest");
		suggest.setActionCommand("suggest");
		suggest.addActionListener(this);
		suggest.setPreferredSize(new Dimension(50,50));
		buttons.add(suggest);

		JButton accuse = new JButton("Accuse");
		accuse.setActionCommand("accuse");
		accuse.addActionListener(this);
		accuse.setPreferredSize(new Dimension(50,50));
		buttons.add(accuse);
		
		JButton rollDice = new JButton(new ImageIcon("src/images/dice.png"));
		rollDice.setBackground(Color.LIGHT_GRAY);
		ImageIcon dice = new ImageIcon("src/images/dice.png");
		Image d = dice.getImage();
		Image newD = d.getScaledInstance(45, 45, 20);
		ImageIcon d2 = new ImageIcon(newD);
		rollDice.setMargin(new Insets(0, 0, 0, 0));
		rollDice.setIcon(d2);
		buttons.add(rollDice);
		
		JButton endTurn = new JButton("End Turn");
		endTurn.setActionCommand("endTurn");
		endTurn.addActionListener(this);
		endTurn.setPreferredSize(new Dimension(100,30));
		buttons.add(endTurn);

		rollDice.setActionCommand("rollDice");
		rollDice.addActionListener(this);

		suggest.setPreferredSize(new Dimension(100,30));
		accuse.setPreferredSize(new Dimension(100,30));

		bottomPanel.add(suggest);
		bottomPanel.add(accuse);
		bottomPanel.add(rollDice);
		bottomPanel.add(endTurn);
		getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		
		
		rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(3,2));
		rightPanel.add(new JLabel(new ImageIcon("src/images/clue.jpg")));
		rightPanel.add(new JLabel(new ImageIcon("src/images/clue.jpg")));
		rightPanel.add(new JLabel(new ImageIcon("src/images/clue.jpg")));
		rightPanel.add(new JLabel(new ImageIcon("src/images/clue.jpg")));
		rightPanel.add(new JLabel(new ImageIcon("src/images/clue.jpg")));
		rightPanel.add(new JLabel(new ImageIcon("src/images/clue.jpg")));
		
		getContentPane().add(rightPanel, BorderLayout.EAST);
		
		boardCanvas = new BoardCanvas();
		add(boardCanvas, BorderLayout.CENTER);
		this.setVisible(true);
	}

	public void updateCards(Player player){
		
		ArrayList<Card> cards = player.getHand();
		
		Component[] comp = rightPanel.getComponents();
		
		for(int i = 0; i < comp.length; i++ ){
			if(cards.get(i) == null){
			((JLabel) comp[i]).setIcon((new ImageIcon("src/images/clue.jpg")));
			}else{
			((JLabel) comp[i]).setIcon((new ImageIcon("src/images/"+cards.get(i).getPicture()+".jpg")));
			}

			bottomPanel.repaint();
			
		}
		
		
	}
	
	
	public static void main(String[] args) {
		BoardFrame frame = new BoardFrame();
		Player p = new Player("andre", null, null );
		p.addCard(frame.getBoard().getCharacter("MISS_SCARLETT"));
		p.addCard(frame.getBoard().getWeapon("DAGGER"));
		p.addCard(frame.getBoard().getRoom("LOUNGE"));
		frame.updateCards(p);
	}
	
	public GameOfCluedo getGame() {
		return game;
	}

	public void setGame(GameOfCluedo game) {
		this.game = game;
	}
	
	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}


	public void actionPerformed(ActionEvent e) {
		String player;
		String weapon;
		String room;
		String cmd = e.getActionCommand();
		if (cmd.equals("accuse")) {

		}
		if (cmd.equals("suggest")){
		
		}

	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		x = x/35;
		y = y/35;
		
		if (boardCanvas.squares[x][y] != null){
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
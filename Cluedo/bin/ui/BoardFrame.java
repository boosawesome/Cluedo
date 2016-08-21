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
import java.awt.image.BufferedImage;
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

import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.Box;

public class BoardFrame extends JFrame implements ActionListener, KeyListener {

	private JPanel bottomPanel;
	private JPanel rightPanel;
	private BoardCanvas boardCanvas;
	private GameOfCluedo game;

	public BoardFrame() {
		super("Cluedo Board Game");

		game = new GameOfCluedo();

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
		bottomPanel.setLayout(new FlowLayout());
		bottomPanel.setPreferredSize(new Dimension(855, 100));
		bottomPanel.setMinimumSize(new Dimension(855, 100));
		
		JButton suggest = new JButton("Suggest");
		suggest.setActionCommand("suggest");
		suggest.addActionListener(this);

		JButton accuse = new JButton("Accuse");
		accuse.setActionCommand("accuse");
		accuse.addActionListener(this);

		JButton rollDice = new JButton("Roll Dice", new ImageIcon("src/images/dice.png"));
		rollDice.setBackground(Color.LIGHT_GRAY);
		ImageIcon dice = new ImageIcon("src/images/dice.png");
		Image d = dice.getImage();
		Image newD = d.getScaledInstance(45, 45, 20);
		ImageIcon d2 = new ImageIcon(newD);
		rollDice.setMargin(new Insets(0, 0, 0, 0));
		rollDice.setIcon(d2);

		rollDice.setActionCommand("rollDice");
		rollDice.addActionListener(this);

		suggest.setPreferredSize(new Dimension(100, 100));
		accuse.setPreferredSize(new Dimension(100, 100));

		bottomPanel.add(accuse, BorderLayout.CENTER);
		bottomPanel.add(suggest, BorderLayout.EAST);
		bottomPanel.add(rollDice, BorderLayout.WEST);
		getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		
		
		rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(3,2));
		rightPanel.add(new JLabel(new ImageIcon("src/images/dagger.jpg")));
		rightPanel.add(new JLabel(new ImageIcon("src/images/dagger.jpg")));
		rightPanel.add(new JLabel(new ImageIcon("src/images/dagger.jpg")));
		rightPanel.add(new JLabel(new ImageIcon("src/images/dagger.jpg")));
		rightPanel.add(new JLabel(new ImageIcon("src/images/dagger.jpg")));
		rightPanel.add(new JLabel(new ImageIcon("src/images/dagger.jpg")));
		
		getContentPane().add(rightPanel, BorderLayout.EAST);
		
		boardCanvas = new BoardCanvas();
		add(boardCanvas, BorderLayout.CENTER);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new BoardFrame();
	}

	public void actionPerformed(ActionEvent e) {
		String player;
		String weapon;
		String room;
		String cmd = e.getActionCommand();
		if (cmd.equals("accuse")) {
			Object[] ppossibilities = { "Miss Scarlett", "Professor Plum", "Mrs. Peacock", "Reverend Green",
					"Colonel Mustard", "Mrs. White" };

			player = (String) JOptionPane.showInputDialog(this, "Select a Character to Accuse:", "Accusation",
					JOptionPane.PLAIN_MESSAGE, null, ppossibilities, "");
			if(player.equals(null)){return;}
			
			Object[] wpossibilities = { "CandleStick", "Dagger", "LeadPipe", "Revolver", "Rope", "Spanner" };

			weapon = (String) JOptionPane.showInputDialog(this, "Select a murder weapon:", "Accusation",
					JOptionPane.PLAIN_MESSAGE, null, wpossibilities, "");
			if(weapon.equals(null)){return;}
			
			Object[] rpossibilities = { "Ballroom", "Billiard Room", "Conservatory", "Dining Room", "Hall", "Kitchen",
					"Library", "Lounge", "Study" };

			room = (String) JOptionPane.showInputDialog(this, "Select a room:", "Accusation",
					JOptionPane.PLAIN_MESSAGE, null, rpossibilities, "");
			if(room.equals(null)){return;}
			
			Accusation accuse = new Accusation(null, null, null);//have a go at fixing these
			
			game.accuse(accuse, null);
		}
		if (cmd.equals("suggest")){
			Object[] ppossibilities = { "Miss Scarlett", "Professor Plum", "Mrs. Peacock", "Reverend Green",
					"Colonel Mustard", "Mrs. White" };

			player = (String) JOptionPane.showInputDialog(this, "Select a Character to Accuse:", "Suggestion",
					JOptionPane.PLAIN_MESSAGE, null, ppossibilities, "");
			if(player.equals(null)){return;}
			
			Object[] wpossibilities = { "CandleStick", "Dagger", "LeadPipe", "Revolver", "Rope", "Spanner" };

			weapon = (String) JOptionPane.showInputDialog(this, "Select a murder weapon:", "Suggestion",
					JOptionPane.PLAIN_MESSAGE, null, wpossibilities, "");
			if(weapon.equals(null)){return;}
			
			Object[] rpossibilities = { "Ballroom", "Billiard Room", "Conservatory", "Dining Room", "Hall", "Kitchen",
					"Library", "Lounge", "Study" };

			room = (String) JOptionPane.showInputDialog(this, "Select a murder room:", "Suggestion",
					JOptionPane.PLAIN_MESSAGE, null, rpossibilities, "");
			if(room.equals(null)){return;}
			
			Suggestion suggest = new Suggestion(null, null, null);//cause I'm not 100% up to speed on how they're constructed
			
			game.suggest(suggest, null, null);
		}

	}

	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}

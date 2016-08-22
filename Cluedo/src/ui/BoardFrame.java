package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import game.Board;
import main.GameOfCluedo;

public class BoardFrame extends JFrame implements ActionListener, MouseListener {

	private JPanel bottomPanel;
	private JPanel rightPanel;
	private BoardCanvas boardCanvas;
	private GameOfCluedo game;

	public BoardFrame() {
		super("Cluedo Board Game");

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
		flow.setHgap(100);
		bottomPanel.setLayout(flow);
		bottomPanel.setPreferredSize(new Dimension(855, 100));
		bottomPanel.setMinimumSize(new Dimension(855, 100));
		
		JLabel profile = new JLabel("<html>Player Info<br> <br>text to edit</html>");
		
		JButton suggest = new JButton("Suggest");
		suggest.setActionCommand("suggest");
		suggest.addActionListener(this);
		suggest.setPreferredSize(new Dimension(50,50));

		JButton accuse = new JButton("Accuse");
		accuse.setActionCommand("accuse");
		accuse.addActionListener(this);
		accuse.setPreferredSize(new Dimension(50,50));
		
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
		bottomPanel.add(profile, BorderLayout.PAGE_END);
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
			
		}

	}

	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
	}

	public void mouseEntered(MouseEvent e) {	
	}

	public void mouseExited(MouseEvent e) {	
	}

	public void mousePressed(MouseEvent e) {	
	}
	
	public void mouseReleased(MouseEvent e) {}
}

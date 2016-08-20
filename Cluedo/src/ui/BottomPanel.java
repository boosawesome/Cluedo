package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class BottomPanel extends JPanel {

	private JButton rollDice;
	
	
	public BottomPanel(){
		setupPanel();
		
		
	}
	
	private void setupPanel(){
		
		setLayout(new BorderLayout());
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(0, 150));
		Border b = (BorderFactory.createLoweredBevelBorder());
		this.setBorder(b);
		setupDice();
		
		JPanel buttons = new JPanel();
		buttons.setBackground(Color.GRAY);
		buttons.add(rollDice);	
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		buttons.add(rigidArea);
		
		FlowLayout layout = new FlowLayout();
		buttons.setLayout(layout);
		buttons.setVisible(true);
		layout.setAlignment(FlowLayout.LEFT);
		layout.setVgap(35);
		layout.setHgap(10);
		add(buttons, BorderLayout.WEST);
	}
	
	private void setupDice(){
		rollDice = new JButton("Roll Dice");
		rollDice.setBackground(Color.LIGHT_GRAY);
		ImageIcon dice = new ImageIcon("src/images/dice.png");
		Image d = dice.getImage();
		Image newD = d.getScaledInstance(45, 45, 20);
		ImageIcon d2 = new ImageIcon(newD);
		
		
		rollDice.setIcon(d2);
		rollDice.setMargin(new Insets(0,0,0,0));
	}
	
	
}

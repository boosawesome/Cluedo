package ui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class BoardCanvas extends Canvas{
	
	public final int numSquare = 25;
	Square[][] squares;
	
	public BoardCanvas(){
		this.setBackground(Color.BLACK);
		squares = new Square[numSquare][numSquare];
		
		
		
	}
	
	
	public void paint(Graphics g){
		
	}
	
	
}

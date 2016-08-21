package ui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class BoardCanvas extends Canvas{
	
	private final int squareSize = 35;
	public final int numSquare = 25;
	Square[][] squares;
	
	public BoardCanvas(){
		this.setBackground(Color.BLACK);
		squares = new Square[numSquare][numSquare];
		
	}
	
	
	public void paint(Graphics g){
		int width = 24*35;
		int height = 25*35;
		
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, width, height);
		drawSquares(g);
		drawRooms(g);
		
	}
	
	public void drawSquares(Graphics g){
		g.setColor(Color.BLACK);
		
		for(int x = 0; x < 24; x++){
			for(int y = 0; y < 25; y++){
				g.drawRect(x*35, y*35, squareSize, squareSize);
			}
		}
	}
	
	public void drawRooms(Graphics g){
		g.setColor(Color.WHITE);
		
		//Kitchen
		for(int x = 0; x <= 5; x++){
			for(int y = 1; y <= 6 ; y++){
				g.fillRect(x*35, y*35, squareSize, squareSize);
			}
		}
		//Ball Room
		for(int x = 8; x <= 15; x++){
			for(int y = 2; y <= 7; y++){
				g.fillRect(x*35, y*35, squareSize, squareSize);
			}
		}
		for(int x = 10; x <= 13; x++){
			g.fillRect(x*35, 1*35, squareSize, squareSize);
		}
		//Conservatory
		for(int x = 19; x <= 23; x++){
			for(int y = 1; y <= 4; y++){
				g.fillRect(x*35, y*35, squareSize, squareSize);
			}
		}
		for(int x = 20; x <= 23; x++){
				g.fillRect(x*35, 5*35, squareSize, squareSize);			
		}
		//Dining Room
		for(int x = 0; x <= 7; x++){
			for(int y = 10; y <= 16; y++){
				g.fillRect(x*35, y*35, squareSize, squareSize);
			}
		}
		for(int x = 0; x <= 5; x++){
			g.fillRect(x*35, 10*35, squareSize, squareSize);
		}
		//Billiard Room
		for(int x = 19; x <= 23; x++){
			for(int y = 8; y <= 12; y++){
				g.fillRect(x*35, y*35, squareSize, squareSize);
			}
		}
		//Library
		for(int x = 18; x <= 23; x++){
			for(int y = 14; y <= 18; y++){
				g.fillRect(x*35, y*35, squareSize, squareSize);
			}
		}
		//Lounge
		for(int x = 0; x <= 6; x++){
			for(int y = 19; y <= 24; y++){
				g.fillRect(x*35, y*35, squareSize, squareSize);
			}
		}
		//Hall
		for(int x = 9; x <= 14; x++){
			for(int y = 18; y <= 24; y++){
				g.fillRect(x*35, y*35, squareSize, squareSize);
			}
		}
		//Study
		for(int x = 17; x <= 23; x++){
			for(int y = 21; y <= 24; y++){
				g.fillRect(x*35, y*35, squareSize, squareSize);
			}
		}
		
		g.setColor(Color.BLUE);
		for(int x = 10; x <= 14; x++){
			for(int y = 10; y <=16; y++){
				g.fillRect(x*1*35, y*1*35, squareSize, squareSize);
			}
		}
		
		g.setColor(Color.GREEN);
		g.fillRect(0, 7*35, squareSize, squareSize);
		g.fillRect(6*35, 1*35, squareSize, squareSize);
		g.fillRect(18*35, 1*35, squareSize, squareSize);
		g.fillRect(23*35, 5*35, squareSize, squareSize);
		g.fillRect(0,  9*35, squareSize, squareSize);
		g.fillRect(23*35, 8*35, squareSize, squareSize);
		g.fillRect(0, 16*35, squareSize, squareSize);
		g.fillRect(0, 18*35, squareSize, squareSize);
		g.fillRect(23*35, 13*35, squareSize, squareSize);
		g.fillRect(23*35, 14*35, squareSize, squareSize);
		g.fillRect(23*35, 18*35, squareSize, squareSize);
		g.fillRect(23*35, 20*35, squareSize, squareSize);
		g.fillRect(6*35, 24*35, squareSize, squareSize);
		g.fillRect(8*35, 24*35, squareSize, squareSize);
		g.fillRect(15*35, 24*35, squareSize, squareSize);
		for(int x = 0; x <= 23; x++){
			g.fillRect(x*1*35, 0, squareSize, squareSize);
		}
		 
		g.setColor(Color.ORANGE);
		g.fillRect(5*35, 1*35, squareSize, squareSize);
		g.fillRect(0,  19*35, squareSize, squareSize);
		g.fillRect(22*35, 5*35, squareSize, squareSize);
		g.fillRect(23*35, 21*35, squareSize, squareSize);
		
		g.setColor(Color.RED);
		g.fillRect(9*35, 0, squareSize, squareSize);
		g.fillRect(14*35, 0, squareSize, squareSize);
		g.fillRect(23*35, 6*35, squareSize, squareSize);
		g.fillRect(0, 17*35, squareSize, squareSize);
		g.fillRect(23*35, 19*35, squareSize, squareSize);
		g.fillRect(7*35, 24*35, squareSize, squareSize);
		g.fillRect(23*35, 19*35, squareSize, squareSize);
	}
	
}
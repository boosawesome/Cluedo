package ui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class BoardCanvas extends Canvas{
	
	private final int squareSize = 10;
	public final int numSquare = 25;
	Square[][] squares;
	
	public BoardCanvas(){
		this.setBackground(Color.BLACK);
		squares = new Square[numSquare][numSquare];
		
	}
	
	
	public void paint(Graphics g){
		int width = 240;
		int height = 250;
		
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, width, height);
		drawSquares(g);
		drawRooms(g);
		
	}
	
	public void drawSquares(Graphics g){
		g.setColor(Color.BLACK);
		
		for(int x = 0; x < 24; x++){
			for(int y = 0; y < 25; y++){
				g.drawRect(x*10, y*10, squareSize, squareSize);
			}
		}
	}
	
	public void drawRooms(Graphics g){
		g.setColor(Color.WHITE);
		
		//Kitchen
		for(int x = 0; x <= 5; x++){
			for(int y = 1; y <= 6 ; y++){
				g.fillRect(x*10, y*10, squareSize, squareSize);
			}
		}
		//Ball Room
		for(int x = 8; x <= 15; x++){
			for(int y = 2; y <= 7; y++){
				g.fillRect(x*10, y*10, squareSize, squareSize);
			}
		}
		for(int x = 10; x <= 13; x++){
			g.fillRect(x*10, 10, squareSize, squareSize);
		}
		//Conservatory
		for(int x = 19; x <= 23; x++){
			for(int y = 1; y <= 4; y++){
				g.fillRect(x*10, y*10, squareSize, squareSize);
			}
		}
		for(int x = 20; x <= 23; x++){
				g.fillRect(x*10, 50, squareSize, squareSize);			
		}
		//Dining Room
		for(int x = 0; x <= 7; x++){
			for(int y = 10; y <= 16; y++){
				g.fillRect(x*10, y*10, squareSize, squareSize);
			}
		}
		for(int x = 0; x <= 5; x++){
			g.fillRect(x*10, 100, squareSize, squareSize);
		}
		//Billiard Room
		for(int x = 19; x <= 23; x++){
			for(int y = 8; y <= 12; y++){
				g.fillRect(x*10, y*10, squareSize, squareSize);
			}
		}
		//Library
		for(int x = 18; x <= 23; x++){
			for(int y = 14; y <= 18; y++){
				g.fillRect(x*10, y*10, squareSize, squareSize);
			}
		}
		//Lounge
		for(int x = 0; x <= 6; x++){
			for(int y = 19; y <= 24; y++){
				g.fillRect(x*10, y*10, squareSize, squareSize);
			}
		}
		//Hall
		for(int x = 9; x <= 14; x++){
			for(int y = 18; y <= 24; y++){
				g.fillRect(x*10, y*10, squareSize, squareSize);
			}
		}
		//Study
		for(int x = 17; x <= 23; x++){
			for(int y = 21; y <= 24; y++){
				g.fillRect(x*10, y*10, squareSize, squareSize);
			}
		}
		
		g.setColor(Color.BLUE);
		for(int x = 10; x <= 14; x++){
			for(int y = 10; y <=16; y++){
				g.fillRect(x*10, y*10, squareSize, squareSize);
			}
		}
		
		g.setColor(Color.GREEN);
		g.fillRect(0, 70, squareSize, squareSize);
		g.fillRect(60, 10, squareSize, squareSize);
		g.fillRect(180, 10, squareSize, squareSize);
		g.fillRect(230, 50, squareSize, squareSize);
		g.fillRect(0,  90, squareSize, squareSize);
		g.fillRect(230, 80, squareSize, squareSize);
		g.fillRect(0, 160, squareSize, squareSize);
		g.fillRect(0, 180, squareSize, squareSize);
		g.fillRect(230, 130, squareSize, squareSize);
		g.fillRect(230, 140, squareSize, squareSize);
		g.fillRect(230, 180, squareSize, squareSize);
		g.fillRect(230, 200, squareSize, squareSize);
		g.fillRect(60, 240, squareSize, squareSize);
		g.fillRect(80, 240, squareSize, squareSize);
		g.fillRect(150, 240, squareSize, squareSize);
		for(int x = 0; x <= 23; x++){
			g.fillRect(x*10, 0, squareSize, squareSize);
		}
		
		g.setColor(Color.ORANGE);
		g.fillRect(50, 10, squareSize, squareSize);
		g.fillRect(0,  190, squareSize, squareSize);
		g.fillRect(220, 50, squareSize, squareSize);
		g.fillRect(230, 210, squareSize, squareSize);
		
		g.setColor(Color.RED);
		g.fillRect(90, 0, squareSize, squareSize);
		g.fillRect(140, 0, squareSize, squareSize);
		g.fillRect(2300, 600, squareSize, squareSize);
		g.fillRect(0, 170, squareSize, squareSize);
		g.fillRect(2300, 190, squareSize, squareSize);
		g.fillRect(70, 240, squareSize, squareSize);
		g.fillRect(230, 190, squareSize, squareSize);
	}
	
}

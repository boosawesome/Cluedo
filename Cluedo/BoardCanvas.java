package ui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import game.Board;

public class BoardCanvas extends Canvas implements ComponentListener{
	
	 private int squareSizeX = 35;
	 private int squareSizeY = 35;
	 private int width = 24*35;
	 private int height = 24*35;
	
	public final int numSquare = 25;
	Square[][] squares;
	String[][] map = Board.map;
	
	public BoardCanvas(){
		
		addComponentListener(this);
		
		squares = new Square[numSquare][numSquare];
		
		for(int x = 0; x < 24; x++){
			for(int y = 0; y < 25; y++){
				if(map[x][y].equals("x")){
					squares[x][y] = new Square(new Point(x,y));
				}
			}
		}
		
	}
	
	public void paint(Graphics g){
		
		this.setBackground(Color.GRAY);
		drawSquares(g);
		drawRooms(g);
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, width, height);

	
	}
	
	public void drawSquares(Graphics g){
		g.setColor(Color.BLACK);
		
		for(int x = 0; x < 24; x++){
			for(int y = 0; y < 25; y++){
				g.drawRect(x*squareSizeX, y*squareSizeY, squareSizeX, squareSizeY);
			}
		}
		System.out.println("C");
	}
	
	public void drawRooms(Graphics g){
		g.setColor(Color.WHITE);
		
		//Kitchen
		for(int x = 0; x <= 5; x++){
			for(int y = 1; y <= 6 ; y++){
				g.fillRect(x*squareSizeX, y*squareSizeY, squareSizeX, squareSizeY);
			}
		}
		//Ball Room
		for(int x = 8; x <= 15; x++){
			for(int y = 2; y <= 7; y++){
				g.fillRect(x*squareSizeX, y*squareSizeY, squareSizeX, squareSizeY);
			}
		}
		for(int x = 10; x <= 13; x++){
			g.fillRect(x*squareSizeX, 1*squareSizeX, squareSizeX, squareSizeY);
		}
		//Conservatory
		for(int x = 19; x <= 23; x++){
			for(int y = 1; y <= 4; y++){
				g.fillRect(x*squareSizeX, y*squareSizeY, squareSizeX, squareSizeY);
			}
		}
		for(int x = 20; x <= 23; x++){
				g.fillRect(x*squareSizeX, 5*squareSizeX, squareSizeX, squareSizeY);			
		}
		//Dining Room
		for(int x = 0; x <= 7; x++){
			for(int y = 10; y <= 16; y++){
				g.fillRect(x*squareSizeX, y*squareSizeY, squareSizeX, squareSizeY);
			}
		}
		for(int x = 0; x <= 5; x++){
			g.fillRect(x*squareSizeX, 10*squareSizeX, squareSizeX, squareSizeY);
		}
		//Billiard Room
		for(int x = 19; x <= 23; x++){
			for(int y = 8; y <= 12; y++){
				g.fillRect(x*squareSizeX, y*squareSizeY, squareSizeX, squareSizeY);
			}
		}
		//Library
		for(int x = 18; x <= 23; x++){
			for(int y = 14; y <= 18; y++){
				g.fillRect(x*squareSizeX, y*squareSizeY, squareSizeX, squareSizeY);
			}
		}
		//Lounge
		for(int x = 0; x <= 6; x++){
			for(int y = 19; y <= 24; y++){
				g.fillRect(x*squareSizeX, y*squareSizeY, squareSizeX, squareSizeY);
			}
		}
		//Hall
		for(int x = 9; x <= 14; x++){
			for(int y = 18; y <= 24; y++){
				g.fillRect(x*squareSizeX, y*squareSizeY, squareSizeX, squareSizeY);
			}
		}
		//Study
		for(int x = 17; x <= 23; x++){
			for(int y = 21; y <= 24; y++){
				g.fillRect(x*squareSizeX, y*squareSizeY, squareSizeX, squareSizeY);
			}
		}
		
		g.setColor(Color.BLUE);
		for(int x = 10; x <= 14; x++){
			for(int y = 10; y <=16; y++){
				g.fillRect(x*squareSizeX, y*squareSizeY, squareSizeX, squareSizeY);
			}
		}
		System.out.println("A");
		
		g.setColor(Color.GREEN);
		g.fillRect(0, 7*squareSizeY, squareSizeX, squareSizeY);
		g.fillRect(6*squareSizeX, 1*squareSizeY, squareSizeX, squareSizeY);
		g.fillRect(18*squareSizeX, 1*squareSizeY, squareSizeX, squareSizeY);
		g.fillRect(23*squareSizeX, 5*squareSizeY, squareSizeX, squareSizeY);
		g.fillRect(0,  9*squareSizeY, squareSizeX, squareSizeY);
		g.fillRect(23*squareSizeX, 8*squareSizeY, squareSizeX, squareSizeY);
		g.fillRect(0, 16*squareSizeY, squareSizeX, squareSizeY);
		g.fillRect(0, 18*squareSizeY, squareSizeX, squareSizeY);
		g.fillRect(23*squareSizeX, 13*squareSizeY, squareSizeX, squareSizeY);
		g.fillRect(23*squareSizeX, 14*squareSizeY, squareSizeX, squareSizeY);
		g.fillRect(23*squareSizeX, 18*squareSizeY, squareSizeX, squareSizeY);
		g.fillRect(23*squareSizeX, 20*squareSizeY, squareSizeX, squareSizeY);
		g.fillRect(6*squareSizeX, 24*squareSizeY, squareSizeX, squareSizeY);
		g.fillRect(8*squareSizeX, 24*squareSizeY, squareSizeX, squareSizeY);
		g.fillRect(15*squareSizeX, 24*squareSizeY, squareSizeX, squareSizeY);
		for(int x = 0; x <= 23; x++){
			g.fillRect(x*squareSizeX, 0, squareSizeX, squareSizeY);
		}
		
		g.setColor(Color.ORANGE);
		g.fillRect(5*squareSizeX, 1*squareSizeY, squareSizeX, squareSizeY);
		g.fillRect(0,  19*squareSizeY, squareSizeX, squareSizeY);
		g.fillRect(22*squareSizeX, 5*squareSizeY, squareSizeX, squareSizeY);
		g.fillRect(23*squareSizeX, 21*squareSizeY, squareSizeX, squareSizeY);
		
		g.setColor(Color.RED);
		g.fillRect(9*squareSizeX, 0, squareSizeX, squareSizeY);
		g.fillRect(14*squareSizeX, 0, squareSizeX, squareSizeY);
		g.fillRect(23*squareSizeX, 6*squareSizeY, squareSizeX, squareSizeY);
		g.fillRect(0, 17*squareSizeY, squareSizeX, squareSizeY);
		g.fillRect(23*squareSizeX, 19*squareSizeY, squareSizeX, squareSizeY);
		g.fillRect(7*squareSizeX, 24*squareSizeY, squareSizeX, squareSizeY);
		g.fillRect(23*squareSizeX, 19*squareSizeY, squareSizeX, squareSizeY);
		System.out.println("B");
	}

	@Override
	public void componentHidden(ComponentEvent arg0) {	
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
	}

	@Override
	public void componentResized(ComponentEvent e) {
		this.squareSizeX = 24/getWidth();
		this.squareSizeY = 25/getHeight();
		this.width = getWidth();
		this.height = getHeight();
		this.repaint();
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
	}

}

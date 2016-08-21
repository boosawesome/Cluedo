package items;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Piece { 

	Image picture;
	public String token;
	public String colour;
	
	public Piece(String token){
		this.token = token;
		setupPiece(token);
		try {
			picture = ImageIO.read(new File("src/images/"+colour+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	

	}


	public void setupPiece(String charac){
		switch(charac){
		case "Miss Scarlett":
			colour = "red"; 
			break;
		case "Mrs White":
			colour = "white";
			break;
		case "Colonel Mustard":
			colour = "yellow";
			break;
		case "The Reverend Green":
			colour = "green";
			break;
		case "Mrs Peacock":
			colour = "blue";
			break;
		case "Professor Plum":
			colour = "purple";
			break;
		}	
		
		
		

	}






}

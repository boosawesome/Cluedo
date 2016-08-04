package game;

public class Card {

	public enum Character{
		MISS_SCARLET,
		COLONEL_MUSTARD,
		MRS_WHITE,
		THE_REVEREND_GREEN,
		MRS_PEACOCK,
		PROFESSOR_PLUM
	}
	
	public enum Weapon{
		CANDLESTICK,
		DAGGER,
		LEAD_PIPE,
		REVOLVER,
		ROPE,
		SPANNER
	}
	
	private String name;
	
	public Card(String name){
		this.name = name;
	}
	
	
	
	
	
	
	
}

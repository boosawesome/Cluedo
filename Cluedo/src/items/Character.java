package items;

public class Character implements Card{
	public enum CharacterToken{ 
		MISS_SCARLETT,
		COLONEL_MUSTARD,
		MRS_WHITE,
		THE_REVEREND_GREEN,
		MRS_PEACOCK,
		PROFESSOR_PLUM
	}
	
	
	private CharacterToken token;
	Room room;


	public Character(CharacterToken token){
		this.token = token;
	}
	
	public String getName(){
		return this.token.name();
	}
	
	public void setRoom(Room room){
		this.room = room;
	}
	
	public Room getRoom(){
		return this.room;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Character other = (Character) obj;
		if (token != other.token)
			return false;
		return true;
	}
	
}

package items;

import items.Character.CharacterToken;

public class Weapon implements Card{



	public enum WeaponToken{
		CANDLESTICK,
		DAGGER,
		LEAD_PIPE,
		REVOLVER,
		ROPE,
		SPANNER
	}
	public boolean isClue = false;
	private WeaponToken token;
	Room room;
	
	public Weapon(WeaponToken token){
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
		Weapon other = (Weapon) obj;
		if (token != other.token)
			return false;
		return true;
	}
	
	
	
	
	
	
	
}

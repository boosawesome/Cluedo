package items;

public class Room implements Card{
	
	public enum RoomToken{
		HALL,
		LOUNGE,
		DINING_ROOM,
		KITCHEN,
		BALLROOM,
		CONSERVATORY,
		BILLARD_ROOM,
		LIBRARY,
		STUDY
	}
	
	private RoomToken token;
	private RoomToken opposite;

	public Room(RoomToken token){
		this.token = token;
	}
	public Room(RoomToken token, RoomToken opposite) {
		this.token = token;
		this.opposite = opposite;

	}

	public String getName() {
		return this.token.name();
	}

	public String getOpposite() {
		return this.opposite.name();
	}
	
	public boolean hasStairWell(){
		return opposite != null;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((opposite == null) ? 0 : opposite.hashCode());
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
		Room other = (Room) obj;
		if (opposite != other.opposite)
			return false;
		if (token != other.token)
			return false;
		return true;
	}
	
	
	
}

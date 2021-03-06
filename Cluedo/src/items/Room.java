package items;

/***
 * Represents a Room Card in the Cluedo Game. This class implements Card Interface,
 * 
 * @author Andre L Westerlund
 *
 */
public class Room implements Card{

	/**
	 * Rooms of Cluedo
	 * 
	 * @author Andre L Westerlund
	 *
	 */
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
	private RoomToken opposite = null; // a room may have a connection to another room

	/**
	 * Constructs a Room Object from a given Room Token
	 * 
	 * @param token
	 */
	public Room(RoomToken token){
		this.token = token;
	}

	/**
	 * Constructs a Room Object from a given Room Token and has access to another
	 * Room Object via opposite room token
	 * 
	 * @param token
	 * @param opposite
	 */
	public Room(RoomToken token, RoomToken opposite) {
		this.token = token;
		this.opposite = opposite;
	}

	/**
	 * Gets the name of the Room
	 */
	public String getName() {
		return this.token.name();
	}
	
	/**
	 * Gets the name of the Accessible Room if this has a Stairwell
	 * @return
	 */
	public String getOpposite() {
		return this.opposite.name();
	}
	
	/**
	 * Determines whether the Room Object is connected to another Room
	 * 
	 * @return
	 */
	public boolean hasStairWell(){
		return opposite != null;
	}
	
	/**
	 * Generated HashCode method
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((opposite == null) ? 0 : opposite.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		return result;
	}
	
	/**
	 * Generated Equals method
	 */
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

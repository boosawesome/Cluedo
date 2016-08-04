package items;

public class WeaponObject{
	private Weapon weapon;
	Room room;
	
	public WeaponObject(Weapon weapon){
		this.weapon = weapon;
	}
	
	public String getName(){
		return this.weapon.getName();
	}
	
	public void setRoom(Room room){
		this.room = room;
	}
	
	public Room getRoom(){
		return this.room;
	}
	
	public Weapon getWeapon(){
		return weapon;
	}
}
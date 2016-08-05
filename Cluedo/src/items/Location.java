package items;

import java.util.ArrayList;

import game.Player;

public class Location {
	
		public Room room;
		WeaponObject w = null;
		ArrayList<Player> players;
		
		public Location(Room room){
			this.room = room;
			players = new ArrayList<Player>();
		}
		
		
		
		public int size(){
			return players.size();
		}
		
		public boolean hasPlayer(Player p){
			return players.contains(p);
		}
		
		public boolean hasWeaponObject(WeaponObject w){
			return this.w.equals(w);
		}
		
		public void setWeaponObject(WeaponObject w){
			this.w = w;
		}
		
		public WeaponObject getWeaponObject(){
			if(w != null)
			return w;
			else return null;
		}
		
		public void addPlayer(Player p){
			this.players.add(p);
			
		}
		
		public void removePlayer(Player p){
			if(players.contains(p))players.remove(p);
			p.setRoom(null);
		}
		
		public ArrayList<Player> getPlayers(){
			return this.players;
		}
		
		
		
	
}

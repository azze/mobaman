import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/*
 * the team class contains all information concerning a certain team
 */
public class Team {
	
	String name;
	List<Player> players;
	int money;
	List<Tournament> tourneys;
	public Team(String curr) {
		name=curr;
		players= new ArrayList<Player>();
		money=0;
		tourneys= new ArrayList<Tournament>();
	}
	public void addPlayer(Player playa) {
		players.add(playa);
		
	}
	public List getPlayers(){
		return players;
	}
	public String getPlayersNames(){
		ListIterator litr = players.listIterator();
		String playersNames = "";
	
		while(litr.hasNext()){
			Player player =(Player)litr.next();
			playersNames += player.name +"\n";
		}
		return playersNames;
	}	
	/*
	 * TODO:
	 * - add stuff like manager, coach, rating etc
	 * - add history
	 * 
	 */
	public double getAverageSkill() {
		ListIterator playerIterator = players.listIterator();
		double skill = 0;
		while(playerIterator.hasNext()){
			skill+=((Player) playerIterator.next()).value;
		}
		return skill/5.;
	}
}

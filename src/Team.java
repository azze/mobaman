import java.util.ArrayList;
import java.util.List;

/*
 * the team class contains all information concerning a certain team
 */
public class Team {
	
	String name;
	List players;
	int money;
	List tourneys;
	public Team(String curr) {
		name=curr;
		players= new ArrayList();
		money=0;
		tourneys= new ArrayList();
	}
	public void addPlayer(Player playa) {
		players.add(playa);
		
	}
	public List getPlayers(){
		return players;
	}
	/*
	 * TODO:
	 * - add stuff like manager, coach, rating etc
	 * - add history
	 * 
	 */
}

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * class containing all the data in the game
 * @author Dr Moebius
 *
 */
public class DataBase {
	List heroes;
	List players;
	List teams;
	List pnames;
	int date;
	
	int round;
	
	List tournaments;
	List tnames;
	Team myTeam;
	List[] matchCalendar;
	
	
	
	
	
	public DataBase(){
		heroes= new ArrayList();
		players= new ArrayList();
		teams= new ArrayList();
		pnames = new ArrayList();
		tnames = new ArrayList();
		tournaments = new ArrayList();
		matchCalendar = new List[100];
		for(int i=0;i<100;i++)
			matchCalendar[i]= new ArrayList();
		date=0;
	}
	
	public void addTournament(Tournament t){
		tournaments.add(t);
		for(int i=0;i<t.matches.length;i++){
			matchCalendar[t.matches[i].startDate].add(t.matches[i]);
		}
	}
	public List getUncontractedPlayers() {
		ListIterator litr = players.listIterator();
		List uncon = new ArrayList();
		while(litr.hasNext()){
			Player playa =(Player) litr.next();
			if(!playa.hasTeam())
				uncon.add(playa);
		}
		return uncon;
	}
	/*
	 * TODO:
	 * -add data on tournaments
	 * -change system in which data is stored
	 * -add methods to better access data needed by the panels
	 */

	public String getNextGames() {
		String str="NEXT UP: \n";
		ListIterator litr=matchCalendar[date+1].listIterator();
		while(litr.hasNext()){
			Match mat =(Match) litr.next();
			str=str+mat.dire.name +" vs. " +mat.radiant.name+"\n";
		}
		return str;
	}
}

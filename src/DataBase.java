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
	
	//Test
	String infoText = "Actions performed this round:" +"\n";
	String messagesText = "Messages: " +"\n";
	
	
	
	
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
		date=1;
	}
	public int timeToNextTournament(){
		Tournament t;
		ListIterator litr = tournaments.listIterator();
		int minDate = 100;
		while(litr.hasNext()){
			
			t = (Tournament) litr.next();
			
			if(t.date<minDate){
				
				minDate = t.date;				
			}

		}
		return minDate-date;
	}
	public void addToInfo(String s){
		
		infoText += " -" +s +"\n";
	}
	public void addToMessages(String s){
		
		messagesText += " -" +s +"\n";
	}
	public void addTournament(Tournament t){
		tournaments.add(t);
		System.out.println("addTournament" +"name: " +t.name +" date: "+t.date);
		for(int i=0;i<t.matches.length;i++){
			matchCalendar[t.matches[i].startDate].add(t.matches[i]);
		}
		addToMessages("New Tournament announced! " +t.name +". " +(t.date-date) +" Days left.");
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
		ListIterator litr=matchCalendar[date+timeToNextTournament()].listIterator();
		while(litr.hasNext()){
			Match mat =(Match) litr.next();
			str=str+mat.dire.name +"\n" +"vs." +"\n" +mat.radiant.name+"\n";
		}		
		System.out.println(str);
		
		return str;

	}

	public List getTodaysMatches() {
		
		return matchCalendar[date];
	}
}

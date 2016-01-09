import java.util.ArrayList;
import java.util.List;

public class Match {
	
	Team radiant;
	Team dire;
	int time;
	int startDate;
	int[][] scores;
	int winner;
	List<Hero> radHeroes;
	List<Hero> dirHeroes;
	public Match(Team team, Team team2, int dat) {
		radiant=team;
		dire=team2;
		startDate=dat;
		radHeroes = new ArrayList<Hero>();
		dirHeroes = new ArrayList<Hero>();
	}
	public void setWinner(int i) {
		winner =i;
		
	}

}

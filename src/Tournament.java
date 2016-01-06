
public class Tournament {
	String name;
	int date;
	Team[] teams;
	int[] prizes;
	int currTeams;
	int noOfTeams;
	int format;
	Match[] matches;
	public Tournament(String string, int num, int form, int _date){
		name=string;
		date=_date;
		noOfTeams=num;
		currTeams=0;
		format=form;
		teams= new Team[noOfTeams];
	}
	public void addTeam(Team team){
		teams[currTeams]=team;
		currTeams++;
	}
	public void setup(){
		matches= new Match[(noOfTeams*(noOfTeams-1))/2];
		int k =0;
		for(int i=0;i<noOfTeams-1;i++)
			for(int j=i+1;j<noOfTeams;j++){
				matches[k]=new Match(teams[i],teams[j],date+k);
				k++;
			}
				
	}
}

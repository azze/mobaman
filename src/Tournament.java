
public class Tournament {
	String name;
	int date;
	Team[] teams;
	int[] prizes;
	int currTeams;
	int noOfTeams;
	int format;
	int status;
	Match[] matches;
	public Tournament(String string, int num, int form, int _date){
		name=string;
		date=_date;
		noOfTeams=num;
		currTeams=0;
		format=form;
		status=0;
		teams= new Team[noOfTeams];
	}
	public void addTeam(Team team){
		System.out.println("new team added. name: " +team);
		teams[currTeams]=team;
		currTeams++;
	}
	public void setup(){
		matches= new Match[(noOfTeams*(noOfTeams-1))/2];
		System.out.println(matches.length);
		System.out.println(teams[0].name +" " +teams[1].name +" " +teams[2].name);
		int k =0;
		for(int i=0;i<noOfTeams-1;i++){
			for(int j=i+1;j<noOfTeams;j++){
				matches[k]=new Match(teams[i],teams[j],date+k);
				k++;
			}
		}
		status=1;
		
	}
}

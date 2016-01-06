/*
 * this class represents a moba player and contains all information about him
 */
public class Player {
	String name;
	double[] prof;
	int morale;
	Team team;
	int value;
	int age;
	int role;
	
/*
 * PreImplemented Softskill values
 * 
 *  double energyLevel;
 *  double concentrationLevel;
 *  double reactionLevel;
 *  double healthLevel;
 *  ...
 */

	public Player(String _name, double[] _prof, int _value){
		name=_name;
		prof=_prof;
		team=null;
		morale=1;
		value=_value;
	}
	public Player(String curr) {
		name=curr;
		morale=1;
		team=null;
		value=100;
	}
	public void setTeam(Team _team){
		team=_team;
	}
	public boolean hasTeam() {
		if(team==null)
			return false;
		else
			return true;
	}
	//some basic info to print to screen
	public String getInfo() {
		String str =name +"\n Team: ";
		if(team==null)
			str=str+ "none";
		else
			str=str +team.name;
		str=str +"\n Price:" +value;
		str=str+ "\n more info";
		return str;
	}
	
	
	
	/*
	 * TODO:
	 * -implement quirks
	 * -setup data on his proficiency with heroes
	 * -add history of the player(former teams, success etc.)
	 * -add more information(age?...)
	 * -add getters/setters for Player variables
	 */
	
}

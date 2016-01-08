import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;

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
	double[] heroSkill;
	Icon image;
	
	
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
		image = (Icon) new ImageIcon("C:/Users/Domi/Documents/Uni/Softwareentwicklung/SE1/neu/MobaMan/" + name + ".jpg");
		Random rand = new Random();
		heroSkill = new double[16];
		for(int i=0;i<heroSkill.length;i++)
			heroSkill[i]=100+rand.nextDouble()*10-5;
	}
	public Player(String curr) {
		name=curr;
		morale=1;
		team=null;
		value=100;
		image = (Icon) new ImageIcon("C:/Users/Domi/Documents/Uni/Softwareentwicklung/SE1/neu/MobaMan/" + name + ".jpg");
		Random rand = new Random();
		heroSkill = new double[16];
		for(int i=0;i<heroSkill.length;i++)
			heroSkill[i]=100+rand.nextDouble()*10-5;
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
	public String createStatsText(){
		
		String temporaryStatsText = "";
		
		temporaryStatsText = "Morale = " +morale +"\n" +"Value = " +value +"\n" +"Role = " +"\n" +"Stuff = ";
		
		
		return temporaryStatsText;
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

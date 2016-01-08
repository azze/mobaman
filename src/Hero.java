import java.util.Random;

/**
 * simple class containg information on heroes
 * @author Dr Moebius
 *
 */
public class Hero {
	public String name;
	double[] heroSkill;
	int type;
	int intstat;
	int agistat;
	int strstat;
	public Hero(int type, String temp, String[] stat) {
		this.type=type;
		Random rand = new Random();
		heroSkill = new double[16];
		for(int i=0;i<heroSkill.length;i++)
			heroSkill[i]=100+rand.nextDouble()*10-5;
		name=temp;
		intstat=Integer.parseInt(stat[0]);
		agistat=Integer.parseInt(stat[1]);
		strstat=Integer.parseInt(stat[2]);
		
	}
	public String toString(){
		return name;
	}
	/*
	 * TODO:
	 * -some more data to flesh out the heroes, i.e reliance on farm, specialities, etc.
	 */
}

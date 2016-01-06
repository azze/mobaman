/**
 * simple class containg information on heroes
 * @author Dr Moebius
 *
 */
public class Hero {
	public String name;
	int intstat;
	int agistat;
	int strstat;
	public Hero(String temp, String[] stat) {
		name=temp;
		intstat=Integer.parseInt(stat[0]);
		agistat=Integer.parseInt(stat[1]);
		strstat=Integer.parseInt(stat[2]);
		
	}
	/*
	 * TODO:
	 * -some more data to flesh out the heroes, i.e reliance on farm, specialities, etc.
	 */
}

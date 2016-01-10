import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;

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
	public ImageIcon icon;
	public Hero(int type, String temp, String[] stat, String imagePath) {
		this.type=type;
		icon=new ImageIcon(imagePath);
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

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
	int damage;
	int damageGain;
	int sustain;
	int sustainGain;
	int burst;
	int burstGain;
	int mobility;
	int mobilityGain;
	public ImageIcon icon;
	public Hero(int type, String temp, int[] stats, String imagePath) {
		this.type=type;
		icon=new ImageIcon(imagePath);
		name=temp;
		damage=stats[0];
		damageGain=stats[1];
		sustain=stats[2]*10;
		sustainGain=stats[3];
		burst=stats[4];
		burstGain=stats[5];
		mobility=stats[6];
		mobilityGain= stats[7];
		
	}
	public String toString(){
		return name;
	}
	/*
	 * TODO:
	 * -some more data to flesh out the heroes, i.e reliance on farm, specialities, etc.
	 */
}

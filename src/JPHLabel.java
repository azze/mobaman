import javax.swing.JLabel;

public class JPHLabel extends JLabel {
	public Hero hero;
	
	public void setHero(Hero hero) {
		this.hero=hero;
		setIcon(hero.icon);
		setHorizontalTextPosition(JLabel.CENTER);
		setVerticalTextPosition(JLabel.BOTTOM);
	}

}

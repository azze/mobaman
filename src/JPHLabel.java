import javax.swing.JLabel;

public class JPHLabel extends JLabel {
	public Hero hero;
	public void setHero(Hero hero) {
		this.hero=hero;
		setText(getText()+"\n"+ hero.name);
	}

}

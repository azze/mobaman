import javax.swing.JLabel;

public class InGameHeroLabel extends JLabel{
	InGameHero IHero;
	public InGameHeroLabel(InGameHero inGameHero) {
		IHero=inGameHero;
		setIcon(IHero.hero.icon);
		setHorizontalTextPosition(JLabel.CENTER);
		setVerticalTextPosition(JLabel.BOTTOM);
		setText(IHero.hero.name+ "   level: " +IHero.level +"\n"+ IHero.player.name + "   lane:" +IHero.pos);
	} 
	
	public void reload() {
		setText(IHero.hero.name+ "   level: " +IHero.level +"\n"+ IHero.player.name + "   lane:" +IHero.pos);
		repaint();
	}
}

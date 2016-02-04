
public class InGameHero {
	Hero hero;
	Player player;
	int level;
	String pos;
	String agg;
	public InGameHero(Hero hero,Player player){
		this.player=player;
		this.hero=hero;
		level=0;
		pos="bottom";
		agg="neutral";
		
	}
	
	public String getHeroName() {
		return hero.name;
	}

	public void setPos(String currentLane) {
		pos=currentLane;
	}

	public void setAggro(String currentAggro) {
		agg=currentAggro;
		
	}
}

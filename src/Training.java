/*
 * Class to provide training of a Player
 */
public class Training {
	
	String name;		//Name of the training.
	
	int efficiencyTier; //The number, the more efficient is the training depending on the skill level of the player. For example, high skill players profit less from low-tier training. 
	int time;			//Time (in rounds) spent for the training.
	double cost;		//The cost of the training
	double concentrationGain; //Standard gain for the Player's concentrationLevel.
	double reactionGain;	//Standard gain for the Player's reactionLevel.
	double energyGain;		//Standard gain for the Player's energyLevel. Most training reduce the energyLevel of the Player, making him tired.
	double healthGain;		//Standard gain for the Player's healthLevel.  
	double overallSkillGain;	//Gain on the skill variable.
	
	Training(int method){
		switch(method){
		case 0:
			name = "Casual Gaming";
			efficiencyTier = 1;
			cost = 0;
			concentrationGain = 0.001;
			reactionGain = 0.001;
			energyGain = -0.1;
			overallSkillGain = 0.001;
		case 1:
			name = "Ranked Gaming";
			efficiencyTier = 1;
			cost = 0;
			concentrationGain = 0.01;
			reactionGain = 0.01;
			energyGain = -0.2;
			overallSkillGain = 0.01;
		case 2:
			name = "Play Chess";
			efficiencyTier = 1;
			cost = 0;
			concentrationGain = 0.1;
			reactionGain = 0;
			energyGain = -0.1;
			overallSkillGain = 0;
		case 3:
			name = "Play FPS";
			efficiencyTier = 1;
			cost = 0;
			concentrationGain = 0;
			reactionGain = 0.1;
			energyGain = -0.1;
			overallSkillGain = 0;
		case 4:
			name = "Vacation";
			efficiencyTier = 3;
			cost = 100;
			time = 5;
			concentrationGain = 0.5;
			reactionGain = 0.1;
			energyGain = 1;
			overallSkillGain = 0;
		case 5:
			name = "Day off";
			efficiencyTier = 1;
			cost = 0;
			concentrationGain = 0.001;
			reactionGain = 0.001;
			energyGain = -0.1;
			overallSkillGain = 0.001;
		case 6:
			name = "Casual Gaming";
			efficiencyTier = 1;
			cost = 0;
			concentrationGain = 0.001;
			reactionGain = 0.001;
			energyGain = -0.1;
			overallSkillGain = 0.001;
		}
		
	}

}

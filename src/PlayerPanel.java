import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Panel containing information on a certain player
 * @author Dr Moebius
 *
 */
public class PlayerPanel extends JPanel {
	
	ManagerFrame home;
	Player plyr;
	JTextArea info;
	JButton backButton;
	public PlayerPanel(ManagerFrame _home,Player player){
		super();
		home=_home;
		plyr=player;
		info = new JTextArea();
		backButton = new JButton("BACK");
		add(info);
		add(backButton);
		info.setText(plyr.getInfo());
		for(int i= 0;i<player.heroSkill.length;i++){
			double number=Math.round(player.heroSkill[i]);
			number=number/100;
			info.setText(info.getText()+((Hero)home.data.heroes.get(i)).name +": " +number+"\n");
		}
		backButton.addActionListener(new BackListener());
		
	}
	class BackListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			PlayerPanel.this.home.switchPanel(1);
		
		}
	}
	/*
	 * TODO:
	 * -this should be the place where we approach a player to sign or fire
	 * -add more information on the player, such as wage etc.
	 */
}

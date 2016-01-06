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
		plyr=player;
		info = new JTextArea();
		backButton = new JButton("BACK");
		add(info);
		add(backButton);
		info.setText(plyr.getInfo());
		backButton.addActionListener(new BackListener());
		home=_home;
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

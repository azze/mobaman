import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.*;

/**
 * in this panel we can see what is going on with the team and its players, as well as gaining access to the player market
 * @author Dr Moebius
 *
 */
public class RosterPanel extends JPanel {
	ManagerFrame home;
	JList roster; //the players in the team
	JButton signButton; //go to the marketplace
	JButton backButton;
	Team team;
	
	public RosterPanel(ManagerFrame _home, Team _team){
		super();
		team=_team;
		home=_home;
		List names = new ArrayList();
		ListIterator litr = team.players.listIterator();
		while(litr.hasNext()){
			Player player = (Player) litr.next();
			names.add(player.name);
		}
		roster= new JList(names.toArray());
		roster.addMouseListener(new RosterMouse());
		backButton = new JButton("BACK");
		signButton = new JButton("FIND PLAYERS");
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(roster);
		add(signButton);
		add(backButton);
		signButton.addActionListener(new SignListener());
		backButton.addActionListener(new BackListener());
		 
	}
	class SignListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			RosterPanel.this.home.switchPanel(4);
			
		}
		
	}
	class BackListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			RosterPanel.this.home.switchPanel(1);
		
		}
	}
	class RosterMouse extends MouseAdapter{
		public void mouseClicked(MouseEvent evt){
			 JList list = (JList) evt.getSource();
		        if (evt.getClickCount() == 2) { // Double-click
		          int index = list.locationToIndex(evt.getPoint());
		          RosterPanel.this.home.showPlayer((Player) RosterPanel.this.team.players.get(index));
		        }
		}
	}
	/*
	 * TODO:
	 * -be able to set the positions in the team
	 * -choose what the players should be training
	 * -get a coach
	 */
}

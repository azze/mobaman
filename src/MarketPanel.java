import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * In this Panel we can look for players we need to join a team and approach them to offer a contract
 * @author Dr Moebius
 *
 */
public class MarketPanel extends JPanel {
	ManagerFrame home;
	JList availablePlayers;
	List plrs;
	JButton backButton;
	JButton hireButton;
	static int selected;
	public MarketPanel(ManagerFrame _home, List players){
		super();
		plrs=players;
		selected=0;
		home=_home;
		List names = new ArrayList();
		ListIterator litr = players.listIterator();
		while(litr.hasNext()){
			Player player = (Player) litr.next();
			names.add(player.name);
		}
		availablePlayers=new JList(names.toArray());
		hireButton = new JButton("HIRE");
		backButton = new JButton("BACK");
		add(availablePlayers);
		add(hireButton);
		add(backButton);
		hireButton.addActionListener(new HireListener());
		backButton.addActionListener(new BackListener());
		availablePlayers.addMouseListener(new PlayersMouse());
		availablePlayers.addListSelectionListener(new PlayerSelectionListener());
	}

	class HireListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			Player plyr =(Player) MarketPanel.this.plrs.get(MarketPanel.selected);
			plyr.setTeam(MarketPanel.this.home.data.myTeam);
			MarketPanel.this.home.data.myTeam.addPlayer(plyr);
			MarketPanel.this.home.switchPanel(4);
			home.data.addToInfo("Hired new Player: " +plyr.name);
		}
		
	}
	class PlayerSelectionListener implements ListSelectionListener{

		public void valueChanged(ListSelectionEvent e) {
			MarketPanel.selected=  e.getFirstIndex();
			
		}
		
	}
	class BackListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			MarketPanel.this.home.switchPanel(2);
		
		}
	}
	//double click on a player brings up his info
	class PlayersMouse extends MouseAdapter{
		public void mouseClicked(MouseEvent evt){
			 JList list = (JList) evt.getSource();
		        if (evt.getClickCount() == 2) { // Double-click
		          int index = list.locationToIndex(evt.getPoint());
		          MarketPanel.this.home.showPlayer((Player) MarketPanel.this.plrs.get(index));
		        }
		}
	}
	/*
	 * TODO:
	 * -add more info on the playres in the list
	 * -some sort of search/filter to easily find players we are looking for
	 */
}

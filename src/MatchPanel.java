import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

public class MatchPanel extends JPanel{
	ManagerFrame home;
	Match match;
	int playerSide;
	int startingTeam;
	List availableHeroes;
	DefaultListModel radiantList;
	DefaultListModel direList;
	JPanel pickPanel;
	JPanel playPanel;
	JPHLabel[] players;
	JButton[] heroButtons;
	JList direPicks;
	JList radiantPicks;
	int turn = 0;
	Random rand= new Random();
	public MatchPanel(ManagerFrame _home, Match _match){
		super();
		home=_home;
		match=_match;
		if(match.dire==home.data.myTeam)
			playerSide=1;
		else
			playerSide=0;
		startingTeam=rand.nextInt(2);
		pickPanel = new JPanel();
		playPanel = new JPanel();
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setupPickPanel();
		add(pickPanel);
		pickPanel.setVisible(true);
		
	}
	private void setupPickPanel() {
		radiantList= new DefaultListModel();
		direList= new DefaultListModel();
		JPanel radiantPanel = new JPanel();
		radiantPicks = new JList(radiantList);
		radiantList.addElement(match.radiant.name);
		radiantPanel.setLayout(new FlowLayout());
		JPanel direPanel = new JPanel();
		direPicks = new JList(direList);
		direList.addElement(match.dire.name);
		direPanel.setLayout(new FlowLayout());
		pickPanel.setLayout(new BorderLayout());
		pickPanel.add(radiantPanel,BorderLayout.WEST);
		pickPanel.add(direPanel, BorderLayout.EAST);
		radiantPanel.add(radiantPicks);
		direPanel.add(direPicks);
		radiantPanel.setVisible(true);
		direPanel.setVisible(true);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(3,5));
		buttonPanel.setVisible(true);
		availableHeroes=new ArrayList();
		ListIterator heroIter = home.data.heroes.listIterator();
		int i = 0;
		heroButtons= new JButton[home.data.heroes.size()];
		while(heroIter.hasNext()){
			Hero hero = (Hero) heroIter.next();
			availableHeroes.add(hero);
			JButton button = new JButton(hero.name);
			final int j=i;
			button.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					MatchPanel.this.pick(j);
					
					
				}
				
			});
			buttonPanel.add(button);
			heroButtons[i]=button;
			i++;
		}
		if(startingTeam!=playerSide)
			computerPick();
			
		pickPanel.add(buttonPanel, BorderLayout.CENTER);
		players= new JPHLabel[5];
		JPanel playerPanel = new JPanel();
		playerPanel.setLayout(new FlowLayout());
		Team mine;
		if(playerSide==0)
			mine=match.radiant;
		else
			mine= match.dire;
		for(int j=0;j<players.length;j++){
			players[j]=new JPHLabel();
			playerPanel.add(players[j]);
			players[j].setText(((Player)mine.players.get(j)).name);
		}
		
		JButton nextt = new JButton("next");
		nextt.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				MatchPanel.this.remove(pickPanel);
				MatchPanel.this.add(playPanel);
				MatchPanel.this.setupPlayPanel();
				
			}
		});
		playerPanel.add(nextt);
		pickPanel.add(playerPanel,BorderLayout.SOUTH);
		
	}
	private void computerPick() {
		int i = rand.nextInt(home.data.heroes.size()-turn);
		Hero hero =(Hero)home.data.heroes.get(i);
		if((playerSide+1)%2==0){
			radiantList.addElement(hero);
			match.radHeroes.add(hero);
		}
		else{
			direList.addElement(hero);
			match.dirHeroes.add(hero);
		}
		availableHeroes.remove(hero);
		heroButtons[i].setEnabled(false);
		turn++;
		if(turn==10){
			selectPhase();
		}
	}
	private void selectPhase() {
		for(int i= 0;i<heroButtons.length;i++)
			heroButtons[i].setEnabled(false);
		if(playerSide==0){
			radiantPicks.setDragEnabled(true);
			radiantPicks.setTransferHandler(new HeroTransferHandler());
			for(int i =0;i<players.length;i++){
				players[i].setTransferHandler(new HeroTransferHandler());
			}
			
		}
	}
	public void pick(int i) {
		Hero hero =(Hero)home.data.heroes.get(i);
		if(playerSide==0){
			radiantList.addElement(hero);
			match.radHeroes.add(hero);
		}
		else{
			direList.addElement(hero);
			match.dirHeroes.add(hero);
		}
		availableHeroes.remove(hero);
		heroButtons[i].setEnabled(false);
		turn++;
		if(turn==10){
			selectPhase();
		}
		else
			computerPick();
	}
	private void setupPlayPanel() {
		playPanel.setLayout(new BorderLayout());
		JTextArea result = new JTextArea();
		JButton next = new JButton("NEXT");
		next.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				MatchPanel.this.home.switchPanel(1);
			}
			
		});
		playPanel.add(result,BorderLayout.NORTH);
		playPanel.add(next, BorderLayout.SOUTH);
		playPanel.setVisible(true);
		double direSkill = match.dire.getAverageSkill();
		double radiantSkill = match.radiant.getAverageSkill();
		double sum = (direSkill+radiantSkill);
		direSkill=direSkill/sum;
		if(rand.nextDouble()<direSkill){
			match.setWinner(1);
			home.data.addToMessages(match.dire.name+ " won against " + match.radiant.name);
			result.setText("DIRE WINS");
		}
		else{
			match.setWinner(0);
			home.data.addToMessages(match.radiant.name+ " won against " + match.dire.name);
			result.setText("RADIANT WINS");
		}
		validate();
		repaint();
		
		
	}

}

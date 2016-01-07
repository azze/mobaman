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
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MatchPanel extends JPanel{
	ManagerFrame home;
	Match match;
	List availableHeroes;
	JPanel pickPanel;
	JPanel playPanel;
	JButton[] heroButtons;
	JTextArea direPicks;
	JTextArea radiantPicks;
	int turn = 0;
	public MatchPanel(ManagerFrame _home, Match _match){
		super();
		home=_home;
		match=_match;
		pickPanel = new JPanel();
		playPanel = new JPanel();
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setupPickPanel();
		add(pickPanel);
		pickPanel.setVisible(true);
	}
	private void setupPickPanel() {
		JPanel radiantPanel = new JPanel();
		radiantPicks = new JTextArea();
		radiantPicks.setText(match.radiant.name +": \n");
		radiantPanel.setLayout(new FlowLayout());
		JPanel direPanel = new JPanel();
		direPicks = new JTextArea();
		direPicks.setText(match.dire.name +": \n");
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
		pickPanel.add(buttonPanel, BorderLayout.CENTER);
		validate();
		repaint();
	}
	public void pick(int i) {
		Hero hero =(Hero)home.data.heroes.get(i);
		if(turn%2==0){
			radiantPicks.setText(radiantPicks.getText()+hero.name+"\n");
			match.radHeroes.add(hero);
		}
		else{
			direPicks.setText(direPicks.getText()+hero.name+"\n");
			match.dirHeroes.add(hero);
		}
		availableHeroes.remove(hero);
		heroButtons[i].setEnabled(false);
		turn++;
		if(turn==10){
			setupPlayPanel();
			remove(pickPanel);
			add(playPanel);
		}
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
		Random rand = new Random();
		if(rand.nextDouble()<direSkill){
			match.setWinner(1);
			result.setText("DIRE WINS");
		}
		else{
			match.setWinner(0);
			result.setText("RADIANT WINS");
		}
		validate();
		repaint();
		
		
	}

}

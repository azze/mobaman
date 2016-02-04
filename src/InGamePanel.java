import java.awt.*;
import java.awt.event.*;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InGamePanel extends JPanel {
	ManagerFrame home;
	int matchTime;
	JPanel radHerPanel;
	JPanel dirHerPanel;
	HeroInfoPanel heroInfoPanel;
	MatchInfoPanel matchInfoPanel;
	InGameHeroLabel[] radHerLabels;
	InGameHeroLabel[] dirHerLabels;
	Canvas canvas;
	List<InGameHero> direPicks;
	List<InGameHero> radiantPicks;
	int playerSide;
	
	public InGamePanel(List<InGameHero> direPicks,List<InGameHero> radiantPicks,int playerSide,ManagerFrame home){
		super();
		this.home=home;
		matchTime=0;
		this.direPicks=direPicks;
		this.radiantPicks=radiantPicks;
		this.playerSide=playerSide;
		setupGUI();
	}


	private void setupGUI() {
		radHerLabels = new InGameHeroLabel[5];
		dirHerLabels = new InGameHeroLabel[5];
		radHerPanel= new JPanel();
		radHerPanel.setLayout(new BoxLayout(radHerPanel, BoxLayout.Y_AXIS));
		dirHerPanel= new JPanel();
		dirHerPanel.setLayout(new BoxLayout(dirHerPanel, BoxLayout.Y_AXIS));
		for(int i=0;i<5;i++){
			radHerLabels[i]= new InGameHeroLabel(radiantPicks.get(i));
			dirHerLabels[i]= new InGameHeroLabel(direPicks.get(i));
			radHerPanel.add(radHerLabels[i]);
			dirHerPanel.add(dirHerLabels[i]);
			final int j=i;
			if(playerSide==1){
				dirHerLabels[i].addMouseListener(new MouseListener() {
					
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					public void mouseClicked(MouseEvent e) {
						heroInfoPanel.setInfo(direPicks.get(j));
						
					}
				});
				heroInfoPanel= new HeroInfoPanel(dirHerLabels[0].IHero);
			}
			else{
				radHerLabels[i].addMouseListener(new MouseListener() {
					
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					public void mouseClicked(MouseEvent e) {
						heroInfoPanel.setInfo(radiantPicks.get(j));
						
					}
				});
				heroInfoPanel= new HeroInfoPanel(radHerLabels[0].IHero);
			}
		}
		canvas = new Canvas();
		
		matchInfoPanel = new MatchInfoPanel();
		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(radHerPanel)
							.addComponent(heroInfoPanel))
					.addComponent(canvas)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
							.addComponent(dirHerPanel)
							.addComponent(matchInfoPanel))
		);
		layout.setVerticalGroup(
				layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(radHerPanel)
							.addComponent(canvas)
							.addComponent(dirHerPanel))
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
							.addComponent(heroInfoPanel)
							.addComponent(matchInfoPanel))
		);
	}
	public class HeroInfoPanel extends JPanel{
		JTextArea info;
		JComboBox<String> laneSelect;
		JComboBox<String> aggroSelect;
		InGameHero hero;
		public HeroInfoPanel(InGameHero hero){
			super();
			this.hero=hero;
			setupGUI();
		}
		public void setInfo(InGameHero hero) {
			info.setText(hero.getHeroName());
			this.hero=hero;
			laneSelect.setSelectedIndex(indexOfPos(hero.pos));
			aggroSelect.setSelectedIndex(indexOfAgg(hero.agg));
		}
		private int indexOfAgg(String agg) {
			if(agg.equals("aggressive"))
				return 0;
			else if(agg.equals("neutral"))
				return 1;
			else if (agg.equals("passive"))
				return 2;
			
			return 0;
		}
		private int indexOfPos(String pos) {
			if(pos.equals("top"))
				return 0;
			else if(pos.equals("bottom"))
				return 1;
			else if (pos.equals("middle"))
				return 2;
			else if (pos.equals("jungle"))
				return 3;
			
			return 0;
		}
		public void setupGUI(){
			info= new JTextArea();
			info.setText("info on the selected hero");
			laneSelect = new JComboBox<String>(new String[] {"top","bottom","middle","jungle"});
			aggroSelect = new JComboBox<String>(new String[] {"aggresive","neutral","passive"});
			laneSelect.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					JComboBox<String> combo = (JComboBox<String>)e.getSource();
                    String currentLane = (String) combo.getSelectedItem();
					hero.setPos(currentLane);
					InGamePanel.this.reloadLabels();
				}
			});
			aggroSelect.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					JComboBox<String> combo = (JComboBox<String>)e.getSource();
                    String currentAggro = (String) combo.getSelectedItem();
					hero.setAggro(currentAggro);
					InGamePanel.this.reloadLabels();
				}
			});
			add(aggroSelect);
			add(laneSelect);
			add(info);
		}
	}
	public class MatchInfoPanel extends JPanel{
		JTextArea info;
		JButton next;
		public MatchInfoPanel(){
			super();
			setupGUI();
		}
		public void setupGUI(){
			info = new JTextArea();
			info.setText("match info here");
			next= new JButton("NEXT");
			next.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					InGamePanel.this.home.switchPanel(1);
				}
				
			});
			add(info);
			add(next);
		}
	}
	protected void reloadLabels() {
		for(int i=0;i<5;i++){
			dirHerLabels[i].reload();
			radHerLabels[i].reload();
			repaint();
		}
	}

}
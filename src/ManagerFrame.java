import java.awt.BorderLayout;
import java.util.ListIterator;
import java.util.Random;

import javax.swing.*;


/**
 *this is our main window, this class should be used to switch between active panels in the game and to relay information between the database and 
 *the panels
 * @author Dr Moebius
 *
 */
public class ManagerFrame extends JFrame{
	JPanel currentPanel;
	DataBase data;
	Random rand= new Random();
	
	public ManagerFrame(String str, DataBase db){
		super(str);
		data=db;
		setContentPane(new BgPanel());
		setSize(1000, 600);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setup();
		
	}
	public void setup(){
		currentPanel = new StartPanel(this);
		add(BorderLayout.CENTER,currentPanel);
		setVisible(true);
	}
	public void switchPanel(int i) {
		remove(currentPanel);
		switch(i){
		case 0:
			currentPanel = new StartPanel(this);
			break;
		case 1: 
			currentPanel = new MainPanel(this);
			break;
		case 2:
			currentPanel = new RosterPanel(this, data.myTeam);
			break;
		case 3:
			currentPanel = new SchedulePanel(this);
			break;
		case 4:
			currentPanel = new MarketPanel(this, data.getUncontractedPlayers());
			break;
		//case 5:
			//currentPanel = new NewGamePanel(this);
			
		}
		add(BorderLayout.CENTER,currentPanel);
		setVisible(true);
		validate();
		repaint();
		
		
	}
	public void showPlayer(Player player) {
		remove(currentPanel);
		currentPanel = new PlayerPanel(this, player);
		add(BorderLayout.CENTER,currentPanel);
		setVisible(true);
		validate();
		repaint();
	}
	public void createContent() {
		ListIterator litr = data.pnames.listIterator();
		while(litr.hasNext()){
			double[] skill = new double[20];
			double avg=0;
			for(int i=0;i<20;i++){
				skill[i]=1+rand.nextGaussian()*0.2;
				avg+=skill[i];
			}
			avg=avg/20;
			data.players.add(new Player((String) litr.next(),skill,(int) (avg*100)));
			
		}
		litr = data.tnames.listIterator();
		while(litr.hasNext()){
			Team tm = new Team((String) litr.next());
			for(int i=0;i<5;i++){
				Player plyr = (Player) data.getUncontractedPlayers().get(0);
				tm.addPlayer(plyr);
				plyr.setTeam(tm);
			}
			data.teams.add(tm);
		}
		Tournament tourney =new Tournament("THE INTERNATIONAL",3,1,data.date+1);
		tourney.addTeam(data.myTeam);
		tourney.addTeam((Team) data.teams.get(0));
		tourney.addTeam((Team) data.teams.get(1));
		tourney.setup();
		data.addTournament(tourney);
		
	}
	
}

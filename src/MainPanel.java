import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * ingame this is the frame used to access all elements of the game, apart from a menu it contains basic information on upcoming matches and other news
 * @author Dr Moebius
 *
 */
public class MainPanel extends JPanel {
	ManagerFrame home;
	JButton rosterButton; //access to roster panel
	JButton scheduleButton; //access to schedule panel
	JButton timeButton; //let time pass in the game
	JButton saveButton; //save the game
	JButton exitButton; 
	JTextArea infoText;
	JTextArea matchesText;
	Dimension textAreasDimension = new Dimension(400,200);
	Dimension dateDimension = new Dimension(200,80);
	Dimension thumbnailDimension = new Dimension(100,150);
	
	//setup the visual elements
	public MainPanel(ManagerFrame _home){
		
		super();
		home=_home;
		initGUI();
		
		
/*
		this.setBackground(Color.BLACK);
		this.setOpaque(true);
		
		
		JPanel messagesAndScorelist = new JPanel();
		messagesAndScorelist.setLayout(new FlowLayout());
		JTextArea messages = new JTextArea();
		messages.setPreferredSize(textAreasDimension);
		JTextArea scorelist = new JTextArea();
		scorelist.setPreferredSize(textAreasDimension);
		messagesAndScorelist.setPreferredSize(new Dimension(400,400));
		messagesAndScorelist.add(messages);
		messagesAndScorelist.add(scorelist);
		messagesAndScorelist.setBackground(Color.BLACK);
		messagesAndScorelist.setOpaque(true);
		this.add(messagesAndScorelist, BorderLayout.WEST);
		
		JPanel moneyAndInfo = new JPanel();
		moneyAndInfo.setLayout(new FlowLayout());
		JTextArea money = new JTextArea("Money");
		money.setPreferredSize(textAreasDimension);
		JTextArea info = new JTextArea("Info");
		info.setPreferredSize(textAreasDimension);
		moneyAndInfo.setPreferredSize(new Dimension(400,400));
		moneyAndInfo.add(money);
		moneyAndInfo.add(info);
		moneyAndInfo.setBackground(Color.BLACK);
		moneyAndInfo.setOpaque(true);
		this.add(moneyAndInfo, BorderLayout.EAST);
		
		JPanel dateAndTournaments = new JPanel();
		dateAndTournaments.setLayout(new GridLayout(5,1));
		JLabel dayRound = new JLabel("Day/Round");
		dayRound.setPreferredSize(dateDimension);
		JLabel roundsToEvent = new JLabel("Rounds to Event");
		roundsToEvent.setPreferredSize(dateDimension);
		JLabel nextTournament = new JLabel("Next Tournament");
		nextTournament.setPreferredSize(dateDimension);
		JLabel lastPlayedTournament = new JLabel("Last played tournament");
		lastPlayedTournament.setPreferredSize(dateDimension);
		dateAndTournaments.setPreferredSize(new Dimension(200,400));
		dateAndTournaments.add(dayRound);
		dateAndTournaments.add(roundsToEvent);
		dateAndTournaments.add(nextTournament);
		dateAndTournaments.add(lastPlayedTournament);
		dateAndTournaments.setBackground(Color.BLACK);
		dateAndTournaments.setOpaque(true);
		this.add(dateAndTournaments, BorderLayout.CENTER);
		
		
		JPanel playersAndButtons = new JPanel();
		playersAndButtons.setLayout(new BorderLayout());
		JPanel playersPanel = new JPanel();
		playersPanel.setLayout(new GridLayout(1,7,20,20));
		playersPanel.setPreferredSize(new Dimension(1000,150));
		JLabel playerThumbnail1 = new JLabel("Player 1");
		playerThumbnail1.setBackground(Color.CYAN);
		playerThumbnail1.setPreferredSize(thumbnailDimension);
		playerThumbnail1.setOpaque(true);
		JLabel playerThumbnail2 = new JLabel("Player 2");
		playerThumbnail2.setBackground(Color.GREEN);
		playerThumbnail2.setPreferredSize(thumbnailDimension);
		playerThumbnail2.setOpaque(true);
		JLabel playerThumbnail3 = new JLabel("Player 3");
		playerThumbnail3.setBackground(Color.MAGENTA);
		playerThumbnail3.setPreferredSize(thumbnailDimension);
		playerThumbnail3.setOpaque(true);
		JLabel playerThumbnail4 = new JLabel("Player 4");
		playerThumbnail4.setBackground(Color.ORANGE);
		playerThumbnail4.setPreferredSize(thumbnailDimension);
		playerThumbnail4.setOpaque(true);
		JLabel playerThumbnail5 = new JLabel("Player 5");
		playerThumbnail5.setBackground(Color.YELLOW);
		playerThumbnail5.setPreferredSize(thumbnailDimension);
		playerThumbnail5.setOpaque(true);
		JLabel playerThumbnail6 = new JLabel("Player 6");
		playerThumbnail6.setBackground(Color.RED);
		playerThumbnail6.setPreferredSize(thumbnailDimension);
		playerThumbnail6.setOpaque(true);
		JLabel playerThumbnail7 = new JLabel("Player 7");
		playerThumbnail7.setBackground(Color.BLUE);
		playerThumbnail7.setPreferredSize(thumbnailDimension);
		playerThumbnail7.setOpaque(true);
		playersPanel.add(playerThumbnail1);
		playersPanel.add(playerThumbnail2);
		playersPanel.add(playerThumbnail3);
		playersPanel.add(playerThumbnail4);
		playersPanel.add(playerThumbnail5);
		playersPanel.add(playerThumbnail6);
		playersPanel.add(playerThumbnail7);
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		buttons.setPreferredSize(new Dimension(1000,50));
		
		rosterButton = new JButton("ROSTER");
		scheduleButton = new JButton("SCHEDULE");
		timeButton = new JButton("NEXT");
		saveButton = new JButton("SAVE");
		exitButton = new JButton("EXIT");
		
		buttons.add(rosterButton);
		buttons.add(scheduleButton);
		buttons.add(timeButton);
		buttons.add(saveButton);
		buttons.add(exitButton);
		buttons.setBackground(Color.BLACK);
		buttons.setOpaque(true);
		
		playersAndButtons.setPreferredSize(new Dimension(1000,200));
		playersAndButtons.add(playersPanel, BorderLayout.NORTH);
		playersAndButtons.add(buttons, BorderLayout.SOUTH);
		playersAndButtons.setBackground(Color.BLACK);
		playersAndButtons.setOpaque(true);
		this.add(playersAndButtons, BorderLayout.SOUTH);
*/		
		
		//infoText = new JTextArea(30,25);
		//infoText.setSize(300, 500);
		
		//matchesText = new JTextArea();
		
		//this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		//JPanel panel1 = new JPanel();
		//JPanel panel2 = new JPanel();
		//JPanel panel3 = new JPanel();
		//JPanel panel4 = new JPanel();
		//JPanel panel5 = new JPanel();
		//JPanel panel6 = new JPanel();
		
		//panel6.setSize(900, 500);
		
		//panel1.setSize(300, 500);
		//panel3.setSize(300, 500);
		//panel4.setSize(300, 500);
		
		//panel6.setLayout(new GridLayout(3,0));
		//this.add(panel6, BorderLayout.CENTER);
		
		//panel6.add(panel1);
		//this.add(panel2,BorderLayout.SOUTH);
		//panel6.add(panel3);
		//panel6.add(panel4);
		//this.add(panel5, BorderLayout.NORTH);
		
		//BorderLayout panel2Layout = new BorderLayout();
		//panel2.setLayout(panel2Layout);
		//JPanel panel21 = new JPanel();
		//JPanel panel22 = new JPanel();
		//JPanel panel23 = new JPanel();
		
		//panel22.setLayout(new FlowLayout());
		
		//panel2.add(panel21,panel2Layout.WEST);
		//panel2.add(panel22,panel2Layout.CENTER);
		//panel2.add(panel23,panel2Layout.EAST);
		
		

		
		
		//panel1.add(infoText);
		//infoText.setVisible(true);
		//panel4.add(matchesText);
		//panel22.add(rosterButton);
		//panel22.add(scheduleButton);
		//panel22.add(timeButton);
		//panel22.add(saveButton);
		//panel22.add(exitButton);
		
		//matchesText.setText(home.data.getNextGames());
		
		rosterButton.addActionListener(new RosterListener());
		scheduleButton.addActionListener(new ScheduleListener());
		timeButton.addActionListener(new TimeListener());
		saveButton.addActionListener(new SaveListener());
		exitButton.addActionListener(new ExitListener());
	}
	public void initGUI(){
		
		this.setLayout(new BorderLayout());
		this.setBackground(Color.BLACK);
		this.setOpaque(true);
		
		
		JPanel messagesAndScorelist = new JPanel();
		messagesAndScorelist.setLayout(new FlowLayout());
		JTextArea messages = new JTextArea();
		messages.setPreferredSize(textAreasDimension);
		JTextArea scorelist = new JTextArea();
		scorelist.setPreferredSize(textAreasDimension);
		messagesAndScorelist.setPreferredSize(new Dimension(400,400));
		messagesAndScorelist.add(messages);
		messagesAndScorelist.add(scorelist);
		messagesAndScorelist.setBackground(Color.BLACK);
		messagesAndScorelist.setOpaque(true);
		this.add(messagesAndScorelist, BorderLayout.WEST);
		
		JPanel moneyAndInfo = new JPanel();
		moneyAndInfo.setLayout(new FlowLayout());
		JTextArea money = new JTextArea("Money");
		money.setPreferredSize(textAreasDimension);
		JTextArea info = new JTextArea("Info");
		info.setPreferredSize(textAreasDimension);
		moneyAndInfo.setPreferredSize(new Dimension(400,400));
		moneyAndInfo.add(money);
		moneyAndInfo.add(info);
		moneyAndInfo.setBackground(Color.BLACK);
		moneyAndInfo.setOpaque(true);
		this.add(moneyAndInfo, BorderLayout.EAST);
		
		JPanel dateAndTournaments = new JPanel();
		dateAndTournaments.setLayout(new GridLayout(5,1));
		JLabel dayRound = new JLabel("Day/Round");
		dayRound.setPreferredSize(dateDimension);
		JLabel roundsToEvent = new JLabel("Rounds to Event");
		roundsToEvent.setPreferredSize(dateDimension);
		JLabel nextTournament = new JLabel("Next Tournament");
		nextTournament.setPreferredSize(dateDimension);
		JLabel lastPlayedTournament = new JLabel("Last played tournament");
		lastPlayedTournament.setPreferredSize(dateDimension);
		dateAndTournaments.setPreferredSize(new Dimension(200,400));
		dateAndTournaments.add(dayRound);
		dateAndTournaments.add(roundsToEvent);
		dateAndTournaments.add(nextTournament);
		dateAndTournaments.add(lastPlayedTournament);
		dateAndTournaments.setBackground(Color.BLACK);
		dateAndTournaments.setOpaque(true);
		this.add(dateAndTournaments, BorderLayout.CENTER);
		
		/*
		 * the following code block creates a visual representation of the own current roster.
		 * It will be replaced with a method createRosterGUI().
		 * This method will iterate through the current roster, creating a visual representation of
		 * every Player in the roster. 
		 * Changing the roster will update the GUI by calling updateRosterGUI(), which will dispose every
		 * component of the rosterGUI Panel and calling createRosterGUI() again.  
		 */
		
		JPanel playersAndButtons = new JPanel();
		playersAndButtons.setLayout(new BorderLayout());
		JPanel playersPanel = new JPanel();
		playersPanel.setLayout(new GridLayout(1,7,20,20));
		playersPanel.setPreferredSize(new Dimension(1000,150));
		JLabel playerThumbnail1 = new JLabel("Player 1");
		playerThumbnail1.setBackground(Color.CYAN);
		playerThumbnail1.setPreferredSize(thumbnailDimension);
		playerThumbnail1.setOpaque(true);
		JLabel playerThumbnail2 = new JLabel("Player 2");
		playerThumbnail2.setBackground(Color.GREEN);
		playerThumbnail2.setPreferredSize(thumbnailDimension);
		playerThumbnail2.setOpaque(true);
		JLabel playerThumbnail3 = new JLabel("Player 3");
		playerThumbnail3.setBackground(Color.MAGENTA);
		playerThumbnail3.setPreferredSize(thumbnailDimension);
		playerThumbnail3.setOpaque(true);
		JLabel playerThumbnail4 = new JLabel("Player 4");
		playerThumbnail4.setBackground(Color.ORANGE);
		playerThumbnail4.setPreferredSize(thumbnailDimension);
		playerThumbnail4.setOpaque(true);
		JLabel playerThumbnail5 = new JLabel("Player 5");
		playerThumbnail5.setBackground(Color.YELLOW);
		playerThumbnail5.setPreferredSize(thumbnailDimension);
		playerThumbnail5.setOpaque(true);
		JLabel playerThumbnail6 = new JLabel("Player 6");
		playerThumbnail6.setBackground(Color.RED);
		playerThumbnail6.setPreferredSize(thumbnailDimension);
		playerThumbnail6.setOpaque(true);
		JLabel playerThumbnail7 = new JLabel("Player 7");
		playerThumbnail7.setBackground(Color.BLUE);
		playerThumbnail7.setPreferredSize(thumbnailDimension);
		playerThumbnail7.setOpaque(true);
		playersPanel.add(playerThumbnail1);
		playersPanel.add(playerThumbnail2);
		playersPanel.add(playerThumbnail3);
		playersPanel.add(playerThumbnail4);
		playersPanel.add(playerThumbnail5);
		playersPanel.add(playerThumbnail6);
		playersPanel.add(playerThumbnail7);
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		buttons.setPreferredSize(new Dimension(1000,50));
		
		rosterButton = new JButton("ROSTER");
		scheduleButton = new JButton("SCHEDULE");
		timeButton = new JButton("NEXT");
		saveButton = new JButton("SAVE");
		exitButton = new JButton("EXIT");
		
		buttons.add(rosterButton);
		buttons.add(scheduleButton);
		buttons.add(timeButton);
		buttons.add(saveButton);
		buttons.add(exitButton);
		buttons.setBackground(Color.BLACK);
		buttons.setOpaque(true);
		
		playersAndButtons.setPreferredSize(new Dimension(1000,200));
		playersAndButtons.add(playersPanel, BorderLayout.NORTH);
		playersAndButtons.add(buttons, BorderLayout.SOUTH);
		playersAndButtons.setBackground(Color.BLACK);
		playersAndButtons.setOpaque(true);
		this.add(playersAndButtons, BorderLayout.SOUTH);
		
		rosterButton.addActionListener(new RosterListener());
		scheduleButton.addActionListener(new ScheduleListener());
		timeButton.addActionListener(new TimeListener());
		saveButton.addActionListener(new SaveListener());
		exitButton.addActionListener(new ExitListener());
		
		
	}
	public void createRosterGUI(){
		
	}
	
	public void updateRosterGUI(){
		
		
		
	}
	class RosterListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			MainPanel.this.home.switchPanel(2);
		
		}
	}
	class ScheduleListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			MainPanel.this.home.switchPanel(3);
		
		}
	}
	class TimeListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			home.data.date++;
			matchesText.setText(home.data.getNextGames());
		
		}
	}
	class SaveListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		
		}
	}
	class ExitListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			MainPanel.this.home.switchPanel(0);
		
		}
	}
	/*
	 * TODO:
	 * - add content to information and schedule textfields
	 * - add functionality to the next button
	 * - add functionality to the save button
	 */
	
}

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

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
	String infoString = "";

	
	
	//setup the visual elements
	public MainPanel(ManagerFrame _home){
		
		super();
		super.setPreferredSize(new Dimension(1000,600));
		home=_home;
		initGUI();
		
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
		
		this.add(createMessagesAndScorelistGUI(), BorderLayout.WEST);
		this.add(createMoneyAndInfoGUI(), BorderLayout.EAST);
		this.add(createDateAndTournamentsGUI(), BorderLayout.CENTER);		
		this.add(createPlayersAndButtonsGUI(), BorderLayout.SOUTH);
		
		rosterButton.addActionListener(new RosterListener());
		scheduleButton.addActionListener(new ScheduleListener());
		timeButton.addActionListener(new TimeListener());
		saveButton.addActionListener(new SaveListener());
		exitButton.addActionListener(new ExitListener());
		
		
	}
	public JPanel createMessagesAndScorelistGUI(){
		
		JPanel messagesAndScorelist = new JPanel();
		messagesAndScorelist.setLayout(new FlowLayout());
		messagesAndScorelist.setPreferredSize(new Dimension(400,400));
		messagesAndScorelist.add(createMessages());
		messagesAndScorelist.add(createRankingTable());
		messagesAndScorelist.setBackground(Color.BLACK);
		messagesAndScorelist.setOpaque(false);
		
		return messagesAndScorelist;
		
	}
	public JTextPane createMessages(){
		
		JTextPane messages = new JTextPane();
		messages.setPreferredSize(textAreasDimension);
		
		StyleContext messagesContext = new StyleContext();		
		StyledDocument messagesDocument = new DefaultStyledDocument(messagesContext);
		Style messagesStyle = messagesContext.getStyle(StyleContext.DEFAULT_STYLE);
		StyleConstants.setFontSize(messagesStyle,15);
		StyleConstants.setAlignment(messagesStyle, StyleConstants.ALIGN_LEFT);
		StyleConstants.setForeground(messagesStyle, Color.WHITE);
    
		try {
			messagesDocument.insertString(messagesDocument.getLength(),home.data.messagesText, messagesStyle);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		messages.setDocument(messagesDocument);
		messages.setOpaque(false);
		messages.setPreferredSize(new Dimension(400,200));

		return messages;
		
	}
	public JScrollPane createRankingTable(){
		
		Object rowData[][] = new Object[home.data.teams.size()][5];	
		Object columnNames[] = { "Rank","Team", "Rating","Win Rate","Trend"};
		ListIterator litr = home.data.teams.listIterator();
		int i = 0;
		
		while(litr.hasNext()){		
			Team t = (Team) litr.next();
			rowData[i][0] = i+1;
			rowData[i][1] = t.name;
			System.out.println(t.name);
			i++;
		}
		
		JTable scorelist = new JTable(rowData,columnNames);
		scorelist.setPreferredSize(textAreasDimension);
		JScrollPane scrollpane = new JScrollPane(scorelist);
		scrollpane.setPreferredSize(new Dimension(400,200));
		scorelist.setForeground(Color.ORANGE);
		scorelist.setBackground(Color.BLACK);
		scorelist.setOpaque(true);
		scrollpane.setOpaque(false);
		
      return scrollpane;
		
	}
	public JPanel createDateAndTournamentsGUI(){
		
		JPanel dateAndTournaments = new JPanel();
		dateAndTournaments.setLayout(new GridLayout(4,1));
		dateAndTournaments.setPreferredSize(new Dimension(200,100));
		dateAndTournaments.add(createDayRoundGUI());
		dateAndTournaments.add(createRoundsToEventGUI());
		dateAndTournaments.add(createNextTournamentGUI());
		dateAndTournaments.add(createLastPlayedTournamentGUI());
		dateAndTournaments.setBackground(Color.BLACK);
		dateAndTournaments.setOpaque(true);
		
		return dateAndTournaments;
		
	}
	public JTextPane createDayRoundGUI(){
		
		JTextPane dayRound = new JTextPane();
		dayRound.setOpaque(false);
		dayRound.setPreferredSize(dateDimension);
		StyleContext dayRoundContext = new StyleContext();
		StyledDocument dayRoundDocument = new DefaultStyledDocument(dayRoundContext);
	
		Style dayRoundStyle = dayRoundContext.getStyle(StyleContext.DEFAULT_STYLE);
		StyleConstants.setFontSize(dayRoundStyle,20);
		StyleConstants.setAlignment(dayRoundStyle, StyleConstants.ALIGN_CENTER);
		StyleConstants.setForeground(dayRoundStyle, Color.WHITE);
    
		try {
			dayRoundDocument.insertString(dayRoundDocument.getLength(),"Day " +Integer.toString(home.data.date), dayRoundStyle);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		dayRound.setDocument(dayRoundDocument);
		
		return dayRound;
		
	}
	public JTextPane createRoundsToEventGUI(){
		
		JTextPane roundsToEvent = new JTextPane();
		roundsToEvent.setOpaque(false);
		roundsToEvent.setPreferredSize(dateDimension);
		
		StyleContext roundsToEventContext = new StyleContext();
		StyledDocument roundsToEventDocument = new DefaultStyledDocument(roundsToEventContext);
		
		Style roundsToEventStyle = roundsToEventContext.getStyle(StyleContext.DEFAULT_STYLE);
		StyleConstants.setFontSize(roundsToEventStyle,20);
		StyleConstants.setAlignment(roundsToEventStyle, StyleConstants.ALIGN_CENTER);
		StyleConstants.setForeground(roundsToEventStyle, Color.WHITE);
		try {
			roundsToEventDocument.insertString(roundsToEventDocument.getLength(),"Time to next Event: "+"\n" +Integer.toString(home.data.timeToNextTournament())  +"Days", roundsToEventStyle);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		roundsToEvent.setDocument(roundsToEventDocument);
		
		return roundsToEvent;
		
	}
	public JTextPane createNextTournamentGUI(){
		
		JTextPane nextTournament = new JTextPane();
		nextTournament.setPreferredSize(new Dimension(200,400));
		
		StyleContext nextTournamentContext = new StyleContext();
		StyledDocument nextTournamentDocument = new DefaultStyledDocument(nextTournamentContext);
	
		Style nextTournamentStyle = nextTournamentContext.getStyle(StyleContext.DEFAULT_STYLE);
		StyleConstants.setFontSize(nextTournamentStyle,20);
		StyleConstants.setAlignment(nextTournamentStyle, StyleConstants.ALIGN_CENTER);
		StyleConstants.setForeground(nextTournamentStyle, Color.WHITE);
    
		try {
			nextTournamentDocument.insertString(nextTournamentDocument.getLength(),home.data.getNextGames(), nextTournamentStyle);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		nextTournament.setDocument(nextTournamentDocument);
		nextTournament.setOpaque(false);
		
		return nextTournament;
		
	}
	public JLabel createLastPlayedTournamentGUI(){
		
		JLabel lastPlayedTournament = new JLabel("Last played tournament");
		lastPlayedTournament.setPreferredSize(dateDimension);
		
		return lastPlayedTournament;
		
	}
	public JPanel createMoneyAndInfoGUI(){
		
		JPanel moneyAndInfo = new JPanel();
		moneyAndInfo.setLayout(new FlowLayout());
		moneyAndInfo.setPreferredSize(new Dimension(400,400));	
		moneyAndInfo.add(createMoneyGUI());
		moneyAndInfo.add(createInfoGUI());
		moneyAndInfo.setBackground(Color.BLACK);
		moneyAndInfo.setOpaque(false);
		
		return moneyAndInfo;
		
	}
	public JPanel createPlayersAndButtonsGUI(){
		
		JPanel playersAndButtons = new JPanel();
		playersAndButtons.setLayout(new BorderLayout());
		/*
		JPanel playersPanel = new JPanel();
		playersPanel.setLayout(new GridLayout(1,7,20,20));
		playersPanel.setPreferredSize(new Dimension(1000,100));
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
		*/
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
		
		playersAndButtons.setPreferredSize(new Dimension(1000,150));
		//playersAndButtons.add(playersPanel, BorderLayout.NORTH);
		playersAndButtons.add(buttons, BorderLayout.SOUTH);
		playersAndButtons.setBackground(Color.BLACK);
		playersAndButtons.setOpaque(true);
		
		return playersAndButtons;
		
	}
	public JTextPane createInfoGUI(){
		
		JTextPane info = new JTextPane();
		info.setEditable(false);
		StyleContext infoContext = new StyleContext();
		StyledDocument infoDocument = new DefaultStyledDocument(infoContext);
	
		Style infoStyle = infoContext.getStyle(StyleContext.DEFAULT_STYLE);
		StyleConstants.setFontSize(infoStyle,20);
		StyleConstants.setAlignment(infoStyle, StyleConstants.ALIGN_LEFT);
		StyleConstants.setForeground(infoStyle, Color.BLUE);
    
		try {
			infoDocument.insertString(infoDocument.getLength(),setInfoText(), infoStyle);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		info.setDocument(infoDocument);
		info.setOpaque(false);
		info.setPreferredSize(new Dimension(400,500));
		
		return info;
		
	}
	public JTextPane createMoneyGUI(){
		
		JTextPane money = new JTextPane();
		money.setEditable(false);

		
		StyleContext moneyContext = new StyleContext();		
		StyledDocument moneyDocument = new DefaultStyledDocument(moneyContext);
	

		Style moneyStyle = moneyContext.getStyle(StyleContext.DEFAULT_STYLE);
		StyleConstants.setFontSize(moneyStyle,30);
		StyleConstants.setAlignment(moneyStyle, StyleConstants.ALIGN_RIGHT);
		StyleConstants.setForeground(moneyStyle, Color.GREEN);
    
		try {
			moneyDocument.insertString(moneyDocument.getLength(),"$" +Integer.toString(home.data.myTeam.money), moneyStyle);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		money.setDocument(moneyDocument);
		money.setOpaque(false);
		money.setPreferredSize(new Dimension(400,100));
		
		return money;
		
	}
	public void createRosterGUI(){
		
	}
	
	public void updateRosterGUI(){	
		
	}
	public String setInfoText(){
		
		return home.data.infoText;
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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

/**
 * in this panel we can see what is going on with the team and its players, as well as gaining access to the player market
 * @author Dr Moebius
 *
 */
public class RosterPanel extends JPanel {
	ManagerFrame home;
	JList roster; //the players in the team
	JButton signButton = new JButton("Find Players"); //go to the marketplace
	JButton backButton = new JButton("Back");
	Team team;
	JPanel currentPlayersGUI = new JPanel();
	JPanel rosterBackgroundPanel = new JPanel();
	JTextPane headerGUI = new JTextPane();
	JPanel infoAndCurrentPlayersContainer = new JPanel();
	JTextPane infoGUI = new JTextPane();
	JPanel selectedPlayerInfoGUI = new JPanel();
	JPanel buttonContainer = new JPanel();
	List names = new ArrayList();
	PlayerThumbnail thumb;
	
	
	public RosterPanel(ManagerFrame _home, Team _team){
		super();
		this.setBackground(Color.yellow);
		team=_team;
		home=_home;
		

		ListIterator litr = team.players.listIterator();
		while(litr.hasNext()){
			Player player = (Player) litr.next();
			names.add(player.name);
			
		}
		//roster= new JList(names.toArray());
		//roster.addMouseListener(new RosterMouse());

		setLayout(new BorderLayout());

		signButton.addActionListener(new SignListener());
		backButton.addActionListener(new BackListener());
		
		add(createRosterGUI(),BorderLayout.CENTER);
		 
	}

	public JPanel createRosterGUI(){
			
		rosterBackgroundPanel.setLayout(new BorderLayout());
		
		rosterBackgroundPanel.add(createSelectedPlayerInfoGUI(), BorderLayout.WEST);
		rosterBackgroundPanel.add(createInfoAndCurrentPlayersContainer(), BorderLayout.EAST);
		rosterBackgroundPanel.add(createHeaderGUI(),BorderLayout.NORTH);
		rosterBackgroundPanel.add(createbuttonContainer(),BorderLayout.SOUTH);
		
		rosterBackgroundPanel.setBackground(Color.BLACK);
		
		return rosterBackgroundPanel;
			
	}
	public JTextPane createHeaderGUI(){
		

		headerGUI.setPreferredSize(new Dimension(1000,50));
		headerGUI.setBackground(Color.blue);
		
		return headerGUI;
		
	}
	public JPanel createInfoAndCurrentPlayersContainer(){
		

		infoAndCurrentPlayersContainer.setLayout(new FlowLayout());
		infoAndCurrentPlayersContainer.setPreferredSize(new Dimension(600,500));
		infoAndCurrentPlayersContainer.add(createInfoGUI());
		infoAndCurrentPlayersContainer.add(createCurrentPlayersGUI());
		
		return infoAndCurrentPlayersContainer;
		
		
	}
	public JTextPane createInfoGUI(){
		

		infoGUI.setPreferredSize(new Dimension(580,320));
		
		StyleContext infoContext = new StyleContext();		
		StyledDocument infoDocument = new DefaultStyledDocument(infoContext);
		Style infoStyle = infoContext.getStyle(StyleContext.DEFAULT_STYLE);
		StyleConstants.setFontSize(infoStyle,15);
		StyleConstants.setAlignment(infoStyle, StyleConstants.ALIGN_LEFT);
		StyleConstants.setForeground(infoStyle, Color.GREEN);
    
		try {
			infoDocument.insertString(infoDocument.getLength(),home.data.messagesText, infoStyle);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		infoGUI.setDocument(infoDocument);
		infoGUI.setOpaque(false);
		
		return infoGUI;
		
	}
	public JPanel createCurrentPlayersGUI(){
		

		currentPlayersGUI.setPreferredSize(new Dimension(600,200));
		currentPlayersGUI.setLayout(new FlowLayout());
		
			int currentPlayerCount = home.data.myTeam.players.size();
			
			ListIterator litr = home.data.myTeam.players.listIterator();
			
			JLabel testLabel2 = new JLabel("hallo");
			testLabel2.setBackground(Color.PINK);
			testLabel2.setPreferredSize(new Dimension(100,200));
			testLabel2.setOpaque(true);
			currentPlayersGUI.add(testLabel2);
			
			while(litr.hasNext()){
								
				Player player =(Player)litr.next();
				
				
				
				/*
				thumb = new PlayerThumbnail(player);
				thumb.setPreferredSize(new Dimension(100,200));
				thumb.setOpaque(true);
				thumb.setVisible(true);
				thumb.setBackground(Color.MAGENTA);
				currentPlayersGUI.add(thumb);
				*/
				
				JLabel testLabel = new JLabel("hallo");
				testLabel.setBackground(Color.GREEN);
				testLabel.setPreferredSize(new Dimension(100,200));
			}
			currentPlayersGUI.setBackground(Color.CYAN);
				
		return currentPlayersGUI;
		
	}

	public JPanel createSelectedPlayerInfoGUI(){
		
		selectedPlayerInfoGUI.setPreferredSize(new Dimension(400,500));
		selectedPlayerInfoGUI.setBackground(Color.ORANGE);
		
		
		return selectedPlayerInfoGUI;
		
	}
	public JPanel createbuttonContainer(){
		

		buttonContainer.setLayout(new BorderLayout());
		JPanel buttonGUI = new JPanel();
		buttonGUI.setLayout(new FlowLayout());
		buttonGUI.setPreferredSize(new Dimension(1000,50));
		buttonGUI.add(signButton);
		buttonGUI.add(backButton);
		buttonContainer.add(buttonGUI);
		
		return buttonContainer;
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

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * the panel where we find tournaments to join and manage upcoming dates
 * @author Dr Moebius
 *
 */
public class SchedulePanel extends JPanel {

	ManagerFrame home;
	JTextArea nextMatches;
	JTextArea ongoingTournaments;
	JTextArea upcomingTournaments;
	JButton back;
	
	public SchedulePanel(ManagerFrame _home){
		super();
		home=_home;
		setLayout(new BorderLayout());
		nextMatches= new JTextArea();
		nextMatches.setText(home.data.getNextGames());
		ongoingTournaments = new JTextArea();
		Tournament[] ongTour = home.data.getOngoingTournaments();
		for(int i =0;i<ongTour.length;i++)
			ongoingTournaments.setText(ongoingTournaments.getText()+ongTour[i].name+"\n");
		upcomingTournaments = new JTextArea();
		Tournament[] upcTour = home.data.getUpcomingTournaments();
		for(int i =0;i<upcTour.length;i++)
			ongoingTournaments.setText(ongoingTournaments.getText()+upcTour[i].name+"\n");
		back = new JButton("BACK");
		back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				SchedulePanel.this.home.switchPanel(1);
				
			}
		});
		add(nextMatches, BorderLayout.NORTH);
		add(ongoingTournaments,BorderLayout.WEST);
		add(upcomingTournaments, BorderLayout.EAST);
		add(back, BorderLayout.SOUTH);
		setVisible(true);
		validate();
		repaint();
	}
	/*
	 * TODO:
	 * -everything
	 */
}

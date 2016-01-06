import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class NewGamePanel extends JDialog {
	ManagerFrame home;
	JLabel teamLabel;
	JTextField teamField;
	JButton go;
	public NewGamePanel(ManagerFrame _home){
		super();
		home=_home;
		teamLabel = new JLabel("Name your Team");
		teamField = new JTextField(20);
		go = new JButton("GO");
		setLayout(new FlowLayout(3));
		add(teamLabel);
		add(teamField);
		add(go);
		go.addActionListener(new GoAction());
	}
	class GoAction implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			Team myTeam = new Team(teamField.getText());
			NewGamePanel.this.home.data.myTeam=myTeam;
			NewGamePanel.this.home.createContent();
			NewGamePanel.this.home.switchPanel(1);
			NewGamePanel.this.dispose();
		}
		
	}
}

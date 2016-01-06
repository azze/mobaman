
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StartPanel extends JPanel {
	ManagerFrame home;
	int dialogWidth = 250;
	int dialogHeight = 200;
	
	public StartPanel(ManagerFrame _home){
		
		super();	
		home=_home;		
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		
		JPanel contentPanel = new JPanel();
		contentPanel.setOpaque(false);
		contentPanel.setLayout(new BorderLayout());
		this.add(contentPanel,BorderLayout.CENTER);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setOpaque(false);
		contentPanel.add(bottomPanel,BorderLayout.SOUTH);
		
		JPanel buttonpanel = new JPanel();
		buttonpanel.setOpaque(false);
		bottomPanel.add(buttonpanel,BorderLayout.CENTER);
		buttonpanel.setLayout(new FlowLayout());
		
		JButton neu = new JButton("New");
		JButton load = new JButton("Load");
		JButton exit = new JButton("Exit");
		
		neu.setToolTipText("Start a new Game");
		load.setToolTipText("Load an existing Game");
		exit.setToolTipText("Exit MOBA Manager");

		buttonpanel.add(neu);
		buttonpanel.add(load);
		buttonpanel.add(exit);
		neu.addActionListener(new NewListener());
		
	}

	class NewListener implements ActionListener{

		public void actionPerformed(ActionEvent e ) {
			//StartPanel.this.home.switchPanel(5);
			NewGamePanel dialog = new NewGamePanel(home);
			dialog.setLocation((home.getLocationOnScreen().x)+(home.getWidth()/2-(dialogWidth/2)),(home.getLocationOnScreen().y)+(home.getHeight()/2-(dialogHeight/2)));
			dialog.setSize(dialogWidth, dialogHeight);
			dialog.setVisible(true);
		}

	}
}

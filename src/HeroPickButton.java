import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HeroPickButton extends JPanel {
	Hero hero;	
	JButton button;
	JLabel label;
	public HeroPickButton(Hero hero){
		this.hero=hero;
		button= new JButton(hero.icon);
		label= new JLabel(hero.name);
		setLayout(new BorderLayout());
		add(button,BorderLayout.NORTH);
		add(label,BorderLayout.SOUTH);
	}
	public void addActionListener(ActionListener actionListener) {
		button.addActionListener(actionListener);
		
	}
	public void setEnabled(boolean bool){
		button.setEnabled(bool);
		super.setEnabled(bool);
	}
}

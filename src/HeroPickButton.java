import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HeroPickButton extends JPanel {
	Hero hero;	
	JButton button;
	JLabel label;
	JTextArea skills;
	public HeroPickButton(Hero hero,double[] skills2){
		this.hero=hero;
		button= new JButton(hero.icon);
		label= new JLabel(hero.name);
		skills=new JTextArea();
		String str="";
		for(int i=0;i<5;i++){
			str=str+skills2[i]+"\n";
		}
		skills.setText(str);
		setLayout(new BorderLayout());
		add(button,BorderLayout.CENTER);
		add(label,BorderLayout.NORTH);
		add(skills, BorderLayout.SOUTH);
	}
	public void addActionListener(ActionListener actionListener) {
		button.addActionListener(actionListener);
		
	}
	public void setEnabled(boolean bool){
		button.setEnabled(bool);
		super.setEnabled(bool);
	}
}

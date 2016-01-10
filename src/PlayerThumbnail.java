
/*
 * This class is used to create a single Thumbnail by using one Player's information.
 * The Result will be a GUI component JPanel, which can easily be used by the MainPanel GUI.
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PlayerThumbnail extends JPanel{
	
	Player current;
	Icon playerImage;
	JLabel descriptionLabel = new JLabel("description Label");
	JLabel roleColorCode = new JLabel("color code");
	JLabel thumbnailImage = new JLabel();
	JPanel thumbnailPanel = new JPanel();
	
	PlayerThumbnail(Player player){
		
		add(makeThumbnail(player));	    
	    
	}
	
	public JPanel makeThumbnail(Player p){
		
		current = p;
		
		playerImage = p.image;		

		thumbnailPanel.setPreferredSize(new Dimension(100,200));
		thumbnailPanel.setLayout(new BorderLayout());
		

		thumbnailImage.setPreferredSize(new Dimension(75,100));
		thumbnailImage.setIcon(playerImage);
		

		roleColorCode.setBackground(Color.RED);
		roleColorCode.setOpaque(true);
		//roleColorCode.setBackground(checkRole(current));
		roleColorCode.setPreferredSize(new Dimension(20,100));
		

		descriptionLabel.setPreferredSize(new Dimension(100,100));
		descriptionLabel.setBackground(Color.BLUE);
		descriptionLabel.setOpaque(true);
		
		thumbnailPanel.add(roleColorCode,BorderLayout.WEST);
		thumbnailPanel.add(thumbnailImage,BorderLayout.EAST);
		thumbnailPanel.add(descriptionLabel,BorderLayout.SOUTH);
		thumbnailPanel.setBackground(Color.GREEN);
		thumbnailPanel.setVisible(true);
		thumbnailPanel.setOpaque(true);
		
		return thumbnailPanel;
		
	}
	
    public void paintComponent(Graphics g) {
       // g.drawImage(playerImage, 0, 0, getWidth(), getHeight(), this);
    }
    
   /* public Color checkRole(Player p){
    	
    	switch(p.role){
    	case 0:
    		return Color.BLUE;
    	case 1:
    		return Color.CYAN;
    	case 2:
    		return Color.DARK_GRAY;
    	case 3:
    		return Color.GREEN;
    	case 4:
    		return Color.LIGHT_GRAY;
    	case 5:
    		return Color.MAGENTA;
    	case 6:
    		return Color.ORANGE;
    	case 7:
    		return Color.PINK;
    	case 8:
    		return Color.RED;
    	case 9:
    		return Color.YELLOW;
    	}
    	
    }
    */

}

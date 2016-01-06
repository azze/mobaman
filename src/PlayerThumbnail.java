
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
	
	Icon playerImage;
	
	PlayerThumbnail(Player player){
		
		makeThumbnail(player);	    
	    
	}
	
	public void makeThumbnail(Player p){
		
		Player current = p;
		
		playerImage = (Icon) new ImageIcon("C:/Users/Domi/Documents/Uni/Softwareentwicklung/SE1/neu/MobaMan/" + current.name + ".jpg").getImage();
		
		JPanel thumbnailPanel = new JPanel();
		thumbnailPanel.setPreferredSize(new Dimension(100,150));
		thumbnailPanel.setLayout(new BorderLayout());
		JLabel thumbnailImage = new JLabel();
		thumbnailImage.setPreferredSize(new Dimension(75,75));
		thumbnailImage.setIcon(playerImage);
		JLabel roleColorCode = new JLabel();
		//roleColorCode.setBackground(checkRole(current));
		roleColorCode.setPreferredSize(new Dimension(25,75));
		JLabel descriptionLabel = new JLabel();
		descriptionLabel.setPreferredSize(new Dimension(100,75));
		thumbnailPanel.add(roleColorCode,BorderLayout.WEST);
		thumbnailPanel.add(thumbnailImage,BorderLayout.EAST);
		thumbnailPanel.add(descriptionLabel,BorderLayout.SOUTH);
		
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

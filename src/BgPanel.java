import java.awt.*;
import javax.swing.*;

class BgPanel extends JPanel {
    Image bg = new ImageIcon("C:/Users/Domi/Documents/Uni/Softwareentwicklung/SE1/neu/MobaMan/MOBAManagerTitle-Layout.jpg").getImage();
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}
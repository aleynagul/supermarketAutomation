import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ArkaplanPanel extends JPanel {
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image img = new ImageIcon(AraYuz.class.getResource("/marketresmi.jpg")).getImage();

        int baslangicX = 0;
        int baslangicY = 0;

        g.drawImage(img,baslangicX,baslangicY,null);


    }
}

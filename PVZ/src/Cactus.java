

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Cactus extends Plants{
	
	Image img = new ImageIcon("pvz_picture\\Cactus.gif").getImage();
	
	Cactus(int m,int n,Graphics g,Bullet bullet){
		super(m,n,g,bullet);
		}
	
	public void draw(Graphics g){
		g.drawImage(img, 350+n*115, 150+m*175, 130, 175, null);
	}

}

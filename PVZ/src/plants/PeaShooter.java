package plants;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import action.*;

public class PeaShooter extends Plants{
	
	
	{
		img[0] = new ImageIcon("plants_picture\\Peashooter.gif").getImage();
	}
	public PeaShooter(int m,int n,Graphics g,Bullet bullet){
		super(m,n,g,bullet);
		hp = 300;
		damage = 20;
		}
	
	public void draw(Graphics g){
		//System.out.println("Draw");
		g.drawImage(img[0], 150+n*115, 150+m*175, 130, 175, null);
	}

}

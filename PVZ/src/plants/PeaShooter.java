package plants;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import action.*;

public class PeaShooter extends Plants{
	
	
	public PeaShooter(int m,int n,Graphics g,Image img,Bullet bullet){
		super(m,n,g,img,bullet);
		}
	
	public void draw(Graphics g){
		//System.out.println("Draw");
		g.drawImage(img, 350+n*115, 150+m*175, 130, 175, null);
		//System.out.println("img pea"+img);
	}

}

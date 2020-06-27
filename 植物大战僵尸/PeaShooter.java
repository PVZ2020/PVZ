package ÷≤ŒÔ¥Û’ΩΩ© ¨;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class PeaShooter extends Plants{
	
	
	PeaShooter(int m,int n,Graphics g,Image img,Bullet bullet){
		super(m,n,g,img,bullet);
		}
	
	public void draw(Graphics g){
		g.drawImage(img, 350+n*115, 150+m*175, 130, 175, null);
	}

}

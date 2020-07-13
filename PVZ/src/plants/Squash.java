package plants;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import action.Bullet;

public class Squash extends Plants{


	{
		img[0] = new ImageIcon("plants_picture\\Squash.gif").getImage();
		img[1] = new ImageIcon("plants_picture\\SquashAttack.gif").getImage();
	}
	public Squash(int m, int n, Graphics g, Bullet bullet) {
		super(m, n, g, null);
		hp = 0;
		damage = 100;
		// TODO Auto-generated constructor stub
	}
	public void draw(Graphics g){
		number ++;
		g.drawImage(img[0], 150+n*115, 150+m*175, 130, 175, null);
		
	}


}

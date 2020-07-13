package plants;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import action.Bullet;

public class Repeater extends Plants{

	
	{img[0] = new ImageIcon("plants_picture\\Repeater.gif").getImage();}
	
	public Repeater(int m, int n, Graphics g, Bullet bullet) {
		super(m, n, g, bullet);
		hp = 300;
		damage = 20;
		// TODO Auto-generated constructor stub
	}
	public void draw(Graphics g){
		g.drawImage(img[0], 150+n*115, 150+m*175, 130, 175, null);
	}

}

package plants;

import java.awt.Graphics;
import java.awt.Image;

import action.Bullet;

public class Chomper extends Plants{

	public Chomper(int m, int n, Graphics g, Image img, Bullet bullet) {
		super(m, n, g, img, bullet);
		// TODO Auto-generated constructor stub
	}
	public void draw(Graphics g){
		g.drawImage(img, 350+n*115, 150+m*175, 130, 175, null);
	}

}

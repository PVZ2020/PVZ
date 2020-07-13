package plants;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import action.Bullet;

public class WallNut extends Plants{

	{
		img[0] = new ImageIcon("plants_picture\\WallNut.gif").getImage();
		img[1] = new ImageIcon("plants_picture\\Wallnut_cracked1.gif").getImage();
		img[2] = new ImageIcon("plants_picture\\Wallnut_cracked2.gif").getImage();
	 }
	public WallNut(int m, int n, Graphics g, Bullet bullet) {
		super(m, n, g, null);
		hp = 400;
		damage = 0;
		// TODO Auto-generated constructor stub
	}
	public void draw(Graphics g){
		if(hp>2666){
			g.drawImage(img[0], 150+n*115, 150+m*175, 130, 175, null);
		}else if(hp>1333){
			g.drawImage(img[1], 150+n*115, 150+m*175, 130, 175, null);
		}else if(hp> 0 ){
			g.drawImage(img[2], 150+n*115, 150+m*175, 130, 175, null);
		}else{
			visible = 0;
		}
	}

}

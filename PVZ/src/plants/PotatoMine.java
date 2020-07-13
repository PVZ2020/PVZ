package plants;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import action.Bullet;

public class PotatoMine extends Plants{

	{
		img[0] = new ImageIcon("plants_picture\\PotatoMineNotReady.gif").getImage();
		img[1] = new ImageIcon("plants_picture\\PotatoMine.gif").getImage();
		img[2] = new ImageIcon("plants_picture\\PotatoMine_mashed.gif").getImage();
	}
	public PotatoMine(int m, int n, Graphics g, Bullet bullet) {
		super(m, n, g, null);
		hp = 300;
		damage = 1800;
		// TODO Auto-generated constructor stub
	}
	public void draw(Graphics g){
		number++;
		if(number<500){
			g.drawImage(img[0], 150+n*115, 150+m*175, 130, 175, null);
		}else if(number>500){
			g.drawImage(img[1], 150+n*115, 150+m*175, 130, 175, null);
		}else if(number> 1000){
			g.drawImage(img[2], 150+n*115, 150+m*175, 130, 175, null);
			visible = 0;
			
		}
		
	}

}

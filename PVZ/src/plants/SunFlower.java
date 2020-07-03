package plants;

import java.awt.Graphics;
import java.awt.Image;

import action.*;

public class SunFlower extends Plants{

	public SunFlower(int m,int n,Graphics g,Image img,Bullet bullet){
		super(m,n,g,img,null);
	}
	public void draw(Graphics g){
		g.drawImage(img, 350+n*115, 150+m*175, 130, 175, null);
		//System.out.println("img sun"+img);
	}
}

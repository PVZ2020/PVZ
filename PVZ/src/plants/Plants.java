package plants;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import action.*;

public class Plants {

	int m,n;
	Graphics g;
	Image img;
	public Bullet bullet;
	public Plants(int m,int n,Graphics g,Image img,Bullet bullet){
		this.m = m;
		this.n = n;
		this.g = g;
		this.img = img;
		this.bullet = bullet;
	}
	public void draw(Graphics g){
		
	}

}

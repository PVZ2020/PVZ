

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class Plants {

//子类需要修改的参数：图片
	
	int m,n;
	Graphics g;
	Image img;
	Bullet bullet;
	Plants(int m,int n,Graphics g,Bullet bullet){
		this.m = m;
		this.n = n;
		this.g = g;
		this.bullet = bullet;
	}
	public void draw(Graphics g){
		
	}
//	public Plants find(int m,int n,ArrayList<Plants> a){
	//for
//		return this;
//	}
}

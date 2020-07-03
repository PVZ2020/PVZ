package action;


import java.awt.Graphics;
import java.awt.Image;
import java.lang.reflect.Constructor;

import javax.swing.ImageIcon;

public class Bullet {

	int m,n;
	Graphics g;
	Image img;
	public int x=0,y=0;
	
	public Bullet(int m,int n,Graphics g,Image img){
		this.m = m;
		this.n = n;
		this.g = g;
		this.img = img;
		x = 350+(n+1)*115;
		y = 150+25+m*175;
	}
	public void drawBullet(Graphics bg){
	}
	public void moveBullet(){
	}
	//....我我我也不想这样
	public Bullet copy(){
		try{
			Class cl = this.getClass();
			Constructor co = cl.getDeclaredConstructor(new Class[]{int.class,int.class,Graphics.class,Image.class});
			return (Bullet)co.newInstance(new Object[]{m,n,g,img});
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}
}

package action;


import java.awt.Graphics;
import java.awt.Image;
import java.lang.reflect.Constructor;

import javax.swing.ImageIcon;

public class Bullet extends Action{

	public int x,y;
	public Bullet(int m,int n,Graphics g){
		this.m = m;
		this.n = n;
		this.g = g;
		x = 350+n*115;
		y = 150+m*175;
	}
	public void drawBullet(Graphics bg){
	}
	public void moveBullet(){
	}
	
	public Bullet copy(){
		try{
			Class cl = this.getClass();
			Constructor co = cl.getDeclaredConstructor(new Class[]{int.class,int.class,Graphics.class});
			return (Bullet)co.newInstance(new Object[]{m,n,g});
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}
}

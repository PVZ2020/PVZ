

import java.awt.Graphics;
import java.awt.Image;
import java.lang.reflect.Constructor;

import javax.swing.ImageIcon;

public class Bullet {

	//������Ҫ�޸ĵĲ�����ͼƬ
	
	int m,n;
	Graphics g;
	Image img;
	int x=0,y=0;
	
	Bullet(int m,int n,Graphics g){
		this.m = m;
		this.n = n;
		this.g = g;
		x = 350+(n+1)*115;
		y = 150+25+m*175;
	}
	public void drawBullet(Graphics bg){
	}
	public void moveBullet(){
	}
	//....������Ҳ��������
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

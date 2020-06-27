package 植物大战僵尸;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class ProjectilePea extends Bullet{
	
	ProjectilePea(int m,int n,Graphics g,Image img){
		super(m,n,g,img);
	}
	
	public void drawBullet(Graphics bg){
		bg.drawImage(img, x, y, 50, 50, null);
		//System.out.print("画出");
	}
	public void moveBullet(){
		x += 6;
	}
	public ProjectilePea copy(){
		try{
			Class cl = this.getClass();
			Constructor co = cl.getDeclaredConstructor(new Class[]{int.class,int.class,Graphics.class,Image.class});
			return (ProjectilePea)co.newInstance(new Object[]{m,n,g,img});
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}

}

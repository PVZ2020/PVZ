

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class ProjectilePea extends Bullet{
	
	static Image img = new ImageIcon("pvz_picture\\ProjectilePea.png").getImage();
	
	ProjectilePea(int m,int n,Graphics g){
		super(m,n,g);
	}
	
	public void drawBullet(Graphics bg){
		bg.drawImage(img, x, y, 50, 50, null);
		//System.out.print("����");
	}
	public void moveBullet(){
		x += 6;
	}
	public ProjectilePea copy(){
		try{
			Class cl = this.getClass();
			Constructor co = cl.getDeclaredConstructor(new Class[]{int.class,int.class,Graphics.class});
			return (ProjectilePea)co.newInstance(new Object[]{m,n,g});
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}

}

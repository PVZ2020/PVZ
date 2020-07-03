

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Projectile_star extends Bullet{
	
	static Image img = new ImageIcon("pvz_picture\\Projectile_star.png").getImage();
	
	Projectile_star(int m,int n,Graphics g){
		super(m,n,g);
	}
	
	public void drawBullet(Graphics bg){
		bg.drawImage(img, x, y, 50, 50, null);
		//System.out.print("»­³ö");
	}
	public void moveBullet(){
		x += 6;
	}
	public Projectile_star copy(){
		try{
			Class cl = this.getClass();
			Constructor co = cl.getDeclaredConstructor(new Class[]{int.class,int.class,Graphics.class});
			return (Projectile_star)co.newInstance(new Object[]{m,n,g});
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}

}

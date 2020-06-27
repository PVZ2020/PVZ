package 植物大战僵尸;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.ImageIcon;



public class BulletRunnable implements Runnable{
	
	Graphics g;
	ArrayList<Bullet> bullet;
	Map<Integer,Plants> plant;
	ShowUI showUI;
	
	
	BulletRunnable(Graphics g,ShowUI showUI){
		this.g = g;
		this.showUI = showUI;
	}
	
	@Override
	public void run() {
		
		
		BufferedImage bfimg = new BufferedImage(showUI.getWidth(), showUI.getHeight(),BufferedImage.TYPE_INT_ARGB);
		Graphics bg = bfimg.getGraphics();
		
		while(true){
			
			try{
				Thread.sleep(10);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
				bg.drawImage(ShowUI.img[0], 0, 0,1980,1080,showUI);
				
				for(Plants p:plant.values()){
					p.draw(bg);
				}
				
				for(int i=0;i<bullet.size();i++){
					bullet.get(i).moveBullet();
					bullet.get(i).drawBullet(bg);
					//System.out.print(i);
					if(bullet.get(i).x>1980){
						bullet.remove(i);
						//System.out.print("清除");
					}
				}
				g.drawImage(bfimg, 0, 0, showUI);
			    
			
		
		}
	}

}

package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import action.*;
import plants.*;



public class BulletRunnable implements Runnable{
	
	int option;
	Graphics g;
	ArrayList<Bullet> bullet;
	Map<Integer,Plants> plant;
	ShowUI jp;
	JPanel p;
	public JButton[] jbutton;
	
	BulletRunnable(Graphics g,ShowUI jp,JPanel p){
		this.g = g;
		this.jp = jp;
		this.p = p;
	}
	
	@Override
	public void run() {
		
		
		BufferedImage bfimg = new BufferedImage(jp.getWidth(), jp.getHeight(),BufferedImage.TYPE_INT_ARGB);
		Graphics bg = bfimg.getGraphics();
		
		while(true){

			try{
				Thread.sleep(10);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
				bg.drawImage(ShowUI.imgB[0], 0, 0,jp.getWidth(),jp.getHeight(),jp);
				
				for(Plants p:plant.values()){
					p.draw(bg);
				//	System.out.print(p.getClass().getName());
				}
//				for(JButton b:jbutton){
//					b.repaint();
//				}
				p.repaint();
				for(int i=0;i<bullet.size();i++){
					bullet.get(i).moveBullet();
					bullet.get(i).drawBullet(bg);
					//System.out.print(i);
					if(bullet.get(i).x>1980){
						bullet.remove(i);
						//System.out.print("Çå³ý");
					}
				}
				g.drawImage(bfimg, 0, 0, jp);
			    
			
		
		}
	}

}

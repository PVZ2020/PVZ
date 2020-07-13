package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import action.*;
import plants.*;
import zombies.Zombies;


public class BulletRunnable implements Runnable{
	
	int option;
	Graphics g;
	ArrayList<Bullet> bullet;
	Map<Integer,Plants> plant;
	//这里有修改
	public ArrayList<Zombies> zombies;
	JPanel jp;
	int sunNumber;
	boolean[][] isFilled;
	public JButton[] jbutton;
	
	BulletRunnable(JPanel jp, boolean[][] isFilled){
		this.g = jp.getGraphics();
		this.jp = jp;
		this.isFilled = isFilled;
	}
	
	/** 
	 * 实现线程的方法.
	 * <p>实现了刷新界面,植物,子弹,更新面板上的阳光数{@code sunNumber},当植物{@code visible}为0的时候从队列中或者表中去除,
	 * 是因为要用{@code drawString}所以才引入了{@code Graphics2D}.
	 * <p>界面的绘制通过PS将图片拆成两个部分 在run方法中反复刷新的是按钮栏之外的(1880 1080)的界面,
	 * 按钮栏背景的绘制见{@link main.ShowUI.Jp#paint(Graphics)}
	 * @see java.lang.Runnable#run()
	 * @see Graphics2D 
	 * @see BufferedImage#createGraphics()
	 */
	@Override
	
	public void run() {
		
		System.out.print(jp);
		BufferedImage bfimg = new BufferedImage(jp.getWidth(), jp.getHeight(),BufferedImage.TYPE_INT_ARGB);
		Graphics bg = bfimg.getGraphics();
		Graphics2D bg2d = bfimg.createGraphics();
		
		while(true){
			/** sunNumber 表示阳光的点数. */
			sunNumber = PvzMouseListener.sunNumber;
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
				Font font = new Font("Times New Roman",Font.BOLD,24);
				bg2d.setFont(font);
				bg2d.setColor(Color.BLACK);
				bg2d.drawImage(ShowUI.imgB[0], 0, 0,jp.getWidth(),jp.getHeight(),jp);
				bg2d.drawString(Integer.toString(sunNumber), 60, 150);
	
				/** 这个for循环 用来画出植物以及通过visible来去除植物. */
				for(Iterator<Map.Entry<Integer, Plants>> it = plant.entrySet().iterator();it.hasNext();){
					Map.Entry<Integer, Plants> entry = it.next();
					if(entry.getValue().visible == 0){
						it.remove();
						isFilled[entry.getKey()%5][(entry.getKey()-entry.getKey()%5)/5] = false;
					}else{
						entry.getValue().draw(bg);
					}
				}
				for(int i=0;i<bullet.size();i++){
					bullet.get(i).moveBullet();
					bullet.get(i).drawBullet(bg2d);
					
					if(bullet.get(i).m>10){
						bullet.remove(i);
					}
				}
				for(int i=0;i<zombies.size();i++){
					zombies.get(i).move();
					zombies.get(i).draw(bg);
					if(zombies.get(i).x<0){
						zombies.remove(i);
					}
				}
				g.drawImage(bfimg, 100, 0, null);
			    
			
		
		}
	}

}

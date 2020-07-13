package plants;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import action.*;
import main.PvzMouseListener;


/**
 * 太阳花类 实现了太阳花的基本功能.
 * <p> 基础属性 {@code hp}为300 {@code damage}为0.
 */

public class SunFlower extends Plants{

	Sun sun = new Sun();
	
	public static ArrayList<Sun> arrS = new ArrayList<>();
	int sunNumber;
	 {
		 img[0] = new ImageIcon("plants_picture\\SunFlower.gif").getImage();
		 
	 }
	public SunFlower(int m,int n,Graphics g,Bullet bullet){
		super(m,n,g,null);
		hp = 300;
		damage = 0;
	}
	/**
	  * 画出太阳花 以及生成太阳花产生的阳光并添加进入{@code arrS}队列中.
	  * <p>hp降为0后设置{@code visible}为0 {@link main.BulletRunnable#run()}中可以看到.
	  * <p>SunFlower的{@code number}属性每计数达到300次后添加一个太阳,Sun的每一个对象{@code number}属性也在这里递增,
	  * 调用了{@link plants.SunFlower.Sun#drawSun(Graphics)}来画出太阳.
	  * @param g 画布.
	  */
	public void draw(Graphics g){
		if (hp>0){
			number ++;
			for (Sun s:arrS){
				s.number++;
			}
			g.drawImage(img[0], 150+n*115, 150+m*175, 130, 175, null);
			if(number % 300 == 1){
				Sun sun1 = new Sun();
				arrS.add(sun1);
			}
			 sun.drawSun(g);
		}
		else{
			visible = 0;
		}
	}
	/**
	 * 阳光 实现了画出阳光,以及点击阳光的音效.
	 *
	 */
	class Sun extends Action{
		int number = 0;
		
		{
			visible = 1;
			x = 150+SunFlower.this.n*115;
			y = 150+SunFlower.this.m*175;
		}
		
		Random r = new Random();
		
		
		Image imgS[]  =new Image[20];
		{
			
			imgS[0] = new ImageIcon("plants_picture\\Sun\\frame_1.png").getImage();
			imgS[1] = new ImageIcon("plants_picture\\Sun\\frame_2.png").getImage();
			imgS[2] = new ImageIcon("plants_picture\\Sun\\frame_3.png").getImage();
			imgS[3] = new ImageIcon("plants_picture\\Sun\\frame_4.png").getImage();
			imgS[4] = new ImageIcon("plants_picture\\Sun\\frame_5.png").getImage();
			imgS[5] = new ImageIcon("plants_picture\\Sun\\frame_6.png").getImage();
			imgS[6] = new ImageIcon("plants_picture\\Sun\\frame_7.png").getImage();
			imgS[7] = new ImageIcon("plants_picture\\Sun\\frame_8.png").getImage();
			imgS[8] = new ImageIcon("plants_picture\\Sun\\frame_9.png").getImage();
			imgS[9] = new ImageIcon("plants_picture\\Sun\\frame_10.png").getImage();
			imgS[10] = new ImageIcon("plants_picture\\Sun\\frame_11.png").getImage();
			imgS[11] = new ImageIcon("plants_picture\\Sun\\frame_12.png").getImage();
			imgS[12] = new ImageIcon("plants_picture\\Sun\\frame_13.png").getImage();
			imgS[13] = new ImageIcon("plants_picture\\Sun\\frame_14.png").getImage();
			imgS[14] = new ImageIcon("plants_picture\\Sun\\frame_15.png").getImage();
			imgS[15] = new ImageIcon("plants_picture\\Sun\\frame_16.png").getImage();
			imgS[16] = new ImageIcon("plants_picture\\Sun\\frame_17.png").getImage();
			imgS[17] = new ImageIcon("plants_picture\\Sun\\frame_18.png").getImage();
			imgS[18] = new ImageIcon("plants_picture\\Sun\\frame_19.png").getImage();
			imgS[19] = new ImageIcon("plants_picture\\Sun\\frame_20.png").getImage();
			
		}
		/**
		 * 画出阳光. 
		 * <p>遍历SunFlower的属性{@code arrS},当number小于19时阳光处于下落阶段,
		 * 大于时就落在地上 大于500后阳光消失
		 *@param g 画笔
		 */
		public void drawSun(Graphics g){

			for (int i = arrS.size()-1;i>=0;i--){
				Sun sun = arrS.get(i);
				if(sun.visible == 1){
					if(sun.number <=19){
						g.drawImage(imgS[sun.number%20], sun.x, sun.y, 100, 100, null);
						sun.x+=r.nextInt(10);
						sun.y+=r.nextInt(10);
						sun.number++;
					}
					else if(sun.number<=500){
						g.drawImage(imgS[sun.number%20], sun.x, sun.y, 100, 100, null);
						sun.number++;
					}
				}else{
					arrS.remove(i);
				}
			}
		}
		/**
		 * 点击阳光产生音效 在{@link main.PvzMouseListener#mousePressed(MouseEvent)}中用到
		 */
		public void act(){
			new Thread(){
				public void run(){
					File sound=new File("pvz_audio\\sunCollect.wav");
					AudioClip audio;
					System.out.print("OO");
					try {
						audio = Applet.newAudioClip(sound.toURL());
						audio.play();
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}.start();
		}
	}	
}

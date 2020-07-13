package plants;

import action.*;
import main.ShowUI;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JPanel;


/**
 * 植物类 是所有植物的父类.
 * 
 * <p>{@code visible} 控制植物可见性的参数 有两个取值0,1.
 * 
 * 
 * 
 *
 */

public class Plants {

	int m,n;
	int hp;
	int damage;
	int number = 0;
	public int visible = 1;
	Graphics g;
	Image img[] = new Image[9];
	public Bullet bullet;
	Plants(int m,int n,Graphics g,Bullet bullet){
		this.m = m;
		this.n = n;
		this.g = g;
		this.bullet = bullet;
		
	}
	
	
	public void draw(Graphics g){
		
	}
	public void remove(Map<Integer,Plants> plant){
		plant.remove(m+n*5);
	}
	/**
	 * 
	 * <p> 用来为栽种植物提供音效 实质上是一个播放声音的线程,
	 * {@link main.PvzMouseListener#mousePressed(java.awt.event.MouseEvent)}中使用.
	 *
	 *
	 */
	public static void plant(){

		new Thread(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				File sound=new File("pvz_audio\\plant.wav");
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

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
 * ֲ���� ������ֲ��ĸ���.
 * 
 * <p>{@code visible} ����ֲ��ɼ��ԵĲ��� ������ȡֵ0,1.
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
	 * <p> ����Ϊ����ֲ���ṩ��Ч ʵ������һ�������������߳�,
	 * {@link main.PvzMouseListener#mousePressed(java.awt.event.MouseEvent)}��ʹ��.
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

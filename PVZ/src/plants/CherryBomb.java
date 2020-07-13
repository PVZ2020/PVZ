package plants;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Map;

import javax.swing.ImageIcon;

import action.Bullet;
import main.ShowUI;


public class CherryBomb extends Plants{

	{
		img[0] = new ImageIcon("plants_picture\\CherryBomb\\CherryBomb (4).png").getImage();
		img[1] = new ImageIcon("plants_picture\\CherryBomb\\CherryBomb (5).png").getImage();
		img[2] = new ImageIcon("plants_picture\\CherryBomb\\CherryBomb (6).png").getImage();
		img[3] = new ImageIcon("plants_picture\\CherryBomb\\CherryBomb (7).png").getImage();
		img[4] = new ImageIcon("plants_picture\\CherryBomb\\CherryBomb (1).png").getImage();
		img[5] = new ImageIcon("plants_picture\\CherryBomb\\CherryBomb (2).png").getImage();
		img[6] = new ImageIcon("plants_picture\\CherryBomb\\CherryBomb (3).png").getImage();
		img[7] = new ImageIcon("plants_picture\\Boom.gif").getImage();
	}
	public CherryBomb(int m, int n, Graphics g, Bullet bullet) {
		super(m, n, g, null);
		damage = 1800;
		hp = 300;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * ����ӣ��ը����ը��Ч��
	 * <p> ����һ��һ������ͨ��number������,Ҳ����˵�߳�ÿˢ��һ����һ�� draw����,Ҳ����˵number��¼�������ֲ��֮���߳����еĴ���,
	 * 7��ͼ��ʾ������{@link plants.CherryBomb#bomb()}���ų�����.
	 *
	 */
	public void draw(Graphics g){
		if(number <= 7){
			g.drawImage(img[number], 150+n*115, 150+m*175, 130, 175, null);
			number++;
		}else{
			visible = 0;
			bomb();
		}
	}
	public void bomb(){
		new Thread(){
			public void run(){
				File sound=new File("pvz_audio\\explosion.wav");
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

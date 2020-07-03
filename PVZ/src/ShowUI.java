
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.applet.AudioClip;

public class ShowUI extends JFrame{
	
	//定义常量
	public final int w = 115;//width
	public final int h = 175;//height
	
	boolean[][] isFilled = new boolean[5][9];
	static Image img[][] = new Image[4][10];
	/* Image[0]系列为背景
	 * Image[1]系列为植物
	 * Image[2]系列为子弹
	 * Image[3]系列为僵尸
	 */
	static{
		img[0][0] = new ImageIcon("pvz_picture\\background1.jpg").getImage();
		img[0][1] = new ImageIcon("pvz_picture\\background2.jpg").getImage();
		
		img[1][0] = new ImageIcon("pvz_picture\\Peashooter.gif").getImage();
		img[1][1] = new ImageIcon("pvz_picture\\SunFlower.gif").getImage();
		img[1][2] = new ImageIcon("pvz_picture\\SPeaShooter2.0.gif").getImage();
		
		img[2][0] = new ImageIcon("pvz_picture\\ProjectilePea.png").getImage();
		img[2][1] = new ImageIcon("pvz_picture\\Projectile_star.png").getImage();
		img[2][2] = new ImageIcon("pvz_picture\\ProjectileSnowPea.png").getImage();
		img[2][3] = new ImageIcon("pvz_picture\\ProjectileCactus.png.png").getImage();
		
	}
	PvzMouseListener mouseListener;
	ArrayList<Bullet> bullet = new ArrayList<>();
	Map<Integer,Plants> plant = new HashMap<>();
	
	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(img[0][0], 0, 0, 1980, 1080, null);
	}
	public void InitUI(){
		
		this.setTitle("植物大战僵尸魔改版");
		this.setSize(1980, 1080);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		
		mouseListener = new PvzMouseListener(isFilled);
		this.addMouseListener(mouseListener);
		mouseListener.g = this.getGraphics();
		mouseListener.bullet = bullet;
		mouseListener.plant = plant;
		
		Thread t1= new Thread(mouseListener);
		t1.start();
		
		BulletRunnable bulletRunnable = new BulletRunnable(mouseListener.g,this);
		bulletRunnable.bullet = bullet;
		bulletRunnable.plant = plant;
		
		Thread t2= new Thread(bulletRunnable);
		t2.start();
		
		BgmRunnable bgm = new BgmRunnable();
		Thread t3 = new Thread(bgm);
		t3.start();
	}
	
	
	

	
	public static void main(String[] args) throws MalformedURLException {
		
		ShowUI UI = new ShowUI();
		UI.InitUI();

	}

}

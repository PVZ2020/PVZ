package main;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import action.*;
import plants.*;
import zombies.*;

import java.applet.AudioClip;

public class ShowUI extends JFrame{
	
	//定义常量
	public final int w = 115;//width
	public final int h = 175;//height
	int option;
	
	boolean[][] isFilled = new boolean[5][9];
	static Image img[] = new Image[10];
	static Image imgB[] = new Image[10];
	static Image imgP[][] = new Image[10][3];
	public static JPanel p2;
		
	static{
		imgB[0] = new ImageIcon("background_picture\\background1 (1).png").getImage();
		imgB[1] = new ImageIcon("background_picture\\background1.png").getImage();
		

		}
	public SunFlower sf ;
	PvzMouseListener mouseListener = new PvzMouseListener(isFilled);
	//Sun sun = new Sun();
	
	ArrayList<Bullet> bullet = new ArrayList<>();
	//这里有修改
	ArrayList<Zombies> zombies = new ArrayList<>();
	Map<Integer,Plants> plant = new ConcurrentHashMap<>();
	JButton[] jbutton = new JButton[8];
	
	public void InitUI(){
		JPanel p = new Jp();
		
		p2 = new JPanel();
	
		p.setSize(100,1080);
		p2.setBounds(0,0,1980,1080);
		p.setVisible(true);
		//p.setLayout(new FlowLayout());
		
		jbutton[0] = new JButton();
		jbutton[0].setIcon(new ImageIcon("slot_card\\CherryBomb.png"));
		jbutton[0].addActionListener(mouseListener);
		
		jbutton[1] = new JButton();
		//b2.setPreferredSize(new Dimension(200,100));
		jbutton[1].setIcon(new ImageIcon("slot_card\\Chomper.png"));
		jbutton[1].addActionListener(mouseListener);
		
		jbutton[2] = new JButton();
		//b3.setPreferredSize(new Dimension(200,100));
		jbutton[2].setIcon(new ImageIcon("slot_card\\WallNut.png"));
		jbutton[2].addActionListener(mouseListener);
		
		jbutton[3] = new JButton();
		//b4.setPreferredSize(new Dimension(200,100));
		jbutton[3].setIcon(new ImageIcon("slot_card\\SunFlower.png"));
		jbutton[3].addActionListener(mouseListener);
		
		jbutton[4] = new JButton();
		//b5.setPreferredSize(new Dimension(200,100));
		jbutton[4].setIcon(new ImageIcon("slot_card\\Squash.png"));
		jbutton[4].addActionListener(mouseListener);
		
		jbutton[5] = new JButton();
		//b6.setPreferredSize(new Dimension(200,100));
		jbutton[5].setIcon(new ImageIcon("slot_card\\PotatoMine.png"));
		jbutton[5].addActionListener(mouseListener);
		
		jbutton[6] = new JButton();
		//b7.setPreferredSize(new Dimension(200,100));
		jbutton[6].setIcon(new ImageIcon("slot_card\\Repeater.png"));
		jbutton[6].addActionListener(mouseListener);
		
		jbutton[7] = new JButton();
		//b8.setPreferredSize(new Dimension(200,100));
		jbutton[7].setIcon(new ImageIcon("slot_card\\Peashooter.png"));
		jbutton[7].addActionListener(mouseListener);
		
		p.add(jbutton[0]);
		p.add(jbutton[1]);
		p.add(jbutton[2]);
		p.add(jbutton[3]);
		p.add(jbutton[4]);
		p.add(jbutton[5]);
		p.add(jbutton[6]);
		p.add(jbutton[7]);
		
		
		
		this.setTitle("植物大战僵尸魔改版");
		this.add(p);
		this.add(p2);
		this.setLayout(null);
		this.setSize(1980, 1080);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		this.addMouseListener(mouseListener);
		
		mouseListener.bullet = bullet;
		mouseListener.plant = plant;
		mouseListener.jbutton = jbutton;
		mouseListener.option = option;
		
		
		Thread t1= new Thread(mouseListener);
		t1.start();
		
		//这里是僵尸产生的线程
		ZombiesRunnable zombiesRunnable = new ZombiesRunnable(mouseListener.g);
		Thread t4 = new Thread(zombiesRunnable);
		t4.start();
		
		BulletRunnable bulletRunnable = new BulletRunnable(p2,isFilled);
		bulletRunnable.bullet = bullet;
		bulletRunnable.plant = plant;
		bulletRunnable.jbutton = jbutton;
		bulletRunnable.option = option;
		//这里有修改
		zombiesRunnable.zombies = zombies;
		bulletRunnable.zombies = zombies;
		
		Thread t2= new Thread(bulletRunnable);
		t2.start();
		
		BgmRunnable bgm = new BgmRunnable();
		Thread t3 = new Thread(bgm);
		t3.start();
		
		
		
	}
	
	class Jp extends JPanel{
		public void paint(Graphics g){
			g.drawImage(imgB[1], 0, 0, 100, 1080, null);
		}
	}
	

	
	public static void main(String[] args) throws MalformedURLException {
		
		ShowUI UI = new ShowUI();
		UI.InitUI();

	}

}

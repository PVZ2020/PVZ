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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import action.*;
import plants.*;

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
	
{
		imgB[0] = new ImageIcon("background_picture\\background2.jpg").getImage();
		//樱桃炸弹
		imgP[0][0] = new ImageIcon("plants_picture\\CherryBomb.gif").getImage();
		imgP[0][1] = new ImageIcon("plants_picture\\Bomb.gif").getImage();
		//食人花
		imgP[1][0] = new ImageIcon("plants_picture\\Chomper.gif").getImage();
		imgP[1][1] = new ImageIcon("plants_picture\\ChomperAttack.gif").getImage();
		imgP[1][2] = new ImageIcon("plants_picture\\ChomperDigest.gif").getImage();
		//低坚果
		imgP[2][0] = new ImageIcon("plants_picture\\WallNut.gif").getImage();
		imgP[2][1] = new ImageIcon("plants_picture\\Wallnut_cracked1.gif").getImage();
		imgP[2][2] = new ImageIcon("plants_picture\\Wallnut_cracked2.gif").getImage();
		//太阳花
		imgP[3][0] = new ImageIcon("plants_picture\\SunFlower.gif").getImage();
		//窝瓜
		imgP[4][0] = new ImageIcon("plants_picture\\Squash.gif").getImage();
		imgP[4][1] = new ImageIcon("plants_picture\\SquashAttack.gif").getImage();
		//土豆地雷
		imgP[5][0] = new ImageIcon("plants_picture\\PotatoMineNotReady.gif").getImage();
		imgP[5][1] = new ImageIcon("plants_picture\\PotatoMine.gif").getImage();
		imgP[5][2] = new ImageIcon("plants_picture\\PotatoMine_mashed.gif").getImage();
		//Repeater
		imgP[6][0] = new ImageIcon("plants_picture\\Repeater.gif").getImage();
		//豌豆射手
		imgP[7][0] = new ImageIcon("plants_picture\\Peashooter.gif").getImage();
		

		}
	PvzMouseListener mouseListener = new PvzMouseListener(isFilled);
	ArrayList<Bullet> bullet = new ArrayList<>();
	Map<Integer,Plants> plant = new HashMap<>();
	JButton[] jbutton = new JButton[8];
	
	public void InitUI(){
		
		JPanel p = new JPanel();
		//JPanel p2 = new JPanel();
		
		p.setBackground(Color.black);
		p.setOpaque(false);
		p.setPreferredSize(new Dimension(100,0));
		
		//p.setVisible(true);
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
		
		this.add(p, BorderLayout.WEST);
		//this.add(p2);
		
		//this.setLayout(null);
		this.setTitle("植物大战僵尸魔改版");
		this.setSize(1980, 1080);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		
//		mouseListener = new PvzMouseListener(isFilled);
		this.addMouseListener(mouseListener);
		mouseListener.g = this.getGraphics();
		
		mouseListener.bullet = bullet;
		mouseListener.plant = plant;
		mouseListener.jbutton = jbutton;
		mouseListener.option = option;
		
		
		Thread t1= new Thread(mouseListener);
		t1.start();
		
		BulletRunnable bulletRunnable = new BulletRunnable(mouseListener.g,this,p);
		bulletRunnable.bullet = bullet;
		bulletRunnable.plant = plant;
		bulletRunnable.jbutton = jbutton;
		bulletRunnable.option = option;
		
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

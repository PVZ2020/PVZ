package main;

import java.awt.Button;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JButton;

import action.*;
import plants.*;

public class PvzMouseListener implements MouseListener,Runnable,ActionListener{
	
	int option;
	JButton[] jbutton;
	ArrayList<Bullet> bullet;
	Map<Integer,Plants> plant;
	boolean isFilled[][];
	PvzMouseListener(boolean[][] isFilled){
		this.isFilled = isFilled;
	}
	
	Graphics g;
	boolean isSelected = false;
	PeaShooter p;
	
	int m=0;//m代表行
	int n=0;//n代表列
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		System.out.print("click");
		if (a.getSource() == jbutton[0]) option = 0;
		if (a.getSource() == jbutton[1]) option = 1;
		if (a.getSource() == jbutton[2]) option = 2;
		if (a.getSource() == jbutton[3]) option = 3;
		if (a.getSource() == jbutton[4]) option = 4;
		if (a.getSource() == jbutton[5]) option = 5;
		if (a.getSource() == jbutton[6]) option = 6;
		if (a.getSource() == jbutton[7]) option = 7;
		//System.out.print(option);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		n = (e.getX()-350)/115;
		m = (e.getY()-150)/175;
		if(m<0||m>4||n<0||n>8) return;
		System.out.println(m+" "+n);
		if(isFilled[m][n]){
			isSelected = true;
		}else{
			switch(option){
			case 0:plant.put(m+n*5,new CherryBomb(m,n,g,ShowUI.imgP[0][0],new ProjectilePea(m,n,g,ShowUI.img[2])));
			isFilled[m][n] = true;
			option = -1;
			break;
			case 1:plant.put(m+n*5,new Chomper(m,n,g,ShowUI.imgP[1][0],null));
			System.out.println("drawChomper");
			isFilled[m][n] = true;
			option = -1;
			break;
			case 2:plant.put(m+n*5,new WallNut(m,n,g,ShowUI.imgP[2][0],null));
			isFilled[m][n] = true;
			option = -1;
			break;
			case 3: 
			plant.put(m+n*5,new SunFlower(m,n,g,ShowUI.imgP[3][0],null));
			isFilled[m][n] = true;
			option = -1;
			break;
			case 4:plant.put(m+n*5,new Squash(m,n,g,ShowUI.imgP[4][0],null));
			isFilled[m][n] = true;
			option = -1;
			break;
			case 5:plant.put(m+n*5,new PotatoMine(m,n,g,ShowUI.imgP[5][0],null));
			isFilled[m][n] = true;
			option = -1;
			break;
			case 6:plant.put(m+n*5,new Repeater(m,n,g,ShowUI.imgP[6][0],null));
			isFilled[m][n] = true;
			option = -1;
			break;
			case 7:plant.put(m+n*5,new PeaShooter(m,n,g,ShowUI.imgP[7][0],new ProjectilePea(m,n,g,ShowUI.img[2])));
			isFilled[m][n] = true;
			option = -1;
			break;
		
		}
		if(isSelected){
//			p = new PeaShooter(m,n,g,);
//			p.clean(g);
			isFilled[m][n] = false;
		}
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		//对每个被植物覆盖的区域产生子弹
		while(true){
			try{
				Thread.sleep(1400);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.print(22222+">>>");
			if(bullet!=null){
				for(int m=0;m<5;m++){
					for(int n=0;n<9;n++){
						if(isFilled[m][n]){
							//Bullet b = plant.get(m+n*5).bullet.copy();
							//bullet.add(b);
						}
					}
				}
			}	
		}
	}

}

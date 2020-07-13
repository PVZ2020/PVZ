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
	
	static int sunNumber;
	int option = -1;
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
	}

	@Override
	public void mousePressed(MouseEvent e) {
		n = (e.getX()-250)/115;
		m = (e.getY()-150)/175;
		System.out.println("x:"+e.getX()+"//"+"row:"+n);
		System.out.println("y:"+e.getY()+"//"+"col:"+m);
		for (Action s:SunFlower.arrS){
			System.out.println(s.x+"///"+(e.getX()-225)+"///"+s.y+"//"+(e.getY()-75));
			if(Math.abs(s.x - e.getX()+175)<30&&Math.abs(s.y - e.getY()+75)<30){
				s.visible =0;
				s.act();
				sunNumber +=50;
			}
		}
		
		if(m<0||m>4||n<0||n>8) return;
		
		if(isFilled[m][n]){
			
		}else{
			switch(option){
				case 0:plant.put(m+n*5,new CherryBomb(m,n,g,new ProjectilePea(m,n,g)));
				isFilled[m][n] = true;
				Plants.plant();
				option = -1;
				break;
				case 1:plant.put(m+n*5,new Chomper(m,n,g,null));
				System.out.println("drawChomper");
				Plants.plant();
				isFilled[m][n] = true;
				option = -1;
				break;
				case 2:plant.put(m+n*5,new WallNut(m,n,g,null));
				isFilled[m][n] = true;
				Plants.plant();
				option = -1;
				break;
				case 3: 
				plant.put(m+n*5,new SunFlower(m,n,g,null));
				isFilled[m][n] = true;
				Plants.plant();
				option = -1;
				break;
				case 4:plant.put(m+n*5,new Squash(m,n,g,null));
				isFilled[m][n] = true;
				Plants.plant();
				option = -1;
				break;
				case 5:plant.put(m+n*5,new PotatoMine(m,n,g,null));
				isFilled[m][n] = true;
				Plants.plant();
				option = -1;
				break;
				case 6:plant.put(m+n*5,new Repeater(m,n,g,null));
				isFilled[m][n] = true;
				Plants.plant();
				option = -1;
				break;
				case 7:plant.put(m+n*5,new PeaShooter(m,n,g,new ProjectilePea(m,n,g)));
				isFilled[m][n] = true;
				Plants.plant();
				option = -1;
				break;
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
			//System.out.print(22222+">>>");
			if(bullet!=null){
				for(int m=0;m<5;m++){
					for(int n=0;n<9;n++){
						if(isFilled[m][n]){
//							if(plant.get(m+n*5).bullet !=null){
//								Bullet b = plant.get(m+n*5).bullet.copy();
//								bullet.add(b);
//							}
							
						}
					}
				}
			}	
		}
	}

}

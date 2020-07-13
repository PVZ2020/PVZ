package zombies;

import java.awt.Graphics;
import java.awt.Image;

//Ω© ¨¿‡
public class Zombies {
	public Image img;
	public int HP;
	Graphics g;
	private int speed = 10;
//	int m,n;
	int n;
	public int x=0;
	public int y=0;
	
	Zombies(int n,Graphics g){
//		this.m = m;
		this.n = n;
		this.g = g;
		x = 1700;
		y = 150+n*175;
	}
	
	public void draw(Graphics bg){
		bg.drawImage(img, x, y, 200, 200, null);
	}
	
	public void move(){
		x -= 1;
	}
	
}

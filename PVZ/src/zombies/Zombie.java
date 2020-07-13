package zombies;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

//∆’Õ®Ω© ¨
public class Zombie extends Zombies{
	
	Image img1 = new ImageIcon("Zombies_picture\\Zombie.gif").getImage();
	Image img2 = new ImageIcon("Zombies_picture\\Zombie2.gif").getImage();
	Image img3 = new ImageIcon("Zombies_picture\\Zombie3.gif").getImage();
	
	int i = (int) (Math.random()*3);
	
	
	Zombie(int n, Graphics g) {
		super(n, g);
		// TODO Auto-generated constructor stub
	}
	
	public void draw(Graphics bg){
		switch(i){
		case 0:img = img1;break;
		case 1:img = img2;break;
		default:img = img3;break;
		}
		bg.drawImage(img, x, y, x+280,y+350,60,20,200,250,null);
	}
	
	public void move(){
		x -= 5;
	}
}


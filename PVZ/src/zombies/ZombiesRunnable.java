package zombies;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Map;

public class ZombiesRunnable implements Runnable{

	Graphics g;
	public ArrayList<Zombies> zombies;
	
	public ZombiesRunnable(Graphics g) {
		// TODO Auto-generated constructor stub
		this.g = g;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			
			try{
				Thread.sleep(3000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			int n = (int) (Math.random()*5);
			Zombie zombie = new Zombie(n,g);
			zombies.add(zombie);
			System.out.print(n);

		}
	}

}


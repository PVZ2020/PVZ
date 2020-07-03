
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Map;

public class PvzMouseListener implements MouseListener,Runnable{
	
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
	public void mousePressed(MouseEvent e) {
		n = (e.getX()-350)/115;
		m = (e.getY()-150)/175;
		if(m<0||m>4||n<0||n>8) return;
		System.out.println(m+" "+n);
		if(isFilled[m][n]){
			isSelected = true;
		}else{
			plant.put(m+n*5,new PeaShooter(m,n,g,new ProjectilePea(m,n,g)));
//			plant.put(m+n*5,new Cactus(m,n,g,new Cactus(m,n,g)));？？？
			isFilled[m][n] = true;
		}
		if(isSelected){
//			p = new PeaShooter(m,n,g,);
//			p.clean(g);
			isFilled[m][n] = false;
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
							Bullet b = plant.get(m+n*5).bullet.copy();
							bullet.add(b);
						}
					}
				}
			}	
		}
	}
}

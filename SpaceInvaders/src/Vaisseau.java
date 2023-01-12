import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Vaisseau {
	
	private int x, y;
	
	public Vaisseau() {
		x = 340;
		y = 400;
	}
    
	public void dessiner(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x-25, y-(int)12.5, 50, 25);
		
	}
	
	public void gauche() {
	  if(x-10-25>=0)
		x-=10;
	}
	
	public void droite() {
		if(x+10+25<640)
		x+=10;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	

}

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Projectile {
	private float x,y;
	private int vy;
	
	public Projectile(int x, int y, int vy) {
	  if(x>=0 && y>=0 && x<640 && y<480) {
		  this.x = x;
		  this.y = y;
	      this.vy = vy;
		
	  }
	  else {
		  this.x = 0;
		  this.y = 0;
	      this.vy = 0;
	  }
	}
	
	public void dessiner(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x-3, y-3, 6, 6);
	}
	
	public void deplacer(int delta) {
		float d = (vy*delta/1000f);
		y += d;
	}
	
	public boolean horsEcran() {
		if(y<=0)
			return true;
		else
			return false;
	}
	
	public boolean testCollision(Ennemi e) {
		if(this.x >= e.getX() && this.x <= e.getX()+30 && this.y >= e.getY() && this.y <= e.getX()+30)
		   return true;
		else
			return false;
	    
	}

}

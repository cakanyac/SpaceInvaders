import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Ennemi {
	
	private float x,y;
	private Color c;
	
	public Ennemi(float x, float y, Color c) {
	  if(x>=0 && x<610 && y>0 && y<450) {
		this.x = x;
		this.y = y;
	  }
	  else {
		this.x = 0;
		this.y = 0;
	  }
		this.c = c;
	}
	
	public void dessiner(Graphics g) {
		g.setColor(c);
		g.fillRect(x, y, 30, 30);
		
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
	  if(x>=0 && x<640)
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
	  if(y>=0 && y<480)
		this.y = y;
	}

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}

	
	

}

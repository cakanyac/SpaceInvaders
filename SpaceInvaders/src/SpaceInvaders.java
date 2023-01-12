

import java.util.ArrayList;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class SpaceInvaders extends BasicGame {
	
	private Ennemi[][] ennemis = new Ennemi[10][6];
	private Vaisseau v;
	
	private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

	public SpaceInvaders(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void init(GameContainer gc) throws SlickException {
		// TODO Auto-generated method stub
		
		for(int i=0; i<10; i++) {
			for(int j=0; j<6; j++) {
				float x = 155+33*i;
				float y = 50+33*j;
				Color[] couleurs = {Color.red, Color.orange, Color.yellow, Color.green, Color.pink, Color.blue};
				Color c = couleurs[j];		
				
				ennemis[i][j] = new Ennemi(x,y,c);
			}
		}
		
		
		v = new Vaisseau();

	}
	

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++) {
			for(int j=0; j<6; j++) {
				if(ennemis[i][j]!=null)
				ennemis[i][j].dessiner(g);
			}
		}
		
		v.dessiner(g);
		
		for(int i=0; i<projectiles.size(); i++) {
			projectiles.get(i).dessiner(g);
		}
		

	}


	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		// TODO Auto-generated method stub
		
		Input inp = gc.getInput();
		
		if(inp.isKeyPressed(Input.KEY_LEFT)) {
			v.gauche();
		}
		if(inp.isKeyPressed(Input.KEY_RIGHT)) {
			v.droite();
		}
		
		for(int i = 0; i<projectiles.size(); i++) {
			projectiles.get(i).deplacer(delta);
		}
		
		for(int i = 0; i < projectiles.size(); i++) {
			if(projectiles.get(i).horsEcran())
				projectiles.remove(i);
			    i--;
		}
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 6; j++) {
				for(int k = 0; k < projectiles.size(); k++) {
					if(ennemis[i][j] != null && projectiles.get(k).testCollision(ennemis[i][j])) {
						ennemis[i][j] = null;
						projectiles.remove(k);
						k--;
					}
				}
			}
		}
		
		if(inp.isKeyPressed(Input.KEY_SPACE) && projectiles.size()<5)
			projectiles.add(new Projectile(v.getX(), v.getY(), -250));

	}
	
	

}

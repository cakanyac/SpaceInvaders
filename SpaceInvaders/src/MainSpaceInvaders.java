import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class MainSpaceInvaders {

	public static void main(String[] args) throws SlickException {
		// TODO Auto-generated method stub
		AppGameContainer app = new AppGameContainer(new SpaceInvaders("Space Invaders"));
		app.setShowFPS(false);
		app.start();
	}

}

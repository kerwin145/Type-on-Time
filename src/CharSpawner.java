import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
public class CharSpawner {
	Game game;
	//Rectangle hitbox;
	double posY = 40;
	double posX = Math.random()*1350 +16;
	public CharSpawner(Game game) {
		this.game = game;
	}
	
	//Test
	Note note = new Note(posX,posY);
	public void TimeDelay() {
		
	}
}

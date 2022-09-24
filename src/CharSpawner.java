import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import Game.GameMode;
public class CharSpawner {
	Game game;
	//Rectangle hitbox;
	double posX;
	double posY;
	double velX;
	double velY;
	
	public CharSpawner(Game game) {
		this.game = game;

		switch(Game.gameMode) {
			case HORIZONTAL:
				double random = Math.random();
				if(random < 0.5) {
					posX = -charWidth;
					posY = (int) (Math.round((Math.random()) * Game.HEIGHT) - charHeight / 2);
					velX = (Game.WIDTH / 2) / time; 
					velY = ((posX + charHeight / 2) - Game.HEIGHT / 2) / time;
				} else {
					posX = Game.WIDTH;
					posY = (int) (Math.round((Math.random()) * Game.HEIGHT) - charHeight / 2);
					velX = -(Game.WIDTH / 2) / time; 
					velY = ((posX + charHeight / 2) - Game.HEIGHT / 2) / time;
				}
			case VERTICAL:
				posX = (int) (Math.round((Math.random()) * Game.WIDTH) - charWidth / 2);
				posY = -charHeight;
				velX = ((posX + charWidth / 2) - Game.WIDTH / 2) / time;
				velY = (Game.HEIGHT / 2) / time;
			case RADIAL:
				double random = Math.round((Math.random() * (2 * (Game.WIDTH + Game.HEIGHT))));
				if(random < Game.WIDTH) { // TOP
					posX = (int) (Math.round((Math.random()) * Game.WIDTH) - charWidth / 2);
					posY = -charHeight;
					velX = ((posX + charWidth / 2) - Game.WIDTH / 2) / time;
					velY = (Game.HEIGHT / 2) / time;
				} else if(random < Game.WIDTH + Game.HEIGHT) { // RIGHT
					posX = Game.WIDTH;
					posY = (int) (Math.round((Math.random()) * Game.HEIGHT) - charHeight / 2);
					velX = -(Game.WIDTH / 2) / time; 
					velY = ((posX + charHeight / 2) - Game.HEIGHT / 2) / time;
				} else if(random < Game.WIDTH * 2 + Game.HEIGHT) { // BOTTOM
					posX = (int) (Math.round((Math.random()) * Game.WIDTH) - charWidth / 2);
					posY = Game.HEIGHT;
					velX = ((posX + charWidth / 2) - Game.WIDTH / 2) / time;
					velY = -(Game.HEIGHT / 2) / time;
				} else { // LEFT
					posX = -charWidth;
					posY = (int) (Math.round((Math.random()) * Game.HEIGHT) - charHeight / 2);
					velX = (Game.WIDTH / 2) / time; 
					velY = ((posX + charHeight / 2) - Game.HEIGHT / 2) / time;
				}
		}
	}
	
	//Test
	Note note = new Note(posX,posY);
	public void TimeDelay() {
		
	}
}

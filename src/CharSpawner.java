import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class CharSpawner {
	Game game;
	//Rectangle hitbox;
	double posX;
	double posY;
	double velX;
	double velY;
	double time;
	private double timeDelay = 0;
	private long currentTime;
	private long lastTime = Game.universalTime; //set to universal time at game start
	
	public CharSpawner(Game game) {
		this.game = game;

		switch(Game.gameMode) {
			case HORIZONTAL:
				double random1 = Math.random();
				if(random1 < 0.5) {
					posX = -Note.size;
					posY = (int) (Math.round((Math.random()) * Game.HEIGHT) - Note.size / 2);
					velX = (Game.WIDTH / 2) / time; 
					velY = ((posX + Note.size / 2) - Game.HEIGHT / 2) / time;
				} else {
					posX = Game.WIDTH;
					posY = (int) (Math.round((Math.random()) * Game.HEIGHT) - Note.size / 2);
					velX = -(Game.WIDTH / 2) / time; 
					velY = ((posX + Note.size / 2) - Game.HEIGHT / 2) / time;
				}
				break;
			case VERTICAL:
				posX = (int) (Math.round((Math.random()) * Game.WIDTH) - Note.size / 2);
				posY = -Note.size;
				velX = ((posX + Note.size / 2) - Game.WIDTH / 2) / time;
				velY = (Game.HEIGHT / 2) / time;
				break;
			case RADIAL:
				double random2 = Math.round((Math.random() * (2 * (Game.WIDTH + Game.HEIGHT))));
				if(random2 < Game.WIDTH) { // TOP
					posX = (int) (Math.round((Math.random()) * Game.WIDTH) - Note.size / 2);
					posY = -Note.size;
					velX = ((posX + Note.size / 2) - Game.WIDTH / 2) / time;
					velY = (Game.HEIGHT / 2) / time;
				} else if(random2 < Game.WIDTH + Game.HEIGHT) { // RIGHT
					posX = Game.WIDTH;
					posY = (int) (Math.round((Math.random()) * Game.HEIGHT) - Note.size / 2);
					velX = -(Game.WIDTH / 2) / time; 
					velY = ((posX + Note.size / 2) - Game.HEIGHT / 2) / time;
				} else if(random2 < Game.WIDTH * 2 + Game.HEIGHT) { // BOTTOM
					posX = (int) (Math.round((Math.random()) * Game.WIDTH) - Note.size / 2);
					posY = Game.HEIGHT;
					velX = ((posX + Note.size / 2) - Game.WIDTH / 2) / time;
					velY = -(Game.HEIGHT / 2) / time;
				} else { // LEFT
					posX = -Note.size;
					posY = (int) (Math.round((Math.random()) * Game.HEIGHT) - Note.size / 2);
					velX = (Game.WIDTH / 2) / time; 
					velY = ((posX + Note.size / 2) - Game.HEIGHT / 2) / time;
				}
				break;
		}
	}
	
	//Test
	Note note = new Note(posX,posY);
	public void tick(){
		currentTime = game.universalTime;
		if(currentTime - lastTime  >= timeDelay) {
			Note newNote = new Note(1,2); //placeholder
			int randomChar = (int)Math.random()*25+65;
			newNote.setNoteType((char)randomChar);
			//int[] beat = {1,2,3};//1 is quarter note, 2 is eight note, 3 is sixteenth note
			int randomInt = (int)Math.random()*2+1;
			if (randomInt == 1) {
				timeDelay = 40; //Represents a quarter note in a 90 BPM song
			} else if (randomInt ==2) {
				timeDelay =20; //Eighth note
			} else {
				timeDelay =10;//Sixteenth note
			}
			lastTime = Game.universalTime;
		}
	}
	
}

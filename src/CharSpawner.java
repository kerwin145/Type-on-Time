import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CharSpawner {
	Game game;
	//Rectangle hitbox;
	private LinkedList<Note> noteList; 
	double posX;
	double posY;
	double velX;
	double velY;
	double time = 8;
	private double timeDelay = 0;
	private long currentTime;
	private long lastTime = Game.universalTime; //set to universal time at game start
	
	
	Map<Character, Integer> charRowMap = new HashMap<Character, Integer>();
	
	
	public CharSpawner(Game game) {
		this.game = game;
		
		noteList = game.levelManager.noteList;
		charRowMap.put('Q', 1);
		charRowMap.put('A', 1);
		charRowMap.put('Z', 1);
		charRowMap.put('W', 2);
		charRowMap.put('S', 2);
		charRowMap.put('X', 2);
		charRowMap.put('E', 3);
		charRowMap.put('D', 3);
		charRowMap.put('C', 3);
		charRowMap.put('R', 4);
		charRowMap.put('F', 4);
		charRowMap.put('V', 4);
		charRowMap.put('T', 5);
		charRowMap.put('G', 5);
		charRowMap.put('B', 5);
		charRowMap.put('Y', 6);
		charRowMap.put('H', 6);
		charRowMap.put('N', 6);
		charRowMap.put('U', 7);
		charRowMap.put('J', 7);
		charRowMap.put('M', 7);
		charRowMap.put('I', 8);
		charRowMap.put('K', 8);
		charRowMap.put('O', 9);
		charRowMap.put('L', 9);
		charRowMap.put('P', 10);

	}
	
	//Test
	public void tick(){
		currentTime = game.universalTime;
		if(currentTime - lastTime  >= timeDelay) {
			int randomChar = (int)(Math.random()*25)+65;
//			while ((char)randomChar == noteList.getLast().getNoteType()) {
//				randomChar = (int)Math.random()*25+65; 
				//loop checks to make sure that the previous spawned note
				//is not the same as the currently spawning note
		
			//}
			//int[] beat = {1,2,3};//1 is quarter note, 2 is eight note, 3 is sixteenth note
			int randomInt = (int)Math.random()*2+1;
			if (randomInt == 1) {
				timeDelay = 40; //Represents a quarter note in a 90 BPM song
			} else if (randomInt ==2) {
				timeDelay =20; //Eighth note
			} else {
				timeDelay =10;//Sixteenth note
			}
			
			
			switch(Game.gameMode) {
				case HORIZONTAL:
					double random1 = Math.random();
					if(random1 < 0.5) {
						posX = -Note.size;
						posY = (int) (Math.round((Math.random()) * Game.HEIGHT) - Note.size / 2);
						velX = (Game.WIDTH) / time;
					} else {
						posX = Game.WIDTH;
						posY = (int) (Math.round((Math.random()) * Game.HEIGHT) - Note.size / 2);
						velX = -(Game.WIDTH) / time;
					}
					break;
				case VERTICAL:
					posX = (int) (Math.round((Math.random()) * Game.WIDTH) - Note.size / 2);
					posY = -Note.size;
					velY = Game.HEIGHT / time;
					System.out.println("At charspawner 78: PosX: " + posX + ", posY: " + posY + ", velX: " +  velX+ ", velY: " + velY );

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

			Note newNote = new Note(posX, posY, velX, velY, (char)randomChar); //placeholder

			game.levelManager.noteList.add(newNote);
			game.levelManager.noteMap.put((char)randomChar, game.levelManager.noteMap.get((char)randomChar) + 1);
			lastTime = Game.universalTime;
		}
	}
	
}

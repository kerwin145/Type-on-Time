
public class CharSpawner {
	Game game;
	double posY = 40;
	double posX = Math.random()*1350 +16;
	public CharSpawner(Game game) {
		this.game = game;
	}
	
	//Test
	Note note = new Note(posX,posY);
}

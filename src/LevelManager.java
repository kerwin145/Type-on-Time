import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LevelManager {
	Game game;

	
	public LevelManager(Game game) {
		this.game = game;
	}
	
	LinkedList<CharNote> noteList = new LinkedList<CharNote>();
	Map<Character, Integer> noteMap = new HashMap<Character, Integer>();

	public void tick(){

			//update and prune
			int i = 0;
			while(i < noteList.size()){

				//2 is a temporary variable
				noteList.get(i).posY += 2;

				if(noteList.get(i).posY > Game.HEIGHT * Game.SCALE) noteList.remove(noteList.get(i));
				else i++;

			}
	
	}
}

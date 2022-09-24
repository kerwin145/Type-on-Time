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
}

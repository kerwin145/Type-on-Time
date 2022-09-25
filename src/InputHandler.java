import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class InputHandler implements KeyListener {
	Game game;

	Map<Integer, Boolean> keysPressed = new HashMap<Integer, Boolean>();
	public InputHandler(Game game) {
		this.game = game;
		for(int i = 65; i <= 90; i++)
			keysPressed.put(i, false);

	}
		
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		char noteChar = Character.toUpperCase(e.getKeyChar());
		if(keysPressed.get(e.getKeyCode()) == false){
			if(game.levelManager.noteMap.get(noteChar) > 0){
				game.levelManager.gradeNote(noteChar);
				keysPressed.put(e.getKeyCode(), true);
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		keysPressed.put(e.getKeyCode(), false);

	}
	
}

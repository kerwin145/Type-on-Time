import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {
	Game game;
	public InputHandler(Game game) {
		this.game = game;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		Character noteChar = (char) e.getKeyCode();
		if(game.levelManager.noteMap.containsKey(noteChar)){
			game.levelManager.gradeNote(noteChar);
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
}

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.MouseEvent;
import java.awt.Rectangle;

import javax.swing.event.MouseInputListener;


public class InputHandler implements KeyListener, MouseInputListener {
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

	int mx = -1, my = -1;

	@Override
	public void mouseClicked(MouseEvent e) {
		if (Game.gameScreen == Game.GameScreen.LEVELSELECT){
			if (clickInBounds(game.levelSelectScreen.verticalSelect.getBounds())){
				Game.gameMode = Game.GameMode.VERTICAL;
			} else if (clickInBounds(game.levelSelectScreen.horizontalSelect.getBounds())){
				Game.gameMode = Game.GameMode.HORIZONTAL;
			} else if (clickInBounds(game.levelSelectScreen.radialSelect.getBounds())){
				Game.gameMode = Game.GameMode.RADIAL;
			} else if (clickInBounds(game.levelSelectScreen.increaseSelect.getBounds())) GameData.onScreenTime += 0.25;
			else if (clickInBounds(game.levelSelectScreen.decreaseSelect.getBounds())) GameData.onScreenTime -= 0.25;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mx = e.getX(); 
		my = e.getY();		
	}

				
	public boolean clickInBounds(Rectangle rectangle) {
		if((mx >= rectangle.x && mx <= rectangle.x + rectangle.width) && (my >= rectangle.y && my <= rectangle.y + rectangle.height)){
			return true;
		}
		else return false;
	}
	
}

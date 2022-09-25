import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.MouseEvent;
import java.awt.Rectangle;

import javax.swing.event.MouseInputListener;

public class InputHandler implements KeyListener, MouseInputListener {
	Game game;

	public InputHandler(Game game) {
		this.game = game;

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		char noteChar = Character.toUpperCase(e.getKeyChar());
		if(game.levelManager.noteMap.get(noteChar) > 0){
			game.levelManager.gradeNote(noteChar);
		}
		
		if (Game.gameScreen == Game.GameScreen.PLAY){
			if(e.getKeyCode() == e.VK_ESCAPE){
				Game.gameScreen = Game.GameScreen.LEVELSELECT;
				game.levelManager.resetField();
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {

	}

	int mx = -1, my = -1;

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mx = e.getX(); 
		my = e.getY();		
		if (Game.gameScreen == Game.GameScreen.TITLE){
			if (clickInBounds(game.titleScreen.playButton.getBounds())) {
				Game.gameScreen = Game.GameScreen.LEVELSELECT;
			} else if (clickInBounds(game.titleScreen.exitButton.getBounds())){
				System.exit(0);
			}
		}
		else if (Game.gameScreen == Game.GameScreen.LEVELSELECT){
			// System.out.println("PRESSED? " + mx  + ", " + my);
			// System.out.println(game.levelSelectScreen.verticalSelect.getBounds().toString());

			if (clickInBounds(game.levelSelectScreen.verticalSelect.getBounds())) {
				Game.gameMode = Game.GameMode.VERTICAL;
				Game.gameScreen = Game.GameScreen.PLAY;
				System.out.println("Starting Vertical");
			} else if (clickInBounds(game.levelSelectScreen.horizontalSelect.getBounds())) {
				Game.gameMode = Game.GameMode.HORIZONTAL;
				Game.gameScreen = Game.GameScreen.PLAY;
				System.out.println("Starting Horizontal");
			} else if (clickInBounds(game.levelSelectScreen.radialSelect.getBounds())) {
				Game.gameMode = Game.GameMode.RADIAL;
				Game.gameScreen = Game.GameScreen.PLAY;
				System.out.println("Starting Radial");
			} else if (clickInBounds(game.levelSelectScreen.increaseSelect.getBounds()))
				GameData.onScreenTime += 0.25;
			else if (clickInBounds(game.levelSelectScreen.decreaseSelect.getBounds()))
				GameData.onScreenTime -= 0.25;
		}
		else if (Game.gameScreen == Game.GameScreen.END){
			if (clickInBounds(game.endScreen.retryButton.getBounds())) {
				Game.gameScreen = Game.GameScreen.LEVELSELECT;
			} else if (clickInBounds(game.endScreen.exitButton.getBounds())){
				Game.gameScreen = Game.GameScreen.TITLE;
			}
		}

		
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

	}

	public boolean clickInBounds(Rectangle rectangle) {
		if ((mx >= rectangle.x && mx <= rectangle.x + rectangle.width)
				&& (my >= rectangle.y && my <= rectangle.y + rectangle.height)) {
			return true;
		} else
			return false;
	}

}

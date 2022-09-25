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
		
		
		if (Game.gameScreen == Game.GameScreen.PLAY){
			if(game.levelManager.noteMap.containsKey(noteChar) && game.levelManager.noteMap.get(noteChar) > 0){
				game.levelManager.gradeNote(noteChar);
			}

			if(e.getKeyCode() == e.VK_ESCAPE){
				Game.gameScreen = Game.GameScreen.LEVELSELECT;
			}
			if(e.getKeyCode() == e.VK_ENTER){
				Game.gameScreen = Game.GameScreen.END;
				game.endScreen.initEndPage(game.scoreBoard.currentScore);
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
				game.levelManager.initializeField();
				//Game.scoreBoard.
			} else if (clickInBounds(game.levelSelectScreen.horizontalSelect.getBounds())) {
				Game.gameMode = Game.GameMode.HORIZONTAL;
				Game.gameScreen = Game.GameScreen.PLAY;
				System.out.println("Starting Horizontal");
				game.levelManager.initializeField();
			} else if (clickInBounds(game.levelSelectScreen.radialSelect.getBounds())) {
				Game.gameMode = Game.GameMode.RADIAL;
				Game.gameScreen = Game.GameScreen.PLAY;
				System.out.println("Starting Radial");
				game.levelManager.initializeField();
			} 
			else if (clickInBounds(game.levelSelectScreen.increaseSelect.getBounds())){
				if(GameData.onScreenTime < 50) GameData.onScreenTime += 0.25;
			}
			else if (clickInBounds(game.levelSelectScreen.decreaseSelect.getBounds())){
				if(GameData.onScreenTime > .25 )GameData.onScreenTime -= 0.25;
			}
			else if (clickInBounds(game.levelSelectScreen.decreaseSelectDelay.getBounds())){
				if(GameData.delay > 2) GameData.delay -= 2;
			}
			else if (clickInBounds(game.levelSelectScreen.increaseSelectDelay.getBounds())){
				if(GameData.onScreenTime < 150) GameData.delay += 2;
			}
			
			
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

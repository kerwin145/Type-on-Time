import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import java.awt.Graphics;

public class LevelManager {
	Game game;

	public LinkedList<Note> noteList = new LinkedList<Note>();
	public Map<Character, Integer> noteMap = new HashMap<Character, Integer>();

	public LevelManager(Game game) {
		this.game = game;
		for(int i = 65; i <= 90; i++){
			noteMap.put((char)i, 0);
		}

	}
	public void resetField(){
		noteList.clear();
		for(int i = 65; i <= 90; i++){
			noteMap.put((char)i, 0);
		}

	}
	
	public void tick(){

		//update and prune
		int i = 0;
		while (i < noteList.size()) {
			Note note = noteList.get(i);

			note.incrementPosX();
			note.incrementPosY();

			// System.out.println("note: " + noteList.get(i).getNoteType() + ", at position:
			// (" + noteList.get(i).getPosX() + ", " + noteList.get(i).getPosY() + ")");
			if (Game.gameMode == Game.GameMode.VERTICAL) {
				if (note.getPosY() > Game.HEIGHT * Game.SCALE) {
					noteMap.put(note.getNoteType(), noteMap.get(note.getNoteType()) - 1);
					noteList.remove(note);
					game.scoreBoard.scoreStreak = 0;
				} else
					i++;
			} else if(Game.gameMode == Game.GameMode.HORIZONTAL) {
				if((note.getPosX() + Note.size / 2 > GameData.horiz_miss_right && note.getVelX() > 0)
						|| (note.getPosX() + Note.size / 2 < GameData.horiz_miss_left && note.getVelX() < 0)) {
					noteMap.put(note.getNoteType(), noteMap.get(note.getNoteType()) - 1);
					noteList.remove(note);
					game.scoreBoard.scoreStreak = 0;
				} else
					i++;
			} else if (Game.gameMode == Game.GameMode.RADIAL) {
				if ((note.getPosX() + Note.size / 2 > GameData.rad_miss_horizontal && note.getVelX() > 0)
						|| (note.getPosX() + Note.size / 2 < GameData.rad_miss_horizontal && note.getVelX() < 0)
						|| (note.getPosY() + Note.size / 2 > GameData.rad_miss_vertical && note.getVelY() > 0)
						|| (note.getPosY() + Note.size / 2 < GameData.rad_miss_vertical && note.getVelY() < 0)) {
					noteMap.put(note.getNoteType(), noteMap.get(note.getNoteType()) - 1);
					noteList.remove(note);
					game.scoreBoard.scoreStreak = 0;
				} else
					i++;
			}
			

		}
	}

	public void render(Graphics g) {
		for (Note note : noteList)
			note.render(g);
	}

	public void gradeNote(Character noteChar) {
		// get the earliest note that matches note char
		Note note = null;
		for (int i = 0; i < noteList.size(); i++) {
			if (noteList.get(i).getNoteType() == noteChar) {
				note = noteList.get(i);
				i = noteList.size();
			}
		}

		if (note == null) {
			System.out.println("NOTE DOES NOT EXIST. WHY AM I TRYING TO GRADE IT?");
			return;
		}

		double noteX = note.getPosX(), noteY = note.getPosY();

		if (Game.gameMode == Game.GameMode.VERTICAL) {
			if (GameData.VERTICAL_PERFECT.contains(note.getBounds().getX() + note.getBounds().getWidth() / 2,
					note.getBounds().getY() + note.getBounds().getHeight() / 2)) {
				game.popupManager.addPopup("PERFECT", noteX, noteY);
				noteList.remove(note);
				noteMap.put(noteChar, noteMap.get(noteChar) - 1);

				game.scoreBoard.scoreStreak += 1;
				game.scoreBoard.currentScore += (3 * (2 * game.scoreBoard.scoreStreak * 0.5));

			} else if (GameData.VERTICAL_GOOD.contains(note.getBounds().getX() + note.getBounds().getWidth() / 2,
					note.getBounds().getY() + note.getBounds().getHeight() / 2)) {
				game.popupManager.addPopup("GOOD", noteX, noteY);
				noteList.remove(note);
				noteMap.put(noteChar, noteMap.get(noteChar) - 1);

				game.scoreBoard.scoreStreak++;
				game.scoreBoard.currentScore += (2 * (1 * game.scoreBoard.scoreStreak * 0.5));
			} else if (GameData.VERTICAL_MEH.contains(note.getBounds().getX() + note.getBounds().getWidth() / 2,
					note.getBounds().getY() + note.getBounds().getHeight() / 2)) {
				game.popupManager.addPopup("MEH", noteX, noteY);
				noteList.remove(note);
				noteMap.put(noteChar, noteMap.get(noteChar) - 1);

				game.scoreBoard.currentScore++;
			} else {// if it is hit too early
				game.popupManager.addPopup("POOR", noteX, noteY);

				game.scoreBoard.scoreStreak = 0;
			}
		} else if (Game.gameMode == Game.GameMode.HORIZONTAL) {
			if (GameData.HORIZONTAL_PERFECT.contains(note.getBounds().getX() + note.getBounds().getWidth() / 2,
					note.getBounds().getY() + note.getBounds().getHeight() / 2)) {
				game.popupManager.addPopup("PERFECT", noteX, noteY);
				noteList.remove(note);
				noteMap.put(noteChar, noteMap.get(noteChar) - 1);

				game.scoreBoard.scoreStreak += 1;
				game.scoreBoard.currentScore += (3 * (2 * game.scoreBoard.scoreStreak * 0.5));

			} else if (GameData.HORIZONTAL_GOOD.contains(note.getBounds().getX() + note.getBounds().getWidth() / 2,
					note.getBounds().getY() + note.getBounds().getHeight() / 2)) {
				game.popupManager.addPopup("GOOD", noteX, noteY);
				noteList.remove(note);
				noteMap.put(noteChar, noteMap.get(noteChar) - 1);

				game.scoreBoard.scoreStreak++;
				game.scoreBoard.currentScore += (2 * (1 * game.scoreBoard.scoreStreak * 0.5));
			} else if (GameData.HORIZONTAL_MEH.contains(note.getBounds().getX() + note.getBounds().getWidth() / 2,
					note.getBounds().getY() + note.getBounds().getHeight() / 2)) {
				game.popupManager.addPopup("MEH", noteX, noteY);
				noteList.remove(note);
				noteMap.put(noteChar, noteMap.get(noteChar) - 1);

				game.scoreBoard.currentScore++;
			} else {// if it is hit too early
				game.popupManager.addPopup("POOR", noteX, noteY);

				game.scoreBoard.scoreStreak = 0;
			}
		} else if (Game.gameMode == Game.GameMode.RADIAL) {

			if (GameData.checkEllipse((int) noteX, (int) noteY, GameData.RADIAL_PERFECT[0], GameData.RADIAL_PERFECT[1],
					GameData.RADIAL_PERFECT[2], GameData.RADIAL_PERFECT[3])) {
				game.popupManager.addPopup("PERFECT", noteX, noteY);
				noteList.remove(note);
				noteMap.put(noteChar, noteMap.get(noteChar) - 1);

				game.scoreBoard.scoreStreak += 1;
				game.scoreBoard.currentScore += (3 * (2 * game.scoreBoard.scoreStreak * 0.5));

			} else if (GameData.checkEllipse((int) noteX, (int) noteY, GameData.RADIAL_GOOD[0], GameData.RADIAL_GOOD[1],
					GameData.RADIAL_GOOD[2], GameData.RADIAL_GOOD[3])) {
				game.popupManager.addPopup("GOOD", noteX, noteY);
				noteList.remove(note);
				noteMap.put(noteChar, noteMap.get(noteChar) - 1);

				game.scoreBoard.scoreStreak++;
				game.scoreBoard.currentScore += (2 * (1 * game.scoreBoard.scoreStreak * 0.5));
			} else if (GameData.checkEllipse((int) noteX, (int) noteY, GameData.RADIAL_MEH[0], GameData.RADIAL_MEH[1],
					GameData.RADIAL_MEH[2], GameData.RADIAL_MEH[3])) {
				game.popupManager.addPopup("MEH", noteX, noteY);
				noteList.remove(note);
				noteMap.put(noteChar, noteMap.get(noteChar) - 1);

				game.scoreBoard.currentScore++;
			} else {// if it is hit too early
				game.popupManager.addPopup("POOR", noteX, noteY);

				game.scoreBoard.scoreStreak = 0;
			}
		}
	}
}
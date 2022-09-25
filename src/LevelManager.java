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
	
	

	public void tick(){

		//update and prune
		int i = 0;
		while(i < noteList.size()){
			noteList.get(i).incrementPosX();
			noteList.get(i).incrementPosY();
			//System.out.println("note: " + noteList.get(i).getNoteType() + ", at position: (" + noteList.get(i).getPosX() + ", " + noteList.get(i).getPosY() + ")");
			if(noteList.get(i).getPosY() > Game.HEIGHT * Game.SCALE){
				noteMap.put(noteList.get(i).getNoteType(), noteMap.get(noteList.get(i).getNoteType())-1);
				noteList.remove(noteList.get(i));
			}
			else i++;

		}
	}

	public void render(Graphics g){
		for(Note note: noteList)
			note.render(g);
	}

	public void gradeNote(Character noteChar){
		//get the earliest note that matches note char
		Note note = null;
		for(int i = 0; i < noteList.size(); i++){
			if(noteList.get(i).getNoteType() == noteChar){
				note = noteList.get(i);
				i = noteList.size();
			}
		}

		if(note == null){
			System.out.println("NOTE DOES NOT EXIST. WHY AM I TRYING TO GRADE IT?");
			return;
		}

		if(Game.gameMode == Game.GameMode.VERTICAL){
			//check if the note can be graded (poor and miss checked first)
			if(note.getPosY() > GameData.vert_miss){
				System.out.println("MISS");
				//tick will automatically prune the note when it passes bottom of screen
				noteMap.put(noteChar, noteMap.get(noteChar)-1);

				game.scoreBoard.scoreStreak = 0;
			}
			else if(GameData.VERTICAL_PERFECT.contains(note.getBounds().getX() + note.getBounds().getWidth() / 2, note.getBounds().getY() + note.getBounds().getHeight() / 2)) {
				System.out.println("PERFECT!");
				noteList.remove(note);
				noteMap.put(noteChar, noteMap.get(noteChar)-1);

				game.scoreBoard.scoreStreak+=1;
				game.scoreBoard.currentScore+=(3*(2*game.scoreBoard.scoreStreak*0.5));
			
			}
			else if(GameData.VERTICAL_GOOD.contains(note.getBounds().getX() + note.getBounds().getWidth() / 2, note.getBounds().getY() + note.getBounds().getHeight() / 2)){
				System.out.println("GOOD");
				noteList.remove(note);
				noteMap.put(noteChar, noteMap.get(noteChar)-1);

				game.scoreBoard.scoreStreak++;
				game.scoreBoard.currentScore+=(2*(1*game.scoreBoard.scoreStreak*0.5));
			}
			else if(GameData.VERTICAL_MEH.contains(note.getBounds().getX() + note.getBounds().getWidth() / 2, note.getBounds().getY() + note.getBounds().getHeight() / 2)) {
				System.out.println("MEH");
				noteList.remove(note);
				noteMap.put(noteChar, noteMap.get(noteChar)-1);

				game.scoreBoard.currentScore++;
			}
			else{//if it is hit too early
				System.out.println("POOR");

				game.scoreBoard.scoreStreak = 0;
			}
		}   
	}
}
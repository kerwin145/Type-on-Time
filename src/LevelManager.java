import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class LevelManager {
	Game game;
	
	public LevelManager(Game game) {
		this.game = game;
	}
	
	public LinkedList<Note> noteList = new LinkedList<Note>();
	public Map<Character, Integer> noteMap = new HashMap<Character, Integer>();

	public void tick(){

		//update and prune
		int i = 0;
		while(i < noteList.size()){

			noteList.get(i).incrementPosX();
			noteList.get(i).incrementPosY();

			if(noteList.get(i).getPosY() > Game.HEIGHT * Game.SCALE) noteList.remove(noteList.get(i));
			else i++;

		}
	}

	//testing purposes
	public void render(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		g.setColor(Color.orange);
		

	}

	public void gradeNote(Character noteChar){
		//get the earliest note that matches note char
		Note note = null;
		for(int i = 0; i < noteList.size(); i++){
			
		}

		if(Game.gameMode == Game.GameMode.HORIZONTAL){
			//check if the note can be graded (poor and miss checked first)
			if(note.getPosX() > LevelData.vert_miss){
				System.out.println("MISS");
				//tick will automatically prune the note when it passes bottom of screen
				noteMap.put(noteChar, noteMap.get(noteChar)-1);
			}
			else if(note.getBounds().intersects(LevelData.VERTICAL_PERFECT)){
				System.out.println("PERFECT!");
				noteList.remove(note);
				noteMap.put(noteChar, noteMap.get(noteChar)-1);
			}
			else if(note.getBounds().intersects(LevelData.VERTICAL_GOOD)){
				System.out.println("GOOD");
				noteList.remove(note);
				noteMap.put(noteChar, noteMap.get(noteChar)-1);
			}
			else if(note.getBounds().intersects(LevelData.VERTICAL_BAD)){
				System.out.println("BAD");
				noteList.remove(note);
				noteMap.put(noteChar, noteMap.get(noteChar)-1);
			}
			else{//if it is hit too early
				System.out.println("POOR");
			}
	}
}

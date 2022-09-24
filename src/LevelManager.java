import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class LevelManager {
	Game game;
	public Gamemode gamemode;

	
	public LevelManager(Game game) {
		this.game = game;
	}

	public enum Gamemode{VERT, HORIZ, RAD}
	
	public LinkedList<Note> noteList = new LinkedList<Note>();
	public Map<Character, Integer> noteMap = new HashMap<Character, Integer>();

	public void tick(){

		//update and prune
		int i = 0;
		while(i < noteList.size()){

			/*
			noteList.get(i).posY += 2;

			if(noteList.get(i).posY > Game.HEIGHT * Game.SCALE) noteList.remove(noteList.get(i));
			else i++;
			 
			*/
		

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
			if(noteList.get(i).getNoteType() == noteChar)
				note = noteList.get(i);
		}

		if(Game.gameMode == Game.GameMode.HORIZONTAL){
			if(note.getBounds().intersects(LevelData.VERTICAL_PERFECT)){
				System.out.println("PERFECT!");
			}else if(note.getBounds().intersects(LevelData.VERTICAL_GOOD)){
				System.out.println("GOOD");
			}else if(note.getBounds().intersects(LevelData.VERTICAL_BAD)){
				System.out.println("BAD");
			}else{

			}
		}
	}
}

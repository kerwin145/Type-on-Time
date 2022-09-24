import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Note {
	private double posX, posY;
	public static int size;
	//font size would be the size variable
	private String noteType;
	//represents letter/number of object
	public Note(int x, int y) {
		posX = x;
		posY = y;
	}
	
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;	
		
		g2d.draw(getBounds());
		g.drawString("Hi", (int)posX, (int)posY);

		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)posX, (int)posY-size, size, size);
	}

	public double getPosX() {
		return posX;
	}


	public void setPosX(int posX) {
		this.posX = posX;
	}


	public double getPosY() {
		return posY;
	}


	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	
}

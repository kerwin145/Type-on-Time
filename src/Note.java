import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
// import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Note {
	private double posX, posY;
	private double velX;
	private double velY;
	public static int size = 30;
	public boolean skip = false;

	
	// font size would be the size variable
	private char noteType;

	// represents letter/number of object
	public Note(double x, double y, double velX, double velY, char noteType) {
		posX = x;
		posY = y;
		this.velX = velX;
		this.velY = velY;
		this.noteType = noteType;
	}

	public void render(Graphics g) {
		// Graphics2D g2d = (Graphics2D) g;

		Font fntTest = new Font("Verdana", Font.BOLD, size);
		g.setFont(fntTest);
		g.setColor(Color.black);

		g.drawString("" + noteType, (int) posX, (int) posY);

		// g2d.draw(getBounds());

	}

	public Rectangle getBounds() {
		return new Rectangle((int) posX, (int) posY - size, size, size);
	}

	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public void incrementPosX() {
		posX += velX / 60;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

	public void incrementPosY() {
		posY += velY / 60;
	}

	public char getNoteType() {
		return noteType;
	}

	public void setNoteType(char letter) {
		noteType = letter;
	}

	public double getVelX() {
		return velX;
	}

	public void setVelX(double velX) {
		this.velX = velX;
	}

	public double getVelY() {
		return velY;
	}

	public void setVelY(double velY) {
		this.velY = velY;
	}
}
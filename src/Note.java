import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Note{
	public double posX, posY;
	
	private int size = 12;
	//font size would be the size variable
	public CharNote() {
		
	}
	
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;	
		
	
		
		g2d.draw(getBounds());
		g.drawString("Hi", (int)posX, (int)posY);

		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)posX, (int)posY-size, size, size);
	}
	
	p
	
}

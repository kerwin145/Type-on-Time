import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class CharNote {
	private int posX, posY, size;
	//font size would be the size variable
	public CharNote() {
		
	}
	
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;	
		
		posX = 25;
		posY = 25;
		size = 12;
		
		Font fntTest = new Font("Verdana", Font.BOLD, size);
		
		g2d.draw(getBounds());
		g.drawString("Hi", posX, posY);

		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(posX, posY-size, size, size);
	}
	
	
}

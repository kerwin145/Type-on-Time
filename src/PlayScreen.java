
import DrawUtil.Rectangle_;
import DrawUtil.DrawFormat;
import DrawUtil.MoColors;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
public class PlayScreen{
    Game game;

    //public Rectangle_(int x, int y, int width, int height, String[] text, textPosition textPos, Font font, Color fontColor,
    
    int buttonWidth = 110;
    int buttonHeight = 30;
       

    public PlayScreen(Game game){
        this.game = game;
    }

    public void render(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.red);
        g2d.draw(LevelData.VERTICAL_BAD);
        g.setColor(Color.yellow);
        g2d.draw(LevelData.VERTICAL_GOOD);
        g.setColor(Color.green);
        g2d.draw(LevelData.VERTICAL_PERFECT);
		
    }
}
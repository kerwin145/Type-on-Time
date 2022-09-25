
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
        g.drawImage(Resources.gameBackground, 0, 0, null);

        /*
        g2d.fill(GameData.VERTICAL_BAD);
        g.setColor(Color.yellow);
        g2d.fill(GameData.VERTICAL_GOOD);
        g.setColor(Color.green);
        g2d.fill(GameData.VERTICAL_PERFECT);
         */

        //Graphics2D g2d = (Graphics2D) g;
       
		
    }
}
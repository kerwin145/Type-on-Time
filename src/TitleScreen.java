
import DrawUtil.Rectangle_;
import DrawUtil.Rectangle_.textPosition;
import DrawUtil.DrawFormat;
import DrawUtil.MoColors;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class TitleScreen{
    Game game;

    //public Rectangle_(int x, int y, int width, int height, String[] text, textPosition textPos, Font font, Color fontColor,
    
    int y1 = (int)(Game.HEIGHT * Game.SCALE * .18);

    int buttonWidth = 110;
    int buttonHeight = 30;
    
    
   // , textPosition.middle, 
    Rectangle_ playButton = new Rectangle_(0,0, buttonWidth, 30, "Play");
    Rectangle_ exitButton = new Rectangle_(0,0, buttonWidth, 30, "Exit");
  
       

    public TitleScreen(Game game){
        this.game = game;

        DrawFormat.setCentered_xy_spacing( 0,Game.WIDTH*game.SCALE, game.HEIGHT*game.SCALE,0,0, (int)(buttonHeight * .5), 
        new Rectangle_[][]{new Rectangle_[]{playButton}, new Rectangle_[]{exitButton}});
    }

    public void render(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        playButton.draw(g2d);
        exitButton.draw(g2d);
    }
}
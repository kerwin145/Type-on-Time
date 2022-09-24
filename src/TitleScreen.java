
import DrawUtil.Rectangle_;
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
    
    Rectangle_ playButton = new Rectangle_(0,0, buttonWidth, 30);
    Rectangle_ exitButton = new Rectangle_(0,0, buttonWidth, 30);


    DrawFormat.setCentered_xy_spacing( );

    DrawFormat.setCentered_xy_spacing(overview.y, GUI.WIDTH * GUI.SCALE, overview.y + overview.height, overview.x + overview.width, 40, 40, buttons);

    public TitleScreen(Game game){
        this.game = game;
    }

    public void render(Graphics g){
        Graphics2D g2d = Graphics2D()
    }
}
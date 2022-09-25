
import DrawUtil.Rectangle_;
import DrawUtil.Rectangle_.gradientFormat;
import DrawUtil.Rectangle_.textPosition;
import DrawUtil.DrawFormat;
import DrawUtil.MoColors;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class TitleScreen {

    Game game;

    int buttonWidth = (int) (180 + Game.WIDTH * Game.SCALE * .05);
    int buttonHeight = (int) (buttonWidth * .37);

    Font fntButton = new Font("Ink Free", Font.BOLD, 55);
    Font fntTitle = new Font("MV Boli", Font.PLAIN, 65);

    int y1 = (int) (30 + Game.HEIGHT * Game.SCALE * .08);

    Rectangle_ playButton = new Rectangle_(0, 0, buttonWidth, buttonHeight, "Play", fntButton);

    Rectangle_ exitButton = new Rectangle_(0, 0, buttonWidth, buttonHeight, "Exit", fntButton);
            
    Rectangle_ title = new Rectangle_(0, y1, Game.WIDTH,
            (int) (30 + Game.HEIGHT * Game.SCALE * .08), "Type on Time", fntTitle);
    /*
     * public Rectangle_(int x, int y, int width, int height, String text,
     * textPosition textPos, Font font, Color fontColor,
     * Color[] borderColors, Color[][] backgroundColors, gradientFormat gFormat, int
     * backgroundOpacity, int borderThickness, boolean hasDarkenedColors){
     * 
     */

    public TitleScreen(Game game) {
        this.game = game;

        DrawFormat.setCentered_xy_spacing(y1, Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE, 0, 0,
                (int) (buttonHeight * .5),
                new Rectangle_[][] { new Rectangle_[] { playButton }, new Rectangle_[] { exitButton } });

    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g.drawImage(Resources.titleBackground, 0, 0, null);

        g.setColor(MoColors.silver);
        playButton.draw(g2d);
        exitButton.draw(g2d);
        title.draw(g2d);

    }
}
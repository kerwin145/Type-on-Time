
import DrawUtil.Rectangle_;
import DrawUtil.Rectangle_.gradientFormat;
import DrawUtil.Rectangle_.textPosition;
import DrawUtil.DrawFormat;
import DrawUtil.MoColors;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class TitleScreen{

    Game game;

    int buttonWidth = (int)(180 + Game.WIDTH * Game. SCALE * .05);
    int buttonHeight = (int)(buttonWidth * .37);
    
    Font fntTitle = new Font("Cascadia Code", Font.PLAIN, 35);
    
    Rectangle_ playButton = new Rectangle_(0,0, buttonWidth, buttonHeight, "Play", textPosition.middle, fntTitle, MoColors.dimgray, new Color[]{MoColors.silver}, new Color[][]{new Color[]{MoColors.lightGreen, MoColors.paleGreen}}, gradientFormat.vertical, 1, 1, true);

    Rectangle_ exitButton = new Rectangle_(0,0, buttonWidth, buttonHeight, "Exit", textPosition.middle, fntTitle, MoColors.dimgray, new Color[]{MoColors.silver}, new Color[][]{new Color[]{MoColors.lightGreen, MoColors.paleGreen}}, gradientFormat.vertical, 1, 1, true);
         
   // Rectangle_ title = new Rectangle_(0,(int)(30 + Game.HEIGHT * Game.SCALE * .05), Game.WIDTH, (int)(130 + Game.HEIGHT * Game.SCALE * .05), "Type on Time");
   
   Rectangle_ title = new Rectangle_(0,0,200, 200, "Type on Time");
    /*
      public Rectangle_(int x, int y, int width, int height, String text, textPosition textPos, Font font, Color fontColor,
    Color[] borderColors,  Color[][] backgroundColors, gradientFormat gFormat, int backgroundOpacity, int borderThickness, boolean hasDarkenedColors){

     */


    public TitleScreen(Game game){
        this.game = game;

        DrawFormat.setCentered_xy_spacing( 0,Game.WIDTH*game.SCALE, game.HEIGHT*game.SCALE,0,0, (int)(buttonHeight * .5), 
        new Rectangle_[][]{new Rectangle_[]{playButton}, new Rectangle_[]{exitButton}});
      
    }

    public void render(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        g.drawImage(Resources.titleBackground, 0, 0, null);

       
        title.draw(g2d);
        playButton.draw(g2d);
        exitButton.draw(g2d);

    }
}
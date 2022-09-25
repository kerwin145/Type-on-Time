import DrawUtil.Rectangle_;
import DrawUtil.Rectangle_.gradientFormat;
import DrawUtil.Rectangle_.textPosition;
import DrawUtil.DrawFormat;
import DrawUtil.MoColors;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.xml.stream.events.EndElement;

public class EndScreen{

    Game game;
    int buttonWidth = (int) (180 + Game.WIDTH * Game.SCALE * .05);
    int buttonHeight = (int) (buttonWidth * .37);

    Font fntTitle = new Font("Cascadia Code", Font.PLAIN, 35);
    Font fntMsg = new Font("Cascadia Code", Font.PLAIN, 40);
    
    Rectangle_ retryButton = new Rectangle_(0,0, buttonWidth, buttonHeight, "Retry", textPosition.middle, fntTitle, MoColors.dimgray, new Color[]{MoColors.silver}, new Color[][]{new Color[]{MoColors.lightGreen, MoColors.paleTurqouise}}, gradientFormat.vertical, 1, 1, true);

    Rectangle_ exitButton = new Rectangle_(0,0, buttonWidth, buttonHeight, "Back to Title", textPosition.middle, fntTitle, MoColors.dimgray, new Color[]{MoColors.silver}, new Color[][]{new Color[]{MoColors.lightGreen, MoColors.paleTurqouise}}, gradientFormat.vertical, 1, 1, true);
         

    int y1 = (int)(Game.HEIGHT * .05 + 40), y2 = (int)(y1 + 20 + Game.HEIGHT * .03), height = (int)(35 + Game.HEIGHT * .1);

    Rectangle_ endMessage = new Rectangle_(0, y1, Game.WIDTH, height, "Score ? ");
    Rectangle_ endMessage2 = new Rectangle_(0, y2, Game.WIDTH, height,  
    "High Score ? ");
    /*
     * public Rectangle_(int x, int y, int width, int height, String text,
     * textPosition textPos, Font font, Color fontColor,
     * Color[] borderColors, Color[][] backgroundColors, gradientFormat gFormat, int
     * backgroundOpacity, int borderThickness, boolean hasDarkenedColors){
     * 
     */

    public EndScreen(Game game) {
        this.game = game;

        endMessage.setFont(fntTitle);
        endMessage2.setFont(fntTitle);

        DrawFormat.setCentered_xy_spacing(0, Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE, 0, 0,
                (int) (buttonHeight * .5),
                new Rectangle_[][] { new Rectangle_[] { retryButton }, new Rectangle_[] { exitButton } });

        
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g.drawImage(Resources.titleBackground, 0, 0, null);
        g.setColor(MoColors.turquoise);
        endMessage.draw(g2d);
        endMessage2.draw(g2d);
       
        /*
         g.setFont(new Font("", Font.PLAIN, 40));
         g.drawString("Game Over!\n Your Score is " + game.scoreBoard.currentScore, (Game.WIDTH/2)-250, 200);
         g.drawString("High Score: " + game.scoreBoard.highestScore, (Game.WIDTH/2)-250, (int)(200 + g.getFont().getSize() * 1.5));
        */ 

        retryButton.draw(g2d);
        exitButton.draw(g2d);

    }

    public void initEndPage(int currentScore){
		if(game.scoreBoard.currentScore > game.scoreBoard.highestScore) game.scoreBoard.highestScore = game.scoreBoard.currentScore;
        endMessage.setText("Game Over! Your Score is: " + game.scoreBoard.currentScore);
        endMessage2.setText("High Score: " + game.scoreBoard.highestScore);
    
    }
}
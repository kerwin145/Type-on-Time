import DrawUtil.Rectangle_;
import DrawUtil.stringGraphics;
import DrawUtil.Rectangle_.gradientFormat;
import DrawUtil.Rectangle_.textPosition;
import DrawUtil.MoColors;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;

public class LevelSelectScreen {
    String[] verticalText = {"Vertical"};
    String[] horizontalText = {"Horizontal"};
    String[] radialText = {"Radial"};
    String[] increaseText = {"+"};
    String[] decreaseText = {"-"};
    Color[][] bgColors = {{MoColors.azure},{MoColors.blanchedAlmond}};
    Font font = new Font( "Arial", Font.BOLD, 16);
    Font font2 = new Font("Arial", Font.BOLD, 32);
    public Rectangle speedRectangle = new Rectangle(300, 800, 400, 100);
    public Rectangle_ verticalSelect = new Rectangle_(100,400,125,280, verticalText, textPosition.middle, font, MoColors.black, null, null, gradientFormat.none, 100, 0, true );
    public Rectangle_ horizontalSelect = new Rectangle_(300, 400, 125, 280, horizontalText, textPosition.middle, font, MoColors.black, null, null, gradientFormat.none,100,0, true);
    public Rectangle_ radialSelect  = new Rectangle_(500, 400, 125, 280, radialText, textPosition.middle, font, MoColors.black, null, null, gradientFormat.none, 100, 0, true);
    public Rectangle_ increaseSelect = new Rectangle_(200, 570, 100, 100, increaseText, textPosition.middle, font2, MoColors.black, null, null, gradientFormat.none, 100, 0, true);
    public Rectangle_ decreaseSelect = new Rectangle_(200, 600, 100, 100, decreaseText, textPosition.middle, font2, MoColors.black, null, null, gradientFormat.none, 100, 0, true);
    public stringGraphics speedDisplay = new stringGraphics();
    
    Rectangle_[] buttons = {verticalSelect, horizontalSelect, radialSelect, increaseSelect, decreaseSelect};

    public void render(Graphics g){
    Graphics2D g2d = (Graphics2D) g;
    for (Rectangle_ button: buttons){
        button.draw(g2d);
    } 
    g.setColor(MoColors.darkBlue);
    g.setFont(new Font("Verdana", Font.PLAIN, 26));
    //DrawUtil.stringGraphics.drawStringCentered("Time Letters are on Screen: ", speedRectangle, g2d);
    g.drawString("Time Letters are on Screen: ", 290, 638);
    g.setFont(new Font("Verdana", Font.BOLD, 32));
    g.drawString("Level Select", 573, 100);

   
    
    }
}

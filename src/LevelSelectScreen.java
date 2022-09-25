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
    String[] verticalText = { "Vertical" };
    String[] horizontalText = { "Horizontal" };
    String[] radialText = { "Radial" };
    String[] increaseText = { "+" };
    String[] decreaseText = { "-" };
    Color[] borderColors = { MoColors.darkBlue };
    Color[][] bgColors = { { MoColors.azure }, { MoColors.blanchedAlmond } };
    Font font = new Font("Arial", Font.BOLD, 24*Game.SCALE);
    Font font2 = new Font("Arial", Font.BOLD, 32*Game.SCALE);
    public Rectangle_ verticalSelect = new Rectangle_(100*Game.SCALE, 300*Game.SCALE, 200*Game.SCALE, 100*Game.SCALE, verticalText, textPosition.middle, font,
            MoColors.black, borderColors, null, gradientFormat.none, 100, 3*Game.SCALE, true);
    public Rectangle_ horizontalSelect = new Rectangle_(300*Game.SCALE, 300*Game.SCALE, 200*Game.SCALE, 100*Game.SCALE, horizontalText, textPosition.middle, font,
            MoColors.black, borderColors, null, gradientFormat.none, 100, 3*Game.SCALE, true);
    public Rectangle_ radialSelect = new Rectangle_(500*Game.SCALE, 300*Game.SCALE, 200*Game.SCALE, 100*Game.SCALE, radialText, textPosition.middle, font,
            MoColors.black, borderColors, null, gradientFormat.none, 100, 3*Game.SCALE, true);
    public Rectangle_ increaseSelect = new Rectangle_(200*Game.SCALE, 470*Game.SCALE, 35*Game.SCALE, 35*Game.SCALE, increaseText, textPosition.middle, font2,
            MoColors.black, borderColors, null, gradientFormat.none, 100, 0, true);
    public Rectangle_ decreaseSelect = new Rectangle_(200*Game.SCALE, 530*Game.SCALE, 35*Game.SCALE, 35*Game.SCALE, decreaseText, textPosition.middle, font2,
            MoColors.black, borderColors, null, gradientFormat.none, 100, 0, true);


    int yStart = decreaseSelect.y + decreaseSelect.height + 40;
public Rectangle_ increaseSelectDelay = new Rectangle_(200*Game.SCALE, yStart*Game.SCALE, 35*Game.SCALE, 35*Game.SCALE, increaseText, textPosition.middle, font2,
    MoColors.black, borderColors, null, gradientFormat.none, 100, 0, true);
public Rectangle_ decreaseSelectDelay = new Rectangle_(200*Game.SCALE, (yStart + 60)*Game.SCALE, 35*Game.SCALE, 35*Game.SCALE, decreaseText, textPosition.middle, font2,
    MoColors.black, borderColors, null, gradientFormat.none, 100, 0, true);


    Rectangle_[] buttons = { verticalSelect, horizontalSelect, radialSelect, increaseSelect, decreaseSelect, increaseSelectDelay, decreaseSelectDelay };

    public void render(Graphics g) {
        g.drawImage(Resources.titleBackground, 0, 0, null);

        Graphics2D g2d = (Graphics2D) g;
        for (Rectangle_ button : buttons) {
            button.draw(g2d);
        }
        g.setColor(MoColors.darkBlue);
        g.setFont(new Font("Verdana", Font.PLAIN, 24*Game.SCALE));
        g.drawString("Select Level Type: ", 50*Game.SCALE, 200*Game.SCALE);
        g.setFont(new Font("Verdana", Font.PLAIN, 26*Game.SCALE));
        // DrawUtil.stringGraphics.drawStringCentered("Time Letters are on Screen: ",
        // speedRectangle, g2d);
        g.drawString("Time letters are on screen (lower is faster): " + GameData.onScreenTime, 290*Game.SCALE, (increaseSelect.y + decreaseSelect.y)/2 *Game.SCALE);
        g.drawString("Time between letter spawns (lower is denser), average: " + 
                (Math.round(GameData.delay/60.0 * 7/12 * 100)) / 100.0 + " sec.", 290*Game.SCALE, (increaseSelectDelay.y + decreaseSelectDelay.y)/2 *Game.SCALE);
        

        g.setFont(new Font("Verdana", Font.PLAIN, 18));
        g.drawString("To begin, click one of the level select options.", Game.WIDTH * Game.SCALE / 2 + 155, verticalSelect.y + font.getSize());
        g.drawString("Once game begins, press the enter key to end game", Game.WIDTH * Game.SCALE / 2 + 155, verticalSelect.y+ 20 + font.getSize());
        g.drawString("Or hit escape to return to level select screen.", Game.WIDTH * Game.SCALE / 2 + 155,verticalSelect.y+ 40 + font.getSize());

        g.setFont(new Font("Verdana", Font.BOLD, 32*Game.SCALE));
        g.drawString("Level Select", 573*Game.SCALE, 100*Game.SCALE);
       // g.drawString(GameData.onScreenTime + "", 920*Game.SCALE, 640*Game.SCALE);

    }
}

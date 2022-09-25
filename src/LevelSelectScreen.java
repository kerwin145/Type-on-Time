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
    public Rectangle speedRectangle = new Rectangle(300*Game.SCALE, 800*Game.SCALE, 400*Game.SCALE, 100*Game.SCALE);
    public Rectangle_ verticalSelect = new Rectangle_(100*Game.SCALE, 400*Game.SCALE, 200*Game.SCALE, 100*Game.SCALE, verticalText, textPosition.middle, font,
            MoColors.black, borderColors, null, gradientFormat.none, 100, 3*Game.SCALE, true);
    public Rectangle_ horizontalSelect = new Rectangle_(300*Game.SCALE, 400*Game.SCALE, 200*Game.SCALE, 100*Game.SCALE, horizontalText, textPosition.middle, font,
            MoColors.black, borderColors, null, gradientFormat.none, 100, 3*Game.SCALE, true);
    public Rectangle_ radialSelect = new Rectangle_(500*Game.SCALE, 400*Game.SCALE, 200*Game.SCALE, 100*Game.SCALE, radialText, textPosition.middle, font,
            MoColors.black, borderColors, null, gradientFormat.none, 100, 3*Game.SCALE, true);
    public Rectangle_ increaseSelect = new Rectangle_(200*Game.SCALE, 570*Game.SCALE, 35*Game.SCALE, 35*Game.SCALE, increaseText, textPosition.middle, font2,
            MoColors.black, borderColors, null, gradientFormat.none, 100, 0, true);
    public Rectangle_ decreaseSelect = new Rectangle_(200*Game.SCALE, 630*Game.SCALE, 35*Game.SCALE, 35*Game.SCALE, decreaseText, textPosition.middle, font2,
            MoColors.black, borderColors, null, gradientFormat.none, 100, 0, true);
    public stringGraphics speedDisplay = new stringGraphics();

    Rectangle_[] buttons = { verticalSelect, horizontalSelect, radialSelect, increaseSelect, decreaseSelect };

    public void render(Graphics g) {
        g.drawImage(Resources.titleBackground, 0, 0, null);

        Graphics2D g2d = (Graphics2D) g;
        for (Rectangle_ button : buttons) {
            button.draw(g2d);
        }
        g.setColor(MoColors.darkBlue);
        g.setFont(new Font("Verdana", Font.PLAIN, 24*Game.SCALE));
        g.drawString("Select Level Type: ", 50*Game.SCALE, 350*Game.SCALE);
        g.setFont(new Font("Verdana", Font.PLAIN, 26*Game.SCALE));
        // DrawUtil.stringGraphics.drawStringCentered("Time Letters are on Screen: ",
        // speedRectangle, g2d);
        g.drawString("Time Letters are on Screen (Lower Is Faster): ", 290*Game.SCALE, 638*Game.SCALE);
        g.setFont(new Font("Verdana", Font.BOLD, 32*Game.SCALE));

        g.drawString("Level Select", 573*Game.SCALE, 100*Game.SCALE);
        g.drawString(GameData.onScreenTime + "", 920*Game.SCALE, 640*Game.SCALE);

    }
}

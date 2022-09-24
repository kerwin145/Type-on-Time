import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ScoreIndicator {
    private String result;
    private double x;
    private double y;
    private int alpha;
    public static final int FONT_SIZE = 50;


    public ScoreIndicator(String result, double x, double y) {
        this.x = x;
        this.y = y;
        this.result = result;
    }

    public void renderScore(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(new Font("Verdana", Font.ITALIC, FONT_SIZE));
        Color color = new Color(22, 216, 213, (int) alpha);
        g2d.setColor(color);
        g2d.drawString(this.result, (int) x, (int) y);
    }

    public void tick() {
        // must implement way of having alpha stay the same for 30 ticks, then progressively
        // fade for 120 ticks before the ScoreIndicator object gets deleted
        if(currentTick > 30 && currentTick < 120){
            alpha -= 255/90;
        } else if(currentTick > 120) {
            alpha = 0;
            // delete current score object
        }
    }

}
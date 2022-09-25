import java.awt.Font;
import java.awt.Graphics;
// import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import DrawUtil.MoColors;

import java.awt.Color;

public class PopupManager {
    Game game;

    LinkedList<Popup> popUpList = new LinkedList<Popup>();
    List<Popup> toRemove = new ArrayList<Popup>();

    public PopupManager(Game game) {
        this.game = game;
    }

    public void addPopup(String result, double x, double y) {
        // cap it to reduce chance of comod
        try {
            popUpList.add(new Popup(result, x, y));
        } catch (ConcurrentModificationException e) {
            System.out.println("Comodification: UwU list is busy!");
        }
    }

    public void tick() {
        for (Iterator<Popup> iterator = popUpList.iterator(); iterator.hasNext();) {
            Popup p = iterator.next();
            p.tick();
            if (p.getAlpha() <= 0) {
                toRemove.add(p);
            }
        }
        popUpList.removeAll(toRemove);
    }

    public void render(Graphics g) {
        g.setFont(new Font("Verdana", Font.ITALIC, 20));
        for (Iterator<Popup> iterator = popUpList.iterator(); iterator.hasNext();) {
            Popup p = iterator.next();
            p.render(g);
        }
    }
}

class Popup {
    private String result;
    private double x;
    private double y;
    private double alpha = 255;
    private int red, green, blue;

    private long startTime, currentTime;

    public Popup(String result, double x, double y) {
        this.x = x;
        this.y = y;
        this.result = result;

        Color c = Color.red;
        switch (result) {
            case "PERFECT":
                c = MoColors.lightGreen;
                break;
            case "GOOD":
                c = MoColors.royalBlue;
                break;
            case "MEH":
                c = MoColors.crimson;
            case "POOR":
                c = MoColors.silver;
                break;
            case "MISS":
                c = MoColors.gainsboro;
                break;
        }

        red = c.getRed();
        green = c.getGreen();
        blue = c.getBlue();

        startTime = Game.universalTime;
        currentTime = Game.universalTime;
    }

    public void render(Graphics g) {
        // Graphics2D g2d = (Graphics2D) g;

        if (alpha >= 0)

            g.setColor(new Color(red, green, blue, (int) alpha));

        g.drawString(this.result, (int) x, (int) y);
    }

    public void tick() {
        currentTime = Game.universalTime;
        // alpha starts at 255, at 75 ticks (5/4 seconds), it goes to 0.
        alpha = -1 * Math.pow((currentTime - startTime), 2) * .04533333333 + 255;
    }

    public int getAlpha() {
        return (int) alpha;
    }

}

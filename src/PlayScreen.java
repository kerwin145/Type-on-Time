import java.awt.Graphics;

public class PlayScreen {
    Game game;

    // public Rectangle_(int x, int y, int width, int height, String[] text,
    // textPosition textPos, Font font, Color fontColor,

    int buttonWidth = 110;
    int buttonHeight = 30;

    public PlayScreen(Game game) {
        this.game = game;
    }

    public void render(Graphics g) {
        switch (Game.gameMode) {
            case HORIZONTAL:
                g.drawImage(Resources.gameBackground, 0, 0, null);
                break;
            case RADIAL:
                g.drawImage(Resources.radialBackground, 0, 0, null);
                break;
            case VERTICAL:

        }

        /*
         * g2d.fill(GameData.VERTICAL_BAD);
         * g.setColor(Color.yellow);
         * g2d.fill(GameData.VERTICAL_GOOD);
         * g.setColor(Color.green);
         * g2d.fill(GameData.VERTICAL_PERFECT);
         */

        // Graphics2D g2d = (Graphics2D) g;

    }
}
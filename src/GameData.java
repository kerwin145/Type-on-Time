import java.awt.Rectangle;

public class GameData{
    private static final int vert_yHoriz = (int)(.85 * Game.HEIGHT * Game.SCALE);
    private static int vert_perfect_range = (int)(Game.HEIGHT * Game.SCALE * .008);
    private static int vert_good_range = (int)(Game.HEIGHT * Game.SCALE * .03);
    private static int vert_bad_range = (int)(Game.HEIGHT * Game.SCALE * .05);
    
    
    public static double onScreenTime = 8;
    
    public  static int vert_miss = (int)(.95 * Game.HEIGHT * Game.SCALE);
    public static final Rectangle VERTICAL_PERFECT = new Rectangle(0, vert_yHoriz - vert_perfect_range, Game.WIDTH * Game.SCALE, vert_perfect_range*2);
    public static final Rectangle VERTICAL_GOOD = new Rectangle(0, vert_yHoriz - vert_good_range, Game.WIDTH * Game.SCALE, vert_good_range*2);
    public static final Rectangle VERTICAL_BAD = new Rectangle(0, vert_yHoriz - vert_bad_range, Game.WIDTH * Game.SCALE, vert_bad_range*2);

    public static final int HORIZONTAL_X_HORIZON = (int)(.5 * Game.HEIGHT * Game.SCALE);
}
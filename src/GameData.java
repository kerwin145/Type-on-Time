import java.awt.Rectangle;


public class GameData{
    private static final int vert_yHoriz = (int)(.85 * Game.HEIGHT * Game.SCALE);
    private static int vert_perfect_range = (int)(Game.HEIGHT * Game.SCALE * .008);
    private static int vert_good_range = (int)(Game.HEIGHT * Game.SCALE * .03);
    private static int vert_meh_range = (int)(Game.HEIGHT * Game.SCALE * .05);

    private static double difficultyConstant = 1.05; //the higher, the easier
    private static int radHeight_perfect_range = (int)(Game.HEIGHT * Game.SCALE * .015 * difficultyConstant);
    private static int radHeight_good_range = (int)(Game.HEIGHT * Game.SCALE * .03 * difficultyConstant);
    private static int radHeight_meh_range = (int)(Game.HEIGHT * Game.SCALE * .05 * difficultyConstant);
    private static int radWidth_perfect_range = (int)(Game.WIDTH * Game.SCALE * .02667 * difficultyConstant);
    private static int radWidth_good_range = (int)(Game.WIDTH * Game.SCALE * .05336 * difficultyConstant);
    private static int radWidth_meh_range = (int)(Game.WIDTH * Game.SCALE * .08893 * difficultyConstant);

    public static double onScreenTime = 8;
    
    public static int vert_miss = (int)(.95 * Game.HEIGHT * Game.SCALE);
    public static final Rectangle VERTICAL_PERFECT = new Rectangle(0, vert_yHoriz - vert_perfect_range, Game.WIDTH * Game.SCALE, vert_perfect_range*2);
    public static final Rectangle VERTICAL_GOOD = new Rectangle(0, vert_yHoriz - vert_good_range, Game.WIDTH * Game.SCALE, vert_good_range*2);
    public static final Rectangle VERTICAL_MEH = new Rectangle(0, vert_yHoriz - vert_meh_range, Game.WIDTH * Game.SCALE, vert_meh_range*2);

    public static final int HORIZONTAL_X_HORIZON = (int)(.5 * Game.HEIGHT * Game.SCALE);

    
    // there is no ellipse object, just pseudo stuff for Ellipse(center x coord, center y coord, x radius, y radius)
    public static int rad_miss = (int)(Game.WIDTH / 2); 

    public static final int[] RADIAL_PERFECT = {(int) (Game.WIDTH * Game.SCALE / 2), (int) (Game.HEIGHT * Game.SCALE / 2), radHeight_perfect_range * 2, radWidth_perfect_range * 2};
    public static final int[] RADIAL_GOOD = {(int) (Game.WIDTH * Game.SCALE / 2), (int) (Game.HEIGHT * Game.SCALE / 2), radHeight_good_range * 2, radWidth_good_range * 2};
    public static final int[] RADIAL_MEH = {(int) (Game.WIDTH * Game.SCALE / 2), (int) (Game.HEIGHT * Game.SCALE / 2), radHeight_meh_range * 2, radWidth_meh_range * 2};

    public static boolean checkEllipse(int h, int k, int x, int y, int a, int b){

    int p = ((int)Math.pow((x - h), 2) / (int)Math.pow(a, 2))
            + ((int)Math.pow((y - k), 2) / (int)Math.pow(b, 2));
 
    if (p <= 1) return true;
    return false;
    }
}
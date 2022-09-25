import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class ScoreBoard {
	Game game;
	public int currentScore = 0;
	public int highestScore = 0;
	public int scoreStreak = 0;
	private int numPosX = 1300;
	private int numPosY = 15;
	public static int numSize = 20;

	public ScoreBoard(Game game) {
		this.game = game;
	}

	public void render(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		// Font fntTest = new Font("Verdana", Font.BOLD, numSize);

		g2d.draw(createBorder());
		g2d.draw(createBorderStreak());

		Integer currentScoreI = Integer.valueOf(currentScore);
		String currentScoreS = currentScoreI.toString();
		Integer highestScoreI = Integer.valueOf(highestScore);
		String highestScoreS = highestScoreI.toString();
		Integer scoreStreakI = Integer.valueOf(scoreStreak);
		String scoreStreakS = scoreStreakI.toString();

		g.setColor(Color.RED);
		g.drawString("Current: " + currentScoreS, numPosX + 1, numPosY + 11);
		g.drawString("High: " + highestScoreS, numPosX + 1, numPosY + 21);
		g.setColor(Color.MAGENTA);
		g.drawString("Streak: " + scoreStreakS, numPosX + 1, numPosY + 55);

	}

	public void tick() {
		String currentScoreS = "" + currentScore;
	}

	public Rectangle createBorder() {
		return new Rectangle(numPosX, numPosY, 63, 30);
	}

	public Rectangle createBorderStreak() {
		return new Rectangle(numPosX + 1, numPosY + 40, 60, 20);
	}
}
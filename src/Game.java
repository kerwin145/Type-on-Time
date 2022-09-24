import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{

    public static final int WIDTH = 1366;
    public static final int HEIGHT = 768;
    public static final int SCALE = 1;
    public final String TITLE = "Quick Maths";
    private boolean running;
    private Thread thread;
	
    public LevelManager levelManager = new LevelManager(this);
    public CharSpawner  charSpawner = new CharSpawner(this);
    
    public static int universalTime = 0;

    public static enum GameMode{HORIZONTAL, VERTICAL, RADIAL};
    public static GameMode gameMode = GameMode.HORIZONTAL;
     
    public void init() {
        this.requestFocus();
    }
    	
	public Game() {
		running = false;
	}
	
	public void run() {
	
        this.init();
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        final double ns = Math.pow(10, 9) / amountOfTicks ;
        double delta = 0.0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();
        while (this.running) {
            final long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1.0) {
            	
                tick();
               updates++;
                --delta;
               
                universalTime++;
            }
            ++frames;
            render();
            if (System.currentTimeMillis() - timer > 1000L) {
                timer += 1000L;
          
                System.out.println("Frames: " + frames + ", ticks: " + updates);
                updates = 0;
                frames = 0;
            }
        }
        this.stop();
    }
    
	private void tick() {
		
	}
	
	private void render()  {
		final BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(2);
            return;
        }
        final Graphics g = bs.getDrawGraphics();
  
        //rendering begins here
        
        g.dispose();
        bs.show();
	}
    
	private synchronized void start() {
        if (this.running) {
            return;
        }

        this.running = true;
        
        (this.thread = new Thread(this)).start();
    }
    
    private synchronized void stop() {

        if (!this.running) {
            return;
        }
        this.running = false;
        try {
            this.thread.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    
	public static void main(String[] args) {
		System.out.println("It's a great day to debug");
        final Game game = new Game();
        game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        game.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        game.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        
        final JFrame frame = new JFrame("Type on Time");
        frame.add(game);
        frame.setDefaultCloseOperation(3);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        game.start();
    }


	

}

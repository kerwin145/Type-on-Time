import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.awt.FontFormatException;
import java.io.IOException;

public class Resources {
    public static BufferedImage titleBackground;
    public static BufferedImage gameBackground;
    public static BufferedImage radialBackground;

    public static Font fntTitle;

    public Resources(){
        try {
            titleBackground = ImageIO.read(new File("Resources/TitleBackground.png"));
            gameBackground = ImageIO.read(new File("Resources/HorizontalBackground.png"));
            radialBackground = ImageIO.read(new File("Resources/RadialBackground.png"));
        } 
        catch (IOException e) 
        {
            System.out.println("image not found");
        }

        
        try {
            fntTitle = Font.createFont(Font.TRUETYPE_FONT, new File("Resources/Helvetica.ttf")).deriveFont(30f);
        } catch (FontFormatException|IOException e) {
            System.out.println("Font not found");
        } 
         GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

    }
       
   

   
 
}

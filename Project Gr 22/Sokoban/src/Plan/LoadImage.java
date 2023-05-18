package Plan;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 *  @authors Hind Dakkeh and Khaled Mhjazi
 */

public class LoadImage {

	
	
	
	/**
     * Method importImg save all images files in an array to be used in the game.
     * @throws IOException if can not be found images.
     * @return Img array with all the images.
     
     */
    public static BufferedImage[] importImg() throws IOException {
    	
    	int i = 0;
    	
        File[] img = { new File("./Sokoban/src/images/blank.png"),
        		 new File("./Sokoban/src/images/player.png"), 
        			new File("./Sokoban/src/images/wall.png"),
        		     new File("./Sokoban/src/images/blankmarked.png"),
        		       new File("./Sokoban/src/images/cratemarked.png"),
                        new File("./Sokoban/src/images/crate.png"), 
           
        };

        BufferedImage[] Img = new BufferedImage[6];
        
        for (File f : img) {
          
				Img[i] = ImageIO.read(f);
            i++;
        }
        return Img;
    }
}
	
	


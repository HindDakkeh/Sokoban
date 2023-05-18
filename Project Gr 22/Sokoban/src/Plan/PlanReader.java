package Plan;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

import model.Blank;
import model.Blank_Marked;
import model.Body;
import model.Crate;
import model.Model;
import model.Player;
import model.Position;
import model.Wall;



/**
 *  @authors Hind Dakkeh and Khaled Mhjazi
 */

public class PlanReader {
 
	

    /**
     *Method readPlan create the body from a specified plan file
     
     * @return body[][] plan, it is body array with all the numbers imported from text file
     */
	 
public static Body[][] readPlan(String s){
	        

	int[][] plan = null;

	        try {
	            File newPlan = new File(s);

	      plan = Files.lines(newPlan.toPath())
	         .map((line) -> line.trim().split(","))
	         .map((token) -> Stream.of(token).mapToInt(Integer::parseInt).toArray())
             .toArray(int[][]::new);
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }

	         if (plan != null) {
	            return readPlan(plan);
	        } else {
	            return null;
	        }

	    }

	    /**
	     * Method readPlan create the body through put number of plan files
	     * @return body[][] , it is Body array with all the numbers imported from text file
	     */

public static Body[][] readPlan(int n){
	       
	   int[][] plan = null;

	        try {
	       
	    File newPlan = new File("./Sokoban/src/PlanMatrix/p"+ n);

	     plan = Files.lines(newPlan.toPath())
	        .map((line) -> line.trim().split(","))
	        .map((token) -> Stream.of(token).mapToInt(Integer::parseInt).toArray())
	        .toArray(int[][]::new);
	       
	        }
	        
	        catch (IOException e) {
	            e.printStackTrace();
	        }

	        if (plan != null) {
	         
	        	return readPlan(plan);
	        } else {
	            return null;
	        }

	    }

	

/**
 * Method readPlan have an array int[][] plan, that check the number which refer to a specific block 
 * @return body array that have all blocks
 */

public static Body[][] readPlan(int[][] plan) {

    
    Body[][] body = new Body[plan.length][plan[0].length];
    
    for (int i = 0; i < plan.length; i++) {
        for (int j = 0; j < plan[0].length; j++) {
        	
            switch (plan[i][j]) {
               
            case 0 -> body[i][j] = new Blank(new Position(i, j));
                			
                case 1 -> body[i][j] = new Player(new Position(i, j));
                		
                   case 2 -> body[i][j] =  new Wall(new Position(i, j));
                
                     case 3 -> body[i][j] = new Blank_Marked(new Position(i, j));
               
                        case 4 -> body[i][j] = new Crate(new Position(i, j), true);
                		
                          case 5 -> body[i][j] = new Crate(new Position(i, j), false);
            }
        }
    }

    return body;
   }



/**
 * Get number of the specific block
 * @return Number of block
 */
public static int getBlockNumber(Model.Blocks block) {
    
	switch (block) {
        
        case BLANK -> {
            return 0;
        }
        case PLAYER ->  {
            return 1;
        }
        case WALL -> {
            return 2;
        }
        case BLANK_MARKED  -> {
            return 3;
        }
        case  CRATE_MARKED -> {
            return 4;
        }
        case CRATE  -> {
            return 5;
        }
    }
    return 10;
}


	
}

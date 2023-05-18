package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;




/**
 *  @authors Hind Dakkeh and Khaled Mhjazi
 */

public class Keyboard extends KeyAdapter implements GameController{

	
    Controller con;

    /**
     * Constructor for Keyboard
     */
    public Keyboard() {
        this.con = null;
    }
    
    
    /**
     * Override method for keyPressed connected to getKeyCode
     * @param e the event of key pressed
     * @see KeyEvent
     */
       @Override
    
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
        
        //  move left
        case 37 :  con.setDirection(Controller.Direction.LEFT);
        break;
        
        // move up
        case 38 :  con.setDirection(Controller.Direction.UP);
        break;
        
         // move Right 
        case 39 :  con.setDirection(Controller.Direction.RIGHT);
        break;
        
          // move down
        case 40 :  con.setDirection(Controller.Direction.DOWN);
        break;
        
        // By pressing R to reset the game
        
        case 82 : con.restartLevel();
        
        }
            
    }

    /**
     * method to add a new controller
     * @param controller Input the controller
     * @see Controller
     */
    @Override
    
    public void addController(Controller controller) {
        con = controller;
    }
}

	



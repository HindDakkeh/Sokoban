package controller;

import model.Model;

/** 
 * @authors Hind Dakkeh and Khaled Mhjazi.
 */


public class Controller {

private Model model;

private final GameController g; 

/**
 * Constructor for controller
 * @param g inputs the controller to be use
 */

public Controller(GameController g) {
    this.g = g;
    g.addController(this);
}




/**
 * Create Direction enum
 */
public enum Direction { UP,DOWN,LEFT,RIGHT}
   
    
/**
 * Method to add model
 */

public void addModel(Model model) {
    this.model = model;
}

/**
 * Method to get model
 * @return model
 */
public Model getModel() {
    return model;
} 
    

/**
 * Method to get controller
 * @return game
 */
public GameController getGameController() {
    return g;
}
    

/**
 * Method to set direction for player
 * @param direction Set the direction 
 */
public void setDirection(Direction direction) {
    model.movePlayer(direction);
}

/**
 * Restart level
 * @see Model
 */
public void restartLevel() {
    model.setPlanLevel(model.getLevel());
}

	
	
}

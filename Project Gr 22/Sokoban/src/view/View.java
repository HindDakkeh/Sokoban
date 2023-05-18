package view;

import java.util.ArrayList;

import controller.Controller;
import model.Model;
import java.util.List;


/**
 *  @authors Hind Dakkeh and Khaled Mhjazi
 */


public class View {

	
    private Model model;
    
    private Controller controller;


    private final List<ViewObs> observers = new ArrayList<>();

    /**
     * Method to add new view observer
     * @param v the viewObs that added to the observer list
     * */
    
    public void addObserver(ViewObs v) {
    	
        observers.add(v);
    }


    /**
     * Method to add new model
     * */

    public void addModel(Model model) {
        this.model = model;
    }

    /**
     *Method to get current controller
     * @return The current controller
     */
    public Controller getController() {
        return controller;
    }

    
    /**
     * Method to add new controller
     * */

    public void addController(Controller controller) {
        this.controller = controller;
    }

    /**
     * Method to display the board to all the view observers
     * */
    public void display() {
    	
        for(ViewObs obs: observers)
            obs.updateBoard(model.getBoard());
    }

    /**
     * Method to refresh the plan by display
     * */

    public void refresh() {
        display();
    }
	
	
	
}

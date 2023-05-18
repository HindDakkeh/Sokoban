package model;
import java.util.ArrayList;
import Plan.PlanReader;
import controller.Controller;
import view.View;


/**
 *  @authors Hind Dakkeh and Khaled Mhjazi
 */


public class Model {

	/**
     * List of all the observers that listens on the events
     * */
    private final ArrayList<EventObs> eventObsList = new ArrayList<>();

    
    /**
     * Reference to the view
     */
    private View view;
	
	
    /* The current board
    */
   private Board board;

   
   /**
    * The current level
    */
   private int level;

   /**
    * reference to the player
    * */
   private Player player;

   
	  /**
     * Enumeration of the different objects in game 
     */
	  public enum Blocks{
	       
	        WALL, PLAYER,  CRATE,  CRATE_MARKED, BLANK_MARKED, BLANK  
	       
	    }
	       
	      
	  /**
	     * Enumeration of the different events in game
	     */
	      
	  public enum Events{
	       
		  PLAYER_STAND,  PLAYER_MOVE,   CRATE_MOVE, CRATE_ON_MARKED, WIN
	    }       
	       
	   
	  
	  /*
	   *  Contractor initializes the model by creating a game board, 
	   *  retrieving the player, and establishing the necessary relationships 
	   *  between the model, 
	   *  player, and game board. 
	   */
	  public Model(int l)  {
	       
		  level = l;
	        
	        board = new Board(PlanReader.readPlan(level));
	        
	        board.setLevel(level);

	        player = board.getPlayer();
	      
	        
	        player.addModel(this);
	        
	        board.addModel(this);

	        board.addMarkers(board);
	    }
	  
	  
	  
	  
	  public Model(String levelp)   {
		  
	        level = 0;
	        
	        board = new Board(PlanReader.readPlan(levelp)); 
	        board.setLevel(level);

	        player = board.getPlayer();
	        
	        
	        player.addModel(this);
	        board.addModel(this);

	        board.addMarkers(board);
	    }
	  
	  
	  
	  /*
	     * Method to add view
	   
	     */
	    public void addView(View view) {
	        this.view = view;
	    }

	  
	    /**
	     * Method to get player
	     * @return Player
	     * */
	    public Player getPlayer(){
	        return player;
	    }
	
	    
	   /**
	     * Method to get board
	    * @return board
	     * */
	    public Board getBoard(){
	        return board;
	    }

	    /**
	     * Method to get view
         * @return View
	     * */
	    public View getView() {
	        return view;
	    }

	    
	    
	    /**
	     * Method to get level
	     * @return current level
	     */
	    public int getLevel() {
	        return level;
	    }

	    /**
	     * Method to set level
	     * @param level input of new level
	     */
	    public void setLevel(int level) {
	        this.level = level;
	    }
	    
	    
	    
	    /**
	     * Method to add event observer
	     */
	    public void addEventObserver(EventObs e){
	        eventObsList.add(e);
	    }

	    
	    
	  /**
	     * Method to notify observers of event.
	     * @param event Input the event to be update
	     
	     */
	    public void notifyObservers(Events event){
	       
			for(EventObs e : eventObsList){
	            e.UpdateEvent(event);
	        }

	        //Reset to default
	        for(EventObs e : eventObsList){
	            e.UpdateEvent(Events.PLAYER_STAND);
	        }
	    }
	
	    
	    /**
	     * Method to move player according to direction
	      * */
	    
	    public void movePlayer(Controller.Direction direction) {

	    	switch (direction) {
	        case UP:
	            player.moveUp();
	            break;
	        case DOWN:
	            player.moveDown();
	            break;
	        case LEFT:
	            player.moveLeft();
	            break;
	        case RIGHT:
	            player.moveRight();
	            break;
	        default:
	            break;
	    }

	    }
	    	
	    	
	    	/*
	         * Method to get new level when finished
	         
	         */
	    	
	        public void setPlanLevel(int l){
	        	
	            level = (l%3);
	            
	            board = new Board(PlanReader.readPlan(level));

	            player = board.getPlayer();
	            
	            player.addModel(this);

	            board.getMarkers().clear();
	            board.addMarkers(board);
	            board.setLevel(l);
	            board.addModel(this);


	            view.refresh();
	        

	    	
	    	
	    	
	    }

	    
	
}

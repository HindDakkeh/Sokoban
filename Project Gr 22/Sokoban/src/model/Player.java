package model;


/**
 *  @authors Hind Dakkeh and Khaled Mhjazi
 */

public class Player extends Body {

	
	/**
     * Reference to the model
     * */
    private Model m;

    /**
     * The block that is back the player
     * */
    private Body back;
	
    /**
     * The position of the player
     * */
    private Position p;

    /**
     * Constructor for Player
     * @param start position for player
     */
    public Player(Position start) {
        super(Model.Blocks.PLAYER, start);
         p = start;
        back = new Blank(p);
    }
    
    /**
     * Method to set object that is back player
     * @param back Set the block back the player
     */
    public void setBackPlayer( Body back) {
        this.back = back;
    }
    
    

    /**
    * Method to add new model
    */
    public void addModel(Model m) {
        this.m = m;
    }
    
    
    
    
    /**
     * Method to move player in the different cases 
     * @param newP New position to be move to it

     */
    public void move(Position newP) throws IllegalAccessException {

        Board board = m.getBoard();

        if(newP.getRow() > board.getRows()-1 || newP.getRow()  < 0 ||
                newP.getCol() > board.getColumns()-1 || newP.getCol() < 0 ){
            throw new IllegalAccessException("Can not move outside plan");
        }

        // moving two steps in the column and row direction.
        int row1 = 2*(newP.getRow()- p.getRow());
        int col1 = 2*(newP.getCol()- p.getCol());

        // check if there is the wall in the new position 
        switch(board.getPlan(newP.getRow(),newP.getCol()).getBlock()) {
            case WALL: //Wall
                break;
                
                // check if there are two crates or crate and wall (behind each other).
                
            case CRATE_MARKED ,CRATE:
            	
                switch (board.getPlan(p.getRow() + row1, p.getCol() +col1).getBlock()){
                
                    case WALL,CRATE_MARKED,CRATE: 
                    	
                        break;
                    
     
           default: {
                      

                boolean isMarker = false;
                        
                 //check if there is blank marked on the new position.
                       
                for (int i = 0; i < board.getMarkers().size(); i++) {
                            
                	if (board.getMarkers().get(i).getP().equals(newP)) {
                                
                  		isMarker = true;
                               
                   		board.setPlan(board.getMarkers().get(i).getP().getRow(), board.getMarkers().get(i).getP().getCol(), board.getMarkers().get(i));
                        
                	}
                        }

              if (!isMarker) {
                
            	      board.setPlan(newP.getRow(), newP.getCol(), new Blank(newP));
                  
              }
              
              
              

                        //Move the crate
                    board.setPlan(p.getRow() + row1, p.getCol() + col1, new Crate(p, false));

                      //Checks if the crate is a marker
  
               for (Blank_Marked marked : board.getMarkers()) {
               
            	   if (marked.getP().getRow() == p.getRow() + row1 && marked.getP().getCol() == p.getCol() + col1) {
                     
            	   board.setPlan(p.getRow() + row1, p.getCol() + col1, new Crate (marked.getP(), true));
                     
                     m.notifyObservers(Model.Events.CRATE_ON_MARKED);
               
                     break;
                 
               }
                        }

                        m.notifyObservers(Model.Events.CRATE_MOVE);
                        movePlayerOnPlan(board, newP);
                    }
                    break;
                }
                break;
            
          default: 
                movePlayerOnPlan(board,newP);
                break;
        }
        

        for (int i = 0; i < board.getMarkers().size(); i++) {
        	
        	Position s = board.getMarkers().get(i).getP();
            
        	switch ( board.getPlan(s.getRow(), s.getCol()).getBlock() ) {
        		
        	case  BLANK :
        		
        		board.setPlan(s.getRow(), s.getCol(), new Blank_Marked(s));
			 break;
			 
        	
        	default:
				break;
        		
        	}}

       
        if(m.getView() != null){
            m.getView().refresh();
        }

        m.notifyObservers(Model.Events.PLAYER_MOVE);
        

        //Check if game is win
        checkWinToMove(board);
        
    }

    
    
    
    
    
    /**
     * Method to move player position up
     * @see Position
     */
    public void moveUp(){
        Position newP = new Position(p.getRow(),p.getCol());

        newP.setRow(newP.getRow() - 1);
        try{
            move(newP);
        }
        catch(IllegalAccessException e){
            e.printStackTrace();
        }
    }
    
    
    /**
     * Method to move player position down
     * @see Position
     */
    public void moveDown(){
        Position newP = new Position(p.getRow(),p.getCol());

        newP.setRow(newP.getRow() + 1);
        try{
            move(newP);
        }
        catch(IllegalAccessException e){
            e.printStackTrace();
        }
    }
    
    
    
    /**
     * Method to move player position left
     * @see Position
     */
    public void moveLeft(){
        Position newP = new Position(p.getRow(),p.getCol());

        newP.setCol(newP.getCol() - 1);
        try{
            move(newP);
        }
        catch(IllegalAccessException e){
            e.printStackTrace();
        }
    }

    
    
    
    /**
     * Method to move player position right
     * @see Position
     */
    public void moveRight(){
        Position newP = new Position(p.getRow(),p.getCol());

        newP.setCol(newP.getCol() + 1);
        try{
            move(newP);
        }
        catch(IllegalAccessException e){
            e.printStackTrace();
        }
    }
    
    
    
    
    /**
     * Method to change player background and move it on plan
     * @param newPos New position
        */
    public void movePlayerOnPlan(Board plan, Position newPos) {
        
    	
        	
        plan.setPlan(p.getRow(), p.getCol(), new Blank(newPos));
        
        

        p = newPos;

        back = plan.getPlan(p.getRow(),p.getCol());
       
      
        
        //Move the player to the new position
        
       plan.setPlan(p.getRow(),p.getCol(),this);
       
     

    }
    
    
    /*
     * Method to check if game win
    
     */
    public void checkWinToMove(Board board){
        if(board.win()){ 
            if(m.getView() != null){
                try {
                    m.setPlanLevel(m.getLevel()+1);
                }
                catch (Exception e){
                    System.out.println("Can not move to next level");
                }
              }
            }
          }
    
}

package model;



public class Body {
	
	
	 /**
     * The type of the block in game
     * @see Model.Blocks
     * */

	private Model.Blocks block;

	private Position p;

	  /*
     * Contractor for Body and Define a object of a specific block and position
     */
	
	  public Body(Model.Blocks block, Position p) {
	        this.block = block;
	        this.p = p;
	    }

	
     /**
      * The type of the block
      * @return block
      */
     
    public Model.Blocks getBlock() {
		return block;
	}
    
    /**
     * Method to get position
     * @return positions
     */
    
    public Position getP() {
		return p;
	}
	
	
    
   
}

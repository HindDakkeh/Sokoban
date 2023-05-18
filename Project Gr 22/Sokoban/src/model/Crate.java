package model;


public class Crate extends Body{
	
	
	
	/**
     * Constructor for Crate
     * @param position of Crate
     * @param Marker If True crate marked, otherwise crate.
     */
	
    public Crate(Position position, Boolean Marker) {
    	
        super(Marker? Model.Blocks.CRATE_MARKED:Model.Blocks.CRATE, position);
    }

	 

	

 
 
 
}

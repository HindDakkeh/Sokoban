package view;

import model.Board;

public interface ViewObs {
	
	/**
	 * Update board for the observers
     * */
	
        void updateBoard(Board board); 
	

}

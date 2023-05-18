package model;



public class Position {
   	
	
	private int row;
	private int col;
	
	  /**
     * Constructor for position
     * @param row Input row
     * @param col Input column 
     */
	
	public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
	
	/**
     * Method to get row
     * @return row
     */
	public int getRow() {
		return row;
		
	}
	
	  /**
     * Method to set row
     * @param row Input row
     */
	
	public void setRow(int row) {
		this.row = row;
	}
	
	/**
     * Method to get column
     * @return column
     */
	
	public int getCol() {
		return col;
	}
	
	/**
     * Method to set column
     * @param col Input column
     */
	
	public void setCol(int col) {
		this.col = col;
	}
	
	
	
}

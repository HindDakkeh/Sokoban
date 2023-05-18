package model;

import java.util.ArrayList;

import Plan.PlanReader;


/**
 *  @authors Hind Dakkeh and Khaled Mhjazi
 */


public class Board {

	
	/**
     * The plan of the board as a 2D array of game 
     */
    private final Body [][] plan;

    
    /**
     * A list of all the markers on the plan. 
     */
    private ArrayList<Blank_Marked> markers;

	
	
    /**
    * The level of the board
    */
    
   private int level = 0;
  
   
   /**
    * Reference to the model
    */
   private Model m;

   /**
    * The height of the board
    */
   private int rows;

   /**
    * The width of the board
    */
   private int columns;

   
	
   /**
    * Constructor to create a board with a plan
    * @param  Input plan
    */
   public Board(Body [][] plan){
       this.plan= plan;
       this.rows = plan.length;
       this.columns = plan[0].length;
       this.markers = new ArrayList<>();
   }
   
   
   
   /**
    * Method to get all rows
    * @return rows
    */
   public int getRows(){
       return rows;
   }

   /**
    * Method to get all columns
    * @return columns
    */
   public int getColumns(){
       return columns;
   }
   
   /**
    * Method to set level
    * @param level New level
    */
   public void setLevel(int level) {
       this.level = level;
   }

   /**
    * Method to get level
    * @return level
    */
   public int getLevel() {
       return level;
   }
   
   
   /**
    * Method to get plan of certain position
    * @return plan with set row and column
    */
   public Body getPlan(int row, int col){
       return plan[row][col];
   }
   
   
   /**
    * Method to get Plan
    * @return Plan
    */
   public int[][] getPlan(){
       
       int [][] newPlan = new int[rows][columns];
       for(int i = 0; i < rows; i++){
           for(int j = 0; j < columns; j++){
               newPlan[i][j] = PlanReader.getBlockNumber(plan[i][j].getBlock());
           }
       }
       return newPlan;
   }
   
   
   /**
    * Method to set object in certain position of plan
    * @param row input row
    * @param columns input column
    * @param obj Input which type of block 
    */
   public void setPlan(int row, int columns, Body obj){
       plan[row][columns] = obj;
   }
  
   
   
   /**
    * Method to get markers
    * @return markers
    */
   public ArrayList<Blank_Marked> getMarkers() {
       return markers;
   }

   /**
    * Method to set markers
    * @param markers Add markers array
    */
   public void setMarkers(ArrayList<Blank_Marked> markers) {
       this.markers = markers;
   }
   
   
   
   
   /**
    * Method to add markers from a Board to the markers
    * @param plan Input plan
    */
   public void addMarkers(Board plan ){

       for(int i = 0; i < rows; i++){
           for(int j = 0; j < columns; j++){
               if(plan.getPlan(i,j).getBlock() == Model.Blocks. BLANK_MARKED){
                   markers.add((Blank_Marked) plan.getPlan(i,j));
               }
               else if (plan.getPlan(i,j).getBlock() == Model.Blocks.CRATE_MARKED){
                   markers.add(new Blank_Marked(new Position(i,j)));
               }
           }
       }
   }

   
   
   
   /**
    * Method to add model
    * @param m set input model
    */
   public void addModel(Model m) {
       this.m = m;
   }
   
   
   
   /**
    * Method to return position of player
    * @see Player
    * @return Position for Player or null if we don't have player
    */
   public Player getPlayer() {
       for (int i = 0; i < rows; i++) {
           for (int j = 0; j < columns; j++) {
               if (plan[i][j].getBlock() == Model.Blocks.PLAYER) {
                   return (Player) plan[i][j];
               }
           }
       }
       return null;
   }
   
   
   
   
   /**
    * Method to see if game win.
    * @return true
    */
   
   public boolean win() {

       	   
       if (markers.size() == 0) {
           return false;
       }
       //Check so all the markers (Blank_Marked)has boxes on them
       
       for (Blank_Marked marker : markers) {
           if (plan[marker.getP().getRow()][marker.getP().getCol()].getBlock() != Model.Blocks.CRATE_MARKED) {
               return false;
           }
       }

       
       m.notifyObservers(Model.Events.WIN);
       return true;
   }

   
   
   
}

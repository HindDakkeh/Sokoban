package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Board;

/**
 *  @authors Hind Dakkeh and Khaled Mhjazi
 */


public class GameGraphical extends JPanel implements ViewObs {

	private JFrame frame;
    private int row;
    private int col;
    int [][] board;
    
    /**
     * Array of images for the blocks
     * */
    private final BufferedImage[] im;
    
    /**
     * Constructor that create a new GameGraphical
     */
	
public GameGraphical (View v,BufferedImage[]i)  {
		  
	frame = new JFrame("Sokoban");  
	

	this.im = i;
	
	row = v.getController().getModel().getBoard().getRows();
    col = v.getController().getModel().getBoard().getColumns();

    frame.addKeyListener((KeyListener) v.getController().getGameController());

    frame.add(this);
    
    frame.setSize(new Dimension(im[0].getWidth()*(col),(im[0].getWidth()*(row+1)-1)));
    
    // To keep the size of the window.
    
    frame.setResizable(false);
    
    //in the middle.
    
    frame.setLocationRelativeTo(null);
    
    // Don't save place in the memory.
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // show the window
 	frame.setVisible(true);
    
		  
	  }
	
	
	
/**
 * Override method to update board
 * @see Board
 */
@Override
public void updateBoard(Board b) {
   
	board = b.getPlan();
	
    row = board.length;
    
    col = board[0].length;

    
    frame.setSize(new Dimension(this.im[0].getWidth()*(col),(this.im[0].getWidth()*(row+1)-1)));

     frame.setTitle("Sokoban -> Level: " + (b.getLevel()%3 +1));
   
    repaint();
}




protected void paintComponent(Graphics g){
  
	  super.paintComponent(g);

    for(int i = 0; i<row; i++){
        for(int j = 0; j<col;j++){
            g.drawImage(im[board[i][j]],im[0].getWidth()*j,im[0].getWidth()*i,null);
        }
    }
    

}

}

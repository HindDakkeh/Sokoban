package Test;
import static org.junit.Assert.assertTrue;
import controller.Controller;
import model.Model;


public class Test {

	



void moveTwo()  {

    Model model = new Model("./Sokoban/src/TestPlan/t0");
    model.movePlayer(Controller.Direction.UP);
    model.movePlayer(Controller.Direction.DOWN);
    model.movePlayer(Controller.Direction.LEFT);
    model.movePlayer(Controller.Direction.RIGHT);

    assertTrue(model.getPlayer().getP().getRow() == 3 && model.getPlayer().getP().getCol() == 4);
}




void WinGame() {

     Model model = new Model("./Sokoban/src/TestPlan/t1");

       model.movePlayer(Controller.Direction.RIGHT);
        model.movePlayer(Controller.Direction.DOWN);

        assertTrue(model.getBoard().win());
  
}

}

	
	
	
	


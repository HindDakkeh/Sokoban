import model.Model;
import view.GameGraphical;
import view.ViewControl;
import view.View;
import Plan.LoadImage;
import controller.Controller;
import controller.Keyboard;
import java.io.IOException;


public class APP {

	public static void main(String[] args) throws IOException {
		
		Model model = new Model(0);
        View view = new View();
        Controller controller = new Controller(new Keyboard());

      
        
        model.addView(view);
        controller.addModel(model);
        view.addModel(model);
        view.addController(controller);
        
        
        view.addObserver(new ViewControl());
        view.addObserver(new GameGraphical(view,LoadImage.importImg()));
        
        view.display();
      
	}

}

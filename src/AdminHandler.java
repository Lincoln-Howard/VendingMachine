import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;

public class AdminHandler implements EventHandler {

	@Override
	public void handle(Event arg0) {
		// the pane for the form
		GridPane form = new GridPane ();
		// the label for food name
		Label name_lbl = new Label ("Food/drink name:");
	}

}
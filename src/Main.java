

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
  @Override
  public void start(Stage primaryStage) throws Exception {
    // title: Vending Machines
    primaryStage.setTitle ("Vending Machines");
    // create the root pane
    BorderPane root = new BorderPane ();
    // set the root pane
    primaryStage.setScene (new Scene (root, 500, 350));
    // vertical box
    VBox sidebar = new VBox ();
    // add the vbox
    root.setLeft (sidebar);
    // vendor pane
    GridPane vendor_pane = new GridPane ();
    // vendor button
    Button vendor_button = new Button ("vendor");
    // event handler for the vendor button
    vendor_button.addEventHandler (MouseEvent.MOUSE_CLICKED, new SimpleButtonHandler (primaryStage, vendor_pane));
    // add vendor button
    sidebar.getChildren().add (vendor_button);
    // show the gui
    primaryStage.show ();
  }
  // simple button handler
  private class SimpleButtonHandler implements EventHandler <MouseEvent> {
    // the stage to set
    private Stage stage;
    // the pane to add
    private Pane pane;
    // constructor
    public SimpleButtonHandler (Stage stage, Pane pane) {
      this.stage = stage;
      this.pane = pane;
    }
    @Override
    public void handle(MouseEvent event) {
      stage.setScene (new Scene (pane, 500, 350));
    }
  }
}
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
  // food and drink vending machines
  public static VendingMachine drink, food;
  // the root pane
  public static BorderPane root;
  @Override
  public void start(Stage primaryStage) throws Exception {
    // read food and drink vending machines from file
	read ();
	// title: Vending Machines
    primaryStage.setTitle ("Vending Machines");
    // create the root pane
    root = new BorderPane ();
    // create sidebar
    VBox sidebar = new VBox ();
    // create admin button
    Button admin_btn = new Button ("Admin");
    // width
    admin_btn.setPrefWidth (80);
    // handle admin
    admin_btn.addEventHandler(MouseEvent.MOUSE_CLICKED, new AdminHandler ());
    // create purchase button
    Button purchase_btn = new Button ("Purchase");
    // width
    purchase_btn.setPrefWidth (80);
    // $$ input level
    Label money_lbl = new Label ("Cash in:");
    // width
    money_lbl.setPrefWidth (80);
    // $$ input
    TextField money_input = new TextField ();
    // width
    money_input.setPrefWidth (80);
    // tooltip
    money_input.setTooltip (new Tooltip ("ex: 0.75"));
    // add all to sidebar
    sidebar.getChildren ().addAll (admin_btn, purchase_btn, money_lbl, money_input);
    // set vbox left
    root.setLeft (sidebar);
    // set root to root
    primaryStage.setScene(new Scene (root, 400, 300));
    // show primary stage
    primaryStage.show ();
  }
  // save the vending machines
  public static void write () {
	  try {
		ObjectOutputStream food_writer, drink_writer;
		food_writer = new ObjectOutputStream (new FileOutputStream (new File ("food.vem")));
		food_writer.writeObject (food);
		food_writer.close ();
		drink_writer = new ObjectOutputStream (new FileOutputStream (new File ("drinks.vem")));
		drink_writer.writeObject (drink);
		drink_writer.close ();
	} catch (Exception e) {
	}
  }
  // read the vending machines
  public static void read () {
	try {
      ObjectInputStream food_reader, drink_reader;
      food_reader = new ObjectInputStream (new FileInputStream (new File ("food.vem")));
      food = (VendingMachine) food_reader.readObject ();
      food_reader.close ();
      drink_reader = new ObjectInputStream (new FileInputStream (new File ("drinks.vem")));
      drink = (VendingMachine) drink_reader.readObject ();
      drink_reader.close ();
	} catch (Exception e) {
		food = new VendingMachine ();
		drink = new VendingMachine ();
	}
  }
}
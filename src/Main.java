import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
  // food and drink vending machines
  public static VendingMachine drink, food;
  @Override
  public void start(Stage primaryStage) throws Exception {
    read ();
	// title: Vending Machines
    primaryStage.setTitle ("Vending Machines");
    // create the root pane
    BorderPane root = new BorderPane ();
    
  }
  // save the vending machines
  private void write () {
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
  private void read () {
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
package view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.VendingMachine;

public class Main extends Application {
	// food and drink vending machines
	public static VendingMachine drink, food;
	// the root pane
	public static BorderPane root;
	// the inputs
	public static TextField usr, money;
	// the password input
	public static PasswordField pwd;
	// start the application
	@Override
	public void start(Stage primaryStage) throws Exception {
		// read food and drink vending machines from file
		read();
		// title: Vending Machines
		primaryStage.setTitle ("Vending Machines");
		// create the root pane
		root = new BorderPane();
		// create sidebar
		VBox sidebar = new VBox();
		// create username label
		Label usr_lbl = new Label ("Username:");
		// set width
		usr_lbl.setPrefWidth (100);
		// create username input
		usr = new TextField ();
    // set width
    usr.setPrefWidth (100);
		// create the password label
		Label pwd_lbl = new Label ("Password:");
    // set width
    pwd_lbl.setPrefWidth (100);
    // password input
    pwd = new PasswordField ();
    // set width
    pwd.setPrefWidth (100);
		// create admin login button
		Button admin_btn = new Button ("Log In!");
		// width
		admin_btn.setPrefWidth(100);
		// handle admin
		admin_btn.addEventHandler (MouseEvent.MOUSE_CLICKED, new AdminHandler());
		// create purchase button
		Button purchase_btn = new Button ("Purchase");
		// width
		purchase_btn.setPrefWidth (100);
		// $$ input level
		Label money_lbl = new Label ("Cash in:");
		// width
		money_lbl.setPrefWidth (100);
		// $$ input
		money = new TextField ();
		// width
		money.setPrefWidth (100);
		// tooltip
		money.setTooltip (new Tooltip ("ex: 0.75"));
		// add all to sidebar
		sidebar.getChildren().addAll(usr_lbl, usr, pwd_lbl, pwd, admin_btn, money_lbl, money, purchase_btn);
		// set vbox left
		root.setLeft(sidebar);
		// set root to root
		primaryStage.setScene(new Scene(root, 400, 300));
		// show primary stage
		primaryStage.show();
	}

	// save the vending machines
	public static void write() {
		try {
			ObjectOutputStream food_writer, drink_writer;
			food_writer = new ObjectOutputStream(new FileOutputStream(new File("food.vem")));
			food_writer.writeObject(food);
			food_writer.close();
			drink_writer = new ObjectOutputStream(new FileOutputStream(new File("drinks.vem")));
			drink_writer.writeObject(drink);
			drink_writer.close();
		} catch (Exception e) {
		}
	}

	// read the vending machines
	public static void read() {
		try {
			ObjectInputStream food_reader, drink_reader;
			food_reader = new ObjectInputStream(new FileInputStream(new File("food.vem")));
			food = (VendingMachine) food_reader.readObject();
			food_reader.close();
			drink_reader = new ObjectInputStream(new FileInputStream(new File("drinks.vem")));
			drink = (VendingMachine) drink_reader.readObject();
			drink_reader.close();
		} catch (Exception e) {
			food = new VendingMachine();
			drink = new VendingMachine();
		}
	}
}
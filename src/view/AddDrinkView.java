package view;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import model.FoodInfo;
/**
 * View for adding a food.
 * @author Lincoln Howard
 */
public class AddDrinkView extends GridPane {
  /**
   * User input for the food name.
   */
  private TextField name_input;
  /**
   * User input for the food calories.
   */
  private TextField cals_input;
  /**
   * User input for the food fat.
   */
  private TextField fat_input;
  /**
   * User input for the food carbs.
   */
  private TextField carbs_input;
  /**
   * User input for the food protein.
   */
  private TextField pro_input;
  /**
   * Input for the cost of the item.
   */
  private TextField cost_input;
  /**
   * Create the food.
   */
  private Button submit;
  /**
   * Default constructor.
   */
  public AddDrinkView () {
    Label name_lbl = new Label ("Name");
    name_lbl.setPrefSize (150, 20);
    this.add(name_lbl, 0, 0);
    Label cals_lbl = new Label ("Calories");
    this.add(cals_lbl, 0, 1);
    this.add(new Label ("Fat"), 0, 2);
    this.add(new Label ("Carbs"), 0, 3);
    this.add(new Label ("Protein"), 0, 4);
    this.add(new Label ("Cost"), 0, 5);
    name_input = new TextField ();
    name_input.setPrefSize(150, 20);
    cals_input = new TextField ();
    fat_input = new TextField ();
    carbs_input = new TextField ();
    pro_input = new TextField ();
    cost_input = new TextField ();
    submit = new Button ("Create Drink");
    submit.addEventHandler(MouseEvent.MOUSE_CLICKED, new NewDrinkHandler ());
    this.add(name_input, 1, 0);
    this.add(cals_input, 1, 1);
    this.add(fat_input, 1, 2);
    this.add(carbs_input, 1, 3);
    this.add(pro_input, 1, 4);
    this.add(cost_input, 1, 5);
    this.add(submit, 0, 6, 2, 1);
  }
  public void clear () {
    name_input.setText ("");
    cals_input.setText ("");
    fat_input.setText ("");
    carbs_input.setText ("");
    pro_input.setText ("");
    cost_input.setText ("");
  }
  // event handler
  class NewDrinkHandler implements EventHandler <Event> {
    @Override
    public void handle(Event event) {
      if (!Main.drink.has (name_input.getText ())) {
        FoodInfo info = new FoodInfo (name_input.getText (),
            cals_input.getText (), fat_input.getText (),
            carbs_input.getText (), pro_input.getText ());
        double cost = 1;
        try {
          cost = Double.parseDouble (cost_input.getText ());
        } catch (Exception e) {
        }
        Main.drink.addItem (cost, info);
        Main.write ();
      }
      clear ();
    }
  }
}
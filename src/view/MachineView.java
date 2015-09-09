package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import model.FoodInfo;
import model.InsufficientFundsException;

public class MachineView extends GridPane {
  
  private ObservableList <String> foods, drinks;
  
  private ListView <String> food, drink;
  
  public MachineView () {
    update ();
  }
  private void update () {
    foods = FXCollections.observableArrayList ();
    for (int i = 0; i < Main.food.size (); i++) {
      foods.add (Main.food.info (i).name ());
    }
    food = new ListView <String> (foods);
    food.setPrefSize(100, 250);
    food.getSelectionModel ().setSelectionMode(SelectionMode.SINGLE);
    this.add (food, 0, 0);
    drinks = FXCollections.observableArrayList ();
    for (int i = 0; i < Main.drink.size (); i++) {
      drinks.add (Main.drink.info (i).name ());
    }
    drink = new ListView <String> (drinks);
    drink.setPrefSize (100, 250);
    drink.getSelectionModel ().setSelectionMode(SelectionMode.SINGLE);
    this.add (drink, 1, 0);
    Main.root.setRight (Main.rightbar);
    Main.rightbar.getChildren ().removeAll (Main.pfb, Main.pdb);
    Main.pfb = new Button ("purchase food");
    Main.pfb.setPrefSize(100, 20);
    Main.pdb = new Button ("purchase drink");
    Main.pdb.setPrefSize(100, 20);
    Main.pfb.addEventHandler (MouseEvent.MOUSE_CLICKED, new PurchaseFoodHandler ());
    Main.pdb.addEventHandler (MouseEvent.MOUSE_CLICKED, new PurchaseDrinkHandler ());
    Main.rightbar.getChildren ().addAll (Main.pfb, Main.pdb);
  }
  // purchase handler
  class PurchaseFoodHandler implements EventHandler <Event> {
    @Override
    public void handle(Event event) {
      String output = "";
      try {
        double money = Double.parseDouble (Main.money.getText ());
        int i = food.getSelectionModel ().getSelectedIndex ();
        System.out.println (i);
        FoodInfo info = Main.food.purchase (i, money);
        output += info.name () + " purchased!";
        Main.money.setText (money - Main.food.cost (i) + "");
        if (Main.food.stock (i) == 0) {
          foods.remove (i);
        }
      } catch (NumberFormatException e) {
        output += "  money in incorrect format  ";
        
      } catch (InsufficientFundsException e) {
        output += "  not enough money entered  ";
      }
      Main.output.setText (output);
      Main.write ();
    }
  }
  //purchase handler
  class PurchaseDrinkHandler implements EventHandler <Event> {
    @Override
    public void handle(Event event) {
      String output = "";
      try {
        double money = Double.parseDouble (Main.money.getText ());
        int i = drink.getSelectionModel ().getSelectedIndex ();
        FoodInfo info = Main.drink.purchase (i, money);
        output += info.name () + " purchased!";
        Main.money.setText (money - Main.drink.cost (i) + "");
        if (Main.drink.stock (i) == 0) {
          drinks.remove (i);
        }
      } catch (NumberFormatException e) {
        output += "  money in incorrect format  ";
      } catch (InsufficientFundsException e) {
        output += "  not enough money entered  ";
      }
      Main.output.setText (output);
      Main.write ();
    }
  }
}
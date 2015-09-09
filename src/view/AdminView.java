package view;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class AdminView extends GridPane {
  
  private Button addFoodBtn;
  
  private Button addDrinkBtn;
  
  private Button viewInventory;
  
  private Button viewLog;
  
  private Pane admin;
  
  public AdminView () {
    addFoodBtn = new Button ("add food");
    addFoodBtn.setPrefSize(150, 20);
    addFoodBtn.addEventHandler (MouseEvent.MOUSE_CLICKED, new FoodBtnHandler ());
    addDrinkBtn = new Button ("add drink");
    addDrinkBtn.setPrefSize(150, 20);
    addDrinkBtn.addEventHandler (MouseEvent.MOUSE_CLICKED, new DrinkBtnHandler ());
    viewInventory = new Button ("view inventory");
    viewInventory.setPrefSize(150, 20);
    viewInventory.addEventHandler (MouseEvent.MOUSE_CLICKED, new InvBtnHandler ());
    viewLog = new Button ("view log");
    viewLog.setPrefSize(150, 20);
    viewLog.addEventHandler (MouseEvent.MOUSE_CLICKED, new LogBtnHandler ());
    this.add (addFoodBtn, 0, 0);
    this.add (addDrinkBtn, 1, 0);
    this.add (viewInventory, 0, 1);
    this.add (viewLog, 1, 1);
  }
  // method to reset admin pane
  private void admin (Pane pane) {
    this.getChildren ().remove (admin);
    admin = pane;
    this.add(admin, 0, 2, 2, 5);
  }
  private class FoodBtnHandler implements EventHandler <Event> {
    @Override
    public void handle(Event event) {
      admin (new AddFoodView ());
      Main.output.setText ("Change to add food view");
    }
  }
  private class DrinkBtnHandler implements EventHandler <Event> {
    @Override
    public void handle(Event event) {
      admin (new AddDrinkView ());
      Main.output.setText ("Change to add drink view");
    }
  }
  private class LogBtnHandler implements EventHandler <Event> {
    @Override
    public void handle(Event event) {
      admin (new TransactionLogView ());
      Main.output.setText ("Transaction logs");
    }
  }
  private class InvBtnHandler implements EventHandler <Event> {
    @Override
    public void handle(Event event) {
      admin (new InvLogView ());
      Main.output.setText ("Inventory view");
    }
  }
}
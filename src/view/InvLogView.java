package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import model.VendingMachine;

public class InvLogView extends BorderPane {
  
  private ScrollPane pane;
  
  private GridPane inventory;
  
  public InvLogView () {
    pane = new ScrollPane ();
    pane.setPrefHeight (350);
    this.setCenter (pane);
    update ();
  }
  
  public void update () {
    inventory = new GridPane ();
    int count = 0;
    for (int i = 0; i < Main.food.size (); i++) {
      inventory.add(new Label (Main.food.info (i).name () + ": #" + Main.food.stock (i)), 0, count);
      Button del = new Button ("X");
      del.setPrefSize(5, 5);
      del.addEventHandler(MouseEvent.MOUSE_CLICKED, new DelHandler (Main.food, i));
      inventory.add(del, 1, count);
      count++;
    }
    for (int i = 0; i < Main.drink.size (); i++) {
      inventory.add(new Label (Main.drink.info (i).name () + ": #" + Main.drink.stock (i)), 0, count);
      Button del = new Button ("X");
      del.setPrefSize(5, 5);
      del.addEventHandler(MouseEvent.MOUSE_CLICKED, new DelHandler (Main.drink, i));
      inventory.add(del, 1, count);
      count++;
    }
    pane.setContent (inventory);
  }
  
  class DelHandler implements EventHandler <Event> {
    VendingMachine machine;
    int loc;
    public DelHandler (VendingMachine machine, int loc) {
      this.machine = machine;
      this.loc = loc;
    }
    @Override
    public void handle(Event event) {
      Main.output.setText("Removing: " + machine.info (loc).name ());
      machine.removeItem (loc);
      update ();
      Main.write ();
    }
  }
}
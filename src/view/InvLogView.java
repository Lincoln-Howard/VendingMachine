package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class InvLogView extends BorderPane {
  
  private ScrollPane pane;
  
  private GridPane inventory;
  
  public InvLogView () {
    pane = new ScrollPane ();
    pane.setPrefHeight (350);
    this.setCenter (pane);
    inventory = new GridPane ();
    pane.setContent (inventory);
    int count = 0;
    for (int i = 0; i < Main.food.size (); i++) {
      inventory.add(new Label (Main.food.info (i).name () + ": #" + Main.food.stock (i)), 0, count);
      Button del = new Button ("X");
      del.setPrefSize(5, 5);
      inventory.add(del, 1, count);
      count++;
    }
    for (int i = 0; i < Main.drink.size (); i++) {
      inventory.add(new Label (Main.drink.info (i).name () + ": #" + Main.drink.stock (i)), 0, count);
      Button del = new Button ("X");
      del.setPrefSize(5, 5);
      inventory.add(del, 1, count);
      count++;
    }
  }
  
  private class DelHandler implements EventHandler <Event> {
    @Override
    public void handle(Event event) {
      
    }
  }
}
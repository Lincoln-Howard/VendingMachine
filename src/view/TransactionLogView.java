package view;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

public class TransactionLogView extends BorderPane {
  
  private ScrollPane fp, dp;
  
  private TabPane pane;
  
  public TransactionLogView () {
    pane = new TabPane ();
    this.setCenter (pane);
    fp = new ScrollPane ();
    fp.setContent (new Label (Main.food.report ()));
    dp = new ScrollPane ();
    dp.setContent (new Label (Main.drink.report ()));
    Tab t1 = new Tab ();
    t1.setText ("Food Sales");
    t1.setContent (fp);
    Tab t2 = new Tab ();
    t2.setText ("Drink Sales");
    t2.setContent (dp);
    pane.getTabs ().addAll (t1, t2);
  }
  
  public void update () {
    fp.setContent (new Label (Main.food.report ()));
    dp.setContent (new Label (Main.drink.report ()));
  }
}
package view;

import javafx.event.Event;
import javafx.event.EventHandler;
/**
 * Handle admin interface
 * @author Lincoln
 *
 */
public class AdminHandler implements EventHandler <Event> {

  @Override
  public void handle (Event event) {
    if ((Main.usr.getText ().equals("Lincoln")) && (Main.pwd.getText ().equals ("hilite"))) {
      Main.root.setCenter (new AdminView ());
      System.out.println ("Lincoln Logged In!");
      Main.admin_btn.setText ("Log Out");
      Main.root.setRight (null);
    }
  }

}
package view;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
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
      Main.output.setText ("Logging in...");
      Main.root.setRight (null);
      Main.sidebar.getChildren().remove (Main.admin_btn);
      Main.admin_btn = new Button ("Log Out");
      Main.admin_btn.addEventHandler (MouseEvent.MOUSE_CLICKED, new LogoutHandler ());
      
    }
  }

}
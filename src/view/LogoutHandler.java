package view;

import javafx.event.Event;
import javafx.event.EventHandler;

public class LogoutHandler implements EventHandler <Event> {
  @Override
  public void handle(Event event) {
    Main.output.setText("logging out");
    Main.root.setCenter (new MachineView ());
    Main.root.setRight (Main.rightbar);
  }
}
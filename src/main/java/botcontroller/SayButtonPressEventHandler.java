package botcontroller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class SayButtonPressEventHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
		Button sayBtn = (Button) event.getSource();
		if (sayBtn.getText() == "say")
			sayBtn.setText("off");
		else
			sayBtn.setText("say");
	}
	
}

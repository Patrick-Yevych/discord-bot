package botcontroller;

import botmodel.BotModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ProfanityControlButtonPressEventHandler implements EventHandler<ActionEvent> {

	private TextField profanityInput;
	
	public ProfanityControlButtonPressEventHandler(TextField profanityInput) {
		this.profanityInput = profanityInput;
	}
	
	@Override
	public void handle(ActionEvent event) {
		Button src = (Button) event.getSource();
		if (src.getText() == "Add") {
			BotModel.get().getProfanities().add(this.profanityInput.getText());
		}
		else if (src.getText() == "Remove") {
			BotModel.get().getProfanities().remove(this.profanityInput.getText());
		}
	}
}

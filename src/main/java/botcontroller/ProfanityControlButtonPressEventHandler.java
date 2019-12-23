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
		String input = this.profanityInput.getText();
		
		if (src.getText() == "Add" && !BotModel.get().getProfanities().contains(input)) {
			BotModel.get().getProfanities().add(input);
		}
		else if (src.getText() == "Remove") {
			BotModel.get().getProfanities().remove(input);
		}
	}
}

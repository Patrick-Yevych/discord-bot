package botcontroller;

import botmodel.BotModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * EventHandler object for the add and remove buttons in the profanity pane.
 * @author Patrick Yevych
 *
 */
public class ProfanityControlButtonPressEventHandler implements EventHandler<ActionEvent> {

	private TextField profanityInput;
	
	/**
	 * 
	 * @param the profanityInput textfield in the pane.
	 */
	public ProfanityControlButtonPressEventHandler(TextField profanityInput) {
		this.profanityInput = profanityInput;
	}
	
	/**
	 * Adds/Removes the word obtained from profanityInput to/from BotModel.profanities, depending on which button is pressed. 
	 * @param the event.
	 */
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

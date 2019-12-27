package botcontroller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 * EventHandler for the buttons under the tool menu.
 * @author Patrick Yevych
 *
 */
public class ToolMenuButtonPressEventHandler implements EventHandler<ActionEvent> {
	
	private Scene sayScene;
	private Scene profanityScene;
	private Stage stage;
	
	/**
	 * 
	 * @param the BotApplication stage.
	 * @param the sayScene in BotApplication which contains the sayPane.
	 * @param the profanityScene in BotApplication which contains the profanityPane.
	 */
	public ToolMenuButtonPressEventHandler(Stage stage, Scene sayScene, Scene profanityScene) {
		super();
		this.stage = stage;
		this.sayScene = sayScene;
		this.profanityScene = profanityScene;
	}
	
	/**
	 * Sets the scene of the BotApplication stage to the appropriate scene,
	 * depending on the button pressed.
	 * @param the event.
	 */
	public void handle(ActionEvent event) {
		MenuItem src = (MenuItem) event.getSource();
		if (src.getText() == "Say") {
			this.stage.setScene(this.sayScene);
		}
		else if (src.getText() == "Profanity Filter") {
			this.stage.setScene(this.profanityScene);
		}
	}
}

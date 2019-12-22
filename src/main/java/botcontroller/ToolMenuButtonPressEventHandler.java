package botcontroller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class ToolMenuButtonPressEventHandler implements EventHandler<ActionEvent> {
	
	private Scene sayScene;
	private Scene profanityScene;
	private Stage stage;
	
	public ToolMenuButtonPressEventHandler(Stage stage, Scene sayScene, Scene profanityScene) {
		super();
		this.stage = stage;
		this.sayScene = sayScene;
		this.profanityScene = profanityScene;
	}
	
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

package botcontroller;

import java.io.File;
import java.io.IOException;

import botmodel.ConfigParser;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * EventHandler object for the load button in the menu bar.
 * @author Patrick Yevych
 *
 */
public class LoadButtonPressEventHandler implements EventHandler<ActionEvent> {

	private Stage stage;
	
	/**
	 * 
	 * @param the BotApplication stage.
	 */
	public LoadButtonPressEventHandler(Stage stage) {
		super();
		this.stage = stage;
	}
	
	/**
	 * Opens a file chooser window and creates a ConfigParser to parse the chosen file.
	 * @param the event.
	 */
	@Override
	public void handle(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(this.stage);
		ConfigParser parser = new ConfigParser(file);
		try {
			parser.parse();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

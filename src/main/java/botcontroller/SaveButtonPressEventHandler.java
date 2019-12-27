package botcontroller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import botmodel.ConfigWriter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * EventHandler object for the save button in the menu bar.
 * @author Patrick Yevych
 *
 */
public class SaveButtonPressEventHandler implements EventHandler<ActionEvent> {

	private Stage stage;
	
	/**
	 * 
	 * @param the BotApplication stage.
	 */
	public SaveButtonPressEventHandler(Stage stage) {
		this.stage = stage;
	}
	
	/**
	 * Opens a file chooser window and creates a ConfigWriter to write to the chosen file.
	 * @param the event.
	 */
	@Override
	public void handle(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showSaveDialog(this.stage);
		ConfigWriter writer = new ConfigWriter(file);
		try {
			writer.write();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package botcontroller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import botmodel.ConfigWriter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SaveButtonPressEventHandler implements EventHandler<ActionEvent> {

	private Stage stage;
	
	public SaveButtonPressEventHandler(Stage stage) {
		this.stage = stage;
	}
	
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

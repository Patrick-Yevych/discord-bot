package botcontroller;

import java.io.File;
import java.io.IOException;

import botmodel.ConfigParser;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class LoadButtonPressEventHandler implements EventHandler<ActionEvent> {

	private Stage stage;
	
	public LoadButtonPressEventHandler(Stage stage) {
		super();
		this.stage = stage;
	}
	
	@Override
	public void handle(ActionEvent arg0) {
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

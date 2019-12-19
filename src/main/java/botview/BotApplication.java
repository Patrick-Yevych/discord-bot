package botview;

import botmodel.BotModel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BotApplication extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		BotModel.get();
		HBox root = new HBox();
		Scene scene = new Scene(root);
		root.getChildren().add(new SayPane());
		
		stage.setTitle("discord-bot");
		stage.setScene(scene);
		stage.show();
	}

}

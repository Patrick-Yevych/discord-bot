package botview;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import botmodel.ConfigParser;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * The GUI itself and the entry point of the program.
 * @author Patrick Yevych
 *
 */
public class BotApplication extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * the landing point of the program.
	 * Creates all of the different tool panes and connects them to their event handlers and the BotModel.
	 * @param the given stage.
	 */
	@Override
	public void start(Stage stage) throws Exception {
		ConfigParser parser = new ConfigParser(new File("cfg.txt"));
		try {
			System.out.println(parser.parse());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		VBox root = new VBox();
		Scene scene = new Scene(root);
		
		VBox profanityRoot = new VBox();
		ProfanityPane profanityPane = new ProfanityPane();
		
		Scene profanityScene = new Scene(profanityRoot);
		
		MainMenuBar menu = new MainMenuBar(stage, scene, profanityScene);
		MainMenuBar menu1 = new MainMenuBar(stage, scene, profanityScene);
		
		root.getChildren().addAll(menu, new SayPane());
		profanityRoot.getChildren().addAll(menu1, profanityPane);
		
		stage.setTitle("discord-bot");
		stage.setScene(scene);
		stage.show();
		stage.setOnCloseRequest(e->{Platform.exit(); System.exit(0);});
	}
}

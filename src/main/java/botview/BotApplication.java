package botview;

import botcontroller.LoadButtonPressEventHandler;
import botmodel.BotModel;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotApplication extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		BotModel.get();
		VBox root = new VBox();
		Scene scene = new Scene(root);
		
		MenuBar menu = new MenuBar();
		Menu fileMenu = new Menu("File");
		MenuItem loadBtn = new MenuItem("Load");
		loadBtn.setOnAction(new LoadButtonPressEventHandler(stage));
		fileMenu.getItems().add(loadBtn);
		menu.getMenus().add(fileMenu);
		
		root.getChildren().addAll(menu, new SayPane());
		
		stage.setTitle("discord-bot");
		stage.setScene(scene);
		stage.show();
		stage.setOnCloseRequest(e->{Platform.exit(); System.exit(0);});
	}

}

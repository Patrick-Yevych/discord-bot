package botview;

import botcontroller.LoadButtonPressEventHandler;
import botcontroller.SaveButtonPressEventHandler;
import botcontroller.ToolMenuButtonPressEventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class MainMenuBar extends MenuBar {
	public MainMenuBar(Stage stage, Scene sayScene, Scene profanityScene) {
		super();
		
		Menu fileMenu = new Menu("File");
		Menu toolMenu = new Menu("Tools");
		
		MenuItem loadBtn = new MenuItem("Load");
		loadBtn.setOnAction(new LoadButtonPressEventHandler(stage));
		fileMenu.getItems().add(loadBtn);
		
		MenuItem saveBtn = new MenuItem("Save");
		saveBtn.setOnAction(new SaveButtonPressEventHandler(stage));
		fileMenu.getItems().add(saveBtn);
		
		ToolMenuButtonPressEventHandler toolHandler = new ToolMenuButtonPressEventHandler(stage, sayScene, profanityScene);
		MenuItem sayMenuBtn = new MenuItem("Say");
		MenuItem profanityMenuBtn = new MenuItem("Profanity Filter");
		sayMenuBtn.setOnAction(toolHandler);
		profanityMenuBtn.setOnAction(toolHandler);
		toolMenu.getItems().addAll(sayMenuBtn, profanityMenuBtn);
		
		this.getMenus().addAll(fileMenu, toolMenu);
	}
	
}

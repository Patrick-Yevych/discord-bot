package botview;

import botcontroller.LoadButtonPressEventHandler;
import botcontroller.SaveButtonPressEventHandler;
import botcontroller.ToolMenuButtonPressEventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 * The main menu bar that appears at the top of the GUI.
 * @author Patrick Yevych
 *
 */
public class MainMenuBar extends MenuBar {
	/**
	 * 
	 * @param the BotApplication stage.
	 * @param the sayScene in BotApplication which contains the sayPane.
	 * @param the profanityScene in BotApplication which contains the profanityPane.
	 */
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

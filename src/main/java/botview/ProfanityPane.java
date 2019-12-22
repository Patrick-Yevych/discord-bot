package botview;

import botcontroller.ProfanityControlButtonPressEventHandler;
import botmodel.BotModel;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ProfanityPane extends VBox {
	
	private ListView<String> profanityList;
	
	public ProfanityPane() {
		super();
		
		TextField profanityInput = new TextField();
		Button addBtn = new Button("Add");
		Button removeBtn = new Button("Remove");
		
		ProfanityControlButtonPressEventHandler handler = new ProfanityControlButtonPressEventHandler(profanityInput);
		HBox controlsPane = new HBox();
		addBtn.setOnAction(handler);
		removeBtn.setOnAction(handler);
		
		this.profanityList = new ListView<String>();
		this.profanityList.setItems(BotModel.get().getProfanities());
		
		controlsPane.getChildren().addAll(profanityInput, addBtn, removeBtn);
		this.getChildren().addAll(controlsPane, this.profanityList);
	}
}

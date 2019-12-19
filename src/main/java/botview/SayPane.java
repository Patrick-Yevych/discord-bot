package botview;

import botcontroller.SayButtonPressEventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class SayPane extends HBox {
	private Button sayBtn;
	private TextField msgField;
	private TextField intervalField;
	
	public SayPane() {
		super();
		this.sayBtn = new Button("say");
		this.sayBtn.setOnAction(new SayButtonPressEventHandler());
		this.msgField = new TextField();
		this.intervalField = new TextField();
		this.getChildren().addAll(new Label("Message: "), this.msgField, new Label("Interval: "), this.intervalField, this.sayBtn);
	}
}

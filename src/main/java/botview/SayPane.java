package botview;

import botcontroller.SayButtonPressEventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class SayPane extends HBox {
	private Button sayBtn;
	private TextField msgField;
	private TextField intervalField;
	private TextField channelField;
	
	public SayPane() {
		super();
		this.setPadding(new Insets(5));
		this.msgField = new TextField();
		this.intervalField = new TextField();
		this.channelField = new TextField();
		this.sayBtn = new Button("say");
		this.sayBtn.setOnAction(new SayButtonPressEventHandler(msgField, intervalField, channelField));
		this.getChildren().addAll(new Label("Message: "), this.msgField, new Label("Interval: "), this.intervalField,
				new Label("Channel: "), this.channelField, this.sayBtn);
	}
}

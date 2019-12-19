package botcontroller;

import botmodel.Messenger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SayButtonPressEventHandler implements EventHandler<ActionEvent> {

	private TextField msgField;
	private TextField intervalField;
	private TextField channelField;
	private Messenger timer;
	
	public SayButtonPressEventHandler(TextField msgField, TextField intervalField, TextField channelField) {
		super();
		this.msgField = msgField;
		this.intervalField = intervalField;
		this.channelField = channelField;
		timer = new Messenger("", 0, "");
	}
	
	@Override
	public void handle(ActionEvent event) {
		Button sayBtn = (Button) event.getSource();

		if (sayBtn.getText() == "say") {
			try {
				timer = new Messenger(this.msgField.getText(), Float.parseFloat(this.intervalField.getText()),
					this.channelField.getText());
			} catch (Exception e) {}
			timer.getTimeline().play();
			sayBtn.setText("off");
		}
		else {
			timer.getTimeline().stop();
			sayBtn.setText("say");
		}
	}
}

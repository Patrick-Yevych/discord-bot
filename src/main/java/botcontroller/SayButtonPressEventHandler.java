package botcontroller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * EventHandler for the say button in the sayPane.
 * @author Patrick Yevych
 *
 */
public class SayButtonPressEventHandler implements EventHandler<ActionEvent> {

	private TextField msgField;
	private TextField intervalField;
	private TextField channelField;
	private Messenger timer;
	
	/**
	 * 
	 * @param the msgField TextField in the sayPane.
	 * @param the intervalField TextField in the sayPane.
	 * @param the channelField TextField in the sayPane.
	 */
	public SayButtonPressEventHandler(TextField msgField, TextField intervalField, TextField channelField) {
		super();
		this.msgField = msgField;
		this.intervalField = intervalField;
		this.channelField = channelField;
		timer = new Messenger("", 0, "");
	}
	
	/**
	 * Treats the say button as a toggle button. Creates a Messenger
	 * object to send the message obtained from msgField to the channel obtained from channelField
	 * on the interval obtained from the intervalField. 
	 * @param the event.
	 */
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

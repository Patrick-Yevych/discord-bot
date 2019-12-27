package botcontroller;

import botmodel.BotModel;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

/**
 * Object which periodically orders the BotModel to send a message to a specified channel on a certain interval.
 * @author Patrick Yevych
 *
 */
public class Messenger {
	
	private Timeline timeline;
	
	/**
	 * 
	 * @param the message to send.
	 * @param the inteval in seconds.
	 * @param the channel to send the message to.
	 */
	public Messenger(String message, float inteval, String channel) {
		timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(inteval), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				BotModel.get().sendMessage(message, channel);
				System.out.println(message);
			}
			
		}));
	}
	/**
	 * 
	 * @return the timeline object.
	 */
	public Timeline getTimeline() { return this.timeline; }
}

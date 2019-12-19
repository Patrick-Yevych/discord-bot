package botmodel;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class Messenger {
	
	private Timeline timeline;
	
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
	public Timeline getTimeline() { return this.timeline; }
}

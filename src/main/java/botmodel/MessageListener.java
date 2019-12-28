package botmodel;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 * A ListenerAdapter that provides a function that runs when a user sends a message.
 * @author Patrick Yevych
 *
 */
public class MessageListener extends ListenerAdapter {
	
	/**
	 * Handler function which executes when a user sends a message on the server.
	 * @param the event.
	 */
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		System.out.println(event.getMessage().getContentDisplay().trim().replace(" ", "").toLowerCase());
		if (event.isFromType(ChannelType.TEXT)) {
			for (String p: BotModel.get().getProfanities()) {
				if (event.getMessage().getContentDisplay().trim().replace(" ", "").toLowerCase().contains(p.trim().replace(" ", "").toLowerCase())) {
					event.getMessage().delete().queue();
				}
			}
		}
	}
}

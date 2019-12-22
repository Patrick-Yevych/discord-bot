package botmodel;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		if (event.isFromType(ChannelType.TEXT)) {
			for (String p: BotModel.get().getProfanities()) {
				if (event.getMessage().getContentDisplay().contains(p)) {
					event.getMessage().delete().queue();
				}
			}
		}
	}
}

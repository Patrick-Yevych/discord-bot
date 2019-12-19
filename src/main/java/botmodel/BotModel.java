package botmodel;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.Event;

public class BotModel {
	private static BotModel instance = null;
	private static String token = "NjU3MTg1MTM1MTUzOTA1Njk0.Xftq0Q.k2j14NURgGUFsmjWkOjxmvXeTV4";
	//https://discordapp.com/oauth2/authorize?&client_id=657185135153905694&scope=bot&permissions=8
	private JDA api;
	
	private BotModel() {
		try {
			api = new JDABuilder(AccountType.BOT).setToken(token).build();
		} catch (LoginException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized static BotModel get() {
		if (BotModel.instance == null) BotModel.instance = new BotModel();
		return BotModel.instance;
	}
	
	public void sendMessage(String message, String channel) {
		api.getTextChannelsByName(channel, false).get(0).sendMessage(message).queue();
	}
	
}

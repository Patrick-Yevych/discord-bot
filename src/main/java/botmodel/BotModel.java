package botmodel;

import java.io.File;
import java.io.IOException;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.Event;

public class BotModel {
	private static BotModel instance = null;
	private static String token = "";
	//https://discordapp.com/oauth2/authorize?&client_id=657185135153905694&scope=bot&permissions=8
	private JDA api;
	
	private BotModel(String token) {
		try {
			api = new JDABuilder(AccountType.BOT).setToken(token).build();
		} catch (LoginException e) {
			e.printStackTrace();
		}
	}
	
	public void setToken(String token) { BotModel.token = token; }
	public String getToken() { return BotModel.token; }
	
	public synchronized static BotModel get(String token) {
		if (BotModel.instance == null) BotModel.instance = new BotModel(token);
		return BotModel.instance;
	}
	
	public synchronized static BotModel get() {
		return BotModel.instance;
	}
	
	public void sendMessage(String message, String channel) {
		api.getTextChannelsByName(channel, false).get(0).sendMessage(message).queue();
	}
	
	
}

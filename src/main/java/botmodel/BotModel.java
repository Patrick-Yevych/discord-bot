package botmodel;

import javax.security.auth.login.LoginException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class BotModel {
	private static BotModel instance = null;
	private JDA api;
	private static String token = "";
	//https://discordapp.com/oauth2/authorize?&client_id=657185135153905694&scope=bot&permissions=8\
	private ObservableList<String> profanities = FXCollections.observableArrayList();
	
	private BotModel(String token) {
		try {
			BotModel.token = token;
			api = new JDABuilder(AccountType.BOT).setToken(token).build();
		} catch (LoginException e) {
			e.printStackTrace();
		}
		api.addEventListener(new MessageListener());
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
	
	public ObservableList<String> getProfanities() { return this.profanities; }
	public JDA getApi() { return this.api; }
	
}

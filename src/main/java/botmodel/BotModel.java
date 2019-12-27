package botmodel;

import javax.security.auth.login.LoginException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

/**
 * The bot itself. A singleton object which holds the JDA object, bot information
 * and provides functions to interact with the discord server.
 * @author Patrick Yevych
 *
 */
public class BotModel {
	private static BotModel instance = null;
	private JDA api;
	private static String token = "";
	//https://discordapp.com/oauth2/authorize?&client_id=657185135153905694&scope=bot&permissions=8\
	private ObservableList<String> profanities = FXCollections.observableArrayList();
	
	/**
	 * 
	 * @param the bot token.
	 */
	private BotModel(String token) {
		try {
			BotModel.token = token;
			api = new JDABuilder(AccountType.BOT).setToken(token).build();
		} catch (LoginException e) {
			e.printStackTrace();
		}
		api.addEventListener(new MessageListener());
	}
	
	/**
	 * 
	 * @return the bot token.
	 */
	public String getToken() { return BotModel.token; }
	
	/**
	 * Retrieves the only instance of BotModel.
	 * If it doesn't exist, instantiate a new one with the provided bot token. 
	 * @param the bot token.
	 * @return the singleton BotModel object.
	 */
	public synchronized static BotModel get(String token) {
		if (BotModel.instance == null) BotModel.instance = new BotModel(token);
		return BotModel.instance;
	}
	
	/**
	 * Retrieves the only instance of BotModel.
	 * @return the singleton BotModel object. null if it has not been instantiated yet.
	 */
	public synchronized static BotModel get() {
		return BotModel.instance;
	}
	
	/**
	 * Sends a message to the specified channel.
	 * @param the message string
	 * @param the channel's name
	 */
	public void sendMessage(String message, String channel) {
		api.getTextChannelsByName(channel, false).get(0).sendMessage(message).queue();
	}
	
	/**
	 * 
	 * @return the profanities ObservableList.
	 */
	public ObservableList<String> getProfanities() { return this.profanities; }
	
	/**
	 * 
	 * @return the JDA object.
	 */
	public JDA getApi() { return this.api; }
	
}

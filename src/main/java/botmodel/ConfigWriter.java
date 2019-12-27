package botmodel;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Writer object which saves the bot's current tools configurations into the specified file.
 * @author Patrick Yevych
 *
 */
public class ConfigWriter {

	private File file;
	
	/**
	 * 
	 * @param the configuration file.
	 */
	public ConfigWriter(File file) {
		this.file = file;
	}
	
	/**
	 * Obtain the state of BotModel and writes it into the configuration file following the format of ConfigParser.
	 * @return true if the writing was successful. false otherwise.
	 * @throws IOException
	 */
	public boolean write() throws IOException {
		try {
			PrintWriter writer = new PrintWriter(file);
			String s = "";
			s += "DISCORD-BOTCONFIGURATIONFILESTART\n";
			s += BotModel.get().getToken() + "\n";
			s += "PROFANITYLISTSTART\n";
			for (String w: BotModel.get().getProfanities()) {
				s += w + "\n";
			}
			s += "PROFANITYLISTEND\n";
			s += "DISCORD-BOTCONFIGURATIONFILEEND\n";
			System.out.println(s);
			writer.write(s);
			writer.close();
		} catch (Exception e) {
			System.out.println("Configurations file writing failed. Reason: " + e.toString());
			return false;
		}
		return true;
	}
	
	/**
	 * Writes to the configuration file an empty configurations template.
	 * Used to create new configurations files that follow the format of ConfigParser.
	 * @return true if the writing was successful. false otherwise.
	 * @throws IOException
	 */
	public boolean makeFile() throws IOException {
		try {
			PrintWriter writer = new PrintWriter(file);
			String s = "";
			s += "DISCORD-BOTCONFIGURATIONFILESTART\n";
			s += "your-token-here\n";
			s += "PROFANITYLISTSTART\n";
			s += "PROFANITYLISTEND\n";
			s += "DISCORD-BOTCONFIGURATIONFILEEND\n";
			System.out.println(s);
			writer.write(s);
			writer.close();
		} catch (Exception e) {
			System.out.println("Configurations file writing failed. Reason: " + e.toString());
			return false;
		}
		return true;
	}
}

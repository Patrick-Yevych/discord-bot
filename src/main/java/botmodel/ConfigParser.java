package botmodel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parser object which parses the specified configuration file; obtaining bot tools configurations such as the bot token, profanity list, etc.
 * @author Patrick Yevych
 *
 */
public class ConfigParser {
	
	private Pattern fileStart = Pattern.compile("^DISCORD-BOTCONFIGURATIONFILESTART$");
	private Pattern fileEnd = Pattern.compile("^DISCORD-BOTCONFIGURATIONFILEEND$");
	private Pattern profanityStart = Pattern.compile("^PROFANITYLISTSTART$");
	private Pattern profanityEnd = Pattern.compile("^PROFANITYLISTEND$");
	
	private File file;
	
	/**
	 * 
	 * @param the configuration file.
	 */
	public ConfigParser(File file) {
		this.file = file;
	}
	
	/**
	 * Parse the configurations file and modifies BotModel accordingly.
	 * @return true if parser succeeded and reached the accepting state. false otherwise.
	 * @throws IOException
	 */
	public boolean parse() throws IOException {
		try {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		Matcher m = null;
		int state = 1, lineNum = 0;
		String line = "";
		
		while ((line = reader.readLine()) != null) {
			lineNum++;
			line = line.replace(" ", "");
			line = line.trim();
			switch (state) {
				case 0:
					return false;
				case 1:
					m = fileStart.matcher(line);
					if (m.matches()) {
						state = 2;
						break;
					}
					return false;
				case 2:
						BotModel.get(line); //BotModel initialized
						state = 3;
						break;
				case 3:
					m = profanityStart.matcher(line);
					if (m.matches()) {
						state = 4;
						break;
					}
					return false;
				case 4:
					m = profanityEnd.matcher(line);
					if (m.matches()) {
						state = 5;
						break;
					}
					else if (!BotModel.get().getProfanities().contains(line))
						BotModel.get().getProfanities().add(line);
					break;
				case 5:
					m = fileEnd.matcher(line);
					if (m.matches()) {
						return true;
					}
					return false;
			}
			
		}
		reader.close();
		return true;
		} catch (FileNotFoundException e) {
			System.out.println("Configuration file missing. A configuration file was created in the directory of this program.");
			ConfigWriter writer = new ConfigWriter(new File("./cfg.txt"));
			writer.makeFile();
			return false;
		} catch (Exception e) {
			System.out.println("Configurations file loading failed. Reason: " + e.toString());
			return false;
		}
	}
}

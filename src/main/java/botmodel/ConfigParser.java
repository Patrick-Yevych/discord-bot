package botmodel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfigParser {
	
	private Pattern fileStart = Pattern.compile("^DISCORD-BOT CONFIGURATION FILE START$");
	private Pattern fileEnd = Pattern.compile("^DISCORD-BOT CONFIGURATION FILE END$");
	private Pattern token = Pattern.compile("^Token: (.+)$");
	private File file;
	
	public ConfigParser(File file) {
		this.file = file;
	}
	
	public boolean parse() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		Matcher m;
		int state = 1, lineNum = 0;
		String line = "";
		
		while ((line = reader.readLine()) != null) {
			lineNum++;
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
					m = token.matcher(line);
					if (m.matches()) {
						BotModel.get().setToken(m.group(1));
						state = 3;
						break;
					}
					return false;
				case 3:
					m = fileEnd.matcher(line);
					if (m.matches()) {
						return true;
					}
					return false;
			}
		}
		
		return true;
	}
	
}

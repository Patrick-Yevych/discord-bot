package botmodel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfigParser {
	
	private Pattern fileStart = Pattern.compile("^DISCORD-BOTCONFIGURATIONFILESTART$");
	private Pattern fileEnd = Pattern.compile("^DISCORD-BOTCONFIGURATIONFILEEND$");
	private Pattern profanityStart = Pattern.compile("^PROFANITYLISTSTART$");
	private Pattern profanityEnd = Pattern.compile("^PROFANITYLISTEND$");
	
	private File file;
	
	public ConfigParser(File file) {
		this.file = file;
	}
	
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
					else BotModel.get().getProfanities().add(line);
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
		}
		catch (Exception e) {
			System.out.println("Configurations file loading failed. Reason: " + e.toString());
			return false;
		}
	}
}

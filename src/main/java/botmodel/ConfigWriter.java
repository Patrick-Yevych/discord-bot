package botmodel;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class ConfigWriter {

	private File file;
	
	public ConfigWriter(File file) {
		this.file = file;
	}
	
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

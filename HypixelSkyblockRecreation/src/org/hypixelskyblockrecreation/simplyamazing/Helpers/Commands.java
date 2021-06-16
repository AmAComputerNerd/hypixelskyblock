package org.hypixelskyblockrecreation.simplyamazing.Helpers;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Logger;

import org.hypixelskyblockrecreation.simplyamazing.Main;

public class Commands {
	
	static HashMap<String, String> commands = new HashMap<String, String>();
	
	public static HashMap<String, String> getCommands() {
		return commands;
	}
	
	public static void registerCommand(String cmd, String usage) throws IOException {
		if(commands.containsKey(cmd)) {
			throw new IOException("A command under the alias '" + cmd + "' is already registered!");
		}
		commands.put(cmd, usage);
		return;
	}
	
	public static void unregisterCommand(String cmd) throws ArrayIndexOutOfBoundsException {
		if(!(commands.containsKey(cmd))) {
			throw new ArrayIndexOutOfBoundsException("No registered command under the alias '" + cmd + "' was found!");
		}
		commands.remove(cmd);
		return;
	}
	
	public static void unregisterAll() {
		commands.clear();
		Logger log = Main.getInstance().getLogger();
		log.info(" > Unregistered commands from the internal usage database.");
		return;
	}
	
	public static boolean isRegistered(String cmd) {
		if(commands.containsKey(cmd)) {
			return true;
		}
		return false;
	}
	
	public static String getCommandUsage(String cmd) throws IOException, ArrayIndexOutOfBoundsException {
		if(!(isRegistered(cmd))) {
			throw new IOException("No registered command under the alias '" + cmd + "' was found!");
		}
		if(commands.get(cmd) == null) {
			throw new ArrayIndexOutOfBoundsException("The registered command under the alias of '" + cmd + "' didn't specify usage.");
		}
		return ChatUtils.chat("&cUsage: " + commands.get(cmd));
	}

}

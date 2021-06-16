package org.hypixelskyblockrecreation.simplyamazing.Commands;

import java.util.List;

import org.bukkit.command.CommandSender;
import org.hypixelskyblockrecreation.simplyamazing.Main;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Types.SkyBlockCommand;

public class SetLocale extends SkyBlockCommand {
	
	private Main plugin;
	
	public SetLocale() {
		super("setlanguage", "/setlanguage", null, false);
	}

	@Override
	public boolean execute(CommandSender sender, String[] args) {
		return false;
	}

	@Override
	public List<String> tabComplete(CommandSender sender, String[] args) {
		return null;
	}

}

package org.hypixelskyblockrecreation.simplyamazing.Commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.hypixelskyblockrecreation.simplyamazing.Main;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ChatUtils;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Utilities;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Types.SkyBlockCommand;

public class SBSkills extends SkyBlockCommand {
	
	private Main plugin;
	
	public SBSkills() {
		super("sbskills", "/sbskills [get/givexp/removexp/set/setxp] (args)", "skyblock.skills", false);
	}

	@Override
	public boolean execute(CommandSender sender, String[] args) {
		Player p = (Player) sender;
		
		if(args.length == 0) {
			Utilities.sendUsage("sbskills", p);
			return false;
		}
		
		switch(args[0].toLowerCase()) {
			case "get":
				if(args.length == 1) {
					p.sendMessage(ChatUtils.chat("&cUsage: /sbskills get [skill] (player)"));
					return false;
				}
				
		}
		return false;
	}

	@Override
	public List<String> tabComplete(CommandSender sender, String[] args) {
		if(args.length == 0) {
			return Arrays.asList("get", "givexp", "removexp", "set", "setxp");
		} else if(args.length == 1) {
			return Arrays.asList("farming", "mining", "combat", "foraging", "farming", "enchanting", "alchemy", "carpentry", "runecrafting", "social", "taming");
		} else if(args.length == 2) {
			return Arrays.asList("num");
		} else if(args.length == 3) {
			List<String> toReturn = new ArrayList<String>();
			for(Player p : Bukkit.getOnlinePlayers()) {
				toReturn.add(p.getName());
			}
			return toReturn;
		}
		return null;
	}

}

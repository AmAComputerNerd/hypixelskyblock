package org.hypixelskyblockrecreation.simplyamazing.Commands;

import org.apache.logging.log4j.core.util.Integers;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.hypixelskyblockrecreation.simplyamazing.Main;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ChatUtils;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Utilities;

public class SkillTest implements CommandExecutor {
	
	private Main plugin;
	
	public SkillTest(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("skilltest").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		
		if(args.length == 0) {
			p.sendMessage(ChatUtils.chat("&7Your Farming skill is level &e" + Utilities.getSkill(p, "farming", "level") + " &7(&e" + Utilities.getSkill(p, "farming", "exp") + "&7 XP)"));
			return true;
		}
		
		switch(args[0].toLowerCase()) {
			case "farming":
				p.sendMessage(ChatUtils.chat("&7Your Farming skill is level &e" + Utilities.numberToRomanNumerals(Integers.parseInt(Utilities.getSkill(p, "farming", "level"))) + " &7(&e" + Utilities.getSkill(p, "farming", "exp") + "&7 XP)"));
				break;
			case "mining":
				p.sendMessage(ChatUtils.chat("&7Your Mining skill is level &e" + Utilities.numberToRomanNumerals(Integers.parseInt(Utilities.getSkill(p, "mining", "level"))) + " &7(&e" + Utilities.getSkill(p, "mining", "exp") + "&7 XP)"));
				break;
			case "combat":
				p.sendMessage(ChatUtils.chat("&7Your Combat skill is level &e" + Utilities.numberToRomanNumerals(Integers.parseInt(Utilities.getSkill(p, "combat", "level"))) + " &7(&e" + Utilities.getSkill(p, "combat", "exp") + "&7 XP)"));
				break;
			case "foraging":
				p.sendMessage(ChatUtils.chat("&7Your Foraging skill is level &e" + Utilities.numberToRomanNumerals(Integers.parseInt(Utilities.getSkill(p, "foraging", "level"))) + " &7(&e" + Utilities.getSkill(p, "foraging", "exp") + "&7 XP)"));
				break;
			case "fishing":
				p.sendMessage(ChatUtils.chat("&7Your Fishing skill is level &e" + Utilities.numberToRomanNumerals(Integers.parseInt(Utilities.getSkill(p, "fishing", "level"))) + " &7(&e" + Utilities.getSkill(p, "fishing", "exp") + "&7 XP)"));
				break;
		}
		return false;
	}

}

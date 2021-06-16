package org.hypixelskyblockrecreation.simplyamazing.Commands;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.core.util.Integers;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.hypixelskyblockrecreation.simplyamazing.Main;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ChatUtils;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Utilities;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Types.SkyBlockCommand;

public class SkillTest extends SkyBlockCommand {
	
	private Main plugin;
	
	public SkillTest() {
		super("skilltest", "/skilltest (farming/mining/combat/foraging/fishing)", null, false);
	}

	@Override
	public boolean execute(CommandSender sender, String[] args) {
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

	@Override
	public List<String> tabComplete(CommandSender sender, String[] args) {
		if(args.length == 0) {
			return Arrays.asList("farming", "mining", "combat", "foraging", "fishing");
		}
		return null;
	}

}

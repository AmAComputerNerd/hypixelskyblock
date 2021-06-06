package org.hypixelskyblockrecreation.simplyamazing.Commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import org.apache.logging.log4j.core.util.Integers;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.hypixelskyblockrecreation.simplyamazing.Main;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ChatUtils;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Utilities;
import org.hypixelskyblockrecreation.simplyamazing.Items.SkyBlockItem;
import org.hypixelskyblockrecreation.simplyamazing.Items.SkyBlockMaterial;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.not_found;

public class Item implements CommandExecutor, TabCompleter {
	
	private Main plugin;
	
	public Item(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("item").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatUtils.chat("&cOnly players can use this command!"));
			return false;
		}
		Player p = (Player) sender;
		// Permission check
		if(Utilities.enforcePermissions(p, "skyblock.item")) {
			return false;
		}
		
		// Show the command usage if the command is executed without arguments
		if(args.length == 0) {
			p.sendMessage(ChatUtils.chat("&cUsage: /item [sb_name] (amount)"));
			return false;
		}
		
		if(Main.isValidItem(args[0])) { // Check if the first argument matches a skyblock item
			// Get the item, and initialize the amount variable
			SkyBlockItem sbi = Main.getItem(args[0]);
			int amount;
			try {
				// Check if there is 2 arguments entered, and attempt to convert the second to an integer
				// Defaults to 1 if it there is no second argument
				amount = args[1]!=null ? Integers.parseInt(args[1]) : 1;
			} catch(Exception e) {
				// Also assigns it to 1 for that item if the second argument can't be converted to an integer
				amount = 1;
			}
			// Add the item to their inventory and send a success message
			p.getInventory().addItem(sbi.createItem(amount));
			p.sendMessage(ChatUtils.chat("&aGiven " + p.getName() + "&a item &e" + args[0].toUpperCase() + "&e."));
			return true;
		} else if(Main.isValidMaterial(args[0])) { // Check if the first argument matches a skyblock material
			// Get the material, and initialize the amount variable
			SkyBlockMaterial sbm = Main.getMaterial(args[0]);
			int amount;
			try {
				// Check if there is 2 arguments entered, and attempt to convert the second to an integer
				// Defaults to the max stack size if it there is no second argument
				amount = args[1]!=null ? Integers.parseInt(args[1]) : sbm.getMaterial().getMaxStackSize();
			} catch(Exception e) {
				// Also assigns it to the maximum stack size for that item if the second argument can't be converted to an integer
				amount = sbm.getMaterial().getMaxStackSize();
			}
			// Add the item to their inventory and send a success message
			p.getInventory().addItem(sbm.createItem(amount));
			p.sendMessage(ChatUtils.chat("&aGiven " + p.getName() + "&a item &e" + args[0].toUpperCase() + "&e. &8(x" + amount + "&8)"));
			return true;
		}
		// Send an error message if it doesn't match either
		p.sendMessage(ChatUtils.chat("&cInvalid item: \"" + args[0] + "\""));
		return false;
	}

	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		Collection<String> auto = new TreeSet<String>();
		if(args.length == 1) {
			if(!args[0].equals("")) {
				for(String s : Main.getItemNames()) {
					if(s.toLowerCase().startsWith(args[0].toLowerCase())) {
						auto.add(s);
					}
				}
				for(String s : Main.getMaterialNames()) {
					if(s.toLowerCase().startsWith(args[0].toLowerCase())) {
						auto.add(s);
					}
				}
			} else {
				for(String s : Main.getItemNames()) {
					auto.add(s);
				}
				for(String s : Main.getMaterialNames()) {
					auto.add(s);
				}
			}
		}
		return new ArrayList<String>(auto);
	}

}

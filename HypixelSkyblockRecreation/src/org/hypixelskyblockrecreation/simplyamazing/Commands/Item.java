package org.hypixelskyblockrecreation.simplyamazing.Commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

import org.apache.logging.log4j.core.util.Integers;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.hypixelskyblockrecreation.simplyamazing.Main;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ChatUtils;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Utilities;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Types.SkyBlockCommand;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.SkyBlockItem;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.SkyBlockMaterial;

public class Item extends SkyBlockCommand {
	
	private Main plugin;
	
	public Item() {
		super("item", "/item [sb_name] (amount)", "skyblock.item", false);
	}

	@Override
	public boolean execute(CommandSender sender, String[] args) {
		Player p = (Player) sender;	
		// Show the command usage if the command is executed without arguments
		if(args.length == 0) {
			Utilities.sendUsage("item", p);
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
			p.sendMessage(ChatUtils.chat("&8Pssstt! &7Use /material to get this item."));
			return true;
		}
		// Send an error message if it doesn't match either
		p.sendMessage(ChatUtils.chat("&cInvalid item: \"" + args[0] + "\""));
		return false;
	}

	@Override
	public List<String> tabComplete(CommandSender sender, String[] args) {
		Collection<String> auto = new TreeSet<String>();
		if(args.length == 1) {
			if(!args[0].equals("")) {
				for(String s : Main.getItemNames()) {
					if(s.toLowerCase().startsWith(args[0].toLowerCase())) {
						auto.add(s);
					}
				}
			} else {
				for(String s : Main.getItemNames()) {
					auto.add(s);
				}
			}
		}
		return new ArrayList<String>(auto);
	}

}

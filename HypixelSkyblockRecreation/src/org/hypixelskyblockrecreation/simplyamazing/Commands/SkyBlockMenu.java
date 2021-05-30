package org.hypixelskyblockrecreation.simplyamazing.Commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.hypixelskyblockrecreation.simplyamazing.Main;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ChatUtils;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Inventories;
import org.hypixelskyblockrecreation.simplyamazing.Menus.SBMenuGUI;

public class SkyBlockMenu implements CommandExecutor {
	
	private Main plugin;
	
	public SkyBlockMenu(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("skyblockmenu").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatUtils.chat("&cOnly players can use this command!"));
			return false;
		}
		
		Player p = (Player) sender;
		p.openInventory(Inventories.build("SkyBlock Menu", 6, SBMenuGUI.main.getInventoryFormat(p)));
		
		return false;
	}
}

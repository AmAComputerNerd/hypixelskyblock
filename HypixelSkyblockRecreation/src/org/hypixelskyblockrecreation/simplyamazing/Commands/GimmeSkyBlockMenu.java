package org.hypixelskyblockrecreation.simplyamazing.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.hypixelskyblockrecreation.simplyamazing.Main;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ChatUtils;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.RegisterItems;
import org.hypixelskyblockrecreation.simplyamazing.Items.SkyBlockItem;

public class GimmeSkyBlockMenu implements CommandExecutor {
	
	private Main plugin;
	
	public GimmeSkyBlockMenu(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("gimme").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		ItemStack sbmenu = Main.sbMenu;
		p.getInventory().addItem(sbmenu);
		return false;
	}

}

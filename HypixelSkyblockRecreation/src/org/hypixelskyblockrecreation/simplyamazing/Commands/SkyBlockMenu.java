package org.hypixelskyblockrecreation.simplyamazing.Commands;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.hypixelskyblockrecreation.simplyamazing.Main;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ChatUtils;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Inventories;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Types.SkyBlockCommand;
import org.hypixelskyblockrecreation.simplyamazing.Menus.SBMenuGUI;

public class SkyBlockMenu extends SkyBlockCommand {
	
	private Main plugin;
	
	public SkyBlockMenu() {
		super("skyblockmenu", "/skyblockmenu", null, false);
	}

	@Override
	public boolean execute(CommandSender sender, String[] args) {
		Player p = (Player) sender;
		p.openInventory(Inventories.build("SkyBlock Menu", 6, SBMenuGUI.main.getInventoryFormat(p)));
		return false;
	}

	@Override
	public List<String> tabComplete(CommandSender sender, String[] args) {
		return null;
	}
}

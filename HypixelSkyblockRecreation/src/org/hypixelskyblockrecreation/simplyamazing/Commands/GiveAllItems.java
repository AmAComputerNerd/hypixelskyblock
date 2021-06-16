package org.hypixelskyblockrecreation.simplyamazing.Commands;

import java.io.IOException;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.hypixelskyblockrecreation.simplyamazing.Main;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ChatUtils;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Commands;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Types.SkyBlockCommand;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.SkyBlockItem;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Other.not_found;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Other.skyblock_menu;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Other.vanilla_item;

public class GiveAllItems extends SkyBlockCommand {
	
	private Main plugin;
	
	public GiveAllItems() {
		super("sbgiveall", "/sbgiveall", "skyblock.sbgiveall", false);
	}

	@Override
	public boolean execute(CommandSender sender, String[] args) {
		Player p = (Player) sender;
		for(SkyBlockItem sbi : Main.getItems()) {
			if(sbi instanceof not_found || sbi instanceof skyblock_menu) {
				continue;
			}
			if(sbi instanceof vanilla_item) {
				continue;
			}
			p.getInventory().addItem(sbi.createItem(1));
			p.sendMessage(ChatUtils.chat("&aGiven " + p.getName() + "&a item &e" + Main.getItemNameFromItem(sbi).toUpperCase() + "&e."));
		}
		p.sendMessage(ChatUtils.chat("&aSuccess! You have been given every &eSkyBlock &aitem!"));
		return false;
	}

	@Override
	public List<String> tabComplete(CommandSender sender, String[] args) {
		return null;
	}

}

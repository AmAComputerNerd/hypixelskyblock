package org.hypixelskyblockrecreation.simplyamazing.Menus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Skull;
import org.hypixelskyblockrecreation.simplyamazing.Main;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ChatUtils;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Inventories;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.SkullHelper;

public class LocaleGUI {
	private Main plugin;
	
	public LocaleGUI(Main plugin) {
		this.plugin = plugin;
	}
	
	public static String getTitle() {
		return "Select Language";
	}
	
	private static HashMap<ItemStack, String> drawInventory(HashMap<ItemStack, String> inv, Player p) {
		// Create the English button
		ItemStack englishSkull = SkullHelper.getSkullFromURL("e");
		ItemStack english = Inventories.buildItem(englishSkull, "&aEnglish", new ArrayList<String>(Arrays.asList("&7Change your language to English.", "", "&eClick to change your language!")));
		inv.put(english, "0");
		return inv;
	}
	
	public static HashMap<ItemStack, String> getInventoryFormat(Player p) {
		HashMap<ItemStack, String> toReturn = drawInventory(new HashMap<ItemStack, String>(), p);
		return toReturn;
	}
	
	public static void clicked(Player p, int slot, ItemStack i, Inventory inv) {
		if(i.getItemMeta().getDisplayName().equals(ChatUtils.chat("&aEnglish"))) {
			p.sendMessage(ChatUtils.chat("&aYou set your language to &6English&a!"));
			return;
		}
	}
}

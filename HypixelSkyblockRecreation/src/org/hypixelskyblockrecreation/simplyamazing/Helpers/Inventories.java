package org.hypixelskyblockrecreation.simplyamazing.Helpers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.hypixelskyblockrecreation.simplyamazing.Main;

public class Inventories {
	
	private static ItemStack getFillerItem() {
		ItemStack filler = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
		ItemMeta meta = filler.getItemMeta();
		meta.setDisplayName(ChatUtils.chat("&c"));
		filler.setItemMeta(meta);
		return filler;
	}
	
	public static ItemStack buildItem(Material m, int amount, String name, List<String> lore) {
		ItemStack i = new ItemStack(m, amount);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(ChatUtils.chat(name));
		meta.setLore(lore);
		i.setItemMeta(meta);
		return i;
	}
	
	public static ItemStack buildItem(Material m, int amount, short value, String name, List<String> lore) {
		ItemStack i = new ItemStack(m, amount, value);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(ChatUtils.chat(name));
		meta.setLore(lore);
		i.setItemMeta(meta);
		return i;
	}
	
	public static ItemStack buildItem(ItemStack i, String name, List<String> lore) {
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(ChatUtils.chat(name));
		meta.setLore(lore);
		i.setItemMeta(meta);
		return i;
	}
	
	public static ItemStack glowify(ItemStack i) {
		ItemMeta meta = i.getItemMeta();
		meta.addItemFlags(org.bukkit.inventory.ItemFlag.HIDE_ENCHANTS);
		i.setItemMeta(meta);
		i.addUnsafeEnchantment(Enchantment.LUCK, 1);
		return i;
	}
	
	public static Inventory build(String name, int rows, HashMap<ItemStack, String> format) {
		Inventory inv = Bukkit.createInventory(null, rows * 9, ChatUtils.chat(name));
		Logger log = Main.getInstance().getLogger();
		
		for(ItemStack set : format.keySet()) {
			try {
				int num = Integer.parseInt(format.get(set));
				if(num > (rows * 9)) {
					log.warning(("An item failed to load into an inventory because the inventory wasn't big enough."));
					continue;
				}
				inv.setItem(num, set);
			} catch(Exception e) {
				log.warning(("An item failed to load into an inventory."));
				continue;
			}
		}
		
		ItemStack filler = getFillerItem();
		
		for(int slot = 0; slot < inv.getSize(); slot++) {
			ItemStack i = inv.getItem(slot);
			if(i == null) {
				inv.setItem(slot, filler);
			}
		}
		
		return inv;
	}

}
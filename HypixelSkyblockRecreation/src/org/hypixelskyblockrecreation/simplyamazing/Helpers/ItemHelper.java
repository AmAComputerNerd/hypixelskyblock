package org.hypixelskyblockrecreation.simplyamazing.Helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.hypixelskyblockrecreation.simplyamazing.Items.Rarity;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBAbility;
import org.hypixelskyblockrecreation.simplyamazing.Items.SkyBlockItem;
import org.hypixelskyblockrecreation.simplyamazing.Items.Type;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.skyblock_menu;

import de.tr7zw.nbtapi.NBTItem;

public class ItemHelper {
	
	public static String getNBTValue(ItemStack i, String key) {
		if(i == null) {
			return null;
		}
		if(i.getType().equals(Material.AIR)) {
			return null;
		}
		NBTItem nbti = new NBTItem(i);
		Set<String> keys = nbti.getKeys();
		for(String k : keys) {
			if(k.equals(key)) {
				return nbti.getString(k);
			}
		}
		return null;
	}
	
	public static ItemStack setNBTValue(ItemStack i, String key, String value) {
		if(i == null) {
			return null;
		}
		if(i.getType().equals(Material.AIR)) {
			return null;
		}
		NBTItem nbti = new NBTItem(i);
		nbti.setString(key, value);
		return nbti.getItem();
	}
	
	public static HashMap<String, String> getAllNBTValues(ItemStack i) {
		if(i == null) {
			return null;
		}
		if(i.getType().equals(Material.AIR)) {
			return null;
		}
		NBTItem nbti = new NBTItem(i);
		HashMap<String, String> values = new HashMap<String, String>();
		if(nbti.getKeys().isEmpty()) {
			return null;
		}
		
		for(String k : nbti.getKeys()) {
			values.put(k, nbti.getString(k));
		}
		
		return values;
	}
	
	public static ItemStack setAllNBTValues(ItemStack i, HashMap<String, String> values) {
		if(i == null) {
			return i;
		}
		if(i.getType().equals(Material.AIR)) {
			return i;
		}
		NBTItem nbti = new NBTItem(i);
		for(Entry<String, String> k : values.entrySet()) {
			nbti.setString(k.getKey(), k.getValue());
		}
		return nbti.getItem();
	}
	
	public static int stringToUUID(final String s) {
		if (s == null) {
            return 0;
        }
        int hash = 0;
        for (final char c : s.toCharArray()) {
            hash = 31 * hash + c;
        }
        return hash;
	}
	
	public static List<String> stringToLore(final String s, final int characterLimit, final ChatColor colour) {
		final String[] words = s.split(" ");
        final List<String> lines = new ArrayList<String>();
        StringBuilder currentLine = new StringBuilder();
        
        for(final String word : words) {
            if(!word.equals("/n")) {
                if(currentLine.toString().equals("")) {
                    currentLine = new StringBuilder(word);
                } else {
                    currentLine.append(" ").append(word);
                }
            }
            if(word.equals("/n") || currentLine.length() + word.length() >= characterLimit) {
                final String newLine = currentLine.toString();
                lines.add("" + colour + newLine);
                currentLine = new StringBuilder();
            }
        }
        
        if(currentLine.length() > 0) {
            lines.add(ChatUtils.chat("" + colour + (Object)currentLine));
        }
        
        return lines;
	}
	
	public static ItemStack loreItem(ItemStack i, List<String> lore) {
		final ItemMeta meta = i.getItemMeta();
		meta.setLore(lore);
		i.setItemMeta(meta);
		return i;
	}

	public static void addEnchantGlint(final ItemStack i) {
		final ItemMeta meta = i.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		i.setItemMeta(meta);
		i.addUnsafeEnchantment(Enchantment.LUCK, 1);
	}
}

package org.hypixelskyblockrecreation.simplyamazing.Helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.hypixelskyblockrecreation.simplyamazing.Main;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Types.Attribute;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Types.Stat;
import org.hypixelskyblockrecreation.simplyamazing.Items.Rarity;
import org.hypixelskyblockrecreation.simplyamazing.Items.Type;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.SkyBlockItem;

import de.tr7zw.nbtapi.NBTCompound;
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
	
	public static String getNBTValueFromCompound(ItemStack i, String compound, String key) {
		if(i == null) {
			return null;
		}
		if(i.getType() == Material.AIR) {
			return null;
		}
		NBTItem nbti = new NBTItem(i);
		NBTCompound comp = nbti.getCompound(compound);
		if(comp == null) {
			i = setNBTValueInCompound(i, compound, key, "empty");
			nbti = new NBTItem(i);
			comp = nbti.getCompound(compound);
		}
		String value = comp.getString(key);
		return value;
	}
	
	public static ItemStack setNBTValue(ItemStack i, String key, String value) {
		if(i == null) {
			Main.getInstance().getLogger().warning("An item didn't have it's NBT value set because it was null.");
			return i;
		}
		if(i.getType().equals(Material.AIR)) {
			Main.getInstance().getLogger().warning("An item didn't have it's NBT value set because it was AIR.");
			return i;
		}
		NBTItem nbti = new NBTItem(i);
		nbti.setString(key, value);
		return nbti.getItem();
	}
	
	public static ItemStack setNBTValueInCompound(ItemStack i, String compound, String key, String value) {
		if(i == null) {
			Main.getInstance().getLogger().warning("An item didn't have it's NBT value set because it was null.");
			return i;
		}
		if(i.getType() == Material.AIR) {
			Main.getInstance().getLogger().warning("An item didn't have it's NBT value set because it was AIR.");
			return i;
		}
		NBTItem nbti = new NBTItem(i);
		NBTCompound comp = nbti.getCompound(compound);
		if(comp == null) {
			nbti.addCompound(compound);
			comp = nbti.getCompound(compound);
		}
		comp.setString(key, value);
		return nbti.getItem();
	}
	
	public static ItemStack removeNBTValue(ItemStack i, String key) {
		if(i == null) {
			Main.getInstance().getLogger().warning("An item didn't have it's NBT value removed because it was null.");
			return i;
		}
		if(i.getType().equals(Material.AIR)) {
			Main.getInstance().getLogger().warning("An item didn't have it's NBT value removed because it was AIR.");
			return i;
		}
		NBTItem nbti = new NBTItem(i);
		if(nbti.getString(key) != null) {
			nbti.removeKey(key);
		}
		return nbti.getItem();
	}
	
	public static ItemStack removeNBTValueFromCompound(ItemStack i, String compound, String key) {
		if(i == null) {
			Main.getInstance().getLogger().warning("An item didn't have it's NBT value removed because it was null.");
			return i;
		}
		if(i.getType().equals(Material.AIR)) {
			Main.getInstance().getLogger().warning("An item didn't have it's NBT value removed because it was AIR.");
			return i;
		}
		NBTItem nbti = new NBTItem(i);
		NBTCompound comp = nbti.getCompound(compound);
		if(comp == null) {
			Main.getInstance().getLogger().warning("An item didn't have it's NBT value removed because the compound specified didn't exist.");
			return i;
		}
		if(comp.getString(key) != null) {
			comp.removeKey(key);
		}
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
	
	public static ItemStack removeAllNBTValues(ItemStack i, List<String> keys) {
		if(i == null) {
			return null;
		}
		if(i.getType().equals(Material.AIR)) {
			return null;
		}
		NBTItem nbti = new NBTItem(i);
		for(String k : keys) {
			if(nbti.getString(k) != null) {
				nbti.removeKey(k);
			}
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
        
        return ChatUtils.chat(lines);
	}
	
	public static HashMap<EntityType, Integer> getItemEntityResistance(ItemStack i) {
		HashMap<EntityType, Integer> toReturn = new HashMap<EntityType, Integer>();
		if(i == null) {
			return toReturn;
		}
		if(i.getType().equals(Material.AIR)) {
			return toReturn;
		}
		String value = getNBTValueFromCompound(i, "ExtraAttributes", "EntityResistance");
		if(value == null) {
			return toReturn;
		}
		if(value.equals("empty")) {
			return toReturn;
		}
		List<String> unprocessed = new ArrayList<String>();
		if(value.contains(", ")) {
			for(String s : value.split(", ")) {
				unprocessed.add(s);
			}
		} else {
			unprocessed.add(value);
		}
		for(String s : unprocessed) {
			String[] split = s.split("-");
			EntityType p0 = matchEntityType(split[0]);
			int p1 = Utilities.percentageToNumber(split[1]);
			toReturn.put(p0, p1);
		}
		return toReturn;
	}
	
	private static EntityType matchEntityType(String s) {
		switch(s.toLowerCase()) {
			case "blaze":
				return EntityType.BLAZE;
			case "cave_spider":
				return EntityType.CAVE_SPIDER;
			case "creeper":
				return EntityType.CREEPER;
			case "elder_guardian":
				return EntityType.ELDER_GUARDIAN;
			case "ender_dragon":
				return EntityType.ENDER_DRAGON;
			case "enderman":
				return EntityType.ENDERMAN;
			case "endermite":
				return EntityType.ENDERMITE;
			case "ghast":
				return EntityType.GHAST;
			case "giant":
				return EntityType.GIANT;
			case "guardian":
				return EntityType.GUARDIAN;
			case "husk":
				return EntityType.HUSK;
			case "illusioner":
				return EntityType.ILLUSIONER;
			case "iron_golem":
				return EntityType.IRON_GOLEM;
			case "llama":
				return EntityType.LLAMA;
			case "magma_cube":
				return EntityType.MAGMA_CUBE;
			case "zombie_pigman":
			case "pig_zombie":
				return EntityType.PIG_ZOMBIE;
			case "shulker":
				return EntityType.SHULKER;
			case "silverfish":
				return EntityType.SILVERFISH;
			case "skeleton":
				return EntityType.SKELETON;
			case "slime":
				return EntityType.SLIME;
			case "spider":
				return EntityType.SPIDER;
			case "stray":
				return EntityType.STRAY;
			case "vex":
				return EntityType.VEX;
			case "vindicator":
				return EntityType.VINDICATOR;
			case "witch":
				return EntityType.WITCH;
			case "wither":
				return EntityType.WITHER;
			case "wither_skeleton":
				return EntityType.WITHER_SKELETON;
			default:
				return EntityType.ZOMBIE;
		}
	}
	
	public static boolean isReforgable(Type t) {
		switch(t) {
			case BOOTS:
			case BOW:
			case CHESTPLATE:
			case HELMET:
			case HOE:
			case LEGGINGS:
			case PICKAXE:
			case AXE:
			case ROD:
			case SHIELD:
			case SWORD:
				return true;
			case ITEM:
			case NONE:
			case SHOVEL:
			default:
				return false;
		}
	}
	
	public static Rarity determineRarity(Material m) {
		List<Material> uncommon = Arrays.asList(Material.CHAINMAIL_HELMET, Material.CHAINMAIL_CHESTPLATE, Material.CHAINMAIL_LEGGINGS, Material.CHAINMAIL_BOOTS, Material.SHIELD, Material.DIAMOND_AXE, Material.DIAMOND_PICKAXE, Material.DIAMOND_SWORD, Material.DIAMOND_SPADE, Material.DIAMOND_HOE, Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS);
		List<Material> legendary = Arrays.asList(Material.COMMAND, Material.COMMAND_CHAIN, Material.COMMAND_MINECART, Material.COMMAND_REPEATING, Material.BEDROCK, Material.BARRIER);
		if(!(uncommon.contains(m)) && !(legendary.contains(m))) {
			return Rarity.COMMON;
		}
		if(uncommon.contains(m)) {
			return Rarity.UNCOMMON;
		}
		if(legendary.contains(m)) {
			return Rarity.LEGENDARY;
		}
		return Rarity.COMMON;
	}
	
	public static Type determineType(Material m) {
		List<Material> swords = Arrays.asList(Material.WOOD_SWORD, Material.STONE_SWORD, Material.IRON_SWORD, Material.GOLD_SWORD, Material.DIAMOND_SWORD);
		List<Material> pickaxes = Arrays.asList(Material.WOOD_PICKAXE, Material.STONE_PICKAXE, Material.IRON_PICKAXE, Material.GOLD_PICKAXE, Material.DIAMOND_PICKAXE);
		List<Material> axes = Arrays.asList(Material.WOOD_AXE, Material.STONE_AXE, Material.IRON_AXE, Material.GOLD_AXE, Material.DIAMOND_AXE);
		List<Material> shovels = Arrays.asList(Material.WOOD_SPADE, Material.STONE_SPADE, Material.IRON_SPADE, Material.GOLD_SPADE, Material.DIAMOND_SPADE);
		List<Material> hoes = Arrays.asList(Material.WOOD_HOE, Material.STONE_HOE, Material.IRON_HOE, Material.GOLD_HOE, Material.DIAMOND_HOE);
		List<Material> helmets = Arrays.asList(Material.LEATHER_HELMET, Material.CHAINMAIL_HELMET, Material.IRON_HELMET, Material.GOLD_HELMET, Material.DIAMOND_HELMET);
		List<Material> chestplates = Arrays.asList(Material.LEATHER_CHESTPLATE, Material.CHAINMAIL_CHESTPLATE, Material.IRON_CHESTPLATE, Material.GOLD_CHESTPLATE, Material.DIAMOND_CHESTPLATE);
		List<Material> leggings = Arrays.asList(Material.LEATHER_LEGGINGS, Material.CHAINMAIL_LEGGINGS, Material.IRON_LEGGINGS, Material.GOLD_LEGGINGS, Material.DIAMOND_LEGGINGS);
		List<Material> boots = Arrays.asList(Material.LEATHER_BOOTS, Material.CHAINMAIL_BOOTS, Material.IRON_BOOTS, Material.GOLD_BOOTS, Material.DIAMOND_BOOTS);
		if(swords.contains(m)) {
			return Type.SWORD;
		} else if(pickaxes.contains(m)) {
			return Type.PICKAXE;
		} else if(axes.contains(m)) {
			return Type.AXE;
		} else if(shovels.contains(m)) {
			return Type.SHOVEL;
		} else if(hoes.contains(m)) {
			return Type.HOE;
		} else if(helmets.contains(m)) {
			return Type.HELMET;
		} else if(chestplates.contains(m)) {
			return Type.CHESTPLATE;
		} else if(leggings.contains(m)) {
			return Type.LEGGINGS;
		} else if(boots.contains(m)) {
			return Type.BOOTS;
		} else if(m == Material.BOW) {
			return Type.BOW;
		} else if(m == Material.SHIELD) {
			return Type.SHIELD;
		} else if(m == Material.FISHING_ROD) {
			return Type.ROD;
		}
		return Type.ITEM;
	}
	
	public static String determineTool(Material m) {
		List<Material> swords = Arrays.asList(Material.WOOD_SWORD, Material.STONE_SWORD, Material.IRON_SWORD, Material.GOLD_SWORD, Material.DIAMOND_SWORD);
		List<Material> pickaxes = Arrays.asList(Material.WOOD_PICKAXE, Material.STONE_PICKAXE, Material.IRON_PICKAXE, Material.GOLD_PICKAXE, Material.DIAMOND_PICKAXE);
		List<Material> axes = Arrays.asList(Material.WOOD_AXE, Material.STONE_AXE, Material.IRON_AXE, Material.GOLD_AXE, Material.DIAMOND_AXE);
		List<Material> shovels = Arrays.asList(Material.WOOD_SPADE, Material.STONE_SPADE, Material.IRON_SPADE, Material.GOLD_SPADE, Material.DIAMOND_SPADE);
		List<Material> hoes = Arrays.asList(Material.WOOD_HOE, Material.STONE_HOE, Material.IRON_HOE, Material.GOLD_HOE, Material.DIAMOND_HOE);
		List<Material> helmets = Arrays.asList(Material.LEATHER_HELMET, Material.CHAINMAIL_HELMET, Material.IRON_HELMET, Material.GOLD_HELMET, Material.DIAMOND_HELMET);
		List<Material> chestplates = Arrays.asList(Material.LEATHER_CHESTPLATE, Material.CHAINMAIL_CHESTPLATE, Material.IRON_CHESTPLATE, Material.GOLD_CHESTPLATE, Material.DIAMOND_CHESTPLATE);
		List<Material> leggings = Arrays.asList(Material.LEATHER_LEGGINGS, Material.CHAINMAIL_LEGGINGS, Material.IRON_LEGGINGS, Material.GOLD_LEGGINGS, Material.DIAMOND_LEGGINGS);
		List<Material> boots = Arrays.asList(Material.LEATHER_BOOTS, Material.CHAINMAIL_BOOTS, Material.IRON_BOOTS, Material.GOLD_BOOTS, Material.DIAMOND_BOOTS);
		if(swords.contains(m)) {
			return "sword";
		} else if(pickaxes.contains(m)) {
			return "pickaxe";
		} else if(axes.contains(m)) {
			return "axe";
		} else if(shovels.contains(m)) {
			return "shovel";
		} else if(hoes.contains(m)) {
			return "hoe";
		} else if(helmets.contains(m)) {
			return "helmet";
		} else if(chestplates.contains(m)) {
			return "chestplate";
		} else if(leggings.contains(m)) {
			return "leggings";
		} else if(boots.contains(m)) {
			return "boots";
		} else if(m == Material.BOW) {
			return "bow";
		} else if(m == Material.SHIELD) {
			return "shield";
		} else if(m == Material.FISHING_ROD) {
			return "shield";
		}
		return "none";
	}
	
	public static ItemStack loreItem(ItemStack i, List<String> lore) {
		ItemMeta meta = i.getItemMeta();
		meta.setLore(lore);
		i.setItemMeta(meta);
		return i;
	}
	
	public static ItemStack applyExtraAttributes(SkyBlockItem sbi, ItemStack i, String id) {
		NBTItem nbti = new NBTItem(i);
		nbti.setInteger("Unbreakable", 1);
		ItemMeta meta = i.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES);
		i = nbti.getItem();
		i.setItemMeta(meta);
		i = setNBTValueInCompound(i, "ExtraAttributes", "hot_potato_count", "0");
		i = setNBTValueInCompound(i, "ExtraAttributes", "modifier", "none");
		i = setNBTValueInCompound(i, "ExtraAttributes", "id", id);
		for(Stat s : sbi.getStats()) {
			i = s.apply(i);
		}
		for(Attribute a : sbi.getAttributes()) {
			i = a.apply(i, sbi.getType());
		}
		return i;
	}

	public static void addEnchantGlint(final ItemStack i) {
		final ItemMeta meta = i.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		i.setItemMeta(meta);
		i.addUnsafeEnchantment(Enchantment.LUCK, 1);
	}
}

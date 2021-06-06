package org.hypixelskyblockrecreation.simplyamazing.Items;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.core.util.Integers;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.hypixelskyblockrecreation.simplyamazing.Main;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ChatUtils;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ItemHelper;

public class SkyBlockMaterial {
	private Material material;
	private String name;
	private String description;
	private Rarity rarity;
	private boolean stackable;
	private int uuid;
	private boolean enchantGlint;
	private boolean isVanillaCraftable;
	private CustomRecipe craftingRecipe;
	
	public SkyBlockMaterial(final Material material, final String name, final String description, final Rarity rarity, final boolean stackable, final boolean enchantGlint, final boolean isVanillaCraftable, final CustomRecipe craftingRecipe) {
		this.material = material;
		this.name = name;
		this.description = description;
		this.rarity = rarity;
		this.stackable = stackable;
		this.uuid = ItemHelper.stringToUUID(material.name() + name + rarity.toString());
		this.enchantGlint = enchantGlint;
		this.isVanillaCraftable = isVanillaCraftable;
		this.craftingRecipe = craftingRecipe;
		Main.getInstance().getLogger().info("   -> Loaded a material with an id of '" + String.valueOf(this.uuid) + "' - named '" + this.name + "'.");
	}
	
	public boolean compare(final ItemStack other) {
		final int otherUUID = Integers.parseInt(ItemHelper.getNBTValue(other, "MaterialUUID"));
		return otherUUID == this.uuid;
	}
	
	public ItemStack createItem(final int amount) {
		final ItemStack item = new ItemStack(this.material, amount);
		final ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatUtils.chat(this.rarity.getColour() + this.name));
		item.setItemMeta(meta);
		ItemHelper.setNBTValue(item, String.valueOf(this.uuid), "MaterialUUID");
		ItemHelper.loreItem(item, this.getLore(item));
		if(this.enchantGlint) {
			ItemHelper.addEnchantGlint(item);
		}
		if(!this.stackable) {
			ItemHelper.setNBTValue(item, "UUID", java.util.UUID.randomUUID().toString());
		}
		return item;
	}
	
	private List<String> getLore(final ItemStack item) {
		final List<String> lore = new ArrayList<String>();
		if(!(this.rarity == Rarity.NONE)) {
			lore.add(ChatUtils.chat("" + this.rarity.getColor() + ChatColor.BOLD + this.rarity.toString()));
		}
		return lore;
	}
	
	public Material getMaterial() {
		return this.material;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public Rarity getRarity() {
		return this.rarity;
	}
	
	public boolean isStackable() {
		return this.stackable;
	}
	
	public int getUUID() {
		return this.uuid;
	}
	
	public boolean isVanillaCraftable() {
		return this.isVanillaCraftable;
	}
	
	public boolean hasCraftingRecipe() {
		return this.craftingRecipe != null;
	}
	
	public CustomRecipe getCraftingRecipe() {
		return this.craftingRecipe;
	}
}

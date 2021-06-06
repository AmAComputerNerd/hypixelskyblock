package org.hypixelskyblockrecreation.simplyamazing.Items;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.core.util.Integers;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.hypixelskyblockrecreation.simplyamazing.Main;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ChatUtils;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ItemHelper;

public abstract class SkyBlockItem {
	protected Material material;
	protected String name;
	private String description;
	protected Rarity rarity;
	private Type type;
	protected int uuid;
	protected boolean stackable;
	private boolean oneTimeUse;
	private boolean noShow;
	private List<SBAbility> abilities;
	private CustomRecipe craftingRecipe;
	
	public SkyBlockItem(final Material material, final String name, final String description, final Rarity rarity, final Type type, final boolean stackable, final boolean oneTimeUse, final boolean noShow, final List<SBAbility> abilities, final CustomRecipe craftingRecipe) {
		this.noShow = noShow;
		this.material = material;
		this.name = name;
		this.description = description;
		this.rarity = rarity;
		this.type = type;
		this.stackable = stackable;
		this.uuid = ItemHelper.stringToUUID(material.name() + name + rarity.toString());
		this.oneTimeUse = oneTimeUse;
		this.abilities = abilities;
		this.craftingRecipe = craftingRecipe;
		Main.getInstance().getLogger().info("   -> Loaded an item with an id of '" + String.valueOf(this.uuid) + "' - named '" + this.name + "'.");
	}
	
	public SkyBlockItem(final Material material, final String name, final String description, final Rarity rarity, final Type type, final boolean stackable, final boolean oneTimeUse, final List<SBAbility> abilities, final CustomRecipe craftingRecipe) {
		this.noShow = false;
		this.material = material;
		this.name = name;
		this.description = description;
		this.rarity = rarity;
		this.type = type;
		this.stackable = stackable;
		this.uuid = ItemHelper.stringToUUID(material.name() + name + rarity.toString());
		this.oneTimeUse = oneTimeUse;
		this.abilities = abilities;
		this.craftingRecipe = craftingRecipe;
		Main.getInstance().getLogger().info("   -> Loaded an item with an id of '" + String.valueOf(this.uuid) + "' - named '" + this.name + "'.");
	}
	
	public boolean compare(final ItemStack other) {
		final int otherUUID = Integers.parseInt(ItemHelper.getNBTValue(other, "SbUUID"));
		return otherUUID == this.uuid;
	}
	
	public ItemStack createItem(final int amount) {
		ItemStack item = new ItemStack(this.material, amount);
		final ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatUtils.chat(this.rarity.getColour() + this.name));
		item.setItemMeta(meta);
		item = ItemHelper.setNBTValue(item, "SbUUID", String.valueOf(this.uuid));
		ItemHelper.loreItem(item, this.getLore(item));
		if(!this.stackable) {
			item = ItemHelper.setNBTValue(item, "UUID", java.util.UUID.randomUUID().toString());
		}
		return item;
	}
	
	protected List<String> getLore(final ItemStack item) {
		final List<String> lore = new ArrayList<String>();
		lore.addAll(ItemHelper.stringToLore(this.description, 35, ChatColor.GRAY));
		lore.add("");
        for (final SBAbility ability : this.abilities) {
            lore.addAll(ability.toLore(this.noShow));
            lore.add("");
        }
		if(this.oneTimeUse) {
			lore.add(ChatUtils.chat("&8(one time use)"));
		}
		if(!(this.rarity == Rarity.NONE)) {
			lore.add(ChatUtils.chat("" + this.rarity.getColor() + ChatColor.BOLD + this.rarity.toString() + " " + this.type));
		}
		return lore;
	}
	
	public void updateLore(final ItemStack i) {
		if(i == null) {
			return;
		}
		ItemHelper.loreItem(i, this.getLore(i));
	}
	
	public void onItemUse(final Player p, final ItemStack i) {
		if(this.oneTimeUse && p.getGameMode() != GameMode.CREATIVE) {
			destroy(i, 1);
		}
	}
	
	public static void destroy(final ItemStack i, final int num) {
		if(i.getAmount() <= num) {
			i.setAmount(0);
		} else {
			i.setAmount(i.getAmount() - num);
		}
	}
	
	public abstract boolean leftClickAction(final Player p0, final ItemStack p1);
	
	public abstract boolean rightClickAction(final Player p0, final ItemStack p1);
	
	public abstract boolean shiftLeftClickAction(final Player p0, final ItemStack p1);
	
	public abstract boolean shiftRightClickAction(final Player p0, final ItemStack p1);
	
	public abstract boolean middleClickAction(final Player p0, final ItemStack p1);
	
	public abstract boolean hitEntityAction(final Player p0, final EntityDamageByEntityEvent p1, final Entity p2, final ItemStack p3);
	
	public abstract boolean killEntityAction(final Player p0, final EntityDeathEvent p1, final Entity p2, final ItemStack p3);
	
	public abstract boolean breakBlockAction(final Player p0, final BlockBreakEvent p1, final Block p2, final ItemStack p3);
	
	public abstract boolean clickedInInventoryAction(final Player p0, final InventoryClickEvent p1, final ItemStack p2, final ItemStack p3);
	
	public abstract boolean activeEffect(final Player p0, final ItemStack p1);
	
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
	
	public Type getType() {
		return this.type;
	}
	
	public boolean isStackable() {
		return this.stackable;
	}
	
	public int getUUID() {
		return this.uuid;
	}
	
	public boolean hasCraftingRecipe() {
		return this.craftingRecipe != null;
	}
	
	public CustomRecipe getCraftingRecipe() {
		return this.craftingRecipe;
	}
	
	public void setCraftingRecipe(final CustomRecipe recipe) {
		this.craftingRecipe = recipe;
	}
}

package org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Epic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.core.util.Integers;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
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
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Utilities;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Types.Attribute;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Types.Stat;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Types.StatType;
import org.hypixelskyblockrecreation.simplyamazing.Items.CustomRecipe;
import org.hypixelskyblockrecreation.simplyamazing.Items.Rarity;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBAbility;
import org.hypixelskyblockrecreation.simplyamazing.Items.Type;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.SkyBlockItem;

public class emerald_blade extends SkyBlockItem {
	private int damage_bonus;

	public emerald_blade(Material material, String displayName, String description, Rarity rarity, Type type, boolean stackable, boolean oneTimeUse, List<SBAbility> abilities, CustomRecipe craftingRecipe) {
		super(material, "EMERALD_BLADE", displayName, description, rarity, type, stackable, oneTimeUse, abilities, Collections.singletonList(new Stat(StatType.DAMAGE, 130, false)), craftingRecipe);
		this.damage_bonus = 0;
	}
	
	@Override
	public ItemStack createItem(int amount) {
		ItemStack item = new ItemStack(this.material, amount);
		final ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatUtils.chat(this.rarity.getColour() + this.displayName));
		item.setItemMeta(meta);
		item = ItemHelper.applyExtraAttributes(this, item, this.sbName);
		item = ItemHelper.setNBTValueInCompound(item, "ExtraAttributes", "damage-bonus", String.valueOf(damage_bonus));
		ItemHelper.loreItem(item, this.getLore(item));
		if(!this.stackable) {
			item = ItemHelper.setNBTValueInCompound(item, "ExtraAttributes", "uuid", java.util.UUID.randomUUID().toString());
		}
		return item;
	}
	
	@Override
	protected List<String> getLore(ItemStack item) {
		final List<String> lore = new ArrayList<String>();
		for(final Attribute a : this.attributes) {
			lore.add(a.toLore());
		}
		if(!(this.attributes.isEmpty())) {
			lore.add("");
		}
		for(final Stat s : this.stats) {
			lore.add(s.toLore());
		}
		if(!(this.stats.isEmpty())) {
			lore.add("");
		}
		if(this.stats.isEmpty() && this.description.equals("") && !(this.abilities.isEmpty())) {
			lore.add("");
		}
		lore.addAll(ItemHelper.stringToLore(this.description, 35, ChatColor.GRAY));
		lore.add(ChatUtils.chat("&7Current Damage Bonus: &a" + String.valueOf(this.damage_bonus)));
		if(this.description != null && !(this.description.equals(""))) {
			lore.add("");
		}
        for (final SBAbility ability : this.abilities) {
            lore.addAll(ability.toLore(this.noShow));
            lore.add("");
        }
		if(this.oneTimeUse) {
			lore.add(ChatUtils.chat("&8(one time use)"));
		}
		if(!(this.rarity == Rarity.NONE)) {
			if(ItemHelper.isReforgable(this.type)) {
				lore.add(ChatUtils.chat("&8This item can be reforged!"));
			}
			lore.add(ChatUtils.chat("" + this.rarity.getColor() + ChatColor.BOLD + this.rarity.toString() + Type.toString(this.type)));
		}
		return lore;
	}

	@Override
	public boolean leftClickAction(Player p0, ItemStack p1) {
		return false;
	}

	@Override
	public boolean rightClickAction(Player p0, ItemStack p1) {
		return false;
	}

	@Override
	public boolean shiftLeftClickAction(Player p0, ItemStack p1) {
		return false;
	}

	@Override
	public boolean shiftRightClickAction(Player p0, ItemStack p1) {
		return false;
	}

	@Override
	public boolean middleClickAction(Player p0, ItemStack p1) {
		return false;
	}

	@Override
	public boolean hitEntityAction(Player p0, EntityDamageByEntityEvent p1, Entity p2, ItemStack p3) {
		return false;
	}

	@Override
	public boolean killEntityAction(Player p0, EntityDeathEvent p1, Entity p2, ItemStack p3) {
		return false;
	}

	@Override
	public boolean breakBlockAction(Player p0, BlockBreakEvent p1, Block p2, ItemStack p3) {
		return false;
	}

	@Override
	public boolean clickedInInventoryAction(Player p0, InventoryClickEvent p1, ItemStack p2, ItemStack p3) {
		return false;
	}

	@Override
	public boolean activeEffect(Player p0, ItemStack p1) {
		int coins = Utilities.getCoins(p0, "purse");
		double damage = Math.round(2.5 * Math.pow(10, (Math.log(coins) / Math.log(10000))));
		String value = ItemHelper.getNBTValueFromCompound(p1, "ExtraAttributes", "stats");
		List<String> unprocessed = new ArrayList<String>();
		if(value.contains(", ")) {
			for(String s : value.split(", ")) {
				unprocessed.add(s);
			}
		} else {
			unprocessed.add(value);
		}
		for(String s : unprocessed) {
			if(s.startsWith("damage")) {
				
			}
		}
		return false;
	}

}

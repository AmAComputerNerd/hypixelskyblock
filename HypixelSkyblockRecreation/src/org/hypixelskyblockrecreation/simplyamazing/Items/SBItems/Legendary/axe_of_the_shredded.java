package org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Legendary;

import java.util.Arrays;
import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ChatUtils;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ItemHelper;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Types.Stat;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Types.StatType;
import org.hypixelskyblockrecreation.simplyamazing.Items.CustomRecipe;
import org.hypixelskyblockrecreation.simplyamazing.Items.Rarity;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBAbility;
import org.hypixelskyblockrecreation.simplyamazing.Items.Type;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.SkyBlockItem;

public class axe_of_the_shredded extends SkyBlockItem {

	public axe_of_the_shredded(Material material, String name, String description, Rarity rarity, Type type, boolean stackable, boolean oneTimeUse, List<SBAbility> abilities, CustomRecipe craftingRecipe) {
		super(material, "AXE_OF_THE_SHREDDED", name, description, rarity, type, stackable, oneTimeUse, abilities, Arrays.asList(new Stat(StatType.DAMAGE, 140, false), new Stat(StatType.STRENGTH, 115, false)), craftingRecipe);
	}
	
	@Override
	public ItemStack createItem(final int amount) {
		ItemStack item = new ItemStack(this.material, amount);
		final ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatUtils.chat(this.rarity.getColour() + this.displayName));
		item.setItemMeta(meta);
		item = ItemHelper.applyExtraAttributes(this, item, this.sbName);
		ItemHelper.loreItem(item, this.getLore(item));
		if(!this.stackable) {
			item = ItemHelper.setNBTValueInCompound(item, "ExtraAttributes", "uuid", java.util.UUID.randomUUID().toString());
		}
		item = ItemHelper.setNBTValueInCompound(item, "ExtraAttributes", "EntityResistance", "Zombie-25%");
		return item;
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
		if(p2 instanceof Zombie) {
			p1.setDamage(p1.getDamage() * 2.25);
		}
		if(p0.getGameMode() == GameMode.SURVIVAL || p0.getGameMode() == GameMode.ADVENTURE) {
			if(p0.getHealth() + 3.0 > 20.0) {
				p0.setHealth(20.0);
				return true;
			}
			p0.setHealth(p0.getHealth() + 3.0);
		}
		return true;
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
		return false;
	}

}

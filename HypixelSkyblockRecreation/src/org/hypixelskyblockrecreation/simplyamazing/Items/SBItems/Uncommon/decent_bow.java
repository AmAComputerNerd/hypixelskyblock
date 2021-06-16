package org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Uncommon;

import java.util.Collections;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Types.Stat;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Types.StatType;
import org.hypixelskyblockrecreation.simplyamazing.Items.CustomRecipe;
import org.hypixelskyblockrecreation.simplyamazing.Items.Rarity;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBAbility;
import org.hypixelskyblockrecreation.simplyamazing.Items.Type;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.SkyBlockItem;

public class decent_bow extends SkyBlockItem {

	public decent_bow(Material material, String name, String description, Rarity rarity, Type type, boolean stackable, boolean oneTimeUse, List<SBAbility> abilities, CustomRecipe craftingRecipe) {
		super(material, "DECENT_BOW", name, description, rarity, type, stackable, oneTimeUse, abilities, Collections.singletonList(new Stat(StatType.DAMAGE, 45, false)), craftingRecipe);
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
		return false;
	}

}

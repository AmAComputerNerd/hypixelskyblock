package org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Epic;

import java.util.ArrayList;
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
import org.hypixelskyblockrecreation.simplyamazing.Items.CustomRecipe;
import org.hypixelskyblockrecreation.simplyamazing.Items.Rarity;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBAbility;
import org.hypixelskyblockrecreation.simplyamazing.Items.Type;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.SkyBlockItem;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Types.Stat;

public class cactus_knife extends SkyBlockItem {

	public cactus_knife(Material material, String name, String description, Rarity rarity, Type type, boolean stackable, boolean oneTimeUse, List<SBAbility> abilities, CustomRecipe craftingRecipe) {
		super(material, "CACTUS_KNIFE", name, description, rarity, type, stackable, oneTimeUse, abilities, new ArrayList<Stat>(), craftingRecipe);
	}

	@Override
	public boolean leftClickAction(Player p0, ItemStack p1) {
		if(p0.getTargetBlock(null, 5).getType() != Material.AIR) {
			Block b = p0.getTargetBlock(null, 5);
			if(b.getLocation().distance(p0.getLocation()) > 5.0) {
				return false;
			}
			if(b.getType() == Material.CACTUS) {
				b.breakNaturally();
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean rightClickAction(Player p0, ItemStack p1) {
		return false;
	}

	@Override
	public boolean shiftLeftClickAction(Player p0, ItemStack p1) {
		return leftClickAction(p0, p1);
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

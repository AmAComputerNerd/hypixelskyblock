package org.hypixelskyblockrecreation.simplyamazing.Items.SBItems;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.hypixelskyblockrecreation.simplyamazing.Main;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Inventories;
import org.hypixelskyblockrecreation.simplyamazing.Items.CustomRecipe;
import org.hypixelskyblockrecreation.simplyamazing.Items.Rarity;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBAbility;
import org.hypixelskyblockrecreation.simplyamazing.Items.SkyBlockItem;
import org.hypixelskyblockrecreation.simplyamazing.Items.Type;
import org.hypixelskyblockrecreation.simplyamazing.Menus.SBMenuGUI;

public class skyblock_menu extends SkyBlockItem {
	private boolean locked;

	public skyblock_menu(Material material, String name, String description, Rarity rarity, Type type, boolean stackable, boolean oneTimeUse, List<SBAbility> abilities, CustomRecipe craftingRecipe) {
		super(material, name, description, rarity, type, stackable, oneTimeUse, true, abilities, craftingRecipe);
	}
	
	public boolean isLocked() {
		return this.locked;
	}
	
	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	@Override
	public boolean leftClickAction(Player p0, ItemStack p1) {
		p0.openInventory(Inventories.build(SBMenuGUI.main.getTitle(), 6, SBMenuGUI.main.getInventoryFormat(p0)));
		return true;
	}

	@Override
	public boolean rightClickAction(Player p0, ItemStack p1) {
		p0.openInventory(Inventories.build(SBMenuGUI.main.getTitle(), 6, SBMenuGUI.main.getInventoryFormat(p0)));
		return true;
	}

	@Override
	public boolean shiftLeftClickAction(Player p0, ItemStack p1) {
		p0.openInventory(Inventories.build(SBMenuGUI.main.getTitle(), 6, SBMenuGUI.main.getInventoryFormat(p0)));
		return true;
	}

	@Override
	public boolean shiftRightClickAction(Player p0, ItemStack p1) {
		p0.openInventory(Inventories.build(SBMenuGUI.main.getTitle(), 6, SBMenuGUI.main.getInventoryFormat(p0)));
		return true;
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
	public boolean breakBlockAction(Player p0, BlockBreakEvent p1, Block p2, ItemStack p3) {
		return false;
	}

	@Override
	public boolean clickedInInventoryAction(Player p0, InventoryClickEvent p1, ItemStack p2, ItemStack p3) {
		if(p0.getInventory().containsAtLeast(Main.sbMenu, 2)) {
			p0.getInventory().remove(Main.sbMenu);
			return false;
		}
		p1.setCancelled(true);
		p0.getInventory().addItem(p3);
		p0.openInventory(Inventories.build(SBMenuGUI.main.getTitle(), 6, SBMenuGUI.main.getInventoryFormat(p0)));
		return true;
	}

	@Override
	public boolean activeEffect(Player p0, ItemStack p1) {
		return false;
	}

}

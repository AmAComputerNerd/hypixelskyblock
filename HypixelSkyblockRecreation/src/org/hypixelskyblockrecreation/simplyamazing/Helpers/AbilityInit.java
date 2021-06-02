package org.hypixelskyblockrecreation.simplyamazing.Helpers;

import org.apache.logging.log4j.core.util.Integers;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.hypixelskyblockrecreation.simplyamazing.Main;
import org.hypixelskyblockrecreation.simplyamazing.Items.SkyBlockItem;

public class AbilityInit implements Listener {
	
	private Main plugin;
	
	public AbilityInit(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler(priority=EventPriority.HIGH)
	public void onSBMenuDrop(PlayerDropItemEvent e) {
		ItemStack i = e.getItemDrop().getItemStack();
		if(i.equals(Main.sbMenu)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler(priority=EventPriority.HIGH)
	public void onClick(PlayerInteractEvent e) {
		ItemStack item = e.getPlayer().getInventory().getItemInMainHand();
		String s = ItemHelper.getNBTValue(item, "SbUUID");
		if(s == null) {
			return;
		}
		SkyBlockItem i = Main.getItemFromID(Integers.parseInt(s));
		if(e.getAction().equals(Action.LEFT_CLICK_AIR) || e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
			if(e.getPlayer().isSneaking()) {
				if(i.shiftLeftClickAction(e.getPlayer(), item)) {
					i.onItemUse(e.getPlayer(), item);
				}
				return;
			}
			if(i.leftClickAction(e.getPlayer(), item)) {
				i.onItemUse(e.getPlayer(), item);
			}
		} else if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if(e.getPlayer().isSneaking()) {
				if(i.shiftRightClickAction(e.getPlayer(), item)) {
					i.onItemUse(e.getPlayer(), item);
				}
				return;
			}
			if(i.rightClickAction(e.getPlayer(), item)) {
				i.onItemUse(e.getPlayer(), item);
			}
		} else {
			System.out.println("Event not successful! " + e.getAction());
		}
		return;
	}
	
	@EventHandler(priority=EventPriority.HIGH)
	public void onPlayerHit(EntityDamageByEntityEvent e) {
		if(e.getDamager().getType() != EntityType.PLAYER) {
			return;
		}
		Player p = (Player) e.getDamager();
		ItemStack item = p.getInventory().getItemInMainHand();
		String s = ItemHelper.getNBTValue(item, "SbUUID");
		if(s == null) {
			return;
		}
		SkyBlockItem i = Main.getItemFromID(Integers.parseInt(s));
		if(i.hitEntityAction(p, e, e.getEntity(), item)) {
			i.onItemUse(p, item);
		}
	}
	
	@EventHandler(priority=EventPriority.HIGH)
	public void onBlockBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		ItemStack item = p.getInventory().getItemInMainHand();
		String s = ItemHelper.getNBTValue(item, "SbUUID");
		if(s == null) {
			return;
		}
		SkyBlockItem i = Main.getItemFromID(Integers.parseInt(s));
		if(i.breakBlockAction(p, e, e.getBlock(), item)) {
			i.onItemUse(p, item);
		}
	}
	
	@EventHandler(priority=EventPriority.HIGH)
	public void onInventoryClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		ItemStack item = e.getCursor();
		String s = ItemHelper.getNBTValue(item, "SbUUID");
		if(s == null) {
			return;
		}
		SkyBlockItem i = Main.getItemFromID(Integers.parseInt(s));
		if(i.clickedInInventoryAction(p, e, e.getCurrentItem(), item)) {
			i.onItemUse(p, item);
		}
	}
}

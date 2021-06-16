package org.hypixelskyblockrecreation.simplyamazing.Listeners;

import java.util.HashMap;

import org.apache.logging.log4j.core.util.Integers;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;
import org.hypixelskyblockrecreation.simplyamazing.Main;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ItemHelper;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Utilities;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.SkyBlockItem;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Other.not_found;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Rare.ender_bow;

public class ItemAbilityListener implements Listener {
	public BukkitTask activeEffect;
	
	private Main plugin;
	
	public ItemAbilityListener(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
		activeEffect = Bukkit.getScheduler().runTaskTimer(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				for(Player p : Bukkit.getOnlinePlayers()) {
					ItemStack i = p.getInventory().getItemInMainHand();
					if(i == null) {
						continue;
					} else if(i.getType() == Material.AIR) {
						continue;
					}
					String sbID = ItemHelper.getNBTValueFromCompound(i, "ExtraAttributes", "id");
					if(sbID.equals("empty")) {
						continue;
					}
					
					if(!(Main.getItem(sbID.toLowerCase()) instanceof not_found)) {
						SkyBlockItem sbi = Main.getItem(sbID.toLowerCase());
						if(sbi.activeEffect(p, i)) {
							sbi.onItemUse(p, i);
						}
					}
				}
			}
		}, 40L, 10L);
	}
	
	@EventHandler(priority=EventPriority.HIGH)
	public void onSBMenuDrop(PlayerDropItemEvent e) {
		ItemStack i = e.getItemDrop().getItemStack();
		if(i.equals(Main.sbMenu)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler(priority=EventPriority.HIGH)
	public void onEnderBowPearlHit(ProjectileHitEvent e) {
		if(e.getEntity().getType() != EntityType.ENDER_PEARL) {
			return;
		}
		if(e.getEntity().getCustomName() != "EnderBowEnderpearl") {
			return;
		}
		Player p = (Player) e.getEntity().getShooter();
		ItemStack item = p.getInventory().getItemInMainHand();
		String s = ItemHelper.getNBTValue(item, "SbUUID");
		if(s == null) {
			return;
		}
		SkyBlockItem i = Main.getItem(s.toLowerCase());
		if(i.getDisplayName() != "Ender Bow") {
			return;
		}
		ender_bow bow = (ender_bow) i;
		if(bow.onEnderpearlLand(p, e, item)) {
			bow.onItemUse(p, item);
		}
	}
	
	@EventHandler(priority=EventPriority.HIGH)
	public void onClick(PlayerInteractEvent e) {
		if(e.getHand() == EquipmentSlot.OFF_HAND) {
			return;
		}
		ItemStack item = e.getPlayer().getInventory().getItemInMainHand();
		String s = ItemHelper.getNBTValueFromCompound(item, "ExtraAttributes", "id");
		if(s == null) {
			return;
		}
		SkyBlockItem i = Main.getItem(s.toLowerCase());
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
		}
		return;
	}
	
	@EventHandler(priority=EventPriority.HIGH)
	public void onEntityHitPlayer(EntityDamageByEntityEvent e) {
		if(e.getDamager().getType() == EntityType.PLAYER) {
			return;
		}
		Entity en = e.getDamager();
		Player p;
		try {
			p = (Player) e.getEntity();
		} catch(ClassCastException exc) {
			return;
		}
		ItemStack item = p.getInventory().getItemInMainHand();
		HashMap<EntityType, Integer> entities = ItemHelper.getItemEntityResistance(item);
		if(entities.isEmpty()) {
			Main.getInstance().getLogger().info("Entity list was empty");
			return;
		}
		if(!(entities.containsKey(en.getType()))) {
			Main.getInstance().getLogger().info("Entity list didn't contain the entity " + en.getType().name());
			return;
		}
		int percentage = entities.get(en.getType());
		if(percentage > 1) {
			Main.getInstance().getLogger().info("percentage was above 1. set to 1");
			percentage = 1;
		} else if(percentage < 0) {
			Main.getInstance().getLogger().info("percentage was below 0. set to 0");
			percentage = 0;
		}
		double points = p.getAttribute(Attribute.GENERIC_ARMOR).getValue();
		double toughness = p.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS).getValue();
		PotionEffect effect = p.getPotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
		int resistance = effect == null ? 0 : effect.getAmplifier();
		int epf = Utilities.getEPF(p.getInventory());
		Main.getInstance().getLogger().info("Damage dealt to player is " + Utilities.calculateDamageApplied(e.getDamage(), percentage, points, toughness, resistance, epf));
		
		e.setDamage(Utilities.calculateDamageApplied(e.getDamage(), percentage, points, toughness, resistance, epf));
	}
	
	@EventHandler(priority=EventPriority.HIGH)
	public void onPlayerHit(EntityDamageByEntityEvent e) {
		if(e.getDamager().getType() != EntityType.PLAYER) {
			return;
		}
		Player p = (Player) e.getDamager();
		ItemStack item = p.getInventory().getItemInMainHand();
		String s = ItemHelper.getNBTValueFromCompound(item, "ExtraAttributes", "id");
		if(s == null) {
			return;
		}
		SkyBlockItem i = Main.getItem(s.toLowerCase());
		if(i.hitEntityAction(p, e, e.getEntity(), item)) {
			i.onItemUse(p, item);
		}
	}
	
	@EventHandler
	public void onEntityDeath(EntityDeathEvent e) {
		if(e.getEntity().getType() == EntityType.PLAYER) {
			return;
		}
		Player p = (Player) e.getEntity().getKiller();
		if(p == null) {
			return;
		}
		ItemStack item = p.getInventory().getItemInMainHand();
		String s = ItemHelper.getNBTValueFromCompound(item, "ExtraAttributes", "id");
		if(s == null) {
			return;
		}
		SkyBlockItem i = Main.getItem(s.toLowerCase());
		if(i.killEntityAction(p, e, e.getEntity(), item)) {
			i.onItemUse(p, item);
		}
	}
	
	@EventHandler(priority=EventPriority.HIGH)
	public void onBlockBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		ItemStack item = p.getInventory().getItemInMainHand();
		String s = ItemHelper.getNBTValueFromCompound(item, "ExtraAttributes", "id");
		if(s == null) {
			return;
		}
		SkyBlockItem i = Main.getItem(s.toLowerCase());
		if(i.breakBlockAction(p, e, e.getBlock(), item)) {
			i.onItemUse(p, item);
		}
	}
	
	@EventHandler(priority=EventPriority.HIGH)
	public void onInventoryClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		ItemStack item = e.getCursor();
		String s = ItemHelper.getNBTValueFromCompound(item, "ExtraAttributes", "id");
		if(s == null) {
			return;
		}
		SkyBlockItem i = Main.getItem(s.toLowerCase());
		if(i.clickedInInventoryAction(p, e, e.getCurrentItem(), item)) {
			i.onItemUse(p, item);
		}
	}
}

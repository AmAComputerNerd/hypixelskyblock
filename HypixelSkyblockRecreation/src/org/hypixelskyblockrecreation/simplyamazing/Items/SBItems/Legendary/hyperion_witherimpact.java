package org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Legendary;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ChatUtils;
import org.hypixelskyblockrecreation.simplyamazing.Items.CustomRecipe;
import org.hypixelskyblockrecreation.simplyamazing.Items.Rarity;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBAbility;
import org.hypixelskyblockrecreation.simplyamazing.Items.SkyBlockItem;
import org.hypixelskyblockrecreation.simplyamazing.Items.Type;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class hyperion_witherimpact extends SkyBlockItem {

	public hyperion_witherimpact(Material material, String name, String description, Rarity rarity, Type type, boolean stackable, boolean oneTimeUse, List<SBAbility> abilities, CustomRecipe craftingRecipe) {
		// Abilities must be hidden so that we can make the custom Scroll Abilities text
		super(material, name, description, rarity, type, stackable, oneTimeUse, true, abilities, craftingRecipe);
	}
	
	private boolean teleport(Player p, Location l) {
        if(l.getBlock().getType().isSolid()) {
        	l.add(0, 1, 0);
        }
        p.teleport(l);
        p.playSound(p.getLocation(), Sound.ENTITY_ZOMBIE_VILLAGER_CURE, 1f, 1f);
        p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1f, 1f);
        p.spawnParticle(Particle.EXPLOSION_HUGE, p.getLocation(), 1);
		List<Entity> en = p.getNearbyEntities(5.0, 5.0, 5.0);
		for(Entity e : en) {
			if(e instanceof LivingEntity) {
				LivingEntity le = (LivingEntity) e;
				le.damage(10.0); // Static value, will change once stats are properly implemented
			}
		}
		if(p.hasPotionEffect(PotionEffectType.ABSORPTION)) {
			p.removePotionEffect(PotionEffectType.ABSORPTION);
		}
		p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 100, 5));
		p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatUtils.chat("&b-0 Mana (&6Wither Impact&b)")));
		return true;
	}

	@Override
	public boolean leftClickAction(Player p0, ItemStack p1) {
		return false;
	}

	@Override
	public boolean rightClickAction(Player p0, ItemStack p1) {
		Location l = p0.getLocation().clone();
        l.add(p0.getEyeLocation().getDirection().multiply(6));
        if(!(l.getBlock().isEmpty() || l.getBlock().isLiquid())) {
        	l = p0.getLocation().clone();
	        l.add(p0.getEyeLocation().getDirection().multiply(5));
	        if(!(l.getBlock().isEmpty() || l.getBlock().isLiquid())) {
	        	l = p0.getLocation().clone();
		        l.add(p0.getEyeLocation().getDirection().multiply(4));
		        if(!(l.getBlock().isEmpty() || l.getBlock().isLiquid())) {
		        	l = p0.getLocation().clone();
			        l.add(p0.getEyeLocation().getDirection().multiply(3));
			        if(!(l.getBlock().isEmpty() || l.getBlock().isLiquid())) {
			        	l = p0.getLocation().clone();
				        l.add(p0.getEyeLocation().getDirection().multiply(2));
				        if(!(l.getBlock().isEmpty() || l.getBlock().isLiquid())) {
				        	l = p0.getLocation().clone();
					        l.add(p0.getEyeLocation().getDirection().multiply(1));
					        if(!(l.getBlock().isEmpty() || l.getBlock().isLiquid())) {}
				        }
			        }
		        }
	        }
        }
        return teleport(p0, l);
	}

	@Override
	public boolean shiftLeftClickAction(Player p0, ItemStack p1) {
		return false;
	}

	@Override
	public boolean shiftRightClickAction(Player p0, ItemStack p1) {
		Location l = p0.getLocation();
		l.setPitch(p0.getLocation().getPitch());
		l.setYaw(p0.getLocation().getYaw());
		return teleport(p0, l);
	}

	@Override
	public boolean middleClickAction(Player p0, ItemStack p1) {
		return false;
	}

	@Override
	public boolean hitEntityAction(Player p0, EntityDamageByEntityEvent p1, Entity p2, ItemStack p3) {
		p1.setDamage(10);
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
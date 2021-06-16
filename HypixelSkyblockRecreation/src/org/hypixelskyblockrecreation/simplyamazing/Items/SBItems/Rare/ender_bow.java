package org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Rare;

import java.util.Collections;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ChatUtils;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Types.Stat;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Types.StatType;
import org.hypixelskyblockrecreation.simplyamazing.Items.CustomRecipe;
import org.hypixelskyblockrecreation.simplyamazing.Items.Rarity;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBAbility;
import org.hypixelskyblockrecreation.simplyamazing.Items.Type;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.SkyBlockItem;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class ender_bow extends SkyBlockItem {

	public ender_bow(Material material, String name, String description, Rarity rarity, Type type, boolean stackable, boolean oneTimeUse, List<SBAbility> abilities, CustomRecipe craftingRecipe) {
		super(material, "ENDER_BOW", name, description, rarity, type, stackable, oneTimeUse, abilities, Collections.singletonList(new Stat(StatType.DAMAGE, 60, false)), craftingRecipe);
	}
	
	private void shootEnderpearl(Player p) {
		EnderPearl thrown = p.launchProjectile(EnderPearl.class);
		Vector v = p.getEyeLocation().getDirection().multiply(2);
		thrown.setVelocity(v);
		thrown.setShooter(p);
		thrown.setGravity(true);
		
		thrown.setCustomName("EnderBowEnderpearl");
		p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatUtils.chat("&b-0 Mana (&6Ender Warp&b)")));
	}
	
	@SuppressWarnings("deprecation")
	public boolean onEnderpearlLand(Player p0, ProjectileHitEvent p1, ItemStack p2) {
		List<Entity> en = p0.getNearbyEntities(8.0, 4.0, 8.0);
		for(Entity e : en) {
			if(e instanceof LivingEntity) {
				LivingEntity le = (LivingEntity) e;
				le.damage(le.getMaxHealth() * 0.1); // Static value, will change once stats are properly implemented
			}
		}
		return true;
	}

	@Override
	public boolean leftClickAction(Player p0, ItemStack p1) {
		shootEnderpearl(p0);
		return true;
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

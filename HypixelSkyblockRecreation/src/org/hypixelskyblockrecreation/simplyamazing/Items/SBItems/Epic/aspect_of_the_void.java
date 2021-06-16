package org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Epic;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
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

public class aspect_of_the_void extends SkyBlockItem {
	
	public aspect_of_the_void(Material material, String name, String description, Rarity rarity, Type type, boolean stackable, boolean oneTimeUse, List<SBAbility> abilities, CustomRecipe craftingRecipe) {
		super(material, "ASPECT_OF_THE_VOID", name, description, rarity, type, stackable, oneTimeUse, abilities, Arrays.asList(new Stat(StatType.DAMAGE, 120, false), new Stat(StatType.STRENGTH, 100, false)), craftingRecipe);
	}
	
	private boolean teleport(Player p, Location l) {
		if(l.getBlock().getType().isSolid()) {
			p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_HURT, 1f, 1f);
			p.sendMessage(ChatUtils.chat("&cThere are blocks in the way!"));
			return false;
		}
        p.teleport(l);
        p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1f, 1f);
        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatUtils.chat("&b-0 Mana (&6Instant Transmission&b)")));
        return true;
	}

	@Override
	public boolean leftClickAction(Player p0, ItemStack p1) {
		return false;
	}

	@Override
	public boolean rightClickAction(Player p0, ItemStack p1) {
		Location l = p0.getEyeLocation().clone();
		l.add(p0.getEyeLocation().getDirection().multiply(1));
		if(l.getBlock().isEmpty() || l.getBlock().isLiquid() || !(l.getBlock().getType().equals(Material.LEAVES)) || !(l.getBlock().getType().equals(Material.LEAVES_2))) {
			l = p0.getEyeLocation().clone();
			l.add(p0.getEyeLocation().getDirection().multiply(2));
			if(l.getBlock().isEmpty() || l.getBlock().isLiquid() || !(l.getBlock().getType().equals(Material.LEAVES)) || !(l.getBlock().getType().equals(Material.LEAVES_2))) {
				l = p0.getEyeLocation().clone();
				l.add(p0.getEyeLocation().getDirection().multiply(3));
				if(l.getBlock().isEmpty() || l.getBlock().isLiquid() || !(l.getBlock().getType().equals(Material.LEAVES)) || !(l.getBlock().getType().equals(Material.LEAVES_2))) {
					l = p0.getEyeLocation().clone(); 
					l.add(p0.getEyeLocation().getDirection().multiply(4));
					 if(l.getBlock().isEmpty() || l.getBlock().isLiquid() || !(l.getBlock().getType().equals(Material.LEAVES)) || !(l.getBlock().getType().equals(Material.LEAVES_2))) {
						 l = p0.getEyeLocation().clone();
						 l.add(p0.getEyeLocation().getDirection().multiply(5));
						 if(l.getBlock().isEmpty() || l.getBlock().isLiquid() || !(l.getBlock().getType().equals(Material.LEAVES)) || !(l.getBlock().getType().equals(Material.LEAVES_2))) {
							 l = p0.getEyeLocation().clone();
							 l.add(p0.getEyeLocation().getDirection().multiply(6));
							 if(l.getBlock().isEmpty() || l.getBlock().isLiquid() || !(l.getBlock().getType().equals(Material.LEAVES)) || !(l.getBlock().getType().equals(Material.LEAVES_2))) {
								 l = p0.getEyeLocation().clone();
								 l.add(p0.getEyeLocation().getDirection().multiply(7));
								 if(l.getBlock().isEmpty() || l.getBlock().isLiquid() || !(l.getBlock().getType().equals(Material.LEAVES)) || !(l.getBlock().getType().equals(Material.LEAVES_2))) {
									 l = p0.getEyeLocation().clone();
									 l.add(p0.getEyeLocation().getDirection().multiply(8));
								 }
							 }
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
		return rightClickAction(p0, p1);
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

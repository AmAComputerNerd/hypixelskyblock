package org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Legendary;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
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

import net.minecraft.server.v1_12_R1.EnumParticle;
import net.minecraft.server.v1_12_R1.PacketPlayOutWorldParticles;

public class aspect_of_the_dragons extends SkyBlockItem {

	public aspect_of_the_dragons(Material material, String name, String description, Rarity rarity, Type type, boolean stackable, boolean oneTimeUse, List<SBAbility> abilities, CustomRecipe craftingRecipe) {
		super(material, "ASPECT_OF_THE_DRAGON", name, description, rarity, type, stackable, oneTimeUse, abilities, Arrays.asList(new Stat(StatType.DAMAGE, 225, false), new Stat(StatType.STRENGTH, 100, false)), craftingRecipe);
	}
	
	@SuppressWarnings("deprecation")
	private void triggerAbility(Player p) {
		Location loc = p.getLocation();
		List<Entity> entities = p.getNearbyEntities(1.0, 1.0, 1.0);
		p.playSound(loc, Sound.ENTITY_ENDERDRAGON_GROWL, 1f, 1f);
		for(Entity e : entities) {
			if(e instanceof LivingEntity) {
				LivingEntity le = (LivingEntity) e;
				le.damage(le.getMaxHealth() - (le.getMaxHealth() * 0.5));
			}
		}
		for(int i = 0; i < 100; ++i) {
            p.playEffect(p.getLocation().add(0.0D, 1.0D, 0.0D), Effect.FLAME, 1);
        }
//		int radius = 1;
//		for(double y = 0; y<= 0.5; y += 0.05) {
//			double x = radius * Math.cos(y);
//			double z = radius * Math.sin(y);
//			PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(EnumParticle.FLAME, true, (float)(loc.getX() + x), (float)(loc.getY() + y), (float)(loc.getZ() + z), 0, 0, 0, 0, 0);
//			((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
//		}
		return;
	}

	@Override
	public boolean leftClickAction(Player p0, ItemStack p1) {
		return false;
	}

	@Override
	public boolean rightClickAction(Player p0, ItemStack p1) {
		triggerAbility(p0);
		return true;
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

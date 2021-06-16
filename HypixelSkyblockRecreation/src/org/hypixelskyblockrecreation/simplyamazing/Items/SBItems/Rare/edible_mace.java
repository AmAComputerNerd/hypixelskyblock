package org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Rare;

import java.util.Arrays;
import java.util.List;

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
import org.hypixelskyblockrecreation.simplyamazing.Main;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ChatUtils;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ItemHelper;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Types.Stat;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Types.StatType;
import org.hypixelskyblockrecreation.simplyamazing.Items.CustomRecipe;
import org.hypixelskyblockrecreation.simplyamazing.Items.Rarity;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBAbility;
import org.hypixelskyblockrecreation.simplyamazing.Items.Type;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.SkyBlockItem;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class edible_mace extends SkyBlockItem {

	public edible_mace(Material material, String name, String description, Rarity rarity, Type type, boolean stackable, boolean oneTimeUse, List<SBAbility> abilities, CustomRecipe craftingRecipe) {
		super(material, "EDIBLE_MACE", name, description, rarity, type, stackable, oneTimeUse, abilities, Arrays.asList(new Stat(StatType.DAMAGE, 125, false), new Stat(StatType.STRENGTH, 25, false)), craftingRecipe);
	}

	@Override
	public boolean leftClickAction(Player p0, ItemStack p1) {
		return false;
	}

	@Override
	public boolean rightClickAction(Player p0, ItemStack p1) {
		if(ItemHelper.getNBTValue(p1, "AbilityActive") != null) {
			if(ItemHelper.getNBTValue(p1, "AbilityActive").equals("true")) {
				p0.playSound(p0.getLocation(), Sound.ENTITY_VILLAGER_AMBIENT, 1f, 1f);
				p0.sendMessage(ChatUtils.chat("&cThat ability is already active! Hit a mob with the &9Edible Mace &cto use it."));
				return false;
			}
			p0.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatUtils.chat("&b-0 Mana (&6ME SMASH HEAD&b)")));
			p1 = ItemHelper.removeNBTValue(p1, "AbilityActive");
			p1 = ItemHelper.setNBTValue(p1, "AbilityActive", "true");
			p0.getInventory().setItemInMainHand(p1);
			return true;
		}
		p0.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatUtils.chat("&b-0 Mana (&6ME SMASH HEAD&b)")));
		p1 = ItemHelper.setNBTValue(p1, "AbilityActive", "true");
		p0.getInventory().setItemInMainHand(p1);
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
		if(ItemHelper.getNBTValue(p3, "AbilityActive") != null) {
			if(ItemHelper.getNBTValue(p3, "AbilityActive").equals("true")) {
				p1.setDamage(p1.getDamage() * 2);
				p3 = ItemHelper.removeNBTValue(p3, "AbilityActive");
				p3 = ItemHelper.setNBTValue(p3, "AbilityActive", "false");
				p0.getInventory().setItemInMainHand(p3);
				return true;
			}
		}
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

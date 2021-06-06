package org.hypixelskyblockrecreation.simplyamazing.Helpers;

import java.util.ArrayList;
import java.util.Collections;

import org.bukkit.Material;
import org.hypixelskyblockrecreation.simplyamazing.Main;
import org.hypixelskyblockrecreation.simplyamazing.Items.AbilityType;
import org.hypixelskyblockrecreation.simplyamazing.Items.Rarity;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBAbility;
import org.hypixelskyblockrecreation.simplyamazing.Items.Type;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.skyblock_menu;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Common.aspect_of_the_jerry;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Epic.cactus_knife;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Epic.coco_chopper;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Epic.ember_rod;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Legendary.axe_of_the_shredded;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Legendary.hyperion;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Legendary.hyperion_implosion;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Legendary.hyperion_shadowwarp;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Legendary.hyperion_witherimpact;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Legendary.hyperion_withershield;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Rare.aspect_of_the_end;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Rare.aspect_of_the_end1;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Rare.ender_bow;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Uncommon.chicken_axe;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Uncommon.cleaver;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Uncommon.efficient_axe;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Uncommon.end_sword;

public class RegisterItems {
	
	public static void registerSkyBlockItems() {
		// Register Other items
		Main.putItem("skyblock_menu", new skyblock_menu(Material.NETHER_STAR, "&aSkyBlock Menu &7(Right Click)", "View all of your SkyBlock progress, including your Skills, Collections, Recipes and more! /n /n &eClick to open!", Rarity.NONE, Type.NONE, false, false, new ArrayList<SBAbility>(), null));
		// Register Common items
		Main.putItem("aspect_of_the_jerry", new aspect_of_the_jerry(Material.WOOD_SWORD, "Aspect of the Jerry", "", Rarity.COMMON, Type.SWORD, false, false, Collections.singletonList(new SBAbility("Parley", AbilityType.RIGHT_CLICK, "Channel your inner Jerry.")), null));
		// Register Uncommon items
		Main.putItem("chicken_axe", new chicken_axe(Material.WOOD_AXE, "Chicken Axe", "", Rarity.UNCOMMON, Type.AXE, false, false, Collections.singletonList(new SBAbility("Chicken Specialist", AbilityType.NONE, "Killing a Chicken increases its drops by 2.")), null));
		Main.putItem("cleaver", new cleaver(Material.GOLD_SWORD, "Cleaver", "", Rarity.UNCOMMON, Type.SWORD, false, false, Collections.singletonList(new SBAbility("Cleave", AbilityType.NONE, "When hitting an entity, monsters in a &a3&7 block radius will be hit for a portion of that damage too.")), null));
		Main.putItem("chicken_axe", new chicken_axe(Material.WOOD_AXE, "Cow Axe", "", Rarity.UNCOMMON, Type.AXE, false, false, Collections.singletonList(new SBAbility("Cow Specialist", AbilityType.NONE, "Killing a Cow increases its drops by 2.")), null));
		Main.putItem("efficient_axe", new efficient_axe(Material.IRON_AXE, "Efficient Axe", "Drops 5 Planks from chopping Logs.", Rarity.UNCOMMON, Type.AXE, false, false, new ArrayList<SBAbility>(), null));
		Main.putItem("end_sword", new end_sword(Material.DIAMOND_SWORD, "End Sword", "Deals &a+100% &7damage to Ender Dragons, Endermen and Endermites.", Rarity.UNCOMMON, Type.SWORD, false, false, new ArrayList<SBAbility>(), null));
		// Register Rare items
		Main.putItem("aspect_of_the_end", new aspect_of_the_end(Material.DIAMOND_SWORD, "Aspect of the End", "", Rarity.RARE, Type.SWORD, false, false, Collections.singletonList(new SBAbility("Instant Transmission", AbilityType.RIGHT_CLICK, "Teleport &a8 blocks &7ahead of you and gain &a+50 &f✦ Speed&7 for &a3 seconds&7.")), null));
		Main.putItem("aspect_of_the_end1", new aspect_of_the_end1(Material.DIAMOND_SWORD, "Aspect of the End 1", "", Rarity.RARE, Type.SWORD, false, false, Collections.singletonList(new SBAbility("Instant Transmission", AbilityType.RIGHT_CLICK, "Teleport &a8 blocks &7ahead of you and gain &a+50 &f✦ Speed&7 for &a3 seconds&7.")), null));
		Main.putItem("ender_bow", new ender_bow(Material.BOW, "Ender Bow", "", Rarity.RARE, Type.BOW, false, false, Collections.singletonList(new SBAbility("Ender Warp", AbilityType.LEFT_CLICK, "Shoots an Ender Pearl. Upon landing you deal damage to all Monsters in a &a8 &7block radius for &a10% &fof their &cHealth ❤&7.")), null));
		// Register Epic items
		Main.putItem("cactus_knife", new cactus_knife(Material.GOLD_HOE, "Cactus Knife", "Slices through &acactus &7instantly!", Rarity.EPIC, Type.HOE, false, false, new ArrayList<SBAbility>(), null));
		Main.putItem("coco_chopper", new coco_chopper(Material.GOLD_AXE, "Coco Chopper", "Increases cocoa bean drops by &e20% /n &7Cannot break trees.", Rarity.EPIC, Type.AXE, false, false, new ArrayList<SBAbility>(), null));
		Main.putItem("ember_rod", new ember_rod(Material.BLAZE_ROD, "Ember Rod", "", Rarity.EPIC, Type.SWORD, false, false, Collections.singletonList(new SBAbility("Fire Blast", AbilityType.RIGHT_CLICK, "Shoot 3 Fireballs which deal &c5 &7damage in rapid succession in front of you!")), null));
		// Register Legendary items
		Main.putItem("axe_of_the_shredded", new axe_of_the_shredded(Material.DIAMOND_AXE, "Axe of the Shredded", "&7Heal &c3❤ &7per hit. /n &7Deal &a+250% &7damage to Zombies. /n &7Receive &a25% &7less damage from Zombies when held.", Rarity.LEGENDARY, Type.SWORD, false, false, Collections.singletonList(new SBAbility("Throw", AbilityType.RIGHT_CLICK, "Throw your axe damaging all enemies in it's path dealing &c10% &7melee damage. Consecutive throws stack &c2x &7damage but cost &92x &7mana up to 16x.")), null));
		Main.putItem("hyperion", new hyperion(Material.IRON_SWORD, "Hyperion", "/n &7Deals &c+50% &7damage to Withers. Grants &c+1 ❁ Damage &7and &a+2 &b✎ Intelligence &7per &cCatacombs &7level. /n /n &7Your Catacombs Level: &c0", Rarity.LEGENDARY, Type.SWORD, false, false, new ArrayList<SBAbility>(), null));
		Main.putItem("hyperion_implosion", new hyperion_implosion(Material.IRON_SWORD, "Hyperion &7(I)", "/n &7Deals &c+50% &7damage to Withers. Grants &c+1 ❁ Damage &7and &a+2 &b✎ Intelligence &7per &cCatacombs &7level. /n /n &7Your Catacombs Level: &c0 /n /n &aScroll Abilities: /n &6Item Ability: Implosion /n &7Deals &c10 &7damage to nearby enemies. /n &8Cooldown: &a10s", Rarity.LEGENDARY, Type.SWORD, false, false, new ArrayList<SBAbility>(), null));
		Main.putItem("hyperion_shadowwarp", new hyperion_shadowwarp(Material.IRON_SWORD, "Hyperion &7(SW)", "/n &7Deals &c+50% &7damage to Withers. Grants &c+1 ❁ Damage &7and &a+2 &b✎ Intelligence &7per &cCatacombs &7level. /n /n &7Your Catacombs Level: &c0 /n /n &aScroll Abilities: /n &6Item Ability: Shadow Warp /n &7Creates a spacial distortion &a6 blocks &7ahead of you that sucks all enemies around it. Use this ability again within &e5&7 seconds to detonate the warp and deal damage to enemies near it.", Rarity.LEGENDARY, Type.SWORD, false, false, new ArrayList<SBAbility>(), null));
		Main.putItem("hyperion_witherimpact", new hyperion_witherimpact(Material.IRON_SWORD, "Hyperion &7(WI)", "/n &7Deals &c+50% &7damage to Withers. Grants &c+1 ❁ Damage &7and &a+2 &b✎ Intelligence &7per &cCatacombs &7level. /n /n &7Your Catacombs Level: &c0 /n /n &aScroll Abilities: /n &6Item Ability: Wither Impact &7Teleport &a6 blocks &7ahead of you. Then implode, dealing &c10 &7damage to nearby enemies. Also applies the wither shield scroll ability, reducing the damage taken and granting an absorption shield for &e5 &7seconds. /n &8Cooldown: &a10s", Rarity.LEGENDARY, Type.SWORD, false, false, new ArrayList<SBAbility>(), null));
		Main.putItem("hyperion_withershield", new hyperion_withershield(Material.IRON_SWORD, "Hyperion &7(WS)", "/n &7Deals &c+50% &7damage to Withers. Grants &c+1 ❁ Damage &7and &a+2 &b✎ Intelligence &7per &cCatacombs &7level. /n /n &7Your Catacombs Level: &c0 /n /n &aScroll Abilities: /n &6Item Ability: Wither Shield &7Reduces damage taken from enemies by &c30% &7for &e5 &7seconds. Also grants an absorption shield that gives &9200% &7of your Critical Damage as health. After &e5 &7seconds of healing &a50% &7of the shield is converted into healing&7. /n &8Cooldown: &a10s", Rarity.LEGENDARY, Type.SWORD, false, false, new ArrayList<SBAbility>(), null));
		// Register Mythic items
	}

}

package org.hypixelskyblockrecreation.simplyamazing.Helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.hypixelskyblockrecreation.simplyamazing.Main;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Types.Attribute;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Types.AttributeType;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Types.Stat;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Types.StatType;
import org.hypixelskyblockrecreation.simplyamazing.Items.AbilityType;
import org.hypixelskyblockrecreation.simplyamazing.Items.Rarity;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBAbility;
import org.hypixelskyblockrecreation.simplyamazing.Items.Type;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.SkyBlockMaterial;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Common.aspect_of_the_jerry;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Epic.aspect_of_the_void;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Epic.cactus_knife;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Epic.coco_chopper;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Epic.ember_rod;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Epic.emerald_blade;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Legendary.aspect_of_the_dragons;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Legendary.auger_rod;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Legendary.axe_of_the_shredded;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Legendary.daedalus_axe;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Legendary.hyperion;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Legendary.hyperion_implosion;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Legendary.hyperion_shadowwarp;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Legendary.hyperion_witherimpact;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Legendary.hyperion_withershield;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Other.skyblock_menu;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Other.vanilla_item;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Rare.aspect_of_the_end;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Rare.challenging_rod;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Rare.edible_mace;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Rare.ender_bow;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Uncommon.bandaged_mithril_pickaxe;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Uncommon.chicken_axe;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Uncommon.cleaver;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Uncommon.cow_axe;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Uncommon.decent_bow;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Uncommon.efficient_axe;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Uncommon.end_sword;

import com.meowj.langutils.lang.LanguageHelper;

public class RegisterItems {
	
	public static void registerSkyBlockItems() {
		// Register Other items
		Main.putItem("skyblock_menu", new skyblock_menu(Material.NETHER_STAR, "&aSkyBlock Menu &7(Right Click)", "View all of your SkyBlock progress, including your Skills, Collections, Recipes and more! /n /n &eClick to open!", Rarity.NONE, Type.NONE, false, false, new ArrayList<SBAbility>(), null));
		// Register Common items
		Main.putItem("aspect_of_the_jerry", new aspect_of_the_jerry(Material.WOOD_SWORD, "Aspect of the Jerry", "", Rarity.COMMON, Type.SWORD, false, false, Collections.singletonList(new SBAbility("Parley", AbilityType.RIGHT_CLICK, 5, "Channel your inner Jerry.")), null));
		// Register Uncommon items
		Main.putItem("bandaged_mithril_pickaxe", new bandaged_mithril_pickaxe(Material.STONE_PICKAXE, "Bandaged Mithril Pickaxe", "", Rarity.UNCOMMON, Type.PICKAXE, false, false, new ArrayList<SBAbility>(), Collections.singletonList(new Attribute(AttributeType.BREAKING_POWER, "5")), null));
		Main.putItem("chicken_axe", new chicken_axe(Material.WOOD_AXE, "Chicken Axe", "", Rarity.UNCOMMON, Type.AXE, false, false, Collections.singletonList(new SBAbility("Chicken Specialist", AbilityType.NONE, "Killing a Chicken increases its drops by 2.")), null));
		Main.putItem("cleaver", new cleaver(Material.GOLD_SWORD, "Cleaver", "", Rarity.UNCOMMON, Type.SWORD, false, false, Collections.singletonList(new SBAbility("Cleave", AbilityType.NONE, "When hitting an entity, monsters in a &a3&7 block radius will be hit for a portion of that damage too.")), null));
		Main.putItem("cow_axe", new cow_axe(Material.WOOD_AXE, "Cow Axe", "", Rarity.UNCOMMON, Type.AXE, false, false, Collections.singletonList(new SBAbility("Cow Specialist", AbilityType.NONE, "Killing a Cow increases its drops by 2.")), null));
		Main.putItem("decent_bow", new decent_bow(Material.BOW, "Decent Bow", "", Rarity.UNCOMMON, Type.BOW, false, false, new ArrayList<SBAbility>(), null));
		Main.putItem("efficient_axe", new efficient_axe(Material.IRON_AXE, "Efficient Axe", "Drops 5 Planks from chopping Logs.", Rarity.UNCOMMON, Type.AXE, false, false, new ArrayList<SBAbility>(), null));
		Main.putItem("end_sword", new end_sword(Material.DIAMOND_SWORD, "End Sword", "Deals &a+100% &7damage to Ender Dragons, Endermen and Endermites.", Rarity.UNCOMMON, Type.SWORD, false, false, new ArrayList<SBAbility>(), null));
		// Register Rare items
		Main.putItem("aspect_of_the_end", new aspect_of_the_end(Material.DIAMOND_SWORD, "Aspect of the End", "", Rarity.RARE, Type.SWORD, false, false, Collections.singletonList(new SBAbility("Instant Transmission", AbilityType.RIGHT_CLICK, "Teleport &a8 blocks &7ahead of you and gain &a+50 &f✦ Speed&7 for &a3 seconds&7.", 50)), null));
		Main.putItem("challenge_rod", new challenging_rod(Material.FISHING_ROD, "Challenging Rod", "Increases fishing speed by &950%", Rarity.RARE, Type.ROD, false, false, new ArrayList<SBAbility>(), null));
		Main.putItem("edible_mace", new edible_mace(Material.MUTTON, "Edible Mace", "", Rarity.RARE, Type.SWORD, false, false, Collections.singletonList(new SBAbility("ME SMASH HEAD", AbilityType.RIGHT_CLICK, "Your next attack deals &cdouble damage &7and weakens animals, making them deal &c-35% &7damage for &a30 &7seconds. /n &8Debuff doesn't stack")), null));
		Main.putItem("ender_bow", new ender_bow(Material.BOW, "Ender Bow", "", Rarity.RARE, Type.BOW, false, false, Collections.singletonList(new SBAbility("Ender Warp", AbilityType.LEFT_CLICK, 45, "Shoots an Ender Pearl. Upon landing you deal damage to all Monsters in a &a8 &7block radius for &a10% &fof their &cHealth ❤&7.", 50)), null));
		// Register Epic items
		Main.putItem("aspect_of_the_void", new aspect_of_the_void(Material.DIAMOND_SPADE, "Aspect of the Void", "", Rarity.EPIC, Type.SWORD, false, false, Collections.singletonList(new SBAbility("Instant Transmission", AbilityType.RIGHT_CLICK, "Teleport &a8 blocks &7ahead of you and gain &a+50 &f✦ Speed&7 for &a3 seconds&7.", 45)), null));
		Main.putItem("cactus_knife", new cactus_knife(Material.GOLD_HOE, "Cactus Knife", "Slices through &acactus &7instantly!", Rarity.EPIC, Type.HOE, false, false, new ArrayList<SBAbility>(), null));
		Main.putItem("coco_chopper", new coco_chopper(Material.GOLD_AXE, "Coco Chopper", "Increases cocoa bean drops by &e20% &7Cannot break trees.", Rarity.EPIC, Type.AXE, false, false, new ArrayList<SBAbility>(), null));
		Main.putItem("ember_rod", new ember_rod(Material.BLAZE_ROD, "Ember Rod", "", Rarity.EPIC, Type.SWORD, false, false, Collections.singletonList(new SBAbility("Fire Blast", AbilityType.RIGHT_CLICK, 30, "Shoot 3 Fireballs which deal &c5 &7damage in rapid succession in front of you!", 150)), null));
		Main.putItem("emerald_blade", new emerald_blade(Material.EMERALD, "Emerald Blade", "A powerful blade made from pure &2Emeralds&7. This blade becomes stronger as you carry more &6coins&7 in your purse. /n /n ", Rarity.EPIC, Type.SWORD, false, false, new ArrayList<SBAbility>(), null));
		// Register Legendary items
		Main.putItem("aspect_of_the_dragon", new aspect_of_the_dragons(Material.DIAMOND_SWORD, "Aspect of the Dragons", "", Rarity.LEGENDARY, Type.SWORD, false, false, Collections.singletonList(new SBAbility("Dragon Rage", AbilityType.RIGHT_CLICK, "All monsters in front of you take &a10 &7damage. Hit monsters take large knockback.", 100)), null));
		Main.putItem("auger_rod", new auger_rod(Material.FISHING_ROD, "Auger Rod", "Breaks nearby ice blocks where it lands. /n /n &7Triples the chance of the sea creatures that you spawn to be winter sea creatures. /n &7Increases fishing speed by &975%", Rarity.LEGENDARY, Type.ROD, false, false, new ArrayList<SBAbility>(), null));
		Main.putItem("axe_of_the_shredded", new axe_of_the_shredded(Material.DIAMOND_AXE, "Axe of the Shredded", "&7Heal &c50❤ &7per hit. /n &7Deal &a+250% &7damage to Zombies. &7Receive &a25% &7less damage from Zombies when held.", Rarity.LEGENDARY, Type.SWORD, false, false, Collections.singletonList(new SBAbility("Throw", AbilityType.RIGHT_CLICK, "Throw your axe damaging all enemies in it's path dealing &c10% &7melee damage. Consecutive throws stack &c2x &7damage but cost &92x &7mana up to 16x.", 20)), null));
		Main.putItem("daedalus_axe", new daedalus_axe(Material.GOLD_AXE, "Daedalus Axe", "&7Gains &c+4 damage &7per Taming level. /n &7Copies the stats from your active pet. /n /n &7Earn &6+35 coins &7from monster kills /n /n &7Deals &a+200% &7damage against mythological followers and Minos followers", Rarity.LEGENDARY, Type.SWORD, false, false, new ArrayList<SBAbility>(), null));
		Main.putItem("hyperion", new hyperion(Material.IRON_SWORD, "Hyperion", "&7Deals &c+50% &7damage to Withers. Grants &c+1 ❁ Damage &7and &a+2 &b✎ Intelligence &7per &cCatacombs &7level. /n /n &7Your Catacombs Level: &c0", Rarity.LEGENDARY, Type.SWORD, false, false, new ArrayList<SBAbility>(), null));
		Main.putItem("hyperion_implosion", new hyperion_implosion(Material.IRON_SWORD, "Hyperion &7(I)", "&7Deals &c+50% &7damage to Withers. Grants &c+1 ❁ Damage &7and &a+2 &b✎ Intelligence &7per &cCatacombs &7level. /n /n &7Your Catacombs Level: &c0 /n /n &aScroll Abilities: /n &6Item Ability: Implosion /n &7Deals &c10 &7damage to nearby enemies. /n &8Mana Cost: &3300 /n &8Cooldown: &a10s", Rarity.LEGENDARY, Type.SWORD, false, false, new ArrayList<SBAbility>(), null));
		Main.putItem("hyperion_shadowwarp", new hyperion_shadowwarp(Material.IRON_SWORD, "Hyperion &7(SW)", "&7Deals &c+50% &7damage to Withers. Grants &c+1 ❁ Damage &7and &a+2 &b✎ Intelligence &7per &cCatacombs &7level. /n /n &7Your Catacombs Level: &c0 /n /n &aScroll Abilities: /n &6Item Ability: Shadow Warp /n &7Creates a spacial distortion &a6 blocks &7ahead of you that sucks all enemies around it. Use this ability again within &e5&7 seconds to detonate the warp and deal damage to enemies near it. /n &8Mana Cost: &3300 /n &8Cooldown: &a10s", Rarity.LEGENDARY, Type.SWORD, false, false, new ArrayList<SBAbility>(), null));
		Main.putItem("hyperion_witherimpact", new hyperion_witherimpact(Material.IRON_SWORD, "Hyperion &7(WI)", "&7Deals &c+50% &7damage to Withers. Grants &c+1 ❁ Damage &7and &a+2 &b✎ Intelligence &7per &cCatacombs &7level. /n /n &7Your Catacombs Level: &c0 /n /n &aScroll Abilities: /n &6Item Ability: Wither Impact &7Teleport &a6 blocks &7ahead of you. Then implode, dealing &c10 &7damage to nearby enemies. Also applies the wither shield scroll ability, reducing the damage taken and granting an absorption shield for &e5 &7seconds. &8Mana Cost: &3300", Rarity.LEGENDARY, Type.SWORD, false, false, new ArrayList<SBAbility>(), null));
		Main.putItem("hyperion_withershield", new hyperion_withershield(Material.IRON_SWORD, "Hyperion &7(WS)", "&7Deals &c+50% &7damage to Withers. Grants &c+1 ❁ Damage &7and &a+2 &b✎ Intelligence &7per &cCatacombs &7level. /n /n &7Your Catacombs Level: &c0 /n /n &aScroll Abilities: /n &6Item Ability: Wither Shield &7Reduces damage taken from enemies by &c30% &7for &e5 &7seconds. Also grants an absorption shield that gives &9200% &7of your Critical Damage as health. After &e5 &7seconds of healing &a50% &7of the shield is converted into healing&7. /n &8Mana Cost: &3300 /n &8Cooldown: &a10s", Rarity.LEGENDARY, Type.SWORD, false, false, new ArrayList<SBAbility>(), null));
		// Register Mythic items
		// Register Vanilla items
		registerVanillaItems();
	}
	
	private static void registerVanillaItems() {
		Main.getInstance().getLogger().info(" > Attempting to load all vanilla items!");
		Utilities.setItemCreationDebug(false);
		List<Material> valid = Arrays.asList(Material.WOOD_SWORD, Material.STONE_SWORD, Material.IRON_SWORD, Material.GOLD_SWORD, Material.DIAMOND_SWORD, Material.WOOD_PICKAXE, Material.STONE_PICKAXE, Material.IRON_PICKAXE, Material.GOLD_PICKAXE, Material.DIAMOND_PICKAXE, Material.WOOD_AXE, Material.STONE_AXE, Material.IRON_AXE, Material.GOLD_AXE, Material.DIAMOND_AXE, Material.WOOD_SPADE, Material.STONE_SPADE, Material.IRON_SPADE, Material.GOLD_SPADE, Material.DIAMOND_SPADE, Material.WOOD_HOE, Material.STONE_HOE, Material.IRON_HOE, Material.GOLD_HOE, Material.DIAMOND_HOE, Material.LEATHER_HELMET, Material.CHAINMAIL_HELMET, Material.IRON_HELMET, Material.GOLD_HELMET, Material.DIAMOND_HELMET, Material.LEATHER_CHESTPLATE, Material.CHAINMAIL_CHESTPLATE, Material.IRON_CHESTPLATE, Material.GOLD_CHESTPLATE, Material.DIAMOND_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.CHAINMAIL_LEGGINGS, Material.IRON_LEGGINGS, Material.GOLD_LEGGINGS, Material.DIAMOND_LEGGINGS, Material.LEATHER_BOOTS, Material.CHAINMAIL_BOOTS, Material.IRON_BOOTS, Material.GOLD_BOOTS, Material.DIAMOND_BOOTS, Material.FISHING_ROD, Material.SHIELD);
		for(Material m : Material.values()) {
			if(valid.contains(m)) {
				continue;
			}
			if(m == Material.AIR || m == Material.MONSTER_EGG || m == Material.MONSTER_EGGS) {
				continue;
			}
			if(m.isItem()) {
				Main.putMaterial(LanguageHelper.getItemName(new ItemStack(m), "en_us").toLowerCase().replace(" ", "_"), new SkyBlockMaterial(m, LanguageHelper.getItemName(new ItemStack(m), "en_us"), "", ItemHelper.determineRarity(m), true, false, true, null));
			}
		}
		registerVanillaTools();
		Utilities.setItemCreationDebug(true);
		Main.getInstance().getLogger().info(" > Vanilla item loading complete!");
	}
	
	private static void registerVanillaTools() {
		Main.getInstance().getLogger().info(" > Attempting to load all vanilla tools!");
		List<Material> valid = Arrays.asList(Material.WOOD_SWORD, Material.STONE_SWORD, Material.IRON_SWORD, Material.GOLD_SWORD, Material.DIAMOND_SWORD, Material.WOOD_PICKAXE, Material.STONE_PICKAXE, Material.IRON_PICKAXE, Material.GOLD_PICKAXE, Material.DIAMOND_PICKAXE, Material.WOOD_AXE, Material.STONE_AXE, Material.IRON_AXE, Material.GOLD_AXE, Material.DIAMOND_AXE, Material.WOOD_SPADE, Material.STONE_SPADE, Material.IRON_SPADE, Material.GOLD_SPADE, Material.DIAMOND_SPADE, Material.WOOD_HOE, Material.STONE_HOE, Material.IRON_HOE, Material.GOLD_HOE, Material.DIAMOND_HOE, Material.LEATHER_HELMET, Material.CHAINMAIL_HELMET, Material.IRON_HELMET, Material.GOLD_HELMET, Material.DIAMOND_HELMET, Material.LEATHER_CHESTPLATE, Material.CHAINMAIL_CHESTPLATE, Material.IRON_CHESTPLATE, Material.GOLD_CHESTPLATE, Material.DIAMOND_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.CHAINMAIL_LEGGINGS, Material.IRON_LEGGINGS, Material.GOLD_LEGGINGS, Material.DIAMOND_LEGGINGS, Material.LEATHER_BOOTS, Material.CHAINMAIL_BOOTS, Material.IRON_BOOTS, Material.GOLD_BOOTS, Material.DIAMOND_BOOTS, Material.FISHING_ROD, Material.SHIELD);
		Stat stat;
		for(Material m : valid) {
			stat = null;
			if(ItemHelper.determineType(m) == Type.SWORD) {
				switch(m) {
					case WOOD_SWORD:
						stat = new Stat(StatType.DAMAGE, 20, false);
						break;
					case STONE_SWORD:
						stat = new Stat(StatType.DAMAGE, 25, false);
						break;
					case IRON_SWORD:
						stat = new Stat(StatType.DAMAGE, 30, false);
						break;
					case GOLD_SWORD:
						stat = new Stat(StatType.DAMAGE, 20, false);
						break;
					case DIAMOND_SWORD:
						stat = new Stat(StatType.DAMAGE, 35, false);
						break;
					default:
						break;
				}
			} else if(ItemHelper.determineType(m) == Type.PICKAXE) {
				switch(m) {
					case WOOD_PICKAXE:
						Main.putItem(LanguageHelper.getItemName(new ItemStack(m), "en_us").toLowerCase().replace(" ", "_"), new vanilla_item(m, LanguageHelper.getItemName(new ItemStack(m), "en_us").toLowerCase().replace(" ", "_"), LanguageHelper.getItemName(new ItemStack(m), "en_us"), "", Rarity.COMMON, Type.PICKAXE, false, false, new ArrayList<SBAbility>(), Arrays.asList(new Stat(StatType.DAMAGE, 15, false), new Stat(StatType.MINING_SPEED, 70, false)), Collections.singletonList(new Attribute(AttributeType.BREAKING_POWER, "1")), null));
						continue;
					case STONE_PICKAXE:
						Main.putItem(LanguageHelper.getItemName(new ItemStack(m), "en_us").toLowerCase().replace(" ", "_"), new vanilla_item(m, LanguageHelper.getItemName(new ItemStack(m), "en_us").toLowerCase().replace(" ", "_"), LanguageHelper.getItemName(new ItemStack(m), "en_us"), "", Rarity.COMMON, Type.PICKAXE, false, false, new ArrayList<SBAbility>(), Arrays.asList(new Stat(StatType.DAMAGE, 20, false), new Stat(StatType.MINING_SPEED, 110, false)), Collections.singletonList(new Attribute(AttributeType.BREAKING_POWER, "2")), null));
						continue;
					case IRON_PICKAXE:
						Main.putItem(LanguageHelper.getItemName(new ItemStack(m), "en_us").toLowerCase().replace(" ", "_"), new vanilla_item(m, LanguageHelper.getItemName(new ItemStack(m), "en_us").toLowerCase().replace(" ", "_"), LanguageHelper.getItemName(new ItemStack(m), "en_us"), "", Rarity.COMMON, Type.PICKAXE, false, false, new ArrayList<SBAbility>(), Arrays.asList(new Stat(StatType.DAMAGE, 25, false), new Stat(StatType.MINING_SPEED, 160, false)), Collections.singletonList(new Attribute(AttributeType.BREAKING_POWER, "3")), null));
						continue;
					case GOLD_PICKAXE:
						Main.putItem(LanguageHelper.getItemName(new ItemStack(m), "en_us").toLowerCase().replace(" ", "_"), new vanilla_item(m, LanguageHelper.getItemName(new ItemStack(m), "en_us").toLowerCase().replace(" ", "_"), LanguageHelper.getItemName(new ItemStack(m), "en_us"), "", Rarity.COMMON, Type.PICKAXE, false, false, new ArrayList<SBAbility>(), Arrays.asList(new Stat(StatType.DAMAGE, 15, false), new Stat(StatType.MINING_SPEED, 250, false)), Collections.singletonList(new Attribute(AttributeType.BREAKING_POWER, "1")), null));
						continue;
					case DIAMOND_PICKAXE:
						Main.putItem(LanguageHelper.getItemName(new ItemStack(m), "en_us").toLowerCase().replace(" ", "_"), new vanilla_item(m, LanguageHelper.getItemName(new ItemStack(m), "en_us").toLowerCase().replace(" ", "_"), LanguageHelper.getItemName(new ItemStack(m), "en_us"), "", Rarity.UNCOMMON, Type.PICKAXE, false, false, new ArrayList<SBAbility>(), Arrays.asList(new Stat(StatType.DAMAGE, 30, false), new Stat(StatType.MINING_SPEED, 230, false)), Collections.singletonList(new Attribute(AttributeType.BREAKING_POWER, "4")), null));
						continue;
					default:
						break;
				}
			} else if(ItemHelper.determineType(m) == Type.AXE) {
				switch(m) {
					case WOOD_AXE:
						stat = new Stat(StatType.DAMAGE, 10, false);
						break;
					case STONE_AXE:
						stat = new Stat(StatType.DAMAGE, 15, false);
						break;
					case IRON_AXE:
						stat = new Stat(StatType.DAMAGE, 25, false);
						break;
					case GOLD_AXE:
						stat = new Stat(StatType.DAMAGE, 20, false);
						break;
					case DIAMOND_AXE:
						stat = new Stat(StatType.DAMAGE, 30, false);
						break;
					default:
						break;
				}
			} else if(ItemHelper.determineType(m) == Type.SHOVEL) {
				switch(m) {
					case WOOD_SPADE:
						stat = new Stat(StatType.DAMAGE, 15, false);
						break;
					case STONE_SPADE:
						stat = new Stat(StatType.DAMAGE, 20, false);
						break;
					case IRON_SPADE:
						stat = new Stat(StatType.DAMAGE, 25, false);
						break;
					case GOLD_SPADE:
						stat = new Stat(StatType.DAMAGE, 15, false);
						break;
					case DIAMOND_SPADE:
						stat = new Stat(StatType.DAMAGE, 30, false);
						break;
					default:
						break;
				}
			} else if(m == Material.BOW) {
				stat = new Stat(StatType.DAMAGE, 30, false);
			} else if(m == Material.FISHING_ROD) {
				Main.putItem(LanguageHelper.getItemName(new ItemStack(m), "en_us").toLowerCase().replace(" ", "_"), new vanilla_item(m, LanguageHelper.getItemName(new ItemStack(m), "en_us").toLowerCase().replace(" ", "_"), LanguageHelper.getItemName(new ItemStack(m), "en_us"), "", ItemHelper.determineRarity(m), ItemHelper.determineType(m), false, false, new ArrayList<SBAbility>(), Arrays.asList(new Stat(StatType.DAMAGE, 10, false), new Stat(StatType.STRENGTH, 5, false)), new ArrayList<Attribute>(), null));
				continue;
			} else if(m == Material.SHIELD || m == Material.BANNER) {
				Main.putItem(LanguageHelper.getItemName(new ItemStack(m), "en_us").toLowerCase().replace(" ", "_"), new vanilla_item(m, LanguageHelper.getItemName(new ItemStack(m), "en_us").toLowerCase().replace(" ", "_"), LanguageHelper.getItemName(new ItemStack(m), "en_us"), "", ItemHelper.determineRarity(m), ItemHelper.determineType(m), false, false, new ArrayList<SBAbility>(), Arrays.asList(new Stat(StatType.DEFENSE, 100, false), new Stat(StatType.TRUE_DEFENSE, 5, false)), new ArrayList<Attribute>(), null));
				continue;
			}
			
			if(stat == null) {
				Main.putItem(LanguageHelper.getItemName(new ItemStack(m), "en_us").toLowerCase().replace(" ", "_"), new vanilla_item(m, LanguageHelper.getItemName(new ItemStack(m), "en_us").toLowerCase().replace(" ", "_"), LanguageHelper.getItemName(new ItemStack(m), "en_us"), "", ItemHelper.determineRarity(m), ItemHelper.determineType(m), false, false, new ArrayList<SBAbility>(), new ArrayList<Stat>(), new ArrayList<Attribute>(), null));
			} else {
				Main.putItem(LanguageHelper.getItemName(new ItemStack(m), "en_us").toLowerCase().replace(" ", "_"), new vanilla_item(m, LanguageHelper.getItemName(new ItemStack(m), "en_us").toLowerCase().replace(" ", "_"), LanguageHelper.getItemName(new ItemStack(m), "en_us"), "", ItemHelper.determineRarity(m), ItemHelper.determineType(m), false, false, new ArrayList<SBAbility>(), Collections.singletonList(stat), new ArrayList<Attribute>(), null));
			}
		}
	}

}

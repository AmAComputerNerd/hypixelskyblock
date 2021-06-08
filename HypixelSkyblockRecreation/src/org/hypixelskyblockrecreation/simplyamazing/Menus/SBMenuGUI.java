package org.hypixelskyblockrecreation.simplyamazing.Menus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

import org.apache.logging.log4j.core.util.Integers;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.material.SpawnEgg;
import org.hypixelskyblockrecreation.simplyamazing.Main;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ChatUtils;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Inventories;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.SkullHelper;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Utilities;

public class SBMenuGUI {
	private static Main plugin;
		
	public SBMenuGUI(Main plugin) {
		this.plugin = plugin;
	}
	
	/*   SKILL SYMBOLS
	 * Damage: &c❁
	 * Health: &c❤
	 * Defense: &a❈
	 * Strength: &c❁
	 * Speed: &f✦
	 * Crit Chance: &9☣
	 * Crit Damage: &9☠
	 * Intelligence: &b✎
	 * Mining Speed: &6⸕
	 * Sea Creature Chance: &3α
	 * Magic Find: &b✯
	 * Pet Luck: &d♣
	 * True Defense: &f❂
	 * Ferocity: &c⫽
	 * Ability Damage: &c๑
	 * Mining Fortune: &6☘
	 * Farming Fortune: &6☘
	 * Foraging Fortune: &6☘
	*/
	
	public static class main {
		public static String getTitle() {
			return "SkyBlock Menu";
		}
		
		private static HashMap<ItemStack, String> drawInventory(HashMap<ItemStack, String> inv, Player p) {
			// Create the player head
			ItemStack skyblockProfile = Inventories.buildItem(SkullHelper.getSkullFromUUID(p.getUniqueId()), "&aYour SkyBlock Profile", ChatUtils.chat(new ArrayList<String>(Arrays.asList(" &c❤ Health &f100 HP", " &a❈ Defence &f0", " &c❁ &cStrength &f0", " &f✦ Speed 100", " &9☣ Crit Chance &f20%", " &9☠ Crit Damage &f0%", " &b✎ Intelligence &f100", " &6⸕ Mining Speed &f0", " &3α Sea Creature Chance &f0%", " &b✯ Magic Find &f0", " &d♣ Pet Luck &f0", " &f❂ True Defence 0", " &c⫽ Ferocity &f0", " &c๑ Ability Damage &f0", " &6☘ Mining Fortune &f0", " &6☘ Farming Fortune &f0", " &6☘ Foraging Fortune &f0", "", "&eClick to view your profile!"))));
			inv.put(skyblockProfile, "13");
			// Create the skills button
			ItemStack skills = Inventories.buildItem(Material.DIAMOND_SWORD, 1, "&aYour Skills", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7View your Skill progression and", "&7rewards.", "", "&60 Skill Avg. &8(non-cosmetic)", "", "&eClick to show skills!"))));
			inv.put(skills, "19");
			// Create the collection button
			ItemStack collection = Inventories.buildItem(Material.ITEM_FRAME, 1, "&aCollection", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7View all of the items available", "&7in SkyBlock. Collect more of an", "&7item to unlock rewards on your", "&7way to becoming a master of", "&7SkyBlock!", "", "&7Collection Maxed Out: &e0.0&6%", "&f-------------------- &e0&6/&e60", "", "&eClick to view!"))));
			inv.put(collection, "20");
			// Create the recipe book button
			ItemStack recipeBook = Inventories.buildItem(Material.BOOK, 1, "&aRecipe Book", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Through your adventure, you will", "&7unlock recipes for all kinds of", "&7special items! You can view how", "&7to craft these items here.", "", "&7Recipe Book Unlocked: &e0.0&6%", "&f-------------------- &e0&6/&e719", "", "&eClick to view!"))));
			inv.put(recipeBook, "21");
			// Create the trades button
			ItemStack trades = Inventories.buildItem(Material.EMERALD, 1, "&aTrades", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7View your available trades.", "&7These trades are always", "&7available and accessible through", "&7the SkyBlock Menu.", "", "&7Trades Unlocked: &e0.0&6%", "&f-------------------- &e0&6/&e26", "", "&eClick to view!"))));
			inv.put(trades, "22");
			// Create the quest log button
			ItemStack questLog = Inventories.buildItem(Material.BOOK_AND_QUILL, 1, "&aQuest Log", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7View your active quests,", "&7progress, and rewards.", "", "&eClick to view!"))));
			inv.put(questLog, "23");
			// Create the calendar button
			ItemStack calendarEvents = Inventories.buildItem(Material.WATCH, 1, "&aCalendar and Events", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7View the SkyBlock calendar,", "&7upcoming events, and event", "&7rewards!", "", "&eClick to view!"))));
			inv.put(calendarEvents, "24");
			// Create the storage button
			ItemStack storage = Inventories.buildItem(Material.CHEST, 1, "&aStorage", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Store global items that you", "&7want to access at any time", "&7from anywhere here.", "", "&eClick to view!"))));
			inv.put(storage, "25");
			// Create the active effects button
			ItemStack activeEffects = Inventories.buildItem(Material.POTION, 1, "&aActive Effects", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7View and manage all of your", "&7active potion effects.", "", "&7Drink Potions or splash them", "&7on the ground to buff yourself!", "", "&7Currently Active: &e0", "", "&eClick to view!"))));
			inv.put(activeEffects, "29");
			// Create the pets button
			ItemStack pets = Inventories.buildItem(Material.BONE, 1, "&aPets", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7View and manage all of your", "&7Pets.", "", "&7Level up your pets faster by", "&7gaining xp in their favourite", "&7skill!", "", "&7Selected pet: &cNone", "", "&eClick to view!"))));
			inv.put(pets, "30");
			// Create the crafting table button
			ItemStack craftingTable = Inventories.buildItem(Material.WORKBENCH, 1, "&aCrafting Table", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Opens the crafting grid.", "", "&eClick to view!"))));
			inv.put(craftingTable, "31");
			// Create the wardrobe button
			ItemStack wardrobe = Inventories.buildItem(Material.LEATHER_CHESTPLATE, 1, "&aWardrobe", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Store armor sets and quickly", "&7swap between them.", "", "&eClick to open!"))));
			LeatherArmorMeta wMeta = (LeatherArmorMeta) wardrobe.getItemMeta();
			wMeta.setColor(Color.fromRGB(127, 63, 178));
			wardrobe.setItemMeta(wMeta);
			inv.put(wardrobe, "32");
			// Create the personal bank item
			ItemStack personalBankSkull = SkullHelper.getSkullFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTM2ZTk0ZjZjMzRhMzU0NjVmY2U0YTkwZjJlMjU5NzYzODllYjk3MDlhMTIyNzM1NzRmZjcwZmQ0ZGFhNjg1MiJ9fX0=");
			ItemStack personalBank = Inventories.buildItem(personalBankSkull, "&aPersonal Bank", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Contact your Banker from", "&7anywhere.", "&7Cooldown: &e1 hour", "", "&7Banker Status:", "&aAvailable", "", "&eClick to open!"))));
			inv.put(personalBank, "33");
			// Create the fishing bag button
			ItemStack fishingBagSkull = SkullHelper.getSkullFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWI4ZTI5N2RmNmI4ZGZmY2YxMzVkYmE4NGVjNzkyZDQyMGFkOGVjYjQ1OGQxNDQyODg1NzJhODQ2MDNiMTYzMSJ9fX0=");
			ItemStack fishingBag = Inventories.buildItem(fishingBagSkull, "&aFishing Bag", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7A useful bag which can hold all", "&7types of fish, baits, and fishing", "&7loot!", "", "&eClick to open!"))));
			inv.put(fishingBag, "43");
			// Create the quiver button
			ItemStack quiverSkull = SkullHelper.getSkullFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGNiM2FjZGMxMWNhNzQ3YmY3MTBlNTlmNGM4ZTliM2Q5NDlmZGQzNjRjNjg2OTgzMWNhODc4ZjA3NjNkMTc4NyJ9fX0=");
			ItemStack quiver = Inventories.buildItem(quiverSkull, "&aQuiver", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7A masterfully crafted Quiver", "&7which holds any kind of", "&7projectile you can think of!", "", "&eClick to open!"))));
			inv.put(quiver, "44");
			// Create the fast travel button
			ItemStack fastTravelSkull = SkullHelper.getSkullFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzljODg4MWU0MjkxNWE5ZDI5YmI2MWExNmZiMjZkMDU5OTEzMjA0ZDI2NWRmNWI0MzliM2Q3OTJhY2Q1NiJ9fX0=");
			ItemStack fastTravel = Inventories.buildItem(fastTravelSkull, "&aFast Travel", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Teleport to islands you've", "&7already visited.", "", "&bRight-click for hub warp!", "&eClick to pick location!"))));
			inv.put(fastTravel, "47");
			// Create the profile management button
			ItemStack profileManagement = Inventories.buildItem(Material.NAME_TAG, 1, "&aProfile Management", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Teleport to islands you've", "&7already visited.", "", "&bRight-click for hub warp!", "&eClick to pick location!"))));
			inv.put(profileManagement, "48");
			// Create the booster cookie button
			ItemStack boosterCookies = Inventories.buildItem(Material.COOKIE, 1, "&6Booster Cookie", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Obtain the &dCookie Buff", "&7from booster cookies in the", "&7hub's community shop.", "", "&7Duration: &a1d 22h 7m 20s", "&7Bits Available: &b16,255", "", "&eClick to get all the info!"))));
			inv.put(boosterCookies, "49");
			// Create the settings button
			ItemStack settings = Inventories.buildItem(Material.REDSTONE_TORCH_ON, 1, "&aSettings", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7View and edit your SkyBlock", "&7settings.", "", "&eClick to view!"))));
			inv.put(settings, "50");
			// Create the sack of sacks button... nope
			ItemStack sackOfSacksSkull = SkullHelper.getSkullFromBase64("ewogICJ0aW1lc3RhbXAiIDogMTU5MTMxMDU4NTYwOSwKICAicHJvZmlsZUlkIiA6ICI0MWQzYWJjMmQ3NDk0MDBjOTA5MGQ1NDM0ZDAzODMxYiIsCiAgInByb2ZpbGVOYW1lIiA6ICJNZWdha2xvb24iLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODBhMDc3ZTI0OGQxNDI3NzJlYTgwMDg2NGY4YzU3OGI5ZDM2ODg1YjI5ZGFmODM2YjY0YTcwNjg4MmI2ZWMxMCIKICAgIH0KICB9Cn0=");
			ItemStack sackOfSacks = Inventories.buildItem(sackOfSacksSkull, "&aSack of Sacks", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7A sack which contains other", "&7sacks. Sackception!", "", "&eClick to open!"))));
			inv.put(sackOfSacks, "51");
			// Create the potion bag button
			ItemStack potionBagSkull = SkullHelper.getSkullFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWY4YjgyNDI3YjI2MGQwYTYxZTY0ODNmYzNiMmMzNWE1ODU4NTFlMDhhOWE5ZGYzNzI1NDhiNDE2OGNjODE3YyJ9fX0=");
			ItemStack potionBag = Inventories.buildItem(potionBagSkull, "&aPotion Bag", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7A handy bag for holding your", "&7Potions in.", "", "&eClick to open!"))));
			inv.put(potionBag, "52");
			// Create the accessory bag button
			ItemStack accessoryBagSkull = SkullHelper.getSkullFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTYxYTkxOGMwYzQ5YmE4ZDA1M2U1MjJjYjkxYWJjNzQ2ODkzNjdiNGQ4YWEwNmJmYzFiYTkxNTQ3MzA5ODVmZiJ9fX0=");
			ItemStack accessoryBag = Inventories.buildItem(accessoryBagSkull, "&aAccessory Bag", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7A special bag which can hold", "&7Talismans, Rings, Artifacts and", "&7Orbs within it. All will still", "&7work while in this bag!", "", "&eClick to view!"))));
			inv.put(accessoryBag, "53");
			return inv;
		}
		
		public static HashMap<ItemStack, String> getInventoryFormat(Player p) {
			HashMap<ItemStack, String> toReturn = drawInventory(new HashMap<ItemStack, String>(), p);
			return toReturn;
		}
		
		public static void clicked(Player p, int slot, ItemStack i, Inventory inv) {
			if(i.getItemMeta() == null) {
				// Fix random, NullPointerExceptions' being thrown to CONSOLE.
				return;
			}
			if(i.getItemMeta().getDisplayName() == null) {
				// Fix NullPointerExceptions' being thrown to CONSOLE when dropping an item with no display name.
				return;
			}
			if(i.getItemMeta().getDisplayName().equals(ChatUtils.chat("&aYour Skills"))) {
				p.openInventory(Inventories.build(SBMenuGUI.skills_main.getTitle(), 6, SBMenuGUI.skills_main.getInventoryFormat(p)));
			} else if(i.getItemMeta().getDisplayName().equals(ChatUtils.chat("&aCollection"))) {
				p.openInventory(Inventories.build(SBMenuGUI.collection_main.getTitle(), 6, SBMenuGUI.collection_main.getInventoryFormat(p)));
			} else if(i.getItemMeta().getDisplayName().equals(ChatUtils.chat("&c"))) {
				return;
			} else if(i.getItemMeta().getDisplayName().equals(ChatUtils.chat("&aRecipe Book"))) {
				p.openInventory(Inventories.build(SBMenuGUI.recipes_main.getTitle(), 6, SBMenuGUI.recipes_main.getInventoryFormat(p)));
			} else if(i.getItemMeta().getDisplayName().equals(ChatUtils.chat("&aYour SkyBlock Profile"))) {
				p.openInventory(Inventories.build(SBMenuGUI.profile.getTitle(), 6, SBMenuGUI.profile.getInventoryFormat(p)));
			} else {
				p.sendMessage(ChatUtils.chat("&cSorry! This option currently isn't available!"));
			}
		}
	}

	public static class profile {
		public static String getTitle() {
			return "Your SkyBlock Profile";
		}
		
		private static HashMap<ItemStack, String> drawInventory(HashMap<ItemStack, String> inv, Player p) {
			// Create the Your SkyBlock Profile button
			ItemStack skyblockProfile = Inventories.buildItem(SkullHelper.getSkullFromUUID(p.getUniqueId()), "&aYour SkyBlock Profile", ChatUtils.chat(new ArrayList<String>(Arrays.asList(" &c❤ Health &f100 HP", " &a❈ Defence &f0", " &c❁ &cStrength &f0", " &f✦ Speed 100", " &9☣ Crit Chance &f20%", " &9☠ Crit Damage &f0%", " &b✎ Intelligence &f100", " &6⸕ Mining Speed &f0", " &3α Sea Creature Chance &f0%", " &b✯ Magic Find &f0", " &d♣ Pet Luck &f0", " &f❂ True Defence 0", " &c⫽ Ferocity &f0", " &c๑ Ability Damage &f0", " &6☘ Mining Fortune &f0", " &6☘ Farming Fortune &f0", " &6☘ Foraging Fortune &f0"))));
			inv.put(skyblockProfile, "4");
			// Create the Health button
			ItemStack health = Inventories.buildItem(Material.GOLDEN_APPLE, 1, "&c❤ Health &f100 HP", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Health is your total maximum", "&7health. Your natural", "&7regeneration gives &a10 HP", "&7every &a2s.", "", "&7Base Health: &a100 HP", " &8&oIncrease your base Health by", " &8&olevelling your Farming and", " &8&oFishing skills and contributing", " &8&oto the &r&dFairy &8&oin the", " &2Wilderness&8&o.", "", "&7Bonus Health: &8+&e0 HP", " &8&oIncrease your bonus Health", " &8&oby equipping items and armor,", " &8&oand storing accessories in your", " &8&oinventory."))));
			inv.put(health, "19");
			// Create the Defense button
			ItemStack defense = Inventories.buildItem(Material.IRON_CHESTPLATE, 1, "&a❈ Defence &f0", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Defense reduces the damage that", "&7you take from enemies.", "", "&7Base Defense: &a0", " &8&oIncrease your base Defense", " &8&oby levelling your Mining Skill", " &8&oand contributing to the &dFairy", " &8&oin the &2Wilderness&8&o.", "", "&7Bonus Defense: &8+&e0", " &8&oIncrease your bonus Defense", " &8&oby equipping items and armor,", " &8&oand storing accessories in your", " &8&oinventory."))));
			inv.put(defense, "20");
			// Create the Strength button
			ItemStack strength = Inventories.buildItem(Material.BLAZE_POWDER, 1, "&c❁ Strength &f0", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Strength increases your base", "&7melee damage, including punching", "&7and weapons.", "", "&7Base Strength: &a0", " &8&oIncrease your base Strength", " &8&oby levelling your Foraging Skill", " &8&oand contributing to the &r&dFairy", " &8&oin the &2Wilderness&8&o.", "", "&7Bonus Strength: &8+&e0", " &8&oIncrease your bonus Strength", " &8&oby equipping items and armor,", " &8&oand storing accessories in your", " &8&oinventory.", "", "&7Base Damage: &a5"))));
			inv.put(strength, "21");
			// Create the Speed button
			ItemStack speed = Inventories.buildItem(Material.SUGAR, 1, "&f✦ Speed &f100", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Speed increases your walk speed.", "", "&7Base Speed: &a100", " &8&oIncrease your base Speed by", " &8&oby contributing to the &r&dFairy", " &8&oin the &2Wilderness&8&o.", "", "&7Bonus Speed: &8+&e0", " &8&oIncrease your bonus Speed", " &8&oby equipping items and armor,", " &8&oand storing accessories in your", " &8&oinventory.", "", "&7You are &a0% &7faster!"))));
			inv.put(speed, "22");
			// Create the Crit Chance button
			ItemStack critchanceskull = SkullHelper.getSkullFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2U0ZjQ5NTM1YTI3NmFhY2M0ZGM4NDEzM2JmZTgxYmU1ZjJhNDc5OWE0YzA0ZDlhNGRkYjcyZDgxOWVjMmIyYiJ9fX0=");
			ItemStack critchance = Inventories.buildItem(critchanceskull, "&9☣ Crit Chance &f20%", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Health is your total maximum", "&7health. Your natural", "&7regeneration gives &a10 HP", "&7every &a2s.", "", "&7Base Health: &a100 HP", " &8&oIncrease your base Health by", " &8&olevelling your Farming and", " &8&oFishing skills and contributing", " &8&oto the &r&dFairy &8&oin the", " &2Wilderness&8&o.", "", "&7Bonus Health: &8+&e0 HP", " &8&oIncrease your bonus Health", " &8&oby equipping items and armor,", " &8&oand storing accessories in your", " &8&oinventory."))));
			inv.put(critchance, "23");
			// Create the Crit Damage button
			ItemStack critdamageskull = SkullHelper.getSkullFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGRhZmIyM2VmYzU3ZjI1MTg3OGU1MzI4ZDExY2IwZWVmODdiNzljODdiMjU0YTdlYzcyMjk2ZjkzNjNlZjdjIn19fQ==");
			ItemStack critdamage = Inventories.buildItem(critdamageskull, "&9☠ Crit Damage &f0%", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Health is your total maximum", "&7health. Your natural", "&7regeneration gives &a10 HP", "&7every &a2s.", "", "&7Base Health: &a100 HP", " &8&oIncrease your base Health by", " &8&olevelling your Farming and", " &8&oFishing skills and contributing", " &8&oto the &r&dFairy &8&oin the", " &2Wilderness&8&o.", "", "&7Bonus Health: &8+&e0 HP", " &8&oIncrease your bonus Health", " &8&oby equipping items and armor,", " &8&oand storing accessories in your", " &8&oinventory."))));
			inv.put(critdamage, "24");
			// Create the Intelligence button
			ItemStack intelligence = Inventories.buildItem(Material.ENCHANTED_BOOK, 1, "&b✎ Intelligence &f100", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Health is your total maximum", "&7health. Your natural", "&7regeneration gives &a10 HP", "&7every &a2s.", "", "&7Base Health: &a100 HP", " &8&oIncrease your base Health by", " &8&olevelling your Farming and", " &8&oFishing skills and contributing", " &8&oto the &r&dFairy &8&oin the", " &2Wilderness&8&o.", "", "&7Bonus Health: &8+&e0 HP", " &8&oIncrease your bonus Health", " &8&oby equipping items and armor,", " &8&oand storing accessories in your", " &8&oinventory."))));
			inv.put(intelligence, "25");
			return inv;
		}
		
		public static HashMap<ItemStack, String> getInventoryFormat(Player p) {
			HashMap<ItemStack, String> toReturn = drawInventory(new HashMap<ItemStack, String>(), p);
			return toReturn;
		}
		
		public static void clicked(Player p, int slot, ItemStack i, Inventory inv) {
			
		}
	}
	
	public static class skills_main {
		public static String getTitle() {
			return "Your Skills";
		}
		
		private static HashMap<ItemStack, String> drawInventory(HashMap<ItemStack, String> inv, Player p) {
			String s;
			// Create the Your Skills ranking toggle button
			ItemStack skills = Inventories.buildItem(Material.DIAMOND_SWORD, 1, "&aYour Skills", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7View your Skill progression and", "&7rewards.", "", "&60 Skill Avg. &8(non-cosmetic)", "", "&eClick to show rankings!"))));
			inv.put(skills, "4");
			// Create the Farming skill button
			s = Utilities.numberToRomanNumerals(Integers.parseInt(Utilities.getSkill(p, "farming", "level")));
			ItemStack farming = Inventories.buildItem(Material.GOLD_HOE, 1, "&aFarming " + s, new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Harvest crops and shear sheep to", "&7earn Farming XP!", "", "&7Progress to Level XXVII: &e78.1%", "&2----------------&f---- &e702,706.1&6/&e900k", "", "&7Level XXVII Rewards:", " &eFarmhand XXVII", "  &fGrants &a+&8104&l➜&r&a108 &6☘", "  &6Farming Fortune&f, which", "  &fincreases your chance for", "  &fmultiple crops.", " &8+&a5 HP &c❤ Health", " &8+&64,000&7 Coins", "", "&eClick to view!"))));
			inv.put(farming, "19");
			// Create the Mining skill button
			s = Utilities.numberToRomanNumerals(Integers.parseInt(Utilities.getSkill(p, "mining", "level")));
			ItemStack mining = Inventories.buildItem(Material.STONE_PICKAXE, 1, "&aMining " + s, new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Spelunk islands for ore and", "&7valuable materials to earn", "&7Mining XP!", "", "&7Progress to Level XXXIX: &e27.3%", "&2------&f-------------- &e572,853.1&6/&e2.1M", "", "&7Level XXXIX Rewards:", " &eSpelunker XXXIX", "  &fGrants &a+&8152&l➜&r&a156 &6☘", "  &6Mining Fortune&f, which", "  &fincreases your chance for", "  &fmultiple ore drops.", " &8+&a2 ❈ Defence", " &8+&640,000&7 Coins", "", "&eClick to view!"))));
			inv.put(mining, "20");
			// Create the Combat skill button
			s = Utilities.numberToRomanNumerals(Integers.parseInt(Utilities.getSkill(p, "combat", "level")));
			ItemStack combat = Inventories.buildItem(Material.STONE_SWORD, 1, "&aCombat " + s, new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Fight mobs and players to", "&7earn Combat XP!", "", "&7Progress to Level XLVI: &e84.5%", "&2-----------------&f--- &e2,450,402.4&6/&e2.9M", "", "&7Level XLVI Rewards:", " &eWarrior XLVI", "  &fDeal &a+&8180&l➜&r&a184% &fmore", "  &fdamage to mobs.", " &8+&a0.5% &9☣ Crit Chance", " &8+&6100,000&7 Coins", "", "&eClick to view!"))));
			inv.put(combat, "21");
			// Create the Foraging skill button
			s = Utilities.numberToRomanNumerals(Integers.parseInt(Utilities.getSkill(p, "foraging", "level")));
			ItemStack foraging = Inventories.buildItem(Material.SAPLING, 1, (short)3, "&aForaging " + s, new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Cut trees and forage for other", "&7plants to earn Foraging XP!", "", "&7Progress to Level XXVII: &e5%", "&2-&f------------------- &e44,818.9&6/&e900k", "", "&7Level XXVII Rewards:", " &eLogger XXVII", "  &fGrants &a+&8104&l➜&r&a108 &6☘", "  &6Foraging Fortune&f, which", "  &fincreases your chance for", "  &fmultiple logs.", " &8+&a2 &c❁ Strength", " &8+&64,000&7 Coins", "", "&eClick to view!"))));
			inv.put(foraging, "22");
			// Create the Fishing skill button
			s = Utilities.numberToRomanNumerals(Integers.parseInt(Utilities.getSkill(p, "fishing", "level")));
			ItemStack fishing = Inventories.buildItem(Material.FISHING_ROD, 1, "&aFishing " + s, new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Visit your local pond to fish", "&7and earn Fishing XP!", "", "&7Progress to Level XXXII: &e7.3%", "&2--&f------------------ &e102,346.3&6/&e1.4M", "", "&7Level XXXII Rewards:", " &eTreasure Hunter XXVII", "  &fIncreases the chance to find", "  &ftreasure when fishing by", "  &a+&86.2&l➜&r&a6.4%", " &8+&a5 HP &c❤ Health", " &8+&612,500&7 Coins", "", "&eClick to view!"))));
			inv.put(fishing, "23");
			// Create the Enchanting skill button
			s = Utilities.numberToRomanNumerals(Integers.parseInt(Utilities.getSkill(p, "enchanting", "level")));
			ItemStack enchanting = Inventories.buildItem(Material.ENCHANTMENT_TABLE, 1, "&aEnchanting " + s, new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Enchant items to earn Enchanting", "&7XP!", "", "&7Progress to Level XLVII: &e31.7%", "&2-------&f------------- &e983,015.9&6/&e3.1M", "", "&7Level XLVII Rewards:", " &eConjurer XLVII", "  &fGain &a+&8184&l➜&r&a188% &fmore", "  &fexperience orbs from any source.", " &8+&a0.5% &c๑ Ability Damage", " &8+&a2 &b✎ Intelligence", " &8+&6125,000&7 Coins", "", "&eClick to view!"))));
			inv.put(enchanting, "24");
			// Create the Alchemy skill button
			s = Utilities.numberToRomanNumerals(Integers.parseInt(Utilities.getSkill(p, "alchemy", "level")));
			ItemStack alchemy = Inventories.buildItem(Material.BREWING_STAND_ITEM, 1, "&aAlchemy " + s, new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Brew potions to earn Alchemy XP!", "", "&7Progress to Level XXVIII: &e25.4%", "&2------&f-------------- &e253,921.3&6/&e1M", "", "&7Level XXVIII Rewards:", " &eBrewer XXVIII", "  &fPotions that you brew have a", "  &&827&l➜&r&a28% &flonger duration.", " &8+&a2 &b✎ Intelligence", " &8+&65,000&7 Coins", "", "&eClick to view!"))));
			inv.put(alchemy, "25");
			// Create the Carpentry skill button
			s = Utilities.numberToRomanNumerals(Integers.parseInt(Utilities.getSkill(p, "carpentry", "level")));
			ItemStack carpentry = Inventories.buildItem(Material.WORKBENCH, 1, "&aCarpentry " + s, new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Craft items to earn Carpentry", "&7XP!", "", "&7Progress to Level XXI: &e64.3%", "&2-------------&f------- &e192,751.5&6/&e300k", "", "&7Level XXI Rewards:", " &fBrewing+ &7Furniture Recipe", "", "&eClick to view!"))));
			inv.put(carpentry, "29");
			// Create the Runecrafting skill button
			s = Utilities.numberToRomanNumerals(Integers.parseInt(Utilities.getSkill(p, "runecrafting", "level")));
			ItemStack runecrafting = Inventories.buildItem(Material.MAGMA_CREAM, 1, "&aRunecrafting " + s, new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Slay bosses, runic mobs &", "&7fuse runes to earn Runecrafting XP!", "", "&8&oYou have reached the max", "&8&olevel for this Skill!", "", "&dLevel up Runecrafting to activate", "&dthe effects of rune-bearing items!", "", "&eClick to view!"))));
			inv.put(runecrafting, "30");
			// Create the Social skill button
			s = Utilities.numberToRomanNumerals(Integers.parseInt(Utilities.getSkill(p, "social", "level")));
			ItemStack social = Inventories.buildItem(Material.EMERALD, 1, "&aSocial " + s, new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Gain Social XP for every new", "&7unique guest, hosting guests, and", "&7visiting islands!", "", "&7Progress to Level V: &e38.4%", "&2--------&f------------ &e191.8&6/&e500", "", "&7Level V Rewards:", " &fAbility to purchase &dIsland", " &dNPCs &fat Amelia in the Hub", " &8+&6300&7 Coins", "", "&eClick to view!"))));
			inv.put(social, "31");
			// Create the Taming skill button
			s = Utilities.numberToRomanNumerals(Integers.parseInt(Utilities.getSkill(p, "taming", "level")));
			ItemStack taming = Inventories.buildItem(Material.MONSTER_EGG, 1, "&aTaming " + s, new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Level up pets to earn Taming XP!", "", "&7Progress to Level XLII: &e7.7%", "&2--&f------------------ &e184,656.5&6/&e2.4M", "", "&7Level XLII Rewards:", " &eZoologist XLII", "  &fGain &841&l➜&r&a42% &fextra pet", "  &fexp.", " &8+&a2 &d♣ Pet Luck", " &8+&660,000&7 Coins", "", "&eClick to view!"))));
			inv.put(taming, "32");
			// Create the Dungeoneering skill button
			ItemStack dungeoneeringSkull = SkullHelper.getSkullFromBase64("eyJ0aW1lc3RhbXAiOjE1Nzg0MDk0MTMxNjksInByb2ZpbGVJZCI6IjQxZDNhYmMyZDc0OTQwMGM5MDkwZDU0MzRkMDM4MzFiIiwicHJvZmlsZU5hbWUiOiJNZWdha2xvb24iLCJzaWduYXR1cmVSZXF1aXJlZCI6dHJ1ZSwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzliNTY4OTViOTY1OTg5NmFkNjQ3ZjU4NTk5MjM4YWY1MzJkNDZkYjljMWIwMzg5YjhiYmViNzA5OTlkYWIzM2QiLCJtZXRhZGF0YSI6eyJtb2RlbCI6InNsaW0ifX19fQ==");
			ItemStack dungeoneering = Inventories.buildItem(dungeoneeringSkull, "&aDungeoneering", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Complete dungeons to level up", "&7your classes! Unlock new gear", "&7and class upgrades by completing", "&7higher tier dungeons!", "", "&7Requires &bCombat Level 5", "&7to enter a Dungeon.", "", "&eClick to view!"))));
			inv.put(dungeoneering, "33");
			// Create the Go Back button
			ItemStack goBack = Inventories.buildItem(Material.ARROW, 1, "&aGo Back", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7To SkyBlock Menu"))));
			inv.put(goBack, "48");
			// Create the Close button
			ItemStack close = Inventories.buildItem(Material.BARRIER, 1, "&cClose", new ArrayList<String>());
			inv.put(close, "49");
			return inv;
		}
		
		public static HashMap<ItemStack, String> getInventoryFormat(Player p) {
			HashMap<ItemStack, String> toReturn = drawInventory(new HashMap<ItemStack, String>(), p);
			return toReturn;
		}
		
		public static void clicked(Player p, int slot, ItemStack i, Inventory inv) {
			if(i.getItemMeta().getDisplayName().equals(ChatUtils.chat("&aGo Back"))) {
				p.openInventory(Inventories.build("SkyBlock Menu", 6, SBMenuGUI.main.getInventoryFormat(p)));
			} else if(i.getItemMeta().getDisplayName().equals(ChatUtils.chat("&cClose"))) {
				p.closeInventory();
			} else if(i.getItemMeta().getDisplayName().equals(ChatUtils.chat("&aYour Skills"))) {
				p.openInventory(Inventories.build("Your Skills > Ranking", 6, SBMenuGUI.skills_ranking.getInventoryFormat(p)));
			} else if(i.getItemMeta().getDisplayName().equals(ChatUtils.chat("&c"))) {
				return;
			} else {
				p.sendMessage(ChatUtils.chat("&cSorry! This option currently isn't available!"));
			}
		}
	}

	public static class skills_ranking {
		public static String getTitle() {
			return "Your Skills > Ranking";
		}
		
		private static HashMap<ItemStack, String> drawInventory(HashMap<ItemStack, String> inv, Player p) {
			String s;
			// Create the Your Skills ranking toggle button
			ItemStack skills = Inventories.buildItem(Material.DIAMOND_SWORD, 1, "&aYour Skills", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7View your Skill progression and", "&7rewards.", "", "&60 Skill Avg. &8(non-cosmetic)", "", "&eClick to hide rankings!"))));
			inv.put(Inventories.glowify(skills), "4");
			// Create the Farming skill button
			s = Utilities.numberToRomanNumerals(Integers.parseInt(Utilities.getSkill(p, "farming", "level")));
			ItemStack farming = Inventories.buildItem(Material.GOLD_HOE, 1, "&aFarming " + s, new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Harvest crops and shear sheep to", "&7earn Farming XP!", "", "&7Progress to Level XXVII: &e78.1%", "&2----------------&f---- &e702,706.1&6/&e900k", "", "&7Level XXVII Rewards:", " &eFarmhand XXVII", "  &fGrants &a+&8104&l➜&r&a108 &6☘", "  &6Farming Fortune&f, which", "  &fincreases your chance for", "  &fmultiple crops.", " &8+&a5 HP &c❤ Health", " &8+&64,000&7 Coins", "", "&7#&b102,180 &7out of &a10,094,489 &7players", "&7You are within the top &e1% &7of players!", "&8Rankings may take some time to refresh.", "", "&eClick to view!"))));
			inv.put(Inventories.glowify(farming), "19");
			// Create the Mining skill button
			s = Utilities.numberToRomanNumerals(Integers.parseInt(Utilities.getSkill(p, "mining", "level")));
			ItemStack mining = Inventories.buildItem(Material.STONE_PICKAXE, 1, "&aMining " + s, new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Spelunk islands for ore and", "&7valuable materials to earn", "&7Mining XP!", "", "&7Progress to Level XXXIX: &e27.3%", "&2------&f-------------- &e572,853.1&6/&e2.1M", "", "&7Level XXXIX Rewards:", " &eSpelunker XXXIX", "  &fGrants &a+&8152&l➜&r&a156 &6☘", "  &6Mining Fortune&f, which", "  &fincreases your chance for", "  &fmultiple ore drops.", " &8+&a2 ❈ Defence", " &8+&640,000&7 Coins", "", "&7#&b59,819 &7out of &a10,094,489 &7players", "&7You are within the top &e0.6% &7of players!", "&8Rankings may take some time to refresh.", "", "&eClick to view!"))));
			inv.put(Inventories.glowify(mining), "20");
			// Create the Combat skill button
			s = Utilities.numberToRomanNumerals(Integers.parseInt(Utilities.getSkill(p, "combat", "level")));
			ItemStack combat = Inventories.buildItem(Material.STONE_SWORD, 1, "&aCombat " + s, new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Fight mobs and players to", "&7earn Combat XP!", "", "&7Progress to Level XLVI: &e84.5%", "&2-----------------&f--- &e2,450,402.4&6/&e2.9M", "", "&7Level XLVI Rewards:", " &eWarrior XLVI", "  &fDeal &a+&8180&l➜&r&a184% &fmore", "  &fdamage to mobs.", " &8+&a0.5% &9☣ Crit Chance", " &8+&6100,000&7 Coins", "", "&7#&b15,862 &7out of &a10,094,489 &7players", "&7You are within the top &e0.2% &7of players!", "&8Rankings may take some time to refresh.", "", "&eClick to view!"))));
			inv.put(Inventories.glowify(combat), "21");
			// Create the Foraging skill button
			s = Utilities.numberToRomanNumerals(Integers.parseInt(Utilities.getSkill(p, "foraging", "level")));
			ItemStack foraging = Inventories.buildItem(Material.SAPLING, 1, (short)3, "&aForaging " + s, new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Cut trees and forage for other", "&7plants to earn Foraging XP!", "", "&7Progress to Level XXVII: &e5%", "&2-&f------------------- &e44,818.9&6/&e900k", "", "&7Level XXVII Rewards:", " &eLogger XXVII", "  &fGrants &a+&8104&l➜&r&a108 &6☘", "  &6Foraging Fortune&f, which", "  &fincreases your chance for", "  &fmultiple logs.", " &8+&a2 &c❁ Strength", " &8+&64,000&7 Coins", "", "&7#&b28,498 &7out of &a10,094,489 &7players", "&7You are within the top &e0.3% &7of players!", "&8Rankings may take some time to refresh.", "", "&eClick to view!"))));
			inv.put(Inventories.glowify(foraging), "22");
			// Create the Fishing skill button
			s = Utilities.numberToRomanNumerals(Integers.parseInt(Utilities.getSkill(p, "fishing", "level")));
			ItemStack fishing = Inventories.buildItem(Material.FISHING_ROD, 1, "&aFishing " + s, new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Visit your local pond to fish", "&7and earn Fishing XP!", "", "&7Progress to Level XXXII: &e7.3%", "&2--&f------------------ &e102,346.3&6/&e1.4M", "", "&7Level XXXII Rewards:", " &eTreasure Hunter XXVII", "  &fIncreases the chance to find", "  &ftreasure when fishing by", "  &a+&86.2&l➜&r&a6.4%", " &8+&a5 HP &c❤ Health", " &8+&612,500&7 Coins", "", "&7#&b15,873 &7out of &a10,094,489 &7players", "&7You are within the top &e0.2% &7of players!", "&8Rankings may take some time to refresh.", "", "&eClick to view!"))));
			inv.put(Inventories.glowify(fishing), "23");
			// Create the Enchanting skill button
			s = Utilities.numberToRomanNumerals(Integers.parseInt(Utilities.getSkill(p, "enchanting", "level")));
			ItemStack enchanting = Inventories.buildItem(Material.ENCHANTMENT_TABLE, 1, "&aEnchanting " + s, new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Enchant items to earn Enchanting", "&7XP!", "", "&7Progress to Level XLVII: &e31.7%", "&2-------&f------------- &e983,015.9&6/&e3.1M", "", "&7Level XLVII Rewards:", " &eConjurer XLVII", "  &fGain &a+&8184&l➜&r&a188% &fmore", "  &fexperience orbs from any source.", " &8+&a0.5% &c๑ Ability Damage", " &8+&a2 &b✎ Intelligence", " &8+&6125,000&7 Coins", "", "&7#&b57,243 &7out of &a10,094,489 &7players", "&7You are within the top &e0.6% &7of players!", "&8Rankings may take some time to refresh.", "", "&eClick to view!"))));
			inv.put(Inventories.glowify(enchanting), "24");
			// Create the Alchemy skill button
			s = Utilities.numberToRomanNumerals(Integers.parseInt(Utilities.getSkill(p, "alchemy", "level")));
			ItemStack alchemy = Inventories.buildItem(Material.BREWING_STAND_ITEM, 1, "&aAlchemy " + s, new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Brew potions to earn Alchemy XP!", "", "&7Progress to Level XXVIII: &e25.4%", "&2------&f-------------- &e253,921.3&6/&e1M", "", "&7Level XXVIII Rewards:", " &eBrewer XXVIII", "  &fPotions that you brew have a", "  &&827&l➜&r&a28% &flonger duration.", " &8+&a2 &b✎ Intelligence", " &8+&65,000&7 Coins", "", "&7#&b69,340 &7out of &a10,094,489 &7players", "&7You are within the top &e0.7% &7of players!", "&8Rankings may take some time to refresh.", "", "&eClick to view!"))));
			inv.put(Inventories.glowify(alchemy), "25");
			// Create the Carpentry skill button
			s = Utilities.numberToRomanNumerals(Integers.parseInt(Utilities.getSkill(p, "carpentry", "level")));
			ItemStack carpentry = Inventories.buildItem(Material.WORKBENCH, 1, "&aCarpentry " + s, new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Craft items to earn Carpentry", "&7XP!", "", "&7Progress to Level XXI: &e64.3%", "&2-------------&f------- &e192,751.5&6/&e300k", "", "&7Level XXI Rewards:", " &fBrewing+ &7Furniture Recipe", "", "&7#&b164,111 &7out of &a10,094,489 &7players", "&7You are within the top &e1.6% &7of players!", "&8Rankings may take some time to refresh.", "", "&eClick to view!"))));
			inv.put(Inventories.glowify(carpentry), "29");
			// Create the Runecrafting skill button
			s = Utilities.numberToRomanNumerals(Integers.parseInt(Utilities.getSkill(p, "runecrafting", "level")));
			ItemStack runecrafting = Inventories.buildItem(Material.MAGMA_CREAM, 1, "&aRunecrafting " + s, new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Slay bosses, runic mobs &", "&7fuse runes to earn Runecrafting XP!", "", "&8&oYou have reached the max", "&8&olevel for this Skill!", "", "&dLevel up Runecrafting to activate", "&dthe effects of rune-bearing items!", "", "&7#&b26,518 &7out of &a10,094,489 &7players", "&7You are within the top &e0.3% &7of players!", "&8Rankings may take some time to refresh.", "", "&eClick to view!"))));
			inv.put(Inventories.glowify(runecrafting), "30");
			// Create the Social skill button
			s = Utilities.numberToRomanNumerals(Integers.parseInt(Utilities.getSkill(p, "social", "level")));
			ItemStack social = Inventories.buildItem(Material.EMERALD, 1, "&aSocial " + s, new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Gain Social XP for every new", "&7unique guest, hosting guests, and", "&7visiting islands!", "", "&7Progress to Level V: &e38.4%", "&2--------&f------------ &e191.8&6/&e500", "", "&7Level V Rewards:", " &fAbility to purchase &dIsland", " &dNPCs &fat Amelia in the Hub", " &8+&6300&7 Coins", "", "&7Rankings require skill level 15", "&8Rankings may take some time to refresh.", "", "&eClick to view!"))));
			inv.put(Inventories.glowify(social), "31");
			// Create the Taming skill button
			s = Utilities.numberToRomanNumerals(Integers.parseInt(Utilities.getSkill(p, "taming", "level")));
			ItemStack taming = Inventories.buildItem(Material.MONSTER_EGG, 1, "&aTaming " + s, new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Level up pets to earn Taming XP!", "", "&7Progress to Level XLII: &e7.7%", "&2--&f------------------ &e184,656.5&6/&e2.4M", "", "&7Level XLII Rewards:", " &eZoologist XLII", "  &fGain &841&l➜&r&a42% &fextra pet", "  &fexp.", " &8+&a2 &d♣ Pet Luck", " &8+&660,000&7 Coins", "", "&7#&b51,949 &7out of &a10,094,489 &7players", "&7You are within the top &e0.5% &7of players!", "&8Rankings may take some time to refresh.", "", "&eClick to view!"))));
			inv.put(Inventories.glowify(taming), "32");
			// Create the Dungeoneering skill button
			ItemStack dungeoneeringSkull = SkullHelper.getSkullFromBase64("eyJ0aW1lc3RhbXAiOjE1Nzg0MDk0MTMxNjksInByb2ZpbGVJZCI6IjQxZDNhYmMyZDc0OTQwMGM5MDkwZDU0MzRkMDM4MzFiIiwicHJvZmlsZU5hbWUiOiJNZWdha2xvb24iLCJzaWduYXR1cmVSZXF1aXJlZCI6dHJ1ZSwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzliNTY4OTViOTY1OTg5NmFkNjQ3ZjU4NTk5MjM4YWY1MzJkNDZkYjljMWIwMzg5YjhiYmViNzA5OTlkYWIzM2QiLCJtZXRhZGF0YSI6eyJtb2RlbCI6InNsaW0ifX19fQ==");
			ItemStack dungeoneering = Inventories.buildItem(dungeoneeringSkull, "&aDungeoneering", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Complete dungeons to level up", "&7your classes! Unlock new gear", "&7and class upgrades by completing", "&7higher tier dungeons!", "", "&7Requires &bCombat Level 5", "&7to enter a Dungeon.", "", "&eClick to view!"))));
			inv.put(Inventories.glowify(dungeoneering), "33");
			// Create the Go Back button
			ItemStack goBack = Inventories.buildItem(Material.ARROW, 1, "&aGo Back", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7To SkyBlock Menu"))));
			inv.put(goBack, "48");
			// Create the Close button
			ItemStack close = Inventories.buildItem(Material.BARRIER, 1, "&cClose", new ArrayList<String>());
			inv.put(close, "49");
			return inv;
		}
		
		public static HashMap<ItemStack, String> getInventoryFormat(Player p) {
			HashMap<ItemStack, String> toReturn = drawInventory(new HashMap<ItemStack, String>(), p);
			return toReturn;
		}
		
		public static void clicked(Player p, int slot, ItemStack i, Inventory inv) {
			if(i.getItemMeta().getDisplayName().equals(ChatUtils.chat("&aGo Back"))) {
				p.openInventory(Inventories.build("SkyBlock Menu", 6, SBMenuGUI.main.getInventoryFormat(p)));
			} else if(i.getItemMeta().getDisplayName().equals(ChatUtils.chat("&cClose"))) {
				p.closeInventory();
			} else if(i.getItemMeta().getDisplayName().equals(ChatUtils.chat("&aYour Skills"))) {
				p.openInventory(Inventories.build("Your Skills", 6, SBMenuGUI.skills_main.getInventoryFormat(p)));
			} else if(i.getItemMeta().getDisplayName().equals(ChatUtils.chat("&c"))) {
				return;
			} else {
				p.sendMessage(ChatUtils.chat("&cSorry! This option currently isn't available!"));
			}
		}
	}

	public static class collection_main {
		public static String getTitle() {
			return "Collection";
		}
		
		private static HashMap<ItemStack, String> drawInventory(HashMap<ItemStack, String> inv, Player p) {
			// Create the Collection button
			ItemStack collection = Inventories.buildItem(Material.ITEM_FRAME, 1, "&aCollection", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7View all of the items available", "&7in SkyBlock. Collect more of an", "&7item to unlock rewards on your", "&7way to becoming a master of", "&7SkyBlock!", "", "&7Collection Maxed Out: &e0.0&6%", "&f-------------------- &e0&6/&e60", "", "&eClick to show rankings!"))));
			inv.put(collection, "4");
			// Create the Farming collection button
			ItemStack farming = Inventories.buildItem(Material.GOLD_HOE, 1, "&aFarming Collection", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7View your Farming Collection!", "", "&7Collection Maxed Out: &e23.5&6%", "&2-----&f--------------- &e4&6/&e17", "", "&eClick to view!"))));
			inv.put(farming, "20");
			// Create the Mining collection button
			ItemStack mining = Inventories.buildItem(Material.STONE_PICKAXE, 1, "&aMining Collection", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7View your Mining Collection!", "", "&7Collection Maxed Out: &e52.9&6%", "&2-----------&f--------- &e9&6/&e17", "", "&eClick to view!"))));
			inv.put(mining, "21");
			// Create the Combat collection button
			ItemStack combat = Inventories.buildItem(Material.STONE_SWORD, 1, "&aCombat Collection", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7View your Combat Collection!", "", "&7Collection Maxed Out: &e40&6%", "&2--------&f------------ &e4&6/&e10", "", "&eClick to view!"))));
			inv.put(combat, "22");
			// Create the Foraging collection button
			ItemStack foraging = Inventories.buildItem(Material.SAPLING, 1, (short)3, "&aForaging Collection", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7View your Foraging Collection!", "", "&7Collection Maxed Out: &e33.3&6%", "&2-------&f------------- &e2&6/&e6", "", "&eClick to view!"))));
			inv.put(foraging, "23");
			// Create the Fishing collection button
			ItemStack fishing = Inventories.buildItem(Material.FISHING_ROD, 1, "&aFishing Collection", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7View your Fishing Collection!", "", "&7Collection Maxed Out: &e100&6%", "&2-------------------- &e10&6/&e10", "", "&eClick to view!"))));
			inv.put(fishing, "24");
			// Create the Boss collection button
			ItemStack boss = Inventories.buildItem(Material.SKULL_ITEM, 1, (short)1, "&5Boss Collection", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7View your progress and claim", "&7rewards you have obtained from", "&7defeating SkyBlock bosses!", "", "&7Boss Collection Maxed Out: &e0&6%", "&f-------------------- &e0&6/&e7", "", "&eClick to view!"))));
			inv.put(boss, "31");
			// Create the Go Back button
			ItemStack goBack = Inventories.buildItem(Material.ARROW, 1, "&aGo Back", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7To SkyBlock Menu"))));
			inv.put(goBack, "48");
			// Create the Close button
			ItemStack close = Inventories.buildItem(Material.BARRIER, 1, "&cClose", new ArrayList<String>());
			inv.put(close, "49");
			return inv;
		}
		
		public static HashMap<ItemStack, String> getInventoryFormat(Player p) {
			HashMap<ItemStack, String> toReturn = drawInventory(new HashMap<ItemStack, String>(), p);
			return toReturn;
		}
		
		public static void clicked(Player p, int slot, ItemStack i, Inventory inv) {
			if(i.getItemMeta().getDisplayName().equals(ChatUtils.chat("&aGo Back"))) {
				p.openInventory(Inventories.build("SkyBlock Menu", 6, SBMenuGUI.main.getInventoryFormat(p)));
			} else if(i.getItemMeta().getDisplayName().equals(ChatUtils.chat("&cClose"))) {
				p.closeInventory();
			} else if(i.getItemMeta().getDisplayName().equals(ChatUtils.chat("&aCollection"))) {
				p.openInventory(Inventories.build("Collection > Ranking", 6, SBMenuGUI.collection_ranking.getInventoryFormat(p)));
			} else if(i.getItemMeta().getDisplayName().equals(ChatUtils.chat("&c"))) {
				return;
			} else {
				p.sendMessage(ChatUtils.chat("&cSorry! This option currently isn't available!"));
			}
		}
	}
	
	public static class collection_ranking {
		public static String getTitle() {
			return "Collection > Ranking";
		}
		
		private static HashMap<ItemStack, String> drawInventory(HashMap<ItemStack, String> inv, Player p) {
			// Create the Collection button
			ItemStack collection = Inventories.buildItem(Material.ITEM_FRAME, 1, "&aCollection", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7View all of the items available", "&7in SkyBlock. Collect more of an", "&7item to unlock rewards on your", "&7way to becoming a master of", "&7SkyBlock!", "", "&7Collection Maxed Out: &e0.0&6%", "&f-------------------- &e0&6/&e60", "", "&eClick to hide rankings!"))));
			inv.put(collection, "4");
			// Create the Farming collection button
			ItemStack farming = Inventories.buildItem(Material.GOLD_HOE, 1, "&aFarming Collection", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7View your Farming Collection!", "", "&7Collection Maxed Out: &e23.5&6%", "&2-----&f--------------- &e4&6/&e17", "", "&eClick to view!"))));
			inv.put(Inventories.glowify(farming), "20");
			// Create the Mining collection button
			ItemStack mining = Inventories.buildItem(Material.STONE_PICKAXE, 1, "&aMining Collection", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7View your Mining Collection!", "", "&7Collection Maxed Out: &e52.9&6%", "&2-----------&f--------- &e9&6/&e17", "", "&eClick to view!"))));
			inv.put(Inventories.glowify(mining), "21");
			// Create the Combat collection button
			ItemStack combat = Inventories.buildItem(Material.STONE_SWORD, 1, "&aCombat Collection", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7View your Combat Collection!", "", "&7Collection Maxed Out: &e40&6%", "&2--------&f------------ &e4&6/&e10", "", "&eClick to view!"))));
			inv.put(Inventories.glowify(combat), "22");
			// Create the Foraging collection button
			ItemStack foraging = Inventories.buildItem(Material.SAPLING, 1, (short)3, "&aForaging Collection", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7View your Foraging Collection!", "", "&7Collection Maxed Out: &e33.3&6%", "&2-------&f------------- &e2&6/&e6", "", "&eClick to view!"))));
			inv.put(Inventories.glowify(foraging), "23");
			// Create the Fishing collection button
			ItemStack fishing = Inventories.buildItem(Material.FISHING_ROD, 1, "&aFishing Collection", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7View your Fishing Collection!", "", "&7Collection Maxed Out: &e100&6%", "&2-------------------- &e10&6/&e10", "", "&eClick to view!"))));
			inv.put(Inventories.glowify(fishing), "24");
			// Create the Boss collection button
			ItemStack boss = Inventories.buildItem(Material.SKULL_ITEM, 1, (short)1, "&5Boss Collection", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7View your progress and claim", "&7rewards you have obtained from", "&7defeating SkyBlock bosses!", "", "&7Boss Collection Maxed Out: &e0&6%", "&f-------------------- &e0&6/&e7", "", "&eClick to view!"))));
			inv.put(Inventories.glowify(boss), "31");
			// Create the Go Back button
			ItemStack goBack = Inventories.buildItem(Material.ARROW, 1, "&aGo Back", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7To SkyBlock Menu"))));
			inv.put(goBack, "48");
			// Create the Close button
			ItemStack close = Inventories.buildItem(Material.BARRIER, 1, "&cClose", new ArrayList<String>());
			inv.put(close, "49");
			return inv;
		}
		
		public static HashMap<ItemStack, String> getInventoryFormat(Player p) {
			HashMap<ItemStack, String> toReturn = drawInventory(new HashMap<ItemStack, String>(), p);
			return toReturn;
		}
		
		public static void clicked(Player p, int slot, ItemStack i, Inventory inv) {
			if(i.getItemMeta().getDisplayName().equals(ChatUtils.chat("&aGo Back"))) {
				p.openInventory(Inventories.build("SkyBlock Menu", 6, SBMenuGUI.main.getInventoryFormat(p)));
			} else if(i.getItemMeta().getDisplayName().equals(ChatUtils.chat("&cClose"))) {
				p.closeInventory();
			} else if(i.getItemMeta().getDisplayName().equals(ChatUtils.chat("&aCollection"))) {
				p.openInventory(Inventories.build("Collection", 6, SBMenuGUI.collection_main.getInventoryFormat(p)));
			} else if(i.getItemMeta().getDisplayName().equals(ChatUtils.chat("&c"))) {
				return;
			} else {
				p.sendMessage(ChatUtils.chat("&cSorry! This option currently isn't available!"));
			}
		}
	}

	public static class recipes_main {
		public static String getTitle() {
			return "Recipe Book";
		}
		
		private static HashMap<ItemStack, String> drawInventory(HashMap<ItemStack, String> inv, Player p) {
			// Create the Recipe Book button
			ItemStack recipeBook = Inventories.buildItem(Material.BOOK, 1, "&aRecipe Book", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7Through your adventure, you will", "&7unlock recipes for all kinds of", "&7special items! You can view how", "&7to craft these items here.", "", "&7Recipe Book Unlocked: &e0.0&6%", "&f-------------------- &e0&6/&e719"))));
			inv.put(recipeBook, "4");
			// Create the Farming recipes button
			ItemStack farming = Inventories.buildItem(Material.GOLD_HOE, 1, "&aFarming Recipes", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7View all of the Farming Recipes", "&7that you have unlocked!", "", "&7Recipes Unlocked: &e76.9&6%", "&2----------------&f---- &e113&6/&e147", "", "&eClick to view!"))));
			inv.put(farming, "20");
			// Create the Mining recipes button
			ItemStack mining = Inventories.buildItem(Material.STONE_PICKAXE, 1, "&aMining Recipes", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7View all of the Mining Recipes", "&7that you have unlocked!", "", "&7Recipes Unlocked: &e76.2&6%", "&2----------------&f---- &e109&6/&e143", "", "&eClick to view!"))));
			inv.put(mining, "21");
			// Create the Combat recipes button
			ItemStack combat = Inventories.buildItem(Material.STONE_SWORD, 1, "&aCombat Recipes", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7View all of the Combat Recipes", "&7that you have unlocked!", "", "&7Recipes Unlocked: &e86.9&6%", "&2------------------&f-- &e86&6/&e99", "", "&eClick to view!"))));
			inv.put(combat, "22");
			// Create the Fishing recipes button
			ItemStack fishing = Inventories.buildItem(Material.FISHING_ROD, 1, "&aFishing Recipes", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7View all of the Fishing Recipes", "&7that you have unlocked!", "", "&7Recipes Unlocked: &a100&6%", "&2-------------------- &e79&6/&e79", "", "&eClick to view!"))));
			inv.put(fishing, "23");
			// Create the Foraging recipes button
			ItemStack foraging = Inventories.buildItem(Material.SAPLING, 1, (short)3, "&aForaging Recipes", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7View all of the Foraging Recipes", "&7that you have unlocked!", "", "&7Recipes Unlocked: &e86.3&6%", "&2------------------&f-- &e44&6/&e51", "", "&eClick to view!"))));
			inv.put(foraging, "24");
			// Create the Enchanting recipes button
			ItemStack enchanting = Inventories.buildItem(Material.ENCHANTMENT_TABLE, 1, "&aEnchanting Recipes", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7View all of the Enchanting Recipes", "&7that you have unlocked!", "", "&7Recipes Unlocked: &e83.1&6%", "&2-----------------&f--- &e49&6/&e59", "", "&eClick to view!"))));
			inv.put(enchanting, "29");
			// Create the Alchemy recipes button
			ItemStack alchemy = Inventories.buildItem(Material.BREWING_STAND_ITEM, 1, "&aAlchemy Recipes", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7View all of the Alchemy Recipes", "&7that you have unlocked!", "", "&7Recipes Unlocked: &e86.9&6%", "&2------------------&f-- &e53&6/&e61", "", "&eClick to view!"))));
			inv.put(alchemy, "30");
			// Create the Carpentry recipes button
			ItemStack carpentry = Inventories.buildItem(Material.WORKBENCH, 1, "&aCarpentry Recipes", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7View all of the Carpentry Recipes", "&7that you have unlocked!", "", "&7Recipes Unlocked: &a100&6%", "&2-------------------- &e1&6/&e1", "", "&eClick to view!"))));
			inv.put(carpentry, "31");
			// Create the Slayer recipes button
			ItemStack slayer = Inventories.buildItem(Material.BOW, 1, "&aSlayer Recipes", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7View all of the Slayer Recipes", "&7that you have unlocked!", "", "&7Recipes Unlocked: &e93.8&6%", "&2-------------------&f- &e60&6/&e64", "", "&eClick to view!"))));
			inv.put(slayer, "32");
			// Create the Special recipes button
			ItemStack special = Inventories.buildItem(Material.NETHER_STAR, 1, "&aSpecial Recipes", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7View all of the Special Recipes", "&7that you have unlocked!", "", "&7Recipes Unlocked: &a100&6%", "&2-------------------- &e15&6/&e15", "", "&eClick to view!"))));
			inv.put(special, "33");
			// Create the Go Back button
			ItemStack goBack = Inventories.buildItem(Material.ARROW, 1, "&aGo Back", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&7To SkyBlock Menu"))));
			inv.put(goBack, "48");
			// Create the Close button
			ItemStack close = Inventories.buildItem(Material.BARRIER, 1, "&cClose", new ArrayList<String>());
			inv.put(close, "49");
			return inv;
		}
		
		public static HashMap<ItemStack, String> getInventoryFormat(Player p) {
			HashMap<ItemStack, String> toReturn = drawInventory(new HashMap<ItemStack, String>(), p);
			return toReturn;
		}
		
		public static void clicked(Player p, int slot, ItemStack i, Inventory inv) {
			if(i.getItemMeta().getDisplayName().equals(ChatUtils.chat("&aGo Back"))) {
				p.openInventory(Inventories.build("SkyBlock Menu", 6, SBMenuGUI.main.getInventoryFormat(p)));
			} else if(i.getItemMeta().getDisplayName().equals(ChatUtils.chat("&cClose"))) {
				p.closeInventory();
			} else if(i.getItemMeta().getDisplayName().equals(ChatUtils.chat("&c"))) {
				return;
			} else {
				p.sendMessage(ChatUtils.chat("&cSorry! This option currently isn't available!"));
			}
		}
	}
	
}

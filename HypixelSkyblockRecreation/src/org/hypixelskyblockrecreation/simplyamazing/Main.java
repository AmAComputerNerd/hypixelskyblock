package org.hypixelskyblockrecreation.simplyamazing;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.hypixelskyblockrecreation.simplyamazing.Main;
import org.hypixelskyblockrecreation.simplyamazing.Commands.Coins;
import org.hypixelskyblockrecreation.simplyamazing.Commands.Item;
import org.hypixelskyblockrecreation.simplyamazing.Commands.SkillTest;
import org.hypixelskyblockrecreation.simplyamazing.Commands.SkyBlockMenu;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ChatUtils;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ItemHelper;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.RegisterItems;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Types.SkyBlockCommand;
import org.hypixelskyblockrecreation.simplyamazing.Items.Rarity;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBAbility;
import org.hypixelskyblockrecreation.simplyamazing.Items.Type;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.SkyBlockItem;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.SkyBlockMaterial;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.Other.not_found;
import org.hypixelskyblockrecreation.simplyamazing.Listeners.ItemAbilityListener;
import org.hypixelskyblockrecreation.simplyamazing.Listeners.JoinLeaveListener;
import org.hypixelskyblockrecreation.simplyamazing.Listeners.MenuClickListener;

import de.tr7zw.nbtinjector.NBTInjector;

public class Main extends JavaPlugin {
	private static Main inst;
	private static FileConfiguration coins;
	private static FileConfiguration skills;
	private static FileConfiguration stats;
	private static BukkitTask autoSbMenu;
	private static BukkitTask checkPlayers;
	public static ItemStack sbMenu;
	private static Map<String, SkyBlockItem> items = new HashMap<String, SkyBlockItem>();
    private static Map<String, SkyBlockMaterial> materials = new HashMap<String, SkyBlockMaterial>();
	
	@Override
	public void onEnable() {
		inst = this;
		try {
			createConfigFiles();
			NBTInjector.inject();
			SkyBlockCommand.registerCommands(this);
			new MenuClickListener(this);
			new ItemAbilityListener(this);
			new JoinLeaveListener(this);
			// Put new items
			putItem("null", new not_found(Material.BARRIER, "null", "&cERROR: SkyBlockItem not found!", Rarity.NONE, Type.NONE, false, false, new ArrayList<SBAbility>(), null));
			RegisterItems.registerSkyBlockItems();
			// Start task for checking the SBMenu location
			sbMenu = getItem("skyblock_menu").createItem(1);
			autoSbMenu = Bukkit.getScheduler().runTaskTimer(this, new Runnable() {
				@Override
				public void run() {
					for(Player p : Bukkit.getOnlinePlayers()) {
						if(p.getInventory().getItem(8) == null) {
							p.getInventory().setItem(8, sbMenu);
							return;
						}
						if(!(p.getInventory().getItem(8).equals(sbMenu))) {
							ItemStack toAdd = p.getInventory().getItem(8);
							p.getInventory().setItem(8, sbMenu);
							if(ItemHelper.getNBTValueFromCompound(toAdd, "ExtraAttributes", "id") != null) {
								if(ItemHelper.getNBTValueFromCompound(toAdd, "ExtraAttributes", "id").equals("SKYBLOCK_MENU")) {
									return;
								}
							}
							p.getInventory().addItem(toAdd);
							return;
						}
					}
				}
			}, 40L, 10L);
			checkPlayers = Bukkit.getScheduler().runTaskTimer(this, new Runnable() {
				@SuppressWarnings("unused")
				@Override
				public void run() {
					int counter = 0;
					for(Player p : Bukkit.getOnlinePlayers()) {
						counter = counter++;
					}
					if(counter > 5) {
						for(Player p : Bukkit.getOnlinePlayers()) {
							p.sendMessage(ChatUtils.chat("&6[HypixelSkyBlock] &7For legal reasons, this plugin has been set to &cauto-disable&7 when more than &a5 players&7 are online. The plugin will be &cdisabled&7 until the next reboot."));
						}
						getLogger().severe("Detected more than 5 players online at once! The plugin has auto-disabled until the next reboot.");
						disable();
					}
				}
			}, 40L, 10L);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void onDisable() {
		autoSbMenu.cancel();
		checkPlayers.cancel();
	}
	
	// Used to disable the plugin.
	private void disable() {
		this.getPluginLoader().disablePlugin(this);
	}
	
	public static Main getInstance() {
		return inst;
	}
	
	public static FileConfiguration getCoinsFile() {
		return Main.coins;
	}
	
	public static FileConfiguration getSkillsFile() {
		return Main.skills;
	}
	
	public static FileConfiguration getStatsFile() {
		return Main.stats;
	}
	
	private void createConfigFiles() {
		File coinsConfigFile = new File(getDataFolder(), "coins.yml");
		File skillsConfigFile = new File(getDataFolder(), "skills.yml");
		File statsConfigFile = new File(getDataFolder(), "stats.yml");
		if(!coinsConfigFile.exists()) {
			coinsConfigFile.getParentFile().mkdirs();
			saveResource("coins.yml", false);
		}
		if(!skillsConfigFile.exists()) {
			skillsConfigFile.getParentFile().mkdirs();
			saveResource("skills.yml", false);
		}
		if(!statsConfigFile.exists()) {
			statsConfigFile.getParentFile().mkdirs();
			saveResource("stats.yml", false);
		}
		
		coins = new YamlConfiguration();
		try {
			coins.load(coinsConfigFile);
		} catch(IOException | InvalidConfigurationException e) {
			getLogger().severe("Coins.yml file could not be loaded! The error is being printed below:");
			e.printStackTrace();
		}
		skills = new YamlConfiguration();
		try {
			skills.load(skillsConfigFile);
		} catch(IOException | InvalidConfigurationException e) {
			getLogger().severe("Skills.yml file could not be loaded! The error is being printed below:");
			e.printStackTrace();
		}
		stats = new YamlConfiguration();
		try {
			stats.load(statsConfigFile);
		} catch(IOException | InvalidConfigurationException e) {
			getLogger().severe("Stats.yml file could not be loaded! The error is being printed below:");
			e.printStackTrace();
		}
	}
	
	public static SkyBlockItem getItem(final String key) {
		final SkyBlockItem i = Main.items.get(key);
		if(i == null) {
			return Main.items.get("null");
		}
		return i;
	}
	
	public static String getItemNameFromItem(final SkyBlockItem sbi) {
		if(Main.items.containsValue(sbi)) {
			for(Entry<String, SkyBlockItem> e : Main.items.entrySet()) {
				if(sbi.getUUID() == e.getValue().getUUID()) {
					return e.getKey();
				}
			}
			return sbi.getDisplayName();
		}
		return "UNREGISTERED_ITEM";
	}
	
	public static boolean isValidItem(final String key) {
		if(Main.items.containsKey(key)) {
			return true;
		}
		return false;
	}
	
	public static Collection<SkyBlockItem> getItems() {
		return Main.items.values();
	}
	
	public static Collection<String> getItemNames() {
		return Main.items.keySet();
	}
	
	public static SkyBlockMaterial getMaterial(final String key) {
		final SkyBlockMaterial m = Main.materials.get(key);
		if(m == null) {
			return null;
		}
		return m;
	}
	
	public static String getItemNameFromMaterial(final SkyBlockMaterial sbm) {
		if(Main.materials.containsValue(sbm)) {
			for(Entry<String, SkyBlockMaterial> e : Main.materials.entrySet()) {
				if(sbm.getUUID() == e.getValue().getUUID()) {
					return e.getKey();
				}
			}
			return sbm.getName();
		}
		return "UNREGISTERED_MATERIAL";
	}
	
	public static boolean isValidMaterial(final String key) {
		if(Main.materials.containsKey(key)) {
			return true;
		}
		return false;
	}
	
	public static Collection<SkyBlockMaterial> getMaterials() {
		return Main.materials.values();
	}
	
	public static Collection<String> getMaterialNames() {
		return Main.materials.keySet();
	}
	
	public static void putItem(final String name, final SkyBlockItem item) {
		Main.items.put(name, item);
	}
	
	public static void putMaterial(final String name, final SkyBlockMaterial material) {
		Main.materials.put(name, material);
	}
	
}

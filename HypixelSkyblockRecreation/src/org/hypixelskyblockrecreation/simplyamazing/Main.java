package org.hypixelskyblockrecreation.simplyamazing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.hypixelskyblockrecreation.simplyamazing.Main;
import org.hypixelskyblockrecreation.simplyamazing.Commands.Item;
import org.hypixelskyblockrecreation.simplyamazing.Commands.SkyBlockMenu;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.AbilityInit;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ChatUtils;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ItemHelper;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.RegisterItems;
import org.hypixelskyblockrecreation.simplyamazing.Items.Rarity;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBAbility;
import org.hypixelskyblockrecreation.simplyamazing.Items.SkyBlockItem;
import org.hypixelskyblockrecreation.simplyamazing.Items.SkyBlockMaterial;
import org.hypixelskyblockrecreation.simplyamazing.Items.Type;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.not_found;
import org.hypixelskyblockrecreation.simplyamazing.Menus.MenuClickListener;

import de.tr7zw.nbtinjector.NBTInjector;

public class Main extends JavaPlugin {
	private static Main inst;
	private static BukkitTask taskId;
	public static ItemStack sbMenu;
	private static Map<String, SkyBlockItem> items = new HashMap<String, SkyBlockItem>();
	private static Map<Integer, SkyBlockItem> itemIDs = new HashMap<Integer, SkyBlockItem>();
    private static Map<String, SkyBlockMaterial> materials = new HashMap<String, SkyBlockMaterial>();
    private static Map<Integer, SkyBlockMaterial> materialIDs = new HashMap<Integer, SkyBlockMaterial>();
	
	@Override
	public void onEnable() {
		inst = this;
		try {
			NBTInjector.inject();
			new Item(this);
			new SkyBlockMenu(this);
			new MenuClickListener(this);
			new AbilityInit(this);
			// Put new items
			putItem("null", new not_found(Material.BARRIER, "null", "&cERROR: SkyBlockItem not found!", Rarity.NONE, Type.NONE, false, false, new ArrayList<SBAbility>(), null));
			RegisterItems.registerSkyBlockItems();
			// Start task for checking the SBMenu location
			sbMenu = getItem("skyblock_menu").createItem(1);
			taskId = Bukkit.getScheduler().runTaskTimer(this, new Runnable() {
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
							if(ItemHelper.getNBTValue(toAdd, "SbUUID") != null) {
								if(ItemHelper.getNBTValue(toAdd, "SbUUID").equals("128821747")) {
									return;
								}
							}
							p.getInventory().addItem(toAdd);
							return;
						}
					}
				}
			}, 40L, 10L);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void onDisable() {
		taskId.cancel();
	}
	
	public static Main getInstance() {
		return inst;
	}
	
	public static SkyBlockItem getItem(final String key) {
		final SkyBlockItem i = Main.items.get(key);
		if(i == null) {
			return Main.items.get("null");
		}
		return i;
	}
	
	public static SkyBlockItem getItemFromID(final int id) {
		final SkyBlockItem i = Main.itemIDs.get(id);
		if(i == null) {
			return Main.items.get("null");
		}
		return i;
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
	
	public static SkyBlockMaterial getMaterialFromID(final int id) {
		final SkyBlockMaterial m = Main.materialIDs.get(id);
		if(m == null) {
			return null;
		}
		return m;
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
		Main.itemIDs.put(item.getUUID(), item);
	}
	
	public static void putMaterial(final String name, final SkyBlockMaterial material) {
		Main.materials.put(name, material);
		Main.materialIDs.put(material.getUUID(), material);
	}
	
}

package org.hypixelskyblockrecreation.simplyamazing.Menus;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.hypixelskyblockrecreation.simplyamazing.Main;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ChatUtils;

public class MenuClickListener implements Listener {
	
	private Main plugin;
	
	public MenuClickListener(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		int slot = e.getSlot();
		ItemStack i = e.getCurrentItem();
		Inventory inv = e.getInventory();
		if(e.getView().getTitle().equals(ChatUtils.chat(SBMenuGUI.main.getTitle()))) {
			e.setCancelled(true);
			SBMenuGUI.main.clicked(p, slot, i, inv);
		} else if(e.getView().getTitle().equals(ChatUtils.chat(SBMenuGUI.skills_main.getTitle()))) {
			e.setCancelled(true);
			SBMenuGUI.skills_main.clicked(p, slot, i, inv);
		} else if(e.getView().getTitle().equals(ChatUtils.chat(SBMenuGUI.skills_ranking.getTitle()))) {
			e.setCancelled(true);
			SBMenuGUI.skills_ranking.clicked(p, slot, i, inv);
		} else if(e.getView().getTitle().equals(ChatUtils.chat(SBMenuGUI.collection_main.getTitle()))) {
			e.setCancelled(true);
			SBMenuGUI.collection_main.clicked(p, slot, i, inv);
		} else if(e.getView().getTitle().equals(ChatUtils.chat(SBMenuGUI.collection_ranking.getTitle()))) {
			e.setCancelled(true);
			SBMenuGUI.collection_ranking.clicked(p, slot, i, inv);
		} else if(e.getView().getTitle().equals(ChatUtils.chat(SBMenuGUI.recipes_main.getTitle()))) {
			e.setCancelled(true);
			SBMenuGUI.recipes_main.clicked(p, slot, i, inv);
		}
	}

}

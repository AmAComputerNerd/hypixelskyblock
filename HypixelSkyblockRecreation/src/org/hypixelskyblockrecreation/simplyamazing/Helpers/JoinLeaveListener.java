package org.hypixelskyblockrecreation.simplyamazing.Helpers;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.hypixelskyblockrecreation.simplyamazing.Main;

public class JoinLeaveListener implements Listener {
	
	private Main plugin;
	
	public JoinLeaveListener(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerFirstJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(p.hasPlayedBefore() && Utilities.playerHasStats(p)) {
			return;
		}
		
		if(Utilities.playerHasStats(p)) {
			return;
		}
		
		plugin.getLogger().info("Starting creation of required SkyBlock values for " + p.getName() + "!");
		Utilities.newPlayer(p);
	}

}

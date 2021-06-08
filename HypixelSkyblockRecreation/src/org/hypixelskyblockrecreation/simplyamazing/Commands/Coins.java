package org.hypixelskyblockrecreation.simplyamazing.Commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.hypixelskyblockrecreation.simplyamazing.Main;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ChatUtils;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Utilities;

public class Coins implements CommandExecutor, TabCompleter {
	
	private Main plugin;
	
	public Coins(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("coins").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player target;
		int coins;
		
		if(Utilities.enforcePermissions(sender, "skyblock.coins")) {
			return false;
		}
		
		if(args.length == 0) {
			sender.sendMessage(ChatUtils.chat("&cUsage: /coins [give/remove/purse/bank] (args)"));
			return false;
		}
		
		if(args.length == 2 && !(sender instanceof Player)) {
			sender.sendMessage(ChatUtils.chat("&cUsage: /coins [give/remove/purse/bank] (args)"));
			return false;
		}
		
		switch(args[0].toLowerCase()) {
			case "give":
				if(args.length == 2) {
					coins = Utilities.convertToInt(args[1]);
					giveCoins((Player)sender, coins);
					sender.sendMessage(ChatUtils.chat("&eYou gave yourself " + coins + "&e coins."));
					return true;
				}
				
				if(!(Utilities.isOnline(args[1]))) {
					sender.sendMessage(ChatUtils.chat("&cInvalid player. Are they online?"));
					return false;
				}
				target = Bukkit.getPlayerExact(args[1]);
				coins = Utilities.convertToInt(args[2]);
				giveCoins(target, coins);
				sender.sendMessage(ChatUtils.chat("&eYou gave " + target.getName() + "&e " + coins + "&e coins."));
				target.sendMessage(ChatUtils.chat("&eYou have received " + coins + "&e coins from an admin."));
				return true;
			case "remove":
				if(args.length == 2) {
					coins = Utilities.convertToInt(args[1]);
					removeCoins((Player)sender, coins);
					sender.sendMessage(ChatUtils.chat("&eYou removed " + coins + "&e coins from your purse."));
					return true;
				}
				
				if(!(Utilities.isOnline(args[1]))) {
					sender.sendMessage(ChatUtils.chat("&cInvalid player. Are they online?"));
					return false;
				}
				target = Bukkit.getPlayerExact(args[1]);
				coins = Utilities.convertToInt(args[2]);
				removeCoins(target, coins);
				sender.sendMessage(ChatUtils.chat("&eYou removed " + coins + "&e coins from " + target.getName() + "&e's purse."));
				target.sendMessage(ChatUtils.chat("&eAn admin has removed " + coins + "&e coins from your purse."));
				return true;
			case "purse":
				if(args.length == 1) {
					coins = 100;
					sender.sendMessage(ChatUtils.chat("&eYou have " + coins + "&e coins in your purse!"));
					return true;
				}
				
				if(!(Utilities.isOnline(args[1]))) {
					sender.sendMessage(ChatUtils.chat("&cInvalid player. Are they online?"));
					return false;
				}
				target = Bukkit.getPlayerExact(args[1]);
				coins = 100;
				sender.sendMessage(ChatUtils.chat("&e" + target.getName() + "&e has " + coins + "&e coins in their purse!"));
				return true;
			case "bank":
				if(args.length == 1) {
					coins = 1000;
					sender.sendMessage(ChatUtils.chat("&eYou have " + coins + "&e coins in your bank!"));
					return true;
				}
				
				if(!(Utilities.isOnline(args[1]))) {
					sender.sendMessage(ChatUtils.chat("&cInvalid player. Are they online?"));
					return false;
				}
				target = Bukkit.getPlayerExact(args[1]);
				coins = 1000;
				sender.sendMessage(ChatUtils.chat("&e" + target.getName() + "&e has " + coins + "&e coins in their bank!"));
				return true;
			default:
				sender.sendMessage(ChatUtils.chat("&cUsage: /coins [give/remove/purse/bank] (args)"));
				return false;
		}
	}
	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 0) {
			return Arrays.asList("give", "remove", "purse", "bank");
		} else if(args.length == 1) {
			List<String> toReturn = new ArrayList<String>();
			for(Player p : Bukkit.getOnlinePlayers()) {
				toReturn.add(p.getName());
			}
			return toReturn;
		} else if(args.length == 2) {
			return null;
		}
		return null;
	}
	
	private static void giveCoins(Player p, int coins) {
		
	}
	
	private static void removeCoins(Player p, int coins) {
		
	}

}

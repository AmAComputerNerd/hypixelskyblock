package org.hypixelskyblockrecreation.simplyamazing.Commands;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.hypixelskyblockrecreation.simplyamazing.Main;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ChatUtils;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Utilities;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Types.SkyBlockCommand;

public class Coins extends SkyBlockCommand {
	
	private Main plugin;
	
	public Coins() {
		super("coins", "/coins [give/remove/purse/bank] (args)", "skyblock.coins", true);
	}

	@Override
	public boolean execute(CommandSender sender, String[] args) {
		Player target;
		int coins;
		
		if(args.length == 0) {
			Utilities.sendUsage("coins", sender);
			return false;
		}
		
		if(args.length == 2 && !(sender instanceof Player)) {
			Utilities.sendUsage("coins", sender);
			return false;
		}
		
		switch(args[0].toLowerCase()) {
			case "give":
				if(args.length == 2) {
					coins = Utilities.convertToInt(args[1]);
					giveCoins((Player)sender, coins);
					sender.sendMessage(ChatUtils.chat("&7You gave yourself &6" + coins + "&6 coins."));
					return true;
				}
				
				if(!(Utilities.isOnline(args[1]))) {
					sender.sendMessage(ChatUtils.chat("&cInvalid player. Are they online?"));
					return false;
				}
				target = Bukkit.getPlayerExact(args[1]);
				coins = Utilities.convertToInt(args[2]);
				giveCoins(target, coins);
				sender.sendMessage(ChatUtils.chat("&7You gave &a" + target.getName() + "&6 " + coins + "&6 coins&7."));
				target.sendMessage(ChatUtils.chat("&7You have received &6" + coins + "&6 coins&7 from an admin."));
				return true;
			case "remove":
				if(args.length == 2) {
					coins = Utilities.convertToInt(args[1]);
					removeCoins((Player)sender, coins);
					sender.sendMessage(ChatUtils.chat("&7You removed &6" + coins + "&6 coins&7 from your purse."));
					return true;
				}
				
				if(!(Utilities.isOnline(args[1]))) {
					sender.sendMessage(ChatUtils.chat("&cInvalid player. Are they online?"));
					return false;
				}
				target = Bukkit.getPlayerExact(args[1]);
				coins = Utilities.convertToInt(args[2]);
				removeCoins(target, coins);
				sender.sendMessage(ChatUtils.chat("&7You removed &6" + coins + "&6 coins&7 from &a" + target.getName() + "&a's&7 purse."));
				target.sendMessage(ChatUtils.chat("&7An admin has removed &6" + coins + "&6 coins&7 from your purse."));
				return true;
			case "purse":
				if(args.length == 1) {
					if(!(sender instanceof Player)) {
						sender.sendMessage(ChatUtils.chat("&cUsage: /coins purse [player]"));
						return false;
					}
					coins = Utilities.getCoins((Player)sender, "purse");
					sender.sendMessage(ChatUtils.chat("&7You have &6" + coins + "&6 coins&7 in your purse!"));
					return true;
				}
				
				if(!(Utilities.isOnline(args[1]))) {
					sender.sendMessage(ChatUtils.chat("&cInvalid player. Are they online?"));
					return false;
				}
				target = Bukkit.getPlayerExact(args[1]);
				coins = Utilities.getCoins(target, "purse");
				sender.sendMessage(ChatUtils.chat("&a" + target.getName() + "&7 has &6" + coins + "&6 coins &7in their purse!"));
				return true;
			case "bank":
				if(args.length == 1) {
					if(!(sender instanceof Player)) {
						sender.sendMessage(ChatUtils.chat("&cUsage: /coins bank [player]"));
						return false;
					}
					coins = Utilities.getCoins((Player)sender, "bank");
					sender.sendMessage(ChatUtils.chat("&7You have &6" + coins + "&6 coins&7 in your bank!"));
					return true;
				}
				
				if(!(Utilities.isOnline(args[1]))) {
					sender.sendMessage(ChatUtils.chat("&cInvalid player. Are they online?"));
					return false;
				}
				target = Bukkit.getPlayerExact(args[1]);
				coins = Utilities.getCoins(target, "bank");
				sender.sendMessage(ChatUtils.chat("&a" + target.getName() + "&7 has &6" + coins + "&6 coins&7 in their bank!"));
				return true;
			default:
				Utilities.sendUsage("coins", sender);
				return false;
		}
	}

	@Override
	public List<String> tabComplete(CommandSender sender, String[] args) {
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
		int prevCoins = Utilities.getCoins(p, "purse");
		int newCoins = prevCoins + coins;
		FileConfiguration coinsFile = Main.getCoinsFile();
		coinsFile.set(p.getUniqueId().toString() + ".purse", String.valueOf(newCoins));
		Utilities.saveFile(coinsFile, new File(Main.getInstance().getDataFolder(), "coins.yml"), p);
	}
	
	private static void removeCoins(Player p, int coins) {
		int prevCoins = Utilities.getCoins(p, "purse");
		int newCoins = prevCoins - coins;
		if(newCoins < 0) {
			newCoins = 0;
		}
		FileConfiguration coinsFile = Main.getCoinsFile();
		coinsFile.set(p.getUniqueId().toString() + ".purse", String.valueOf(newCoins));
		Utilities.saveFile(coinsFile, new File(Main.getInstance().getDataFolder(), "coins.yml"), p);
	}

}
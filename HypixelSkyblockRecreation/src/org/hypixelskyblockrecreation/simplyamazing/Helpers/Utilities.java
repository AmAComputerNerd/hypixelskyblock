package org.hypixelskyblockrecreation.simplyamazing.Helpers;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.core.util.Integers;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;
import org.hypixelskyblockrecreation.simplyamazing.Main;

public class Utilities {
	private static BukkitTask coins;
	private static BukkitTask skills;
	private static BukkitTask stats;
	
	public static boolean enforcePermissions(Player p, String perm) {
		if(p.hasPermission(perm)) {
			return false;
		}
		p.sendMessage(ChatUtils.chat("&cYou require the permission &7" + perm + "&c to use this command!"));
		return true;
	}
	
	public static boolean enforcePermissions(CommandSender s, String perm) {
		if(s.hasPermission(perm)) {
			return false;
		}
		s.sendMessage(ChatUtils.chat("&cYou require the permission &7" + perm + "&c to use this command!"));
		return true;
	}
	
	public static int percentageToNumber(String s) {
		if(!(s.contains("%"))) {
			return 0;
		}
		s = s.replace("%", "");
		return (Integers.parseInt(s) / 100);
	}
	
	public void damagePlayer(Player p, double damage, double reduce) {
		  double points = p.getAttribute(Attribute.GENERIC_ARMOR).getValue();
		  double toughness = p.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS).getValue();
		  PotionEffect effect = p.getPotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
		  int resistance = effect == null ? 0 : effect.getAmplifier();
		  int epf = getEPF(p.getInventory());

		  p.damage(calculateDamageApplied(damage, points, toughness, resistance, epf) - (calculateDamageApplied(damage, points, toughness, resistance, epf) * reduce));
	}
	
	public static double calculateDamageApplied(double damage, double points, double toughness, int resistance, int epf) {
		  double withArmorAndToughness = damage * (1 - Math.min(20, Math.max(points / 5, points - damage / (2 + toughness / 4))) / 25);
		  double withResistance = withArmorAndToughness * (1 - (resistance * 0.2));
		  double withEnchants = withResistance * (1 - (Math.min(20.0, epf) / 25));
		  return withEnchants;
	}
	
	public static double calculateDamageApplied(double damage, double reduce, double points, double toughness, int resistance, int epf) {
		  double withArmorAndToughness = damage * (1 - Math.min(20, Math.max(points / 5, points - damage / (2 + toughness / 4))) / 25);
		  double withResistance = withArmorAndToughness * (1 - (resistance * 0.2));
		  double withEnchants = withResistance * (1 - (Math.min(20.0, epf) / 25));
		  double withReduced = withEnchants - (withEnchants * reduce);
		  return withReduced;
	}

	public static int getEPF(PlayerInventory inv) {
		  ItemStack helm = inv.getHelmet();
		  ItemStack chest = inv.getChestplate();
		  ItemStack legs = inv.getLeggings();
		  ItemStack boot = inv.getBoots();

		  return (helm != null ? helm.getEnchantmentLevel(Enchantment.DAMAGE_ALL) : 0) +
		     (chest != null ? chest.getEnchantmentLevel(Enchantment.DAMAGE_ALL) : 0) +
		     (legs != null ? legs.getEnchantmentLevel(Enchantment.DAMAGE_ALL) : 0) +
		     (boot != null ? boot.getEnchantmentLevel(Enchantment.DAMAGE_ALL) : 0);
	}
	
	public static int convertToInt(String s) {
		int num;
		try {
			num = Integers.parseInt(s);
		} catch(Exception e) {
			return 0;
		}
		return num;
	}
	
	public static boolean isOnline(String s) {
		for(Player p : Bukkit.getServer().getOnlinePlayers()) {
			if(p.getName().equalsIgnoreCase(s)) {
				return true;
			}
		}
		return false;
	}
	
	public static String numberToRomanNumerals(int input) {
		if (input < 0 || input > 3999)
	        return "Invalid Roman Number Value";
		if(input == 0) {
			return "0";
		}
	    String s = "";
	    while (input >= 1000) {
	        s += "M";
	        input -= 1000;        }
	    while (input >= 900) {
	        s += "CM";
	        input -= 900;
	    }
	    while (input >= 500) {
	        s += "D";
	        input -= 500;
	    }
	    while (input >= 400) {
	        s += "CD";
	        input -= 400;
	    }
	    while (input >= 100) {
	        s += "C";
	        input -= 100;
	    }
	    while (input >= 90) {
	        s += "XC";
	        input -= 90;
	    }
	    while (input >= 50) {
	        s += "L";
	        input -= 50;
	    }
	    while (input >= 40) {
	        s += "XL";
	        input -= 40;
	    }
	    while (input >= 10) {
	        s += "X";
	        input -= 10;
	    }
	    while (input >= 9) {
	        s += "IX";
	        input -= 9;
	    }
	    while (input >= 5) {
	        s += "V";
	        input -= 5;
	    }
	    while (input >= 4) {
	        s += "IV";
	        input -= 4;
	    }
	    while (input >= 1) {
	        s += "I";
	        input -= 1;
	    }    
	    return s;
	}
	
	public static boolean playerHasStats(Player p) {
		FileConfiguration coins = Main.getCoinsFile();
		if(coins.getString(p.getUniqueId().toString()) != null) {
			return true;
		}
		return false;
	}
	
	public static void newPlayer(Player p) {
		FileConfiguration coins = Main.getCoinsFile();
		FileConfiguration skills = Main.getSkillsFile();
		FileConfiguration stats = Main.getStatsFile();
		
		coins.set(p.getUniqueId().toString() + ".purse", 0);
		coins.set(p.getUniqueId().toString() + ".bank", 0);
		
		skills.set(p.getUniqueId().toString() + ".farming.level", 0);
		skills.set(p.getUniqueId().toString() + ".farming.exp", 0);
		skills.set(p.getUniqueId().toString() + ".mining.level", 0);
		skills.set(p.getUniqueId().toString() + ".mining.exp", 0);
		skills.set(p.getUniqueId().toString() + ".combat.level", 0);
		skills.set(p.getUniqueId().toString() + ".combat.exp", 0);
		skills.set(p.getUniqueId().toString() + ".foraging.level", 0);
		skills.set(p.getUniqueId().toString() + ".foraging.exp", 0);
		skills.set(p.getUniqueId().toString() + ".fishing.level", 0);
		skills.set(p.getUniqueId().toString() + ".fishing.exp", 0);
		skills.set(p.getUniqueId().toString() + ".enchanting.level", 0);
		skills.set(p.getUniqueId().toString() + ".enchanting.exp", 0);
		skills.set(p.getUniqueId().toString() + ".alchemy.level", 0);
		skills.set(p.getUniqueId().toString() + ".alchemy.exp", 0);
		skills.set(p.getUniqueId().toString() + ".carpentry.level", 0);
		skills.set(p.getUniqueId().toString() + ".carpentry.exp", 0);
		skills.set(p.getUniqueId().toString() + ".runecrafting.level", 0);
		skills.set(p.getUniqueId().toString() + ".runecrafting.exp", 0);
		skills.set(p.getUniqueId().toString() + ".social.level", 0);
		skills.set(p.getUniqueId().toString() + ".social.exp", 0);
		skills.set(p.getUniqueId().toString() + ".taming.level", 0);
		skills.set(p.getUniqueId().toString() + ".taming.exp", 0);
		
		stats.set(p.getUniqueId().toString() + ".health.base", 100);
		stats.set(p.getUniqueId().toString() + ".health.bonus", 0);
		stats.set(p.getUniqueId().toString() + ".defense.base", 0);
		stats.set(p.getUniqueId().toString() + ".defense.bonus", 0);
		stats.set(p.getUniqueId().toString() + ".strength.base", 0);
		stats.set(p.getUniqueId().toString() + ".strength.bonus", 0);
		stats.set(p.getUniqueId().toString() + ".damage.base", 5);
		stats.set(p.getUniqueId().toString() + ".speed.base", 100);
		stats.set(p.getUniqueId().toString() + ".speed.bonus", 0);
		stats.set(p.getUniqueId().toString() + ".critchance.base", 30);
		stats.set(p.getUniqueId().toString() + ".critchance.bonus", 0);
		stats.set(p.getUniqueId().toString() + ".critdamage.base", 50);
		stats.set(p.getUniqueId().toString() + ".critdamage.bonus", 0);
		stats.set(p.getUniqueId().toString() + ".intelligence.base", 100);
		stats.set(p.getUniqueId().toString() + ".intelligence.bonus", 0);
		stats.set(p.getUniqueId().toString() + ".intelligence.manapool", 100);
		stats.set(p.getUniqueId().toString() + ".miningspeed.base", 0);
		stats.set(p.getUniqueId().toString() + ".miningspeed.bonus", 0);
		stats.set(p.getUniqueId().toString() + ".attackspeed.base", 0);
		stats.set(p.getUniqueId().toString() + ".attackspeed.bonus", 0);
		stats.set(p.getUniqueId().toString() + ".seacreaturechance.base", 20);
		stats.set(p.getUniqueId().toString() + ".seacreaturechance.bonus", 0);
		stats.set(p.getUniqueId().toString() + ".magicfind.base", 0);
		stats.set(p.getUniqueId().toString() + ".magicfind.bonus", 0);
		stats.set(p.getUniqueId().toString() + ".petluck.base", 0);
		stats.set(p.getUniqueId().toString() + ".petluck.bonus", 0);
		stats.set(p.getUniqueId().toString() + ".truedefense.base", 0);
		stats.set(p.getUniqueId().toString() + ".truedefense.bonus", 0);
		stats.set(p.getUniqueId().toString() + ".ferocity.base", 0);
		stats.set(p.getUniqueId().toString() + ".ferocity.bonus", 0);
		stats.set(p.getUniqueId().toString() + ".abilitydamage.base", 0);
		stats.set(p.getUniqueId().toString() + ".abilitydamage.bonus", 0);
		stats.set(p.getUniqueId().toString() + ".fortune.mining.base", 0);
		stats.set(p.getUniqueId().toString() + ".fortune.mining.bonus", 0);
		stats.set(p.getUniqueId().toString() + ".fortune.farming.base", 0);
		stats.set(p.getUniqueId().toString() + ".fortune.farming.bonus", 0);
		stats.set(p.getUniqueId().toString() + ".fortune.foraging.base", 0);
		stats.set(p.getUniqueId().toString() + ".fortune.foraging.bonus", 0);
		
		try {
			coins.save(new File(Main.getInstance().getDataFolder(), "coins.yml"));
		} catch (IOException e) {
			Main.getInstance().getLogger().warning("Failed to save the coins.yml file for " + p.getName() + ". Loop started.");
			Utilities.coins = Bukkit.getScheduler().runTaskTimer(Main.getInstance(), new Runnable() {
				@Override
				public void run() {
					try {
						coins.save(new File(Main.getInstance().getDataFolder(), "coins.yml"));
						Utilities.coins.cancel();
					} catch(IOException e) {}
				}
			}, 40L, 40L);
		}
		
		try {
			skills.save(new File(Main.getInstance().getDataFolder(), "skills.yml"));
		} catch (IOException e) {
			Main.getInstance().getLogger().warning("Failed to save the skills.yml file for " + p.getName() + ". Loop started.");
			Utilities.skills = Bukkit.getScheduler().runTaskTimer(Main.getInstance(), new Runnable() {
				@Override
				public void run() {
					try {
						skills.save(new File(Main.getInstance().getDataFolder(), "skills.yml"));
						Utilities.skills.cancel();
					} catch(IOException e) {}
				}
			}, 40L, 40L);
		}
		
		try {
			stats.save(new File(Main.getInstance().getDataFolder(), "stats.yml"));
		} catch (IOException e) {
			Main.getInstance().getLogger().warning("Failed to save the stats.yml file for " + p.getName() + ". Loop started.");
			Utilities.stats = Bukkit.getScheduler().runTaskTimer(Main.getInstance(), new Runnable() {
				@Override
				public void run() {
					try {
						stats.save(new File(Main.getInstance().getDataFolder(), "stats.yml"));
						Utilities.stats.cancel();
					} catch(IOException e) {}
				}
			}, 40L, 40L);
		}
	}
	
	public static int getCoins(Player p, String loc) {
		if(loc.toLowerCase() != "purse" && loc.toLowerCase() != "bank") {
			return 0;
		}
		
		FileConfiguration coins = Main.getCoinsFile();
		if(loc.toLowerCase().equals("purse")) {
			int purseCoins = (int) coins.get(p.getUniqueId().toString() + ".purse");
			return purseCoins;
		}
		int bankCoins = (int) coins.get(p.getUniqueId().toString() + ".bank");
		return bankCoins;
	}
	
	public static String getSkill(Player p, String skill, String value) {
		if(value.toLowerCase() != "level" && value.toLowerCase() != "exp") {
			return null;
		}
		
		FileConfiguration skills = Main.getSkillsFile();
		if(value.toLowerCase().equals("level")) {value = "level";}
		if(value.toLowerCase().equals("exp")) {value = "exp";}
		
		switch(skill.toLowerCase()) {
			case "farming":
				return String.valueOf(skills.get(p.getUniqueId().toString() + ".farming." + value));
			case "mining":
				return String.valueOf(skills.get(p.getUniqueId().toString() + ".mining." + value));
			case "combat":
				return String.valueOf(skills.get(p.getUniqueId().toString() + ".combat." + value));
			case "foraging":
				return String.valueOf(skills.get(p.getUniqueId().toString() + ".foraging." + value));
			case "fishing":
				return String.valueOf(skills.get(p.getUniqueId().toString() + ".fishing." + value));
			case "enchanting":
				return String.valueOf(skills.get(p.getUniqueId().toString() + ".enchanting." + value));
			case "alchemy":
				return String.valueOf(skills.get(p.getUniqueId().toString() + ".alchemy." + value));
			case "carpentry":
				return String.valueOf(skills.get(p.getUniqueId().toString() + ".carpentry." + value));
			case "runecrafting":
				return String.valueOf(skills.get(p.getUniqueId().toString() + ".runecrafting." + value));
			case "social":
				return String.valueOf(skills.get(p.getUniqueId().toString() + ".social." + value));
			case "taming":
				return String.valueOf(skills.get(p.getUniqueId().toString() + ".taming." + value));
			default:
				return null;
		}
	}
}

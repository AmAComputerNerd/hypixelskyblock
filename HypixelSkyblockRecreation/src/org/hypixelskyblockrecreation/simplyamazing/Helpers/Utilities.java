package org.hypixelskyblockrecreation.simplyamazing.Helpers;

import org.apache.logging.log4j.core.util.Integers;
import org.bukkit.attribute.Attribute;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Utilities {
	
	public static boolean enforcePermissions(Player p, String perm) {
		if(p.hasPermission(perm)) {
			return false;
		}
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

}

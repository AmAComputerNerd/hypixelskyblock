package org.hypixelskyblockrecreation.simplyamazing.Items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ChatUtils;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ItemHelper;

public class SBAbility {
	private String name;
	private String description;
	private AbilityType type;
	private int cooldown;
	private int cost;
	
	public SBAbility(final String name, final AbilityType type, final String description) {
		this.cooldown = 0;
		this.cost = 0;
		this.name = name;
		this.type = type;
		this.description = description;
	}
	
	public SBAbility(final String name, final AbilityType type, final String description, final int cost) {
		this.cooldown = 0;
		this.name = name;
		this.type = type;
		this.description = description;
		this.cost = cost;
	}
	
	public SBAbility(final String name, final AbilityType type, final int cooldown, final String description) {
		this.cost = 0;
		this.name = name;
		this.type = type;
		this.cooldown = cooldown;
		this.description = description;
	}
	
	public SBAbility(final String name, final AbilityType type, final int cooldown, final String description, final int cost) {
		this.name = name;
		this.type = type;
		this.cooldown = cooldown;
		this.description = description;
		this.cost = cost;
	}
	
	public List<String> toLore(boolean noShow) {
		final List<String> lore = new ArrayList<String>();
		if(!noShow) {
			lore.add(ChatUtils.chat("&6Ability: " + this.name + " &e&l" + this.type.getText()));
		}
		lore.addAll(ItemHelper.stringToLore(this.description, 35, ChatColor.GRAY));
		if(this.cost > 0) {
			if(!noShow) {
				lore.add(ChatUtils.chat("&8Mana Cost: &3" + this.cost));
			}
		}
		if(this.cooldown > 0) {
			if(!noShow) {
				lore.add(ChatUtils.chat("&8Cooldown: &a" + this.cooldown + "&as."));
			}
		}
		return lore;
	}
}

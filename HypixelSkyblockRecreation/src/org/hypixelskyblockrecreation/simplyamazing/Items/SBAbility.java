package org.hypixelskyblockrecreation.simplyamazing.Items;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.hypixelskyblockrecreation.simplyamazing.Main;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ChatUtils;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ItemHelper;

public class SBAbility {
	private String name;
	private String description;
	private AbilityType type;
	private Method ability;
	private int cooldown;
	
	public SBAbility(final String name, final Method ability, final AbilityType type, final String description) {
		this.cooldown = 0;
		this.name = name;
		ability.setAccessible(true);
		this.ability = ability;
		this.type = type;
		this.description = description;
	}
	
	public SBAbility(final String name, final Method ability, final AbilityType type, final int cooldown, final String description) {
		this.name = name;
		ability.setAccessible(true);
		this.ability = ability;
		this.type = type;
		this.cooldown = cooldown;
		this.description = description;
	}
	
	public void invoke(Player p) {
		this.ability.setAccessible(true);
		try {
			this.ability.invoke(this, p);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			Main.getInstance().getLogger().severe("An item's ability could not be invoked!");
		}
	}
	
	public List<String> toLore(boolean noShow) {
		final List<String> lore = new ArrayList<String>();
		if(!noShow) {
			lore.add(ChatUtils.chat("&6Item Ability: " + this.name + " &e&l" + this.type.getText()));
		}
		lore.addAll(ItemHelper.stringToLore(this.description, 40, ChatColor.GRAY));
		if(this.cooldown > 0) {
			if(!noShow) {
				lore.add(ChatUtils.chat("&8Cooldown: &a" + this.cooldown + "&as."));
			}
		}
		return lore;
	}
}

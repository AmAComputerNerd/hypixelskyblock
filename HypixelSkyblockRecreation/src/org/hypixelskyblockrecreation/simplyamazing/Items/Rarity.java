package org.hypixelskyblockrecreation.simplyamazing.Items;

import org.bukkit.ChatColor;

public enum Rarity {
	COMMON(ChatColor.WHITE),
	UNCOMMON(ChatColor.GREEN),
	RARE(ChatColor.BLUE),
	EPIC(ChatColor.DARK_PURPLE),
	LEGENDARY(ChatColor.GOLD),
	MYTHICAL(ChatColor.LIGHT_PURPLE),
	SPECIAL(ChatColor.RED),
	NONE(ChatColor.GRAY);
	
	private ChatColor color;
	
	private Rarity(final ChatColor color) {
		this.color = color;
	}
	
	public ChatColor getColour() {
		return getColor();
	}
	
	public ChatColor getColor() {
		return this.color;
	}
	
	public static Rarity fromString(String s) {
		if(s == null) {
			return Rarity.NONE;
		}
		switch(s.toLowerCase()) {
			case "c":
			case "common":
				return Rarity.COMMON;
			case "unc":
			case "uncommon":
				return Rarity.UNCOMMON;
			case "r":
			case "rare":
				return Rarity.RARE;
			case "e":
			case "epic":
				return Rarity.EPIC;
			case "l":
			case "legendary":
				return Rarity.LEGENDARY;
			case "m":
			case "mythic":
			case "mythical":
				return Rarity.MYTHICAL;
			case "s":
			case "special":
				return Rarity.SPECIAL;
			default:
				return Rarity.NONE;
		}
	}
	
	public boolean isRarerThan(final Rarity rarity) {
		final int current = this.getIndex();
		final int param = rarity.getIndex();
		return current > param;
	}
	
	private int getIndex() {
		int index = 0;
		for(final Rarity rarity : values()) {
			if(this.equals(rarity)) {
				return index;
			}
			++index;
		}
		return -1;
	}

}

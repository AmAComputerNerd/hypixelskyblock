package org.hypixelskyblockrecreation.simplyamazing.Helpers.Types;

import org.bukkit.inventory.ItemStack;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ChatUtils;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ItemHelper;

public class Stat {
	private StatType stat; // Specify the stat
	private int amount; // The level of the stat
	private boolean hidden; // Whether or not the stat is hidden
	
	public Stat(StatType stat, int amount, boolean hidden) {
		this.stat = stat;
		this.amount = amount;
		this.hidden = hidden;
	}
	
	public ItemStack apply(ItemStack i) {
		if(!(ItemHelper.getNBTValueFromCompound(i, "ExtraAttributes", "stats").equals(""))) {
			String value = ItemHelper.getNBTValueFromCompound(i, "ExtraAttributes", "stats");
			i = ItemHelper.removeNBTValueFromCompound(i, "ExtraAttributes", "stats");
			if(this.hidden) {
				i = ItemHelper.setNBTValueInCompound(i, "ExtraAttributes", "stats", value + ", " + this.stat.toNBT() + " " + amount + " true");
			} else {
				i = ItemHelper.setNBTValueInCompound(i, "ExtraAttributes", "stats", value + ", " + this.stat.toNBT() + " " + amount + " false");
			}
			return i;
		}
		if(this.hidden) {
			i = ItemHelper.setNBTValueInCompound(i, "ExtraAttributes", "stats", this.stat.toNBT() + " " + amount + " true");
		} else {
			i = ItemHelper.setNBTValueInCompound(i, "ExtraAttributes", "stats", this.stat.toNBT() + " " + amount + " false");
		}
		return i;
	}
	
	public String toLore() {
		return ChatUtils.chat(this.stat.toString().replace("/", String.valueOf(amount)));
	}
	
	public StatType getStatType() {
		return this.stat;
	}
	
	public void setStatType(StatType stat) {
		this.stat = stat;
	}
	
	public int getLevel() {
		return this.amount;
	}
	
	public void setLevel(int amount) {
		this.amount = amount;
	}
	
	public boolean isHidden() {
		return this.hidden;
	}
	
	public void setVisibility(boolean hidden) {
		this.hidden = hidden;
	}
}
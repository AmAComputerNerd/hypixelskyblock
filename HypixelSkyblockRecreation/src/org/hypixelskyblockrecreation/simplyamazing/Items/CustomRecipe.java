package org.hypixelskyblockrecreation.simplyamazing.Items;

import java.util.List;

import org.bukkit.inventory.ItemStack;

// The methods and values in this file are taken from the UberItems plugin.
// All thanks goes to them.

public class CustomRecipe {
	private List<ItemStack> components;
	private boolean shapeless;
	private int craftAmount;
	
	public CustomRecipe(final List<ItemStack> components, final boolean shapeless, final int craftAmount) {
		this.components = components;
		this.shapeless = shapeless;
		this.craftAmount = craftAmount;
	}
	
//	public boolean isEqual(final List<ItemStack> items) {
//		for(int counter = 0; counter < items.size(); counter++) {
//			if(items.get(counter) == null) {
//				items.set(counter, new ItemStack(Material.AIR));
//			}
//		}
//		if(!this.shapeless) {
//			for(int counter = 0; counter < this.components.size(); ++counter) {
//				if(!this.isSame(this.components.get(counter), items.get(counter))) {
//					return false;
//				}
//			}
//			return true;
//		}
//		return false;
//	}
	
//	private boolean isSame(final ItemStack i1, final ItemStack i2) {
//		final int UUID = Integer.parseInt(ItemHelper.getNBTValue(i1, "SbUUID"));
//		if(UUID != 0) {
//			return ItemHelper.getMaterialFromID(UUID).compare(i2) && i1.getAmount() <= i2.getAmount();
//		}
//		return i1.getType() == i2.getType() && i1.getAmount() <= i2.getAmount();
//	}
	
	public ItemStack get(final int index) {
		return this.components.get(index);
	}
	
	public int getCraftAmount() {
		return this.craftAmount;
	}

}

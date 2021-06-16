package org.hypixelskyblockrecreation.simplyamazing.Helpers.Types;

import java.util.Arrays;

import org.bukkit.inventory.ItemStack;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ChatUtils;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ItemHelper;
import org.hypixelskyblockrecreation.simplyamazing.Items.Type;

public class Attribute {
	private AttributeType type;
	private String value;
	
	public Attribute(final AttributeType type, final String value) {
		this.type = type;
		if(type.isValidValue(value)) {
			this.value = value;
		} else {
			this.value = type.getDefaultValue();
		}
	}
	
	public ItemStack apply(ItemStack i, Type t) {
		if(!type.canBeAppliedTo(t)) {
			return i;
		}
		if(ItemHelper.getNBTValueFromCompound(i, "ExtraAttributes", this.type.toNBT()) != null) {
			i = ItemHelper.removeNBTValueFromCompound(i, "ExtraAttributes", this.type.toNBT());
		}
		i = ItemHelper.setNBTValueInCompound(i, "ExtraAttributes", type.toNBT(), value);
		return i;
	}
	
	public String toLore() {
		return ChatUtils.chat(this.type.toString().replace("/", value));
	}

}

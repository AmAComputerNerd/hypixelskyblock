package org.hypixelskyblockrecreation.simplyamazing.Helpers.Types;

import java.util.List;
import java.util.Arrays;

import org.apache.logging.log4j.core.util.Integers;
import org.hypixelskyblockrecreation.simplyamazing.Items.Type;

public enum AttributeType {
	BREAKING_POWER("1", Arrays.asList(Type.PICKAXE));
	
	private String defaultValue;
	private List<Type> validItemTypes;
	
	private AttributeType(final String defaultValue, final List<Type> validItemTypes) {
		this.defaultValue = defaultValue;
		this.validItemTypes = validItemTypes;
	}
	
	public String getDefaultValue() {
		return this.defaultValue;
	}
	
	public boolean isValidValue(String s) {
		if(s == null) {
			return false;
		}
		switch(this) {
			case BREAKING_POWER:
				try {
					if(Integers.parseInt(s) > 6 || Integers.parseInt(s) < 1) {
						return false;
					}
					return true;
				} catch(Exception e) {
					return false;
				}
		}
		return false;
	}
	
	public boolean canBeAppliedTo(Type t) {
		if(this.validItemTypes.contains(t)) {
			return true;
		}
		return false;
	}
	
	public String toNBT() {
		switch(this) {
			case BREAKING_POWER:
				return "attr-breaking_power";
			default:
				return "null";
		}
	}
	
	public String toString() {
		switch(this) {
			case BREAKING_POWER:
				return "&8Breaking Power /";
			default:
				return "&cUnknown Attribute: &6/";
		}
	}
	
	public static StatType fromString(String s) {
		if(s == null) {
			return null;
		}
		switch(s.toLowerCase()) {
			case "breakingpower":
			case "breaking_power":
			case "breaking power":
				return StatType.DAMAGE;
			default:
				return null;
		}
	}

}

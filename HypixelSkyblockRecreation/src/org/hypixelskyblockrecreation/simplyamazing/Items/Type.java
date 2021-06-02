package org.hypixelskyblockrecreation.simplyamazing.Items;

public enum Type {
	SWORD,
	BOW,
	SHIELD,
	PICKAXE,
	AXE,
	SHOVEL,
	HOE,
	HELMET,
	CHESTPLATE,
	LEGGINGS,
	BOOTS,
	ITEM,
	NONE;
	
	public static Type fromString(String s) {
		switch(s.toLowerCase()) {
			case "sword":
				return Type.SWORD;
			case "bow":
				return Type.BOW;
			case "shield":
				return Type.SHIELD;
			case "pickaxe":
				return Type.PICKAXE;
			case "axe":
				return Type.AXE;
			case "shovel":
				return Type.SHOVEL;
			case "hoe":
				return Type.HOE;
			case "helmet":
				return Type.HELMET;
			case "chestplate":
				return Type.CHESTPLATE;
			case "leggings":
				return Type.LEGGINGS;
			case "boots":
				return Type.BOOTS;
			case "item":
				return Type.ITEM;
			default:
				return Type.NONE;
		}
	}
}

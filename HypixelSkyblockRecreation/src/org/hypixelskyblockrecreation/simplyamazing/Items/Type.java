package org.hypixelskyblockrecreation.simplyamazing.Items;

public enum Type {
	SWORD,
	BOW,
	SHIELD,
	PICKAXE,
	AXE,
	SHOVEL,
	HOE,
	ROD,
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
			case "rod":
				return Type.ROD;
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
	
	public static String toString(Type t) {
		switch(t) {
			case AXE:
				return " AXE";
			case BOOTS:
				return " BOOTS";
			case BOW:
				return " BOW";
			case CHESTPLATE:
				return " CHESTPLATE";
			case HELMET:
				return " HELMET";
			case HOE:
				return " HOE";
			case ITEM:
				return " ITEM";
			case LEGGINGS:
				return " LEGGINGS";
			case NONE:
				return "";
			case PICKAXE:
				return " PICKAXE";
			case ROD:
				return " FISHING ROD";
			case SHIELD:
				return " SHIELD";
			case SHOVEL:
				return " SHOVEL";
			case SWORD:
				return " SWORD";
			default:
				return "";
		}
	}
}

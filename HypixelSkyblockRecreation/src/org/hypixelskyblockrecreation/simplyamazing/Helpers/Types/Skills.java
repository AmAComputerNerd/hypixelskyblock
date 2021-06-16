package org.hypixelskyblockrecreation.simplyamazing.Helpers.Types;

public enum Skills {
	FARMING,
	MINING,
	COMBAT,
	FORAGING,
	FISHING,
	ENCHANTING,
	ALCHEMY,
	CARPENTRY,
	RUNECRAFTING,
	SOCIAL,
	TAMING;
	
	public Skills fromString(String s) {
		if(s == null) {
			return null;
		}
		switch(s.toLowerCase()) {
			case "farming":
				return Skills.FARMING;
			case "mining":
				return Skills.MINING;
			case "combat":
				return Skills.COMBAT;
			case "foraging":
				return Skills.FORAGING;
			case "fishing":
				return Skills.FISHING;
			case "enchanting":
				return Skills.ENCHANTING;
			case "alchemy":
				return Skills.ALCHEMY;
			case "carpentry":
				return Skills.CARPENTRY;
			case "runecrafting":
				return Skills.RUNECRAFTING;
			case "social":
				return Skills.SOCIAL;
			case "taming":
				return Skills.TAMING;
			default:
				return null;
		}
	}

}

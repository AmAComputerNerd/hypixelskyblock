package org.hypixelskyblockrecreation.simplyamazing.Helpers.Types;

public enum StatType {
	DAMAGE("❁"),
	HEALTH("❤"),
	DEFENSE("❈"),
	STRENGTH("❁"),
	SPEED("✦"),
	CRIT_CHANCE("☣"),
	CRIT_DAMAGE("☠"),
	INTELLIGENCE("✎"),
	MINING_SPEED("⸕"),
	SEA_CREATURE_CHANCE("α"),
	MAGIC_FIND("✯"),
	PET_LUCK("♣"),
	TRUE_DEFENSE("❂"),
	FEROCITY("⫽"),
	ABILITY_DAMAGE("๑"),
	MINING_FORTUNE("☘"),
	FARMING_FORTUNE("☘"),
	FORAGING_FORTUNE("☘");
	
	private String symbol;
	
	private StatType(final String symbol) {
		this.symbol = symbol;
	}
	
	public String getSymbol() {
		return this.symbol;
	}
	
	public String toNBT() {
		switch(this) {
			case DAMAGE:
				return "damage";
			case HEALTH:
				return "health";
			case DEFENSE:
				return "defense";
			case STRENGTH:
				return "strength";
			case SPEED:
				return "speed";
			case CRIT_CHANCE:
				return "crit_chance";
			case CRIT_DAMAGE:
				return "crit_damage";
			case INTELLIGENCE:
				return "intelligence";
			case MINING_SPEED:
				return "mining_speed";
			case SEA_CREATURE_CHANCE:
				return "sea_creature_chance";
			case MAGIC_FIND:
				return "magic_find";
			case PET_LUCK:
				return "pet_luck";
			case TRUE_DEFENSE:
				return "true_defense";
			case FEROCITY:
				return "ferocity";
			case ABILITY_DAMAGE:
				return "ability_damage";
			case FARMING_FORTUNE:
				return "farming_fortune";
			case MINING_FORTUNE:
				return "mining_fortune";
			case FORAGING_FORTUNE:
				return "foraging_fortune";
			default:
				return "null";
		}
	}
	
	public String toString() {
		switch(this) {
			case DAMAGE:
				return "&7Damage: &c+/";
			case HEALTH:
				return "&7Health: &a+/";
			case DEFENSE:
				return "&7Defense: &a+/";
			case STRENGTH:
				return "&7Strength: &c+/";
			case SPEED:
				return "&7Speed: &a+/";
			case CRIT_CHANCE:
				return "&7Crit Chance: &c+/%";
			case CRIT_DAMAGE:
				return "&7Crit Damage: &c+/%";
			case INTELLIGENCE:
				return "&7Intelligence: &a+/";
			case MINING_SPEED:
				return "&7Mining Speed: &a+/";
			case SEA_CREATURE_CHANCE:
				return "&7Sea Creature Chance: &c+/%";
			case MAGIC_FIND:
				return "&7Magic Find: &a+/";
			case PET_LUCK:
				return "&7Pet Luck: &a+/";
			case TRUE_DEFENSE:
				return "&7True Defense: &a+/";
			case FEROCITY:
				return "&7Ferocity: &a+/";
			case ABILITY_DAMAGE:
				return "&7Ability Damage: &c+/%";
			case FARMING_FORTUNE:
				return "&7Farming Fortune: &a+/";
			case MINING_FORTUNE:
				return "&7Mining Fortune: &a+/";
			case FORAGING_FORTUNE:
				return "&7Foraging Fortune: &a+/";
			default:
				return "&7Unknown Stat: &6+/";
		}
	}
	
	public static StatType fromString(String s) {
		if(s == null) {
			return null;
		}
		switch(s.toLowerCase()) {
			case "damage":
				return StatType.DAMAGE;
			case "health":
				return StatType.HEALTH;
			case "defense":
				return StatType.DEFENSE;
			case "strength":
				return StatType.STRENGTH;
			case "speed":
				return StatType.SPEED;
			case "critchance":
			case "crit_chance":
			case "crit chance":
				return StatType.CRIT_CHANCE;
			case "critdamage":
			case "crit_damage":
			case "crit damage":	
				return StatType.CRIT_DAMAGE;
			case "mana":
			case "intelligence":
				return StatType.INTELLIGENCE;
			case "miningspeed":
			case "mining_speed":
			case "mining speed":
				return StatType.MINING_SPEED;
			case "seacreaturechance":
			case "sea_creature_chance":
			case "sea creature chance":
				return StatType.SEA_CREATURE_CHANCE;
			case "magicfind":
			case "magic_find":
			case "magic find":
				return StatType.MAGIC_FIND;
			case "petluck":
			case "pet_luck":
			case "pet luck":
				return StatType.PET_LUCK;
			case "truedefense":
			case "true_defense":
			case "true defense":
				return StatType.TRUE_DEFENSE;
			case "ferocity":
				return StatType.FEROCITY;
			case "abilitydamage":
			case "ability_damage":
			case "ability damage":
				return StatType.ABILITY_DAMAGE;
			case "farmingfortune":
			case "farming_fortune":
			case "farming fortune":
				return StatType.FARMING_FORTUNE;
			case "miningfortune":
			case "mining_fortune":
			case "mining fortune":
				return StatType.MINING_FORTUNE;
			case "foragingfortune":
			case "foraging_fortune":
			case "foraging fortune":
				return StatType.FORAGING_FORTUNE;
			default:
				return null;
		}
	}
	
	// Deprecated because multiple stats have the same symbol, unreliable way to get some stats.
	@Deprecated
	public static StatType fromSymbol(String s) {
		if(s == null) {
			return null;
		}
		switch(s) {
			case "❁":
				return StatType.DAMAGE;
			case "❤":
				return StatType.HEALTH;
			case "❈":
				return StatType.DEFENSE;
			case "✦":
				return StatType.SPEED;
			case "☣":
				return StatType.CRIT_CHANCE;
			case "☠":
				return StatType.CRIT_DAMAGE;
			case "✎":
				return StatType.INTELLIGENCE;
			case "⸕":
				return StatType.MINING_SPEED;
			case "α":
				return StatType.SEA_CREATURE_CHANCE;
			case "✯":
				return StatType.MAGIC_FIND;
			case "♣":
				return StatType.PET_LUCK;
			case "❂":
				return StatType.TRUE_DEFENSE;
			case "⫽":
				return StatType.FEROCITY;
			case "๑":
				return StatType.ABILITY_DAMAGE;
			case "☘":
				return StatType.FARMING_FORTUNE;
			default:
				return null;
		}
	}
}
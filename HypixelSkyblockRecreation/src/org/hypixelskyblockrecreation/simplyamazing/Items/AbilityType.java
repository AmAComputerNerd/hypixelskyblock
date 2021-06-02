package org.hypixelskyblockrecreation.simplyamazing.Items;

public enum AbilityType {
	LEFT_CLICK("LEFT CLICK"),
	RIGHT_CLICK("RIGHT CLICK"),
	MIDDLE_CLICK("MIDDLE CLICK"),
	NONE("");
	
	private String text;
	
	private AbilityType(final String text) {
		this.text = text;
	}
	
	public String getText() {
		return this.text;
	}
}

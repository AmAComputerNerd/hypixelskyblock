package org.hypixelskyblockrecreation.simplyamazing.Helpers;

import java.util.ArrayList;

import org.bukkit.Material;
import org.hypixelskyblockrecreation.simplyamazing.Main;
import org.hypixelskyblockrecreation.simplyamazing.Items.Rarity;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBAbility;
import org.hypixelskyblockrecreation.simplyamazing.Items.Type;
import org.hypixelskyblockrecreation.simplyamazing.Items.SBItems.skyblock_menu;

public class RegisterItems {
	
	public static void registerSkyBlockItems() {
		Main.putItem("skyblock_menu", new skyblock_menu(Material.NETHER_STAR, "&aSkyBlock Menu &7(Right Click)", "View all of your SkyBlock progress, including your Skills, Collections, Recipes and more! /n /n &eClick to open!", Rarity.NONE, Type.NONE, false, false, new ArrayList<SBAbility>(), null));
	}

}

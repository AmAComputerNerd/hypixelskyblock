package org.hypixelskyblockrecreation.simplyamazing;

import org.bukkit.plugin.java.JavaPlugin;
import org.hypixelskyblockrecreation.simplyamazing.Commands.SkyBlockMenu;
import org.hypixelskyblockrecreation.simplyamazing.Menus.MenuClickListener;

public class Main extends JavaPlugin {
	private static Main inst;
	
	public static Main getInstance() {
		return inst;
	}
	
	@Override
	public void onEnable() {
		inst = this;
		new SkyBlockMenu(this);
		new MenuClickListener(this);
	}
	
	@Override
	public void onDisable() {
		
	}

}

package org.hypixelskyblockrecreation.simplyamazing.Helpers.Types;

import java.io.IOException;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.hypixelskyblockrecreation.simplyamazing.Main;
import org.hypixelskyblockrecreation.simplyamazing.Commands.Coins;
import org.hypixelskyblockrecreation.simplyamazing.Commands.GiveAllItems;
import org.hypixelskyblockrecreation.simplyamazing.Commands.Item;
import org.hypixelskyblockrecreation.simplyamazing.Commands.Material;
import org.hypixelskyblockrecreation.simplyamazing.Commands.SBSkills;
import org.hypixelskyblockrecreation.simplyamazing.Commands.SkillTest;
import org.hypixelskyblockrecreation.simplyamazing.Commands.SkyBlockMenu;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ChatUtils;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Commands;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.Utilities;

public abstract class SkyBlockCommand implements CommandExecutor, TabCompleter {
	private final String cmd;
	private final String usage;
	private final String perm;
	private final boolean canConsoleUse;
	
	private static Main plugin = Main.getInstance();
	
	public SkyBlockCommand(final String cmd, final String usage, final String perm, final boolean canConsoleUse) {
		this.cmd = cmd;
		this.usage = usage;
		this.perm = perm;
		this.canConsoleUse = canConsoleUse;
		try {
			Commands.registerCommand(cmd, usage);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			plugin.getCommand(cmd).setExecutor(this);
		} catch(NullPointerException e) {
			plugin.getLogger().warning("The command '/" + cmd + "' is not registered in the plugin.yml! It has not been loaded.");
		}
	}
	
	public final static void registerCommands(Main p) {
		plugin = p;
		new Coins();
		new GiveAllItems();
		new Item();
		new Material();
		new SBSkills();
		new SkillTest();
		new SkyBlockMenu();
	}
	
	public abstract boolean execute(CommandSender sender, String[] args);
	
	public abstract List<String> tabComplete(CommandSender sender, String[] args);
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!cmd.getLabel().equalsIgnoreCase(this.cmd)) {
			return false;
		}
		if(this.perm == null) {} else {
			if(this.perm.equals("")) {} else {
				if(Utilities.enforcePermissions(sender, this.perm)) {
					return false;
				}
			}
		}
		
		if(!canConsoleUse && !(sender instanceof Player)) {
			sender.sendMessage(ChatUtils.chat("&cOnly players can use this command!"));
			return false;
		}
		execute(sender, args);
		return true;
	}
	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		return tabComplete(sender, args);
	}
	
}

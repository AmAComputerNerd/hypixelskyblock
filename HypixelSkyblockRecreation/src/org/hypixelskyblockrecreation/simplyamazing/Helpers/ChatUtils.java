package org.hypixelskyblockrecreation.simplyamazing.Helpers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;

public class ChatUtils {
	
	public static String chat(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
	
	public static List<String> chat(List<String> lore){
        List<String> clore = new ArrayList<>();
        for(String s : lore){
            clore.add(chat(s));
        }
        return clore;
    }

}

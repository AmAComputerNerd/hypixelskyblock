package org.hypixelskyblockrecreation.simplyamazing.Helpers;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Base64;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.block.Block;
import org.bukkit.block.Skull;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

public class SkullHelper {
	
	// some reflection stuff to be used when setting a skull's profile
	private static Field blockProfileField;
	private static Method metaSetProfileMethod;
	private static Field metaProfileField;
	
	public static ItemStack createSkull() {
		return new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
	}
	
	// Custom head skull-retrieval
	@Deprecated
	public static ItemStack getSkullFromName(String name) {
		return modifySkullWithName(createSkull(), name);
	}
		
	public static ItemStack getSkullFromUUID(UUID id) {
		return modifySkullWithUUID(createSkull(), id);
	}
	
	public static ItemStack getSkullFromURL(String url) {
		return modifySkullWithURL(createSkull(), url);
	}
		
	public static ItemStack getSkullFromBase64(String base64) {
		return modifySkullWithBase64(createSkull(), base64);
	}
		
	@Deprecated
	public static ItemStack modifySkullWithName(ItemStack item, String name) {
		notNull(item, "item");
		notNull(name, "name");
		
		SkullMeta meta = (SkullMeta) item.getItemMeta();
		meta.setOwner(name);
		item.setItemMeta(meta);
			
		return item;
	}
		
	public static ItemStack modifySkullWithUUID(ItemStack item, UUID id) {
		notNull(item, "item");
		notNull(id, "id");
		
		SkullMeta meta = (SkullMeta) item.getItemMeta();
		meta.setOwningPlayer(Bukkit.getOfflinePlayer(id));
		item.setItemMeta(meta);
		
		return item;
	}
		
	public static ItemStack modifySkullWithURL(ItemStack item, String url) {
		notNull(item, "item");
		notNull(url, "url");
		
		return modifySkullWithBase64(item, urlToBase64(url));
	}
		
	public static ItemStack modifySkullWithBase64(ItemStack item, String base64) {
		notNull(item, "item");
		notNull(base64, "base64");
		
		if(!(item.getItemMeta() instanceof SkullMeta)) {
			return null;
		}
		SkullMeta meta = (SkullMeta) item.getItemMeta();
		mutateItemMeta(meta, base64);
		item.setItemMeta(meta);
		
		return item;
	}
		
	@Deprecated
	public static void modifyPlacedSkullWithName(Block b, String name) {
		notNull(b, "block");
		notNull(name, "name");
			
		Skull state = (Skull) b.getState();
		state.setOwningPlayer(Bukkit.getOfflinePlayer(name));
		state.update(false, false);
	}
		
	public static void modifyPlacedSkullWithUUID(Block b, UUID id) {
		notNull(b, "block");
		notNull(id, "id");
		
		setToSkull(b);
		Skull state = (Skull) b.getState();
		state.setOwningPlayer(Bukkit.getOfflinePlayer(id));
		state.update(false, false);
	}

	public static void modifyPlacedSkullWithUrl(Block b, String url) {
		notNull(b, "block");
		notNull(url, "url");
			
		modifyPlacedSkullWithBase64(b, urlToBase64(url));
	}
		
	public static void modifyPlacedSkullWithBase64(Block b, String base64) {
		notNull(b, "block");
		notNull(base64, "base64");
			
		setToSkull(b);
		Skull state = (Skull) b.getState();
		mutateBlockState(state, base64);
	}
		
	private static void setToSkull(Block b) {
		b.setType(Material.valueOf("SKULL"), false);
		Skull state = (Skull) b.getState();
		state.setSkullType(SkullType.PLAYER);
		state.update(false, false);
	}
		
	private static void notNull(Object o, String name) {
		if(o == null) {
			throw new NullPointerException(name + " should not be null!");
		}
	}
		
	private static String urlToBase64(String url) {
		URI actualUrl;
		try {
			actualUrl = new URI(url);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
		String toEncode = "{\"textures\":{\"SKIN\":{\"url\":\"" + actualUrl.toString() + "\"}}}";
		return Base64.getEncoder().encodeToString(toEncode.getBytes());
	}
		
	private static GameProfile makeProfile(String b64) {
		UUID id = new UUID(
				b64.substring(b64.length() - 20).hashCode(),
				b64.substring(b64.length() - 10).hashCode()
		);
		GameProfile profile = new GameProfile(id, "Player");
		profile.getProperties().put("textures", new Property("textures", b64));
		return profile;
	}
		
	private static void mutateBlockState(Skull block, String b64) {
		try {
			if(blockProfileField == null) {
				blockProfileField = block.getClass().getDeclaredField("profile");
				blockProfileField.setAccessible(true);
			}
			blockProfileField.set(block, makeProfile(b64));
		} catch(NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	private static void mutateItemMeta(SkullMeta meta, String b64) {
		try {
			if(metaSetProfileMethod == null) {
				metaSetProfileMethod = meta.getClass().getDeclaredMethod("setProfile", GameProfile.class);
				metaSetProfileMethod.setAccessible(true);
			}
			metaSetProfileMethod.invoke(meta, makeProfile(b64));
		} catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			// Used if the older api is used where there is no setProfile method
			try {
				if(metaProfileField == null) {
					metaProfileField = meta.getClass().getDeclaredField("profile");
					metaProfileField.setAccessible(true);
				}
				metaProfileField.set(meta, makeProfile(b64));
			} catch(NoSuchFieldException | IllegalAccessException e2) {
				e2.printStackTrace();
			}
		}
	}

}

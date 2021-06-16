package org.hypixelskyblockrecreation.simplyamazing.Menus;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ChatUtils;
import org.hypixelskyblockrecreation.simplyamazing.Helpers.ItemHelper;

public class CraftingTableGUI {
	// Not ready for use as of yet.
	public static final ItemStack EMPTY_SLOT_ITEM;
	public static final ItemStack NO_QUICK_CRAFTING;
	public static final ItemStack CRAFTING_SLOT_ITEM;
	public static final ItemStack CLOSE_MENU;
	public static final List<ItemStack> customItems;
	public static final List<Integer> CUSTOM_CRAFTING_MENU_EXCEPTIONS;
	public static final List<InventoryAction> validCraftActions;
	
	public static String getTitle() {
		return "Craft Item";
	}
	
//	private static HashMap<ItemStack, String> drawInventory(HashMap<ItemStack, String> inv, Player p) {
//		for(int counter = 0; counter < 45; ++counter) {
//			if(!CraftingTableGUI.CUSTOM_CRAFTING_MENU_EXCEPTIONS.contains(counter)) {
//				inv.put(CraftingTableGUI.EMPTY_SLOT_ITEM, String.valueOf(counter));
//			}
//		}
//		inv.put(CraftingTableGUI.CRAFTING_SLOT_ITEM, "23");
//		inv.put(CraftingTableGUI.CLOSE_MENU, "23");
//	}
	
	static {
		EMPTY_SLOT_ITEM = nameItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)15), "");
		NO_QUICK_CRAFTING = nameItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)14), "&cQuickCrafting is locked!");
		CRAFTING_SLOT_ITEM = ItemHelper.loreItem(nameItem(new ItemStack(Material.BARRIER), "&cRecipe Required"), Arrays.asList("&7Add the items for a valid recipe", "&7in the crafting grid to the", "&7left!"));
		CLOSE_MENU = nameItem(new ItemStack(Material.BARRIER), "&cClose");
		customItems = Arrays.asList(CraftingTableGUI.EMPTY_SLOT_ITEM, CraftingTableGUI.NO_QUICK_CRAFTING, CraftingTableGUI.CRAFTING_SLOT_ITEM, CraftingTableGUI.CLOSE_MENU);
		CUSTOM_CRAFTING_MENU_EXCEPTIONS = Arrays.asList(10, 11, 12, 19, 20, 21, 28, 29, 30, 23);
		validCraftActions = Arrays.asList(InventoryAction.PICKUP_ALL, InventoryAction.MOVE_TO_OTHER_INVENTORY);
	}
	
	private static ItemStack nameItem(ItemStack i, String name) {
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(ChatUtils.chat(name));
		i.setItemMeta(meta);
		return i;
	}
}

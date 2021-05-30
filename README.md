Instructions:

  FOR CODE:
    - The code was compiled in eclipse, so this is the easiest option when it comes to editing the code. Simply close your Eclipse, find the eclipse-workspace folder (Usually in
    C:/Users/your-username/eclipse-workspace) and paste the "HypixelSkyblock" folder.
  
  FOR SETUP:
    - Place the 'HypixelSkyblock.jar' file into the plugins folder of a 1.12.2 server. Running the command '/skyblockmenu' or '/sbm' will open the menu.
    
  NOTE:
  
  This project is for personal use only. Hypixel SkyBlock is the copywrite of Hypixel, and you shall not use this plugin as a method to recreate SkyBlock to steal
  Hypixel's playerbase. This is a very early development release, and as such the only features right now are the Skills page, which itself still has a lot missing.
  You are free to make new menus with the code already provided as a starting point. To learn how to do this, refer to the section below and the existing code:
  
  ---------------------------------------------------------------------------------
  
  SETTING UP NEW INVENTORIES
  
  To start making a new inventory, you must make a new file that has the following methods:
  
    public static String getTitle() {}

    public static HashMap<ItemStack, String> drawInventory(HashMap<ItemStack, String> inv, Player p) {}

    public static HashMap<ItemStack, String> getInventoryFormat(Player p) {}
    
    public static void clicked(Player p, int slot, ItemStack i, Inventory inv) {}

  Each of the methods is used to construct the inventory. The getTitle() method only needs to return the title of the inventory, e.g.:
    
    public static String getTitle() {
      return "SkyBlock Menu";
    }
  
  The drawInventory() method is used to add a list of every item you want inside the inventory to a list, which it returns to the getInventoryFormat() method. You can use the Inventories.buildItem() method to make new items easily, and assign it to an ItemStack variable. You then add it to the list provided to the method, usually named inv, along with the slot you want the item in (minus 1 because of the way lists are numbered in java). All slots that aren't specified here are automatically filled with a filler item, so if you want an empty slot make sure to make an item with the Material AIR. For example:

    public static HashMap<ItemStack, String> drawInventory(HashMap<ItemStack, String> inv, Player p) {
      // Create the Your Skills button
      ItemStack skills = Inventories.buildItem(Material.DIAMOND_SWORD, 1, "&aYour Skills", new ArrayList<String>(ChatUtils.chat(Arrays.asList("&aTest"))));
      inv.put(skills, "5"); // Put the skills item you just built in the 4th slot.
      // After adding all the other items...
      return inv;
    }
    
  The getInventoryFormat() method is used to return the custom items inside the inventory to the InventoryBuilder. It only requires the following code:
    
    public static HashMap<ItemStack, String> getInventoryFormat(Player p) {
      HashMap<ItemStack, String> toReturn = drawInventory(new HashMap<ItemStack, String>(), p);
      return toReturn;
    }
    
  Finally, the clicked() method is used by the MenuClickListener to decide what actions occur by clicking which button. e.g.

    public static void clicked(Player p, int slot, ItemStack i, Inventory inv) {
      if(i.getItemMeta().getDisplayName().equals(ChatUtils.chat("&cClose"))) {
        p.closeInventory();
      }
    }

  Once all your inventory file methods are finished, to open the inventory to a player, simply call the openInventory() method on a Player with the following arguments.

    // Assuming your inventory is called file-name...
    p.openInventory(file-name.getTitle(), 6, file-name.getInventoryFormat(p));

  ---------------------------------------------------------------------------------

  PERFORMING ACTIONS UPON CLICKING AN ITEM

  To start using this feature, you must first go to the file titled 'MenuClickListener' and add the following line of code to the end of the last else if():
     
    // Assuming your inventory is called file-name...
    } else if(e.getView().getTitle().equals(ChatUtils.chat(file-name.getTitle()))) {
       e.setCancelled(true); // Stop the player from taking an item out of the menu
       file-name.clicked(p, slot, i, inv);
    }

  After this inclusion, you can control what button does what through using the slot clicked, information about the item clicked, etc.

    // Example of using a slot to make a button close the menu
    if(slot.equals(5)) {
      p.closeInventory();
    }

  And your done! More will be coming soon.
  

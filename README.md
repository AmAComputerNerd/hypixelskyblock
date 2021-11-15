**Instructions:**
---------------------------------------------------------------------------------

  FOR CODE:
    - The code was compiled in eclipse, so this is the easiest option when it comes to editing the code. Simply close your Eclipse, find the eclipse-workspace folder (Usually in
    C:/Users/your-username/eclipse-workspace) and paste the "HypixelSkyblock" folder.
  
  FOR SETUP:
    - Place the 'HypixelSkyblock.jar' file into the plugins folder of a 1.12.2 server, alongside the dependencies located in the 'dep' folder. Running the command '/skyblockmenu' or '/sbm' will open the menu.
    
  #### NOTE:
  
  This project is for personal use only. Hypixel SkyBlock is the copywrite of Hypixel, and you shall not use this plugin as a method to recreate SkyBlock to steal
  Hypixel's playerbase. This is a very early release of my plugin, and as such currently has very limited features and some bugs.
  You **are** allowed to edit the code to add new items, inventories, command, and listeners, but you are **forbidden** to edit the code of existing commands, listeners and   other files except to register new commands, or register a new item. To learn how to do this, refer to the code and the sections below.
  
  ---------------------------------------------------------------------------------
  
  ### CREATING NEW ITEMS
  
  To make a new SkyBlock item, you must navigate to the Items / SBItems subpackage and create a new class under whatever rarity it is. You should name this class (in lowercase, replacing the spaces with underscores) the name of the item. You can refer to the existing items if you are confused about how to name your item class. Once it is created, you should make sure the class `extends SkyBlockItem`. You should add the missing constructor when prompted to do so, and edit it so it looks like below:
  
    public class your_item extends SkyBlockItem {
        public your_item(Material material, String displayName, String description, Rarity rarity, Type type, boolean stackable, boolean oneTimeUse, List<SBAbility> abilities, CustomRecipe craftingRecipe) {
          // Notice how I removed the `String sbName` and `List<Stat> stats` from the constructor. Instead, I define it here in the file
          super(material, "YOUR_ITEM_IN_CAPS", displayName, description, rarity, type, stackable, oneTimeUse, abilities, Arrays.asList(new Stat(StatType.DAMAGE, 200, false), new Stat(StatType.STRENGTH, 100, false)), craftingRecipe);
        }
    }
  
  Once you have made your constructer, add the missing methods and fill them in as desired - these are the abilities, and they trigger based on certain actions. After this, you need to register your new item. Go to Helpers / RegisterItems.class, and add a new value to the registerSkyBlockItems() method. Refer to the other values for what argument does what. When it's registered, after exporting the plugin, it will now be available to get using the /item command!
  
  ---------------------------------------------------------------------------------
  
  ### SETTING UP NEW INVENTORIES
  
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
    p.openInventory(Inventories.build(file-name.getTitle(), 6, file-name.getInventoryFormat(p)));

  ---------------------------------------------------------------------------------

  ### PERFORMING ACTIONS UPON CLICKING AN ITEM

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

  And your done!
  
  ---------------------------------------------------------------------------------

  ### USING CUSTOM SKULLS

  The code has a helper inside that can be used to make custom skulls. There are a multitude of ways to get a custom head, however. The easiest way is to use a player's name to get their head:
  
    // This is a valid way to do this, but it is also deprecated.
    Player p = (Player) sender;
    ItemStack item = SkullHelper.getSkullFromName(p.getName());

  While this *is* a valid option, this is also a deprecated option. This means that it is no longer supported, and may be buggy - not to mention the fact that the method used to get a skull by name will likely be removed by Spigot in the near future. The next easiest, and non-deprecated way to get a player's head is using their UUID:

    // This is a better way to get a head, and is more reliable
    Player p = (Player) sender;
    ItemStack item = SkullHelper.getSkullFromUUID(p.getUniqueId());
    
  What about when you want to set a skull to have the texture of a skin you found on minecraftskins.com, however? While you could try to find an account with this skin active, the library also has included an option to use a URL to retrieve a custom head:

    Player p = (Player) sender;
    ItemStack item = SkullHelper.getSkullFromURL("https://www.minecraftskins.com/uploads/skins/2021/05/29/-*tippidytoppidy*--17961371.png?v399")

 Finally, if you are trying to recreate an item from a menu, but you don't know the name of the player, the final option is to use it's base64 tag to get the skin. To find this, you can search 'NBT viewer minecraft mod' on Google to get the mod required. Once you have it, and are hovering over a head in a menu, copying the value under the tag "Value" is the base64 id for that skin. You can use this to get the custom head by using:

    Player p = (Player) sender;
    ItemStack item = SkullHelper.getSkullFromBase64("copy it here");

 That's all!

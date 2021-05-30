Instructions:

  FOR CODE:
    - The code was compiled in eclipse, so this is the easiest option when it comes to editing the code. Simply close your Eclipse, find the eclipse-workspace folder (Usually in
    C:/Users/your-username/eclipse-workspace) and paste the "HypixelSkyblock" folder.
  
  FOR SETUP:
    - Place the 'HypixelSkyblock.jar' file into the plugins folder of a 1.12.2 server. Running the command '/skyblockmenu' or '/sbm' will open the menu.
    
  NOTE:
  
  This project is for personal use only. Hypixel SkyBlock is the copywrite of Hypixel, and you shall not use this plugin as a method to recreate SkyBlock to steal
  Hypixel's playerbase. This is a very early development release, and as such the only features right now are the Skills page, which itself still has a lot missing.
  You are free to make new menus with the code already provided as a starting point, making sure that when you add a new menu you add the following to the
  'MenuClickListener.class' file:

  if(e.getView().getTitle().equals(ChatUtils.chat(file-name.getTitle())) {
    e.setCancelled(true); // Cancel the click so the item can't be stolen from the gui
    file-name.clicked(p, slot, i, inv); // Refer to the file's method clicked() which specifies what to do when you click on an item.
  }

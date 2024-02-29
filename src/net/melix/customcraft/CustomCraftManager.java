package net.melix.customcraft;

import cn.nukkit.plugin.PluginBase;

public class CustomCraftManager extends PluginBase {

    public final static String CHEST_ID = "§C§R§A§F§T§-§C§U§S§T§O§M";
    public final static String TITLE = "§8Дополнительные крафты";

    @Override
    public void onLoad() {
        CustomCraftList.init();
    }

    public void onEnable(){
        this.getServer().getCommandMap().register("newcraft", new CustomCraftCommand("newcraft"));
        this.getServer().getPluginManager().registerEvents(new CustomCraftListener(), this);
    }


}

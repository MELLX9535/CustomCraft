package net.melix.customcraft;

import cn.nukkit.Server;
import cn.nukkit.inventory.CraftingManager;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import net.melix.anarchregion.item.RegionItemManager;

import java.util.*;

public class CustomCraftList {

    private static final Map<String, CustomCraft> crafts = new LinkedHashMap<>();

    public static void init() {
        CustomShapedRecipe[] shapedRecipes = new CustomShapedRecipe[]{
                new CustomShapedRecipe(RegionItemManager.getLevelItemKey(1), new String[]{
                        "GGG",
                        "GBG",
                        "GGG"
                }, new HashMap<>() {{
                    put('B', Item.get(Item.GOLD_BLOCK));
                    put('G', Item.get(Item.GOLD_INGOT));
                }}),

                new CustomShapedRecipe(Item.get(ItemID.ELYTRA), new String[]{
                        "FSF",
                        "F F",
                        "F F"
                }, new HashMap<>(){{
                    put('F', Item.get(Item.FEATHER));
                    put('S', Item.get(Item.NETHER_STAR));
                }}),

                new CustomShapedRecipe(Item.get(ItemID.ELYTRA), new String[]{
                        "GIG",
                        "IEI",
                        "GIG"
                }, new HashMap<>(){{
                    put('G', Item.get(Item.GOLD_BLOCK));
                    put('I', Item.get(Item.IRON_INGOT));
                    put('E', Item.get(Item.EMERALD));
                }})
        };

        CraftingManager craftingManager = Server.getInstance().getCraftingManager();
        for (CustomShapedRecipe recipe : shapedRecipes) {
            CustomCraft craft = new CustomCraft(recipe);
            crafts.put(recipe.getItemResultHash(), craft);

            craftingManager.registerRecipe(recipe.toShapedRecipe());
        }
        craftingManager.rebuildPacket();
    }

    public static Map<String, CustomCraft> getCrafts() {
        return crafts;
    }

}

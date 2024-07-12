package net.melix.customcraft;

import cn.nukkit.Server;
import cn.nukkit.inventory.CraftingManager;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemNetheriteUpgradeSmithingTemplate;
import net.melix.anarchregion.item.RegionItemManager;
import net.melix.bottleexp.BottleEXP;

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

                new CustomShapedRecipe(Item.get(ItemID.TOTEM), new String[]{
                        "GIG",
                        "IEI",
                        "GIG"
                }, new HashMap<>(){{
                    put('G', Item.get(Item.GOLD_BLOCK));
                    put('I', Item.get(Item.DIAMOND));
                    put('E', Item.get(Item.EMERALD_BLOCK));
                }}),
                new CustomShapedRecipe(Item.get(ItemID.TRIDENT), new String[]{
                        " SS",
                        " TS",
                        "T  "
                }, new HashMap<>(){{
                    put('S', Item.get(Item.DIAMOND_SWORD));
                    put('T', Item.get(Item.STICK));
                }}),

                new CustomShapedRecipe(Item.get(ItemID.SPYGLASS), new String[]{
                        "ISI",
                        "G G",
                        "GSG"
                }, new HashMap<>(){{
                    put('I', Item.get(Item.IRON_INGOT));
                    put('G', Item.get(Item.GOLD_INGOT));
                    put('S', Item.get(Item.GLASS_PANE));
                }}),

                new CustomShapedRecipe(BottleEXP.getBottleEXP(), new String[]{
                        "GDG",
                        "GPG",
                        "GFG"
                }, new HashMap<>(){{
                    put('G', Item.get(371));
                    put('D', Item.get(Item.DIAMOND));
                    put('P', Item.get(373));
                    put('F', Item.get(377));
                }}),

                new CustomShapedRecipe(new ItemNetheriteUpgradeSmithingTemplate(), new String[]{
                        "DND",
                        "NBN",
                        "DND"
                }, new HashMap<>(){{
                    put('N', Item.get(Item.NETHERITE_INGOT));
                    put('D', Item.get(Item.DIAMOND_BLOCK));
                    put('B', Item.get(Item.BOOK));
                }}),
        };

        CraftingManager craftingManager = Server.getInstance().getCraftingManager();
        for (CustomShapedRecipe recipe : shapedRecipes) {
            CustomCraft craft = new CustomCraft(recipe);

            craftingManager.registerRecipe(313, recipe.toShapedRecipe());
            craftingManager.registerRecipe(332, recipe.toShapedRecipe());
            craftingManager.registerRecipe(388, recipe.toShapedRecipe());
            craftingManager.registerRecipe(419, recipe.toShapedRecipe());
            craftingManager.registerRecipe(527, recipe.toShapedRecipe());
            craftingManager.registerRecipe(649, recipe.toShapedRecipe());

            crafts.put(recipe.getItemResultHash(), craft);
        }
        craftingManager.rebuildPacket();
    }

    public static Map<String, CustomCraft> getCrafts() {
        return crafts;
    }

}

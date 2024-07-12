package net.melix.customcraft;

import cn.nukkit.inventory.Inventory;
import cn.nukkit.item.Item;

public class CustomCraft {

    private final CustomShapedRecipe recipe;

    public CustomCraft(CustomShapedRecipe recipe){
        this.recipe = recipe;
    }

    public void setInventoryCraft(Inventory inventory){
        //select item slot
        inventory.setItem(15, this.getRecipe().getItemResult());

        int levelPage = 1;
        for (String level : this.getRecipe().getShape()){

            String fixLevel = this.fixLevel(level);

            for (int page = 1; page < fixLevel.length() + 1; page++){
                char currentChar = fixLevel.charAt(page - 1);
                if(currentChar == ' '){
                    inventory.setItem(this.getSlotPageLevel(levelPage, page), Item.get(0));
                    continue;
                }
                Item charItem = this.getCharItem(currentChar);
                inventory.setItem(this.getSlotPageLevel(levelPage, page), charItem);
            }
            levelPage++;
        }
    }

    private int getSlotPageLevel(int levelPage, int page){
        return switch (levelPage){
            case 1 -> (1 + page);
            case 2 -> (10 + page);
            case 3 -> (19 + page);
            default -> throw new IllegalStateException("Unexpected value: " + levelPage);
        };
    }

    private Item getCharItem(char symbol){
        return this.recipe.getIngredients().get(symbol);
    }

    private String fixLevel(String level){
        StringBuilder levelBuilder = new StringBuilder(level);
        levelBuilder.append(" ".repeat(Math.max(0, (3 - levelBuilder.length()))));
        return levelBuilder.toString();
    }

    public CustomShapedRecipe getRecipe(){
        return this.recipe;
    }
}

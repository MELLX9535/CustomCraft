package net.melix.customcraft;

import cn.nukkit.inventory.ShapedRecipe;
import cn.nukkit.item.Item;

import java.util.Collections;
import java.util.Map;

public class CustomShapedRecipe {

    private final Item itemResult;
    private final String[] shape;
    private final Map<Character, Item> ingredients;

    public CustomShapedRecipe(Item itemResult, String[] shape, Map<Character, Item> ingredients){
        this.itemResult = itemResult;
        this.shape = shape;
        this.ingredients = ingredients;
    }

    public Item getItemResult(){
        return this.itemResult;
    }

    public String getItemResultHash(){
        return this.getItemResult().toString();
    }

    public String[] getShape(){
        return this.shape;
    }

    public Map<Character, Item> getIngredients(){
        return this.ingredients;
    }

    public ShapedRecipe toShapedRecipe(){
        return new ShapedRecipe(null, 1, this.getItemResult(), this.getShape(), this.getIngredients(), Collections.emptyList());
    }


}

package net.melix.customcraft;

import cn.nukkit.Player;
import cn.nukkit.block.BlockID;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.item.Item;
import net.soulmc.inventory.ChestFakeInventory;

import java.util.Map;

public class CustomCraftCommand extends Command {
    public CustomCraftCommand(String name) {
        super(name, "§bДополнительные крафты сервера");
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        if (commandSender instanceof Player player) {
            final ChestFakeInventory chest = new ChestFakeInventory(null, CustomCraftManager.CHEST_ID + " " + CustomCraftManager.TITLE);

            int slot = 1;
            int upper = 6;
            for (Map.Entry<String, CustomCraft> craftData : CustomCraftList.getCrafts().entrySet()) {
                if (slot % upper == 0) {
                    slot += 4;
                    upper += 9;//width chest
                }

                CustomShapedRecipe recipe = craftData.getValue().getRecipe();
                int currentSlot = (slot - 1);
                chest.setItem(currentSlot, recipe.getItemResult());

                slot++;
            }

            //BARRIER
            chest.setItem(5, Item.get(BlockID.INVISIBLE_BEDROCK));
            chest.setItem(14, Item.get(BlockID.INVISIBLE_BEDROCK));
            chest.setItem(23, Item.get(BlockID.INVISIBLE_BEDROCK));


            player.addWindow(chest);
        }
        return false;
    }
}

package net.melix.customcraft;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;

import cn.nukkit.item.Item;
import net.soulmc.inventory.FakeInventory;
import net.soulmc.inventory.FakeSlotChangeEvent;

public class CustomCraftListener implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onClick(final FakeSlotChangeEvent event) {
        final FakeInventory inventory = event.getInventory();
        if (!inventory.getTitle().split(" ")[0].equals(CustomCraftManager.CHEST_ID)) return;

        event.setCancelled();

        Item itemClick = inventory.getItem(event.getAction().getSlot());

        if(itemClick.getId() == 0) return;
        String hash = itemClick.toString();
        CustomCraft craft = CustomCraftList.getCrafts().get(hash);

        if(craft == null) return;

        craft.setInventoryCraft(inventory);
    }

}

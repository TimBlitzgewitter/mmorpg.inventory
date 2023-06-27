package de.squeezzy.playerinventory.inventories;

import de.squeezzy.playerinventory.items.PlayerInventoryItems;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

public class PlayerJoinInventory {

    PlayerInventoryItems playerInventoryItems = new PlayerInventoryItems();



    public void openInventory(Player p) {

        PlayerInventory inv = p.getInventory();
        inv.setItem(7, playerInventoryItems.openInventory());

    }
}

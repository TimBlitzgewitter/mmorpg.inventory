package de.squeezzy.playerinventory.items.allitems;

import de.squeezzy.playerinventory.PlayerInventory;
import de.squeezzy.playerinventory.model.PlayerInventoryModel;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemList {
    Items items = new Items();

    public ArrayList<ItemStack> itemList() {

        ArrayList<ItemStack> list = new ArrayList<>();
            //item 0
            list.add(items.air());
            //items
            list.add(items.woodensword());
            list.add(items.stonesword());
            list.add(items.stick());
            list.add(items.weapons());


        return list;
    }
}

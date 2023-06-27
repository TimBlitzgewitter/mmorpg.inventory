package de.squeezzy.playerinventory.inventories;

import de.squeezzy.playerinventory.PlayerInventory;
import de.squeezzy.playerinventory.database.SaveInventoryInDB;
import de.squeezzy.playerinventory.items.PlayerInventoryItems;
import de.squeezzy.playerinventory.items.allitems.ItemList;
import de.squeezzy.playerinventory.items.allitems.Items;
import de.squeezzy.playerinventory.model.PlayerInventoryModel;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.sql.SQLException;

public class PlayerInventoryInventory {

    private final PlayerInventory plugin;

    public PlayerInventoryInventory(PlayerInventory plugin) {
        this.plugin = plugin;
    }

    Items items = new Items();

    public Inventory defaultInventory() {

        Inventory inventory = Bukkit.createInventory(null, 54, "Your Inventory");
        ItemList list = new ItemList();
        for (int i = 0; i < inventory.getSize(); i++) {
            inventory.setItem(i,PlayerInventoryItems.whiteGlasPane());
        }
            //row 1
        inventory.setItem(2, Items.weapons());
        inventory.setItem(3, Items.armor());

        inventory.setItem(19, list.itemList().get(0));
        inventory.setItem(20, list.itemList().get(0));
        inventory.setItem(21, list.itemList().get(0));
        inventory.setItem(22, list.itemList().get(0));
        inventory.setItem(23, list.itemList().get(0));
        inventory.setItem(24, list.itemList().get(0));
        inventory.setItem(25, list.itemList().get(0));
        //row 2
        inventory.setItem(28, list.itemList().get(0));
        inventory.setItem(29, list.itemList().get(0));
        inventory.setItem(30, list.itemList().get(0));
        inventory.setItem(31, list.itemList().get(0));
        inventory.setItem(32, list.itemList().get(0));
        inventory.setItem(33, list.itemList().get(0));
        inventory.setItem(34, list.itemList().get(0));
        //row 3
        inventory.setItem(37, list.itemList().get(0));
        inventory.setItem(38, list.itemList().get(0));
        inventory.setItem(39, list.itemList().get(0));
        inventory.setItem(40, list.itemList().get(0));
        inventory.setItem(41, list.itemList().get(0));
        inventory.setItem(42, list.itemList().get(0));
        inventory.setItem(43, list.itemList().get(0));
        //row 4
        inventory.setItem(46, list.itemList().get(0));
        inventory.setItem(47, list.itemList().get(0));
        inventory.setItem(48, list.itemList().get(0));
        inventory.setItem(49, list.itemList().get(0));
        inventory.setItem(50, list.itemList().get(0));
        inventory.setItem(51, list.itemList().get(0));
        inventory.setItem(52, list.itemList().get(0));

        return inventory;
    }
    public Inventory playerInventory(Player p) {
        ItemList list = new ItemList();
        Inventory inventory = Bukkit.createInventory(null, 54, "Your Inventory");

        try {
            PlayerInventoryModel stats = this.plugin.getDatabase().findPlayerByUUID(p.getUniqueId().toString());
            SaveInventoryInDB saveInventoryInDB = new SaveInventoryInDB();

            ItemStack[] contents = saveInventoryInDB.fromBase64(stats.getInventory()).getContents();
            inventory.setContents(contents);

        } catch (SQLException | IOException exception) {
            exception.printStackTrace();
        }

        return inventory;
    }

    public Inventory clickedItemInventory(ItemStack item) {
        ItemList list = new ItemList();
        Inventory inventory = Bukkit.createInventory(null, 54, "Your Inventory");

        for (int i = 0; i < inventory.getSize(); i++) {
            inventory.setItem(i, PlayerInventoryItems.whiteGlasPane());
        }
        inventory.setItem(20, item);
        inventory.setItem(23,PlayerInventoryItems.getEquip());
        inventory.setItem(32, PlayerInventoryItems.getDelete());
        inventory.setItem(0, PlayerInventoryItems.getBack());

        return inventory;
    }

    public Inventory equipItemInventory(ItemStack item) {
        ItemList list = new ItemList();
        Inventory inventory = Bukkit.createInventory(null, 54, "Your Inventory");

        for (int i = 0; i < inventory.getSize(); i++) {
            inventory.setItem(i, PlayerInventoryItems.whiteGlasPane());
        }
        inventory.setItem(0, PlayerInventoryItems.getBack());
        inventory.setItem(20, item);
        inventory.setItem(23, PlayerInventoryItems.getEquip());
        inventory.setItem(32, PlayerInventoryItems.getDelete());
        inventory.setItem(36, PlayerInventoryItems.getOne());
        inventory.setItem(37, PlayerInventoryItems.getTwo());
        inventory.setItem(38, PlayerInventoryItems.getThree());
        inventory.setItem(39, PlayerInventoryItems.getFour());
        inventory.setItem(40, PlayerInventoryItems.getFive());
        inventory.setItem(41, PlayerInventoryItems.getSix());
        inventory.setItem(42, PlayerInventoryItems.getSeven());
        inventory.setItem(43, PlayerInventoryItems.getEight());
        inventory.setItem(44, PlayerInventoryItems.getNine());



        return inventory;
    }

    public static Inventory sortedInventory(ItemStack[] items) {
        ItemList list = new ItemList();
        Inventory inventory = Bukkit.createInventory(null, 54, "Your Inventory");
        for (int i = 0; i < inventory.getSize(); i++) {
            inventory.setItem(i,PlayerInventoryItems.whiteGlasPane());
        }
        //row 1
        inventory.setItem(2, Items.weapons());
        inventory.setItem(3, Items.armor());

        inventory.setItem(19, list.itemList().get(0));
        inventory.setItem(20, list.itemList().get(0));
        inventory.setItem(21, list.itemList().get(0));
        inventory.setItem(22, list.itemList().get(0));
        inventory.setItem(23, list.itemList().get(0));
        inventory.setItem(24, list.itemList().get(0));
        inventory.setItem(25, list.itemList().get(0));
        //row 2
        inventory.setItem(28, list.itemList().get(0));
        inventory.setItem(29, list.itemList().get(0));
        inventory.setItem(30, list.itemList().get(0));
        inventory.setItem(31, list.itemList().get(0));
        inventory.setItem(32, list.itemList().get(0));
        inventory.setItem(33, list.itemList().get(0));
        inventory.setItem(34, list.itemList().get(0));
        //row 3
        inventory.setItem(37, list.itemList().get(0));
        inventory.setItem(38, list.itemList().get(0));
        inventory.setItem(39, list.itemList().get(0));
        inventory.setItem(40, list.itemList().get(0));
        inventory.setItem(41, list.itemList().get(0));
        inventory.setItem(42, list.itemList().get(0));
        inventory.setItem(43, list.itemList().get(0));
        //row 4
        inventory.setItem(46, list.itemList().get(0));
        inventory.setItem(47, list.itemList().get(0));
        inventory.setItem(48, list.itemList().get(0));
        inventory.setItem(49, list.itemList().get(0));
        inventory.setItem(50, list.itemList().get(0));
        inventory.setItem(51, list.itemList().get(0));
        inventory.setItem(52, list.itemList().get(0));

        for (int i = 0; i < items.length; i++) {
            inventory.setItem(i, items[i]);
        }

        return inventory;
    }
}

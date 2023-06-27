package de.squeezzy.playerinventory.listeners;

import de.squeezzy.playerinventory.PlayerInventory;
import de.squeezzy.playerinventory.database.SaveInventoryInDB;
import de.squeezzy.playerinventory.inventories.PlayerInventoryInventory;
import de.squeezzy.playerinventory.inventories.PlayerJoinInventory;
import de.squeezzy.playerinventory.inventories.SortInventory;
import de.squeezzy.playerinventory.items.PlayerInventoryItems;
import de.squeezzy.playerinventory.items.allitems.Items;
import de.squeezzy.playerinventory.model.PlayerInventoryModel;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;

public class Listeners implements Listener {

    private final PlayerInventory plugin;

    public Listeners(PlayerInventory plugin) {
        this.plugin = plugin;
    }

    PlayerJoinInventory playerJoinInventory = new PlayerJoinInventory();

    @EventHandler
    public void openInventory(PlayerInteractEvent e) {
        PlayerInventoryInventory playerInventoryInventory = new PlayerInventoryInventory(this.plugin);
        Player p = e.getPlayer();
        ItemStack item = e.getItem();

        if(item != null) {
            if (item.equals(PlayerInventoryItems.openInventory())) {
                e.setCancelled(true);
                Inventory inventory = Bukkit.createInventory(null, 54, "Your Inventory");
                ItemStack[] contents = playerInventoryInventory.playerInventory(p).getContents();
                inventory.setContents(contents);
                p.openInventory(inventory);
            }
        }

    }

    @EventHandler
    public void joinEvent(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        playerJoinInventory.openInventory(p);
        try {

            PlayerInventoryModel stats = this.plugin.getDatabase().findPlayerByUUID(p.getUniqueId().toString());
            PlayerInventoryInventory pII = new PlayerInventoryInventory(this.plugin);
            SaveInventoryInDB saveInventoryInDB = new SaveInventoryInDB();

            if (stats == null) {
                String uuid = p.getUniqueId().toString();
                String defaultInventory = saveInventoryInDB.toBase64(pII.defaultInventory());
                stats = new PlayerInventoryModel(uuid, defaultInventory);
                this.plugin.getDatabase().createPlayerStats(stats);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

    @EventHandler
    public void inventoryClick(InventoryClickEvent e) {
        PlayerInventoryInventory pII = new PlayerInventoryInventory(this.plugin);
        SortInventory sort = new SortInventory(this.plugin);
        Player p = (Player) e.getWhoClicked();
        if (!(e.getClickedInventory() instanceof org.bukkit.inventory.PlayerInventory)) {
            ItemStack[] inventory = Objects.requireNonNull(e.getClickedInventory()).getContents();
            ItemStack item = e.getCurrentItem();
            ItemStack[] getEquipInventory = pII.clickedItemInventory(item).getContents();
            SaveInventoryInDB saveInv = new SaveInventoryInDB();
            PlayerInventoryModel stats;
            assert item != null;
            if (item.equals(Items.weapons())) {
                sort.sortWeapons(p);
            } else if (item.equals(Items.armor())) {
                sort.sortArmor(p);
            }
            if (!(item.equals(PlayerInventoryItems.whiteGlasPane()) || item.equals(Items.weapons()) || item.equals(Items.armor()))) {
                try {
                    stats = this.plugin.getDatabase().findPlayerByUUID(p.getUniqueId().toString());
                    String uuid = p.getUniqueId().toString();
                    ItemStack[] getInventory = saveInv.fromBase64(stats.getInventory()).getContents();
                    if (Arrays.equals(inventory, getInventory)) {
                        p.openInventory(pII.clickedItemInventory(item));
                    }

                    else if (Arrays.equals(inventory, getEquipInventory)) {
                        if (item.equals(PlayerInventoryItems.getBack())) {
                            PlayerInventoryInventory playerInventoryInventory = new PlayerInventoryInventory(this.plugin);
                            Inventory getPlayerInventory = Bukkit.createInventory(null, 54, "Your Inventory");
                            ItemStack[] contents = playerInventoryInventory.playerInventory(p).getContents();
                            getPlayerInventory.setContents(contents);
                            p.openInventory(getPlayerInventory);
                        }
                        if (item.equals(PlayerInventoryItems.getEquip())) {
                            p.openInventory(pII.equipItemInventory(item));

                        }
                        if (item.equals(PlayerInventoryItems.getDelete())) {
                            PlayerInventoryInventory playerInventoryInventory = new PlayerInventoryInventory(this.plugin);
                            ItemStack[] contents = playerInventoryInventory.playerInventory(p).getContents();
                            for (ItemStack content : contents) {
                                if (content.equals(item)) {
                                    content.setAmount(0);
                                    Inventory newInventory = Bukkit.createInventory(null, 54, "Your Inventory");
                                    newInventory.setContents(contents);
                                    String newInventoryString = saveInv.toBase64(newInventory);
                                    stats = new PlayerInventoryModel(uuid, newInventoryString);
                                    this.plugin.getDatabase().updatePlayerStats(stats);

                                }
                            }
                        }
                        else if (item.equals(PlayerInventoryItems.getOne())) {
                            org.bukkit.inventory.PlayerInventory playerInventory = p.getInventory();
                            ItemStack tempItem = playerInventory.getItem(0);
                            playerInventory.setItem(0, item);
                        }
                    }
                } catch (SQLException | IOException ex) {
                    ex.printStackTrace();
                }

            }
        }
        e.setCancelled(true);
    }

    @EventHandler
    public void pickUpItems(EntityPickupItemEvent e) {

        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();

            try {
                ItemStack item = e.getItem().getItemStack();
                SaveInventoryInDB saveInv = new SaveInventoryInDB();
                PlayerInventoryModel stats = this.plugin.getDatabase().findPlayerByUUID(p.getUniqueId().toString());
                String uuid = p.getUniqueId().toString();
                Inventory inventory = saveInv.fromBase64(stats.getInventory());
                inventory.addItem(item);
                String inv = saveInv.toBase64(inventory);
                stats = new PlayerInventoryModel(uuid, inv);
                this.plugin.getDatabase().updatePlayerStats(stats);
                e.setCancelled(true);
                e.getItem().remove();

            } catch (SQLException | IOException ex) {
                throw new RuntimeException(ex);
            }
        }


    }
}

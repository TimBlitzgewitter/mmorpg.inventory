package de.squeezzy.playerinventory.inventories;

import de.squeezzy.playerinventory.PlayerInventory;
import de.squeezzy.playerinventory.database.SaveInventoryInDB;
import de.squeezzy.playerinventory.items.allitems.Items;
import de.squeezzy.playerinventory.model.PlayerInventoryModel;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class SortInventory {

    PlayerInventoryModel stats;
    private final PlayerInventory plugin;
    SaveInventoryInDB saveInv = new SaveInventoryInDB();

    public SortInventory(PlayerInventory plugin) {
        this.plugin = plugin;
    }

    

    public void sortWeapons(Player p) {
        try {
            stats = this.plugin.getDatabase().findPlayerByUUID(p.getUniqueId().toString());
            ItemStack[] getInventory = saveInv.fromBase64(stats.getInventory()).getContents();
            ArrayList<ItemStack> liste = new ArrayList<>();
            ItemStack[] items = new ItemStack[getInventory.length];
            for (int i = 0; i < getInventory.length; i++) {
                if (getInventory[i] != null) {
                    if (getInventory[i].getType().equals(Material.WOODEN_SWORD) || getInventory[i].getType().equals(Material.STONE_SWORD) ||
                        (!getInventory[i].equals(Items.weapons())) && getInventory[i].getType().equals(Material.IRON_SWORD) ||
                        getInventory[i].getType().equals(Material.GOLDEN_SWORD) ||
                        getInventory[i].getType().equals(Material.DIAMOND_SWORD) || getInventory[i].getType().equals(Material.NETHERITE_SWORD) ||
                        getInventory[i].getType().equals(Material.BOW) || getInventory[i].getType().equals(Material.CROSSBOW) ||
                        getInventory[i].getType().equals(Material.TRIDENT)) {

                        liste.add(getInventory[i]);
                    }
                }
            }
            for (int i = 0; i < liste.size(); i++) {
                if (liste.get(i) != null) {
                    items[i] = liste.get(i);
                }
            }
            for (int k = 0; k <= liste.size(); k++) {
                assert items[k] != null;
                p.sendMessage(items[k].getType().name());
            }

            p.openInventory(PlayerInventoryInventory.sortedInventory(items));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //return items;
    }

    public void sortArmor(Player p) {
        try {
            stats = this.plugin.getDatabase().findPlayerByUUID(p.getUniqueId().toString());
            ItemStack[] getInventory = saveInv.fromBase64(stats.getInventory()).getContents();
            ArrayList<ItemStack> liste = new ArrayList<>();
            ItemStack[] items = new ItemStack[getInventory.length];
            for (int i = 0; i < getInventory.length; i++) {
                if (getInventory[i] != null) {
                    if (getInventory[i].getType().equals(Material.LEATHER_CHESTPLATE) || getInventory[i].getType().equals(Material.LEATHER_BOOTS) ||
                            getInventory[i].getType().equals(Material.LEATHER_HELMET) || getInventory[i].getType().equals(Material.LEATHER_LEGGINGS) ||
                            getInventory[i].getType().equals(Material.IRON_BOOTS) || getInventory[i].getType().equals(Material.IRON_LEGGINGS) ||
                            getInventory[i].getType().equals(Material.IRON_HELMET) || getInventory[i].getType().equals(Material.DIAMOND_BOOTS) ||
                            getInventory[i].getType().equals(Material.DIAMOND_LEGGINGS) || getInventory[i].getType().equals(Material.DIAMOND_CHESTPLATE) ||
                            getInventory[i].getType().equals(Material.DIAMOND_HELMET) || getInventory[i].getType().equals(Material.GOLDEN_BOOTS) ||
                            getInventory[i].getType().equals(Material.GOLDEN_LEGGINGS) || getInventory[i].getType().equals(Material.GOLDEN_CHESTPLATE) ||
                            getInventory[i].getType().equals(Material.GOLDEN_HELMET) || getInventory[i].getType().equals(Material.NETHERITE_BOOTS) ||
                            getInventory[i].getType().equals(Material.NETHERITE_LEGGINGS) || getInventory[i].getType().equals(Material.NETHERITE_CHESTPLATE) ||
                            getInventory[i].getType().equals(Material.NETHERITE_HELMET) ||
                            (!getInventory[i].equals(Items.armor())) && getInventory[i].getType().equals(Material.IRON_CHESTPLATE)) {

                        liste.add(getInventory[i]);
                    }
                }
            }
            for (int i = 0; i < liste.size(); i++) {
                if (liste.get(i) != null) {
                    items[i] = liste.get(i);
                }
            }
            for (int k = 0; k <= items.length; k++) {
                assert items[k] != null;
                p.sendMessage(items[k].getType().name());
            }
            p.openInventory(PlayerInventoryInventory.sortedInventory(items));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

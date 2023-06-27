package de.squeezzy.playerinventory.items.allitems;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Items {

    public static ItemStack air() {

        return new ItemStack(Material.AIR);
    }

    public static ItemStack woodensword() {

        ItemStack item = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("§l§6Wooden Sword");
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack stonesword() {

        ItemStack item = new ItemStack(Material.STONE_SWORD);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("§l§6Stone Sword");
        item.setItemMeta(meta);

        return item;
    }


    public static ItemStack stick() {

        ItemStack item = new ItemStack(Material.STICK);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("§l§6Wooden Stick");
        item.setItemMeta(meta);

        return item;
    }

    //Kategorien

    public static ItemStack weapons() {

        ItemStack item = new ItemStack(Material.IRON_SWORD);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("§l§fWeapons");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§cClick here to see");
        lore.add("§call your weapons!");
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack armor() {

        ItemStack item = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("§l§fArmor");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§cClick here to see");
        lore.add("§call your armor!");
        item.setItemMeta(meta);

        return item;
    }
}

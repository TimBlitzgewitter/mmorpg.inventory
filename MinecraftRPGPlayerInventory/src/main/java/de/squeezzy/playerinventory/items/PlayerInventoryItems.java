package de.squeezzy.playerinventory.items;

import dev.dbassett.skullcreator.SkullCreator;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class PlayerInventoryItems {

    public static ItemStack openInventory() {

        ItemStack item = new ItemStack(Material.BUNDLE);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("§l§eInventory");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§fPress §eright click §fto open your Inventory§l§f!");
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack whiteGlasPane() {

        ItemStack item = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        ItemMeta meta = item.getItemMeta();

        assert meta != null;
        meta.setDisplayName(" ");
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getOne() {
        // Got this base64 string from minecraft-heads.com
        String base64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2E1MTZmYmFlMTYwNThmMjUxYWVmOWE2OGQzMDc4NTQ5ZjQ4ZjZkNWI2ODNmMTljZjVhMTc0NTIxN2Q3MmNjIn19fQ==";
        SkullCreator.itemFromBase64(base64);
        ItemStack skull = SkullCreator.itemFromBase64(base64);
        ItemMeta m = skull.getItemMeta();
        assert m != null;
        m.setDisplayName("§l§7Slot 1");
        skull.setItemMeta(m);
        return skull;
    }
    public static ItemStack getTwo() {
        // Got this base64 string from minecraft-heads.com
        String base64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDY5OGFkZDM5Y2Y5ZTRlYTkyZDQyZmFkZWZkZWMzYmU4YTdkYWZhMTFmYjM1OWRlNzUyZTlmNTRhZWNlZGM5YSJ9fX0=";
        SkullCreator.itemFromBase64(base64);
        ItemStack skull = SkullCreator.itemFromBase64(base64);
        ItemMeta m = skull.getItemMeta();
        assert m != null;
        m.setDisplayName("§l§7Slot 2");
        skull.setItemMeta(m);
        return skull;
    }
    public static ItemStack getThree() {
        // Got this base64 string from minecraft-heads.com
        String base64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmQ5ZTRjZDVlMWI5ZjNjOGQ2Y2E1YTFiZjQ1ZDg2ZWRkMWQ1MWU1MzVkYmY4NTVmZTlkMmY1ZDRjZmZjZDIifX19";
        SkullCreator.itemFromBase64(base64);
        ItemStack skull = SkullCreator.itemFromBase64(base64);
        ItemMeta m = skull.getItemMeta();
        assert m != null;
        m.setDisplayName("§l§7Slot 3");
        skull.setItemMeta(m);
        return skull;
    }
    public static ItemStack getFour() {
        // Got this base64 string from minecraft-heads.com
        String base64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjJhM2Q1Mzg5ODE0MWM1OGQ1YWNiY2ZjODc0NjlhODdkNDhjNWMxZmM4MmZiNGU3MmY3MDE1YTM2NDgwNTgifX19";
        SkullCreator.itemFromBase64(base64);
        ItemStack skull = SkullCreator.itemFromBase64(base64);
        ItemMeta m = skull.getItemMeta();
        assert m != null;
        m.setDisplayName("§l§7Slot 4");
        skull.setItemMeta(m);
        return skull;
    }
    public static ItemStack getFive() {
        // Got this base64 string from minecraft-heads.com
        String base64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDFmZTM2YzQxMDQyNDdjODdlYmZkMzU4YWU2Y2E3ODA5YjYxYWZmZDYyNDVmYTk4NDA2OTI3NWQxY2JhNzYzIn19fQ==";
        SkullCreator.itemFromBase64(base64);
        ItemStack skull = SkullCreator.itemFromBase64(base64);
        ItemMeta m = skull.getItemMeta();
        assert m != null;
        m.setDisplayName("§l§7Slot 5");
        skull.setItemMeta(m);
        return skull;
    }
    public static ItemStack getSix() {
        // Got this base64 string from minecraft-heads.com
        String base64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2FiNGRhMjM1OGI3YjBlODk4MGQwM2JkYjY0Mzk5ZWZiNDQxODc2M2FhZjg5YWZiMDQzNDUzNTYzN2YwYTEifX19";
        SkullCreator.itemFromBase64(base64);
        ItemStack skull = SkullCreator.itemFromBase64(base64);
        ItemMeta m = skull.getItemMeta();
        assert m != null;
        m.setDisplayName("§l§7Slot 6");
        skull.setItemMeta(m);
        return skull;
    }
    public static ItemStack getSeven() {
        // Got this base64 string from minecraft-heads.com
        String base64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjk3NzEyYmEzMjQ5NmM5ZTgyYjIwY2M3ZDE2ZTE2OGIwMzViNmY4OWYzZGYwMTQzMjRlNGQ3YzM2NWRiM2ZiIn19fQ==";
        SkullCreator.itemFromBase64(base64);
        ItemStack skull = SkullCreator.itemFromBase64(base64);
        ItemMeta m = skull.getItemMeta();
        assert m != null;
        m.setDisplayName("§l§7Slot 7");
        skull.setItemMeta(m);
        return skull;
    }
    public static ItemStack getEight() {
        // Got this base64 string from minecraft-heads.com
        String base64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWJjMGZkYTlmYTFkOTg0N2EzYjE0NjQ1NGFkNjczN2FkMWJlNDhiZGFhOTQzMjQ0MjZlY2EwOTE4NTEyZCJ9fX0=";
        SkullCreator.itemFromBase64(base64);
        ItemStack skull = SkullCreator.itemFromBase64(base64);
        ItemMeta m = skull.getItemMeta();
        assert m != null;
        m.setDisplayName("§l§7Slot 8");
        skull.setItemMeta(m);
        return skull;
    }
    public static ItemStack getNine() {
        // Got this base64 string from minecraft-heads.com
        String base64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDZhYmM2MWRjYWVmYmQ1MmQ5Njg5YzA2OTdjMjRjN2VjNGJjMWFmYjU2YjhiMzc1NWU2MTU0YjI0YTVkOGJhIn19fQ==";
        SkullCreator.itemFromBase64(base64);
        ItemStack skull = SkullCreator.itemFromBase64(base64);
        ItemMeta m = skull.getItemMeta();
        assert m != null;
        m.setDisplayName("§l§7Slot 9");
        skull.setItemMeta(m);
        return skull;
    }

    public static ItemStack getEquip() {
        // Got this base64 string from minecraft-heads.com
        String base64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTkyZTMxZmZiNTljOTBhYjA4ZmM5ZGMxZmUyNjgwMjAzNWEzYTQ3YzQyZmVlNjM0MjNiY2RiNDI2MmVjYjliNiJ9fX0=";
        SkullCreator.itemFromBase64(base64);
        ItemStack skull = SkullCreator.itemFromBase64(base64);
        ItemMeta m = skull.getItemMeta();
        assert m != null;
        m.setDisplayName("§l§aEquip Item");
        skull.setItemMeta(m);
        return skull;
    }
    public static ItemStack getDelete() {
        // Got this base64 string from minecraft-heads.com
        String base64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmViNTg4YjIxYTZmOThhZDFmZjRlMDg1YzU1MmRjYjA1MGVmYzljYWI0MjdmNDYwNDhmMThmYzgwMzQ3NWY3In19fQ==";
        SkullCreator.itemFromBase64(base64);
        ItemStack skull = SkullCreator.itemFromBase64(base64);
        ItemMeta m = skull.getItemMeta();
        assert m != null;
        m.setDisplayName("§l§cDelete Item");
        skull.setItemMeta(m);
        return skull;
    }
    public static ItemStack getBack() {
        // Got this base64 string from minecraft-heads.com
        String base64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjg0ZjU5NzEzMWJiZTI1ZGMwNThhZjg4OGNiMjk4MzFmNzk1OTliYzY3Yzk1YzgwMjkyNWNlNGFmYmEzMzJmYyJ9fX0=";
        SkullCreator.itemFromBase64(base64);
        ItemStack skull = SkullCreator.itemFromBase64(base64);
        ItemMeta m = skull.getItemMeta();
        assert m != null;
        m.setDisplayName("§l§fGet Back");
        skull.setItemMeta(m);
        return skull;
    }

}

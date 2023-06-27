package de.squeezzy.playerinventory.commands;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collection;
import java.util.Objects;

public class UpgradeItem implements CommandExecutor {

    private final de.squeezzy.playerinventory.PlayerInventory plugin;

    public UpgradeItem(de.squeezzy.playerinventory.PlayerInventory plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
        Player p = (Player) sender;
            PlayerInventory pInv = p.getInventory();
            ItemStack is = pInv.getItem(0);
            assert is != null;
            ItemMeta meta = is.getItemMeta();
            assert meta != null;
            double damage = Double.parseDouble(args[0]);
            if (meta.getAttributeModifiers(Attribute.GENERIC_ATTACK_DAMAGE) != null) {
                Objects.requireNonNull(meta.getAttributeModifiers(Attribute.GENERIC_ATTACK_DAMAGE)).clear();
            }
            AttributeModifier am_ad = new AttributeModifier(p.getUniqueId(),
                    "generic.attackDamage",
                    damage,
                    AttributeModifier.Operation.ADD_NUMBER,
                    EquipmentSlot.HAND);
            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, am_ad);
            is.setItemMeta(meta);
    }

        return false;
    }
}

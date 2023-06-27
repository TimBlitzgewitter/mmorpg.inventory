package de.squeezzy.playerinventory.commands;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collection;
import java.util.Objects;

public class RemoveUpgrade implements CommandExecutor {

    private final de.squeezzy.playerinventory.PlayerInventory plugin;

    public RemoveUpgrade(de.squeezzy.playerinventory.PlayerInventory plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            ItemStack is = p.getInventory().getItemInMainHand();
            ItemMeta meta = is.getItemMeta();
            assert meta != null;
                meta.removeAttributeModifier(Attribute.valueOf("generic.attackDamage"));
                is.setItemMeta(meta);
        }



        return false;
    }
}

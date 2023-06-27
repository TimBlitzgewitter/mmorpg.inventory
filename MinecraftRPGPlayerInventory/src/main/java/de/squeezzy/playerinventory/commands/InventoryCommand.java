package de.squeezzy.playerinventory.commands;

import de.squeezzy.playerinventory.PlayerInventory;
import de.squeezzy.playerinventory.database.SaveInventoryInDB;
import de.squeezzy.playerinventory.model.PlayerInventoryModel;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.sql.SQLException;

public class InventoryCommand implements CommandExecutor {

    private final PlayerInventory plugin;

    public InventoryCommand(PlayerInventory plugin) {
        this.plugin = plugin;
    }
    SaveInventoryInDB saveInv = new SaveInventoryInDB();


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            try {
                PlayerInventoryModel stats = this.plugin.getDatabase().findPlayerByUUID(p.getUniqueId().toString());
                Inventory inventory = Bukkit.createInventory(null, 54, "Your Inventory");
                ItemStack[] contents = saveInv.fromBase64(stats.getInventory()).getContents();
                inventory.setContents(contents);
                p.openInventory(inventory);

            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }


        }


        return false;
    }
}

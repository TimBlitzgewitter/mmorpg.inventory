package de.squeezzy.playerinventory.commands;

import de.squeezzy.playerinventory.PlayerInventory;
import de.squeezzy.playerinventory.database.SaveInventoryInDB;
import de.squeezzy.playerinventory.inventories.PlayerInventoryInventory;
import de.squeezzy.playerinventory.model.PlayerInventoryModel;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.SQLException;

public class InventoryClearCommand implements CommandExecutor {

    private final PlayerInventory plugin;

    public InventoryClearCommand(PlayerInventory plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            PlayerInventoryInventory pII = new PlayerInventoryInventory(this.plugin);
            SaveInventoryInDB saveInv = new SaveInventoryInDB();
            try {
                PlayerInventoryModel stats = this.plugin.getDatabase().findPlayerByUUID(p.getUniqueId().toString());
                String inv = saveInv.toBase64(pII.defaultInventory());
                stats = new PlayerInventoryModel(stats.getUuid(), inv);
                this.plugin.getDatabase().updatePlayerStats(stats);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return false;
    }
}

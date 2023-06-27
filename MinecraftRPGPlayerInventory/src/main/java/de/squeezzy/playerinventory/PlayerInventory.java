package de.squeezzy.playerinventory;

import de.squeezzy.playerinventory.commands.InventoryClearCommand;
import de.squeezzy.playerinventory.commands.InventoryCommand;
import de.squeezzy.playerinventory.commands.RemoveUpgrade;
import de.squeezzy.playerinventory.commands.UpgradeItem;
import de.squeezzy.playerinventory.database.Database;
import de.squeezzy.playerinventory.listeners.Listeners;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;
import java.util.Objects;

public final class PlayerInventory extends JavaPlugin {

    private Database database;

    @Override
    public void onEnable() {
        // Plugin startup logic

        this.database = new Database();
        try {
            database.initializeDatabase();
        } catch (SQLException e) {
            System.out.println("Unable to connect to database and create tables.");
            e.printStackTrace();
        }
        Objects.requireNonNull(getCommand("inventory")).setExecutor(new InventoryCommand(this));
        Objects.requireNonNull(getCommand("inventoryclear")).setExecutor(new InventoryClearCommand(this));
        Objects.requireNonNull(getCommand("upgrade")).setExecutor(new UpgradeItem(this));
        Objects.requireNonNull(getCommand("removeupgrade")).setExecutor(new RemoveUpgrade(this));
        getServer().getPluginManager().registerEvents(new Listeners(this), this);

    }

    public Database getDatabase() {
        return database;
    }


    public void setDatabase(Database database) {
        this.database = database;
    }

}

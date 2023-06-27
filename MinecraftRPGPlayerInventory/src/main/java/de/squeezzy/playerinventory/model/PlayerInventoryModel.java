package de.squeezzy.playerinventory.model;

import org.bukkit.inventory.Inventory;

public class PlayerInventoryModel {

    private String uuid;
    private String inventory;


    public PlayerInventoryModel(String uuid, String inventory) {
        this.uuid = uuid;
        this.inventory = inventory;

    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

}


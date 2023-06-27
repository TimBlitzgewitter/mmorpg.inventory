package de.squeezzy.playerinventory.database;

import de.squeezzy.playerinventory.model.PlayerInventoryModel;

import java.sql.*;

public class Database {

    private Connection connection;

    public Connection getConnection() throws SQLException {

        if (connection != null) {
            return connection;
        }

        String url = "jdbc:mysql://localhost/player";
        String user = "root";
        String password = "";

        this.connection = DriverManager.getConnection(url, user, password);

        System.out.println("Connected to the Player Class Database.");

        return this.connection;
    }

    public void initializeDatabase() throws SQLException{

        Statement statement = getConnection().createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS player_inventory(uuid varchar(36) primary key, inventory BLOB)";
        statement.execute(sql);

        statement.close();

        System.out.println("Created the Class table in the database.");

    }

    public PlayerInventoryModel findPlayerByUUID(String uuid) throws SQLException{

        PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM player_inventory WHERE uuid = ?");
        statement.setString(1, uuid);
        ResultSet results = statement.executeQuery();

        if(results.next()){

            String inventory = results.getString("inventory");


            PlayerInventoryModel playerInventoryModel = new PlayerInventoryModel(uuid, inventory);

            statement.close();

            return playerInventoryModel;


        }
        statement.close();

        return null;
    }

    public void createPlayerStats(PlayerInventoryModel stats) throws SQLException{

        PreparedStatement statement = getConnection()
                .prepareStatement("INSERT INTO player_inventory(uuid, inventory) VALUES (?, ?)");

        statement.setString(1, stats.getUuid());
        statement.setString(2, stats.getInventory());

        statement.executeUpdate();

        statement.close();

    }

    public void updatePlayerStats(PlayerInventoryModel stats) throws SQLException{

        PreparedStatement statement = getConnection()
                .prepareStatement("UPDATE player_inventory SET inventory = ? WHERE uuid = ?");


        statement.setString(1, stats.getInventory());
        statement.setString(2, stats.getUuid());

        statement.executeUpdate();

        statement.close();

    }
}

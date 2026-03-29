package com.vaxsafe.dao;

import com.vaxsafe.model.VaccineBatch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Handles database operations for inventory
public class InventoryDAO {
    public void save(VaccineBatch batch){

        String sql = "INSERT INTO vaccine_batch " +
                "(batch_id, vaccine_name, expiry_date, min_temp, max_temp, state) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

                //Mapping object fields to SQL parameters
                stmt.setString(1, batch.getBatchId());
                stmt.setString(2, batch.getVaccineName());
                stmt.setString(3, batch.getExpiryDate().toString());
                stmt.setDouble(4, batch.getMinTemperature());
                stmt.setDouble(5, batch.getMaxTemperature());
                stmt.setString(6, batch.getState().name());

                stmt.executeUpdate();
            } catch(SQLException e){
                e.printStackTrace();
            }
    }

    // Creates table if it does not exist
    public void createTable() {

        String sql = "CREATE TABLE IF NOT EXISTS vaccine_batch (" +
                "batch_id TEXT PRIMARY KEY," +
                "vaccine_name TEXT," +
                "expiry_date TEXT," +
                "min_temp REAL," +
                "max_temp REAL," +
                "state TEXT" +
                ")";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update the state of a vaccine batch
    public void updateState(String batchID, String state){
        String sql = "UPDATE vaccine_batch  SET state = ? WHERE batch_id = ?";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

                // Maps entire new state to corresponding batch
                stmt.setString(1, state);
                stmt.setString(2, batchID);

                stmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}

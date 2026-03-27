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
}

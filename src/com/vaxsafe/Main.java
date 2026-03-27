package com.vaxsafe;

import com.vaxsafe.dao.InventoryDAO;
import com.vaxsafe.model.VaccineBatch;

import java.time.LocalDate;

// Entry point to validate database persistence
public class Main {

    public static void main(String[] args) {

        InventoryDAO dao = new InventoryDAO();

        // Ensure table exists
        dao.createTable();

        VaccineBatch batch = new VaccineBatch(
                "BATCH003",
                "Sputnik V",
                LocalDate.of(2026, 11, 20),
                2.0,
                8.0
        );

        // Persist batch into database
        dao.save(batch);

        System.out.println("Batch saved to database");
    }
}
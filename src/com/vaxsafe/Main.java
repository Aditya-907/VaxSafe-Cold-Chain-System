package com.vaxsafe;

import com.vaxsafe.dao.InventoryDAO;
import com.vaxsafe.model.VaccineBatch;
import com.vaxsafe.service.AlertSystem;
import com.vaxsafe.service.ColdChainManager;
import com.vaxsafe.simulation.EnvironmentSimulator;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

// Entry point wiring all system components
public class Main {

    public static void main(String[] args) {

        InventoryDAO dao = new InventoryDAO();
        dao.createTable();

        VaccineBatch batch1 = new VaccineBatch(
                "BATCH301", "Covaxin",
                LocalDate.of(2026, 12, 31),
                2.0, 8.0
        );

        VaccineBatch batch2 = new VaccineBatch(
                "BATCH302", "Covishield",
                LocalDate.of(2026, 11, 30),
                2.0, 8.0
        );

        // Persist initial batches
        dao.save(batch1);
        dao.save(batch2);

        List<VaccineBatch> batches = Arrays.asList(batch1, batch2);

        AlertSystem alertSystem = new AlertSystem();
        ColdChainManager manager =
                new ColdChainManager(alertSystem, dao);

        EnvironmentSimulator simulator =
                new EnvironmentSimulator(2, manager);

        simulator.startSimulation(batches);
    }
}
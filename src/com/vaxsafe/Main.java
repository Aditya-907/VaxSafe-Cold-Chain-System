package com.vaxsafe;

import com.vaxsafe.model.VaccineBatch;
import com.vaxsafe.service.AlertSystem;
import com.vaxsafe.service.ColdChainManager;
import com.vaxsafe.simulation.EnvironmentSimulator;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

// Entry point to validate sensor simulation
public class Main {

    public static void main(String[] args) {

        VaccineBatch batch1 = new VaccineBatch(
                "BATCH201", "Jorex",
                LocalDate.of(2026, 12, 31),
                2.0, 8.0
        );

        VaccineBatch batch2 = new VaccineBatch(
                "BATCH202", "Rovet",
                LocalDate.of(2026, 11, 30),
                2.0, 8.0
        );

        List<VaccineBatch> batches = Arrays.asList(batch1, batch2);

        AlertSystem alertSystem = new AlertSystem();
        ColdChainManager manager = new ColdChainManager(alertSystem);

        EnvironmentSimulator simulator = new EnvironmentSimulator(2, manager);

        simulator.startSimulation(batches);
    }
}
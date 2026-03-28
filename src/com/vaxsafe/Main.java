package com.vaxsafe;

import com.vaxsafe.model.VaccineBatch;
import com.vaxsafe.simulation.EnvironmentSimulator;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

// Entry point to validate sensor simulation
public class Main {

    public static void main(String[] args) {

        VaccineBatch batch1 = new VaccineBatch(
                "BATCH101", "Foxin",
                LocalDate.of(2026, 12, 31),
                2.0, 8.0
        );

        VaccineBatch batch2 = new VaccineBatch(
                "BATCH102", "Covishield",
                LocalDate.of(2026, 11, 30),
                2.0, 8.0
        );

        List<VaccineBatch> batches = Arrays.asList(batch1, batch2);

        EnvironmentSimulator simulator = new EnvironmentSimulator(2);

        simulator.startSimulation(batches);
    }
}
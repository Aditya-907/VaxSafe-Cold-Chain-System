package com.vaxsafe;

import com.vaxsafe.model.VaccineBatch;
import com.vaxsafe.exception.ThermalExcursionException;
import com.vaxsafe.util.AnalyticsUtils;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        VaccineBatch batch = new VaccineBatch(
            "BATCH002",
            "Hexin",
            LocalDate.of(2026,10,10),
            2.0,
            8.0
        );

        double temperature = 10.5;

        try {
            //Validates temperature and throws exception if unsafe
            if(!batch.isTemperatureSafe(temperature)){
                throw new ThermalExcursionException(
                    "Temperature out of safe range: " + temperature
                );
            }
        } catch (ThermalExcursionException e){
            System.out.println("ALERT: " + e.getMessage());
        }

        // Sample Temperature readings
        List<Double> readings = Arrays.asList(5.0, 6.5, 7.0, 8.5, 9.0);

        double mkt = AnalyticsUtils.calculateMKT(readings);

        System.out.println("Calculated MKT: " + mkt);
        
    }
}

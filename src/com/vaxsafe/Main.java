package com.vaxsafe;

import com.vaxsafe.model.VaccineBatch;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        VaccineBatch batch = new VaccineBatch(
            "BATCH001",
            "Peraxine",
            LocalDate.of(2026,12,31),
            2.0,
            8.0
        );

        System.out.println("Batch ID: " + batch.getBatchId());
        System.out.println("Vaccine: " + batch.getVaccineName());
        System.out.println("Is it Safe Temperature(5°C): " + batch.isTemperatureSafe(5.0));
        System.out.println("Is Expired: " + batch.isExpired());
    }

    
}

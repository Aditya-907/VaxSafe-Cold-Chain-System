package com.vaxsafe.model;
import java.time.LocalDate;

public class VaccineBatch extends InventoryItem {
    
    private String vaccineName;

    // Safe temperature ranges
    private double mintemperature;
    private double maxtemperature;

    public VaccineBatch(String batchId, String vaccineName, LocalDate expiryDate, double mintemperature, double maxtemperature){
        super(batchId, expiryDate);
        this.vaccineName = vaccineName;
        this.mintemperature = mintemperature;
        this.maxtemperature = maxtemperature;

    }

    // Return vaccine name
    public String getVaccineName(){
        return vaccineName;
    }

    // Checking temperature is in safe range
    public boolean isTemperatureSafe(double temperature){
        return temperature >= mintemperature && temperature <= maxtemperature;
    }

    // Reutrn Minimum safe temperature
    public double getMinTemperature(){
        return mintemperature;
    }

    // Reutrn Maximum safe temperature
    public double getMaxTemperature(){
        return maxtemperature;
    }

}

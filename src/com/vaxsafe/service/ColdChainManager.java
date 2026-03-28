package com.vaxsafe.service;

import com.vaxsafe.exception.ThermalExcursionException;
import com.vaxsafe.model.ItemState;
import com.vaxsafe.model.VaccineBatch;

// Central system to control temperature validation and states
public class ColdChainManager {

    private final AlertSystem alertSystem;

    public ColdChainManager(AlertSystem alertSystem){
        this.alertSystem = alertSystem;
    }

    // Processing temperature ranges
    public void processTemperature(VaccineBatch batch, double temperature){

        try{
            // Validating temperature Range
            if(!batch.isTemperatureSafe(temperature)){
                throw new ThermalExcursionException(
                    "Temperature out of range: " + temperature 
                );
            } 
        } catch (ThermalExcursionException e){
                // Marking batch as SPOILED
                batch.setState(ItemState.SPOILED);

                // Trigger ALERT
                alertSystem.triggerAlert(batch, temperature);
            }
    }
    
}

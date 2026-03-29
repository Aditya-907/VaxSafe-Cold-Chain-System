package com.vaxsafe.service;

import com.vaxsafe.exception.ThermalExcursionException;
import com.vaxsafe.model.ItemState;
import com.vaxsafe.model.VaccineBatch;
import com.vaxsafe.dao.InventoryDAO;

// Central system to control temperature validation and states
public class ColdChainManager {

    private final AlertSystem alertSystem;
    private final InventoryDAO inventoryDAO;

    public ColdChainManager(AlertSystem alertSystem, InventoryDAO inventoryDAO){
        this.alertSystem = alertSystem;
        this.inventoryDAO = inventoryDAO;
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

            if(batch.getState() != ItemState.SPOILED){

                batch.setState(ItemState.SPOILED);

                inventoryDAO.updateState(
                    batch.getBatchId(),
                    batch.getState().name()
                );
            }

            // Trigger ALERT
            alertSystem.triggerAlert(batch, temperature);
        }
    }
    
}

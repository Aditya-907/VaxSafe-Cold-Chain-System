package com.vaxsafe.service;

import com.vaxsafe.model.VaccineBatch;

// Handling alerts for unsafe conditions
public class AlertSystem {

    // Triggers alert when batch becomes unsafe
    public void triggerAlert(VaccineBatch batch, double temperature){

        System.out.println(
            "ALERT: Batch " + batch.getBatchId() + 
            "exceeded safe temperature. Current Temperature is: " + temperature
        );
    }
    
}

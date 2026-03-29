package com.vaxsafe.service;

import com.vaxsafe.model.VaccineBatch;
import com.vaxsafe.util.LoggerUtil;

// Handling alerts for unsafe conditions
public class AlertSystem {

    // Triggers alert when batch becomes unsafe
    public void triggerAlert(VaccineBatch batch, double temperature){

        String message = 
            "ALERT: Batch " + batch.getBatchId() + 
            "exceeded safe temperature. Current Temperature is: " + temperature;
        System.out.println(message);

        LoggerUtil.log(message);
    }
    
}

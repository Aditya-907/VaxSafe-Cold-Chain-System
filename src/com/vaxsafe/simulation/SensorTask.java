package com.vaxsafe.simulation;

import com.vaxsafe.model.VaccineBatch;
import com.vaxsafe.service.ColdChainManager;

import java.util.Random;

// Runnable task generating periodic temperature readings for the batch
public class SensorTask implements Runnable{

    //Associated vaccine batch
    private final VaccineBatch batch;
    private final ColdChainManager manager;
    
    // Random for simulating temperature fluctuations
    private final Random random = new Random();

    public SensorTask(VaccineBatch batch, ColdChainManager manager){
        this.batch = batch;
        this.manager = manager;
    }

    @Override
    public void run(){

        double temperature = 0 + (15 - 0) * random.nextDouble();

        System.out.println(
            "Batch " + batch.getBatchId() + 
            " | Temp: " + String.format("%.2f", temperature)
        );

        manager.processTemperature(batch, temperature);
    }
    
}

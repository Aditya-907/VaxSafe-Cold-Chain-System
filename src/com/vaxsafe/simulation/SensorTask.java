package com.vaxsafe.simulation;

import com.vaxsafe.model.VaccineBatch;
import java.util.Random;

// Runnable task generating periodic temperature readings for the batch
public class SensorTask implements Runnable{

    //Associated vaccine batch
    private final VaccineBatch batch;
    
    // Random for simulating temperature fluctuations
    private final Random random = new Random();

    public SensorTask(VaccineBatch batch){
        this.batch = batch;
    }

    @Override
    public void run(){

        double temperature = 0 + (15 - 0) * random.nextDouble();

        System.out.println(
            "Batch " + batch.getBatchId() + 
            " | Temp: " + String.format("%.2f", temperature)
        );
    }
    
}

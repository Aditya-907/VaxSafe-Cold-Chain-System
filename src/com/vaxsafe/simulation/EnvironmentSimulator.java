package com.vaxsafe.simulation;

import com.vaxsafe.model.VaccineBatch;
import com.vaxsafe.service.ColdChainManager;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//Manages the execution of sensor tasks for all batches
public class EnvironmentSimulator {

    //Thread pool handling sensor execution
    private final ExecutorService executor;
    private final ColdChainManager manager;
    
    public EnvironmentSimulator(int threadCount, ColdChainManager manager){
        this.executor = Executors.newScheduledThreadPool(threadCount);
        this.manager = manager;
    }

    //Starts simulation for fixed Duration
    public void startSimulation(List<VaccineBatch> batches, int durationSeconds){

        for(VaccineBatch batch : batches){

            // Each batch gets its own recurring sensor task
            executor.submit(() -> {

                long endTime = System.currentTimeMillis() + durationSeconds * 1000L;

                while (System.currentTimeMillis() < endTime) {

                    new SensorTask(batch, manager).run();

                    try{
                        //Simulation sensor interval (5 sec)
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            });
        }
        shutdownAfter(durationSeconds);
    }

    // shuts down executor
    private void shutdownAfter(int durationSeconds) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(durationSeconds);
                executor.shutdown();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }
    
}

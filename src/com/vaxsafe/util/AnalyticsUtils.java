package com.vaxsafe.util;
import java.util.List;

//Calculations on Temperature Data
public class AnalyticsUtils {

    // gas constant
    private static final double R = 8.314;

    //activation energy
    private static final double EA = 83144;

    // Mean Kinetic Temperature from recorded readings
    public static double calculateMKT(List<Double> temperatures){

        double sum = 0.0;

        for (double temp : temperatures){
            double tempKelvin = temp + 273.15;
            sum += Math.exp(-EA / (R * tempKelvin));
        }
        // average exponential value
        double average = sum /temperatures.size();

        // Final MKT Calculation
        double mktKelvin = -EA / (R * Math.log(average));

        return mktKelvin - 273.15;
    }
    
}

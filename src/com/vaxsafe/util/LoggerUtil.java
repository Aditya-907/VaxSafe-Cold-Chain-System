package com.vaxsafe.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class LoggerUtil {

    private static final String LOG_FILE = "vaxsafe.log";

    //Appending log messages with time
    public static void log(String message) {
        String logEntry = LocalDateTime.now() + " | " + message + "\n";

        try{
            Files.write(
                        Paths.get(LOG_FILE),
                        logEntry.getBytes(),
                        StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND
            );
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
}

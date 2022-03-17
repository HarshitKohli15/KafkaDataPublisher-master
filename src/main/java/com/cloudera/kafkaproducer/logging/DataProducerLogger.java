package com.cloudera.kafkaproducer.logging;

import com.cloudera.kafkaproducer.properties.GetConfigurations;
import org.apache.log4j.*;

import java.time.LocalDateTime;

public class DataProducerLogger {

    public DataProducerLogger(){

        /* Instantiating consoleAppender with PatternLayout,
        and Target set to System.out*/

        ConsoleAppender consoleAppender = new ConsoleAppender(new PatternLayout(GetConfigurations.getLoggingPattern()),
                GetConfigurations.getConsoleLoggingTarget());
        consoleAppender.setName(GetConfigurations.getAppName()); // Sets the name of the logging tool
        consoleAppender.setThreshold(Level.INFO);
        consoleAppender.activateOptions();
        Logger.getRootLogger().addAppender(consoleAppender);


        //File Appender

        FileAppender fileAppender = new FileAppender();

        fileAppender.setFile(GetConfigurations.getLogPath().trim() + LocalDateTime.now() + "_" + GetConfigurations.getAppName()
                + GetConfigurations.getLogExtension());
        fileAppender.setLayout(new PatternLayout(GetConfigurations.getLoggingPattern()));
        fileAppender.setThreshold(Level.INFO);

        fileAppender.activateOptions();
        Logger.getRootLogger().addAppender(fileAppender);


    }
}

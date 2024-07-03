package com.ayushi.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class LoggingConfig {

    private static final Logger logger = LogManager.getLogger(LoggingConfig.class);

    public static void adjustLoggingLevelBasedOnPatientId(String patientId) {
        if (patientId != null && !patientId.isEmpty()) {
            Configurator.setLevel("com.ayushi", org.apache.logging.log4j.Level.DEBUG);
            logger.info("Logging level set to DEBUG due to patientId presence");
        } else {
            logger.info("Logging level set to ERROR as patientId is absent");
            Configurator.setLevel("com.ayushi", org.apache.logging.log4j.Level.ERROR);
            logger.info("Logging level set to ERROR as patientId is absent");

        }
    }
}


package com.ayushi.service;

import com.ayushi.config.LoggingConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggingServiceImpl implements LoggingService {
    private static final Logger logger = LogManager.getLogger(LoggingServiceImpl.class);
    @Autowired
    private final SubjectIdManagerServiceImpl subjectIdManagerServiceImpl;

    public LoggingServiceImpl(SubjectIdManagerServiceImpl subjectIdManagerServiceImpl) {
        this.subjectIdManagerServiceImpl = subjectIdManagerServiceImpl;
    }

    @Override
    public String addPatient(String patientId) {
        if(subjectIdManagerServiceImpl.containsId(patientId)) {
            LoggingConfig.adjustLoggingLevelBasedOnPatientId(patientId);
            logger.error("This is an error message with patientId");
            logger.info("This is an info message with patientId");
            logger.debug("This is a debug message with patientId");
            Configurator.setLevel("com.ayushi", org.apache.logging.log4j.Level.INFO);
            return "Successfully set the logging level to DEBUG";
        }
        logger.error("addPatient: This is an error message without patientId");
        logger.info("addPatient : This is an info message without patientId");
        logger.debug("addPatient : This is a debug message without patientId");
        return "Current logging level is INFO only";

    }

    @Override
    public String fetchPatient() {
        logger.error("fetchPatient : This is an error message without patientId");
        logger.info("fetchPatient : This is an info message without patientId");
        logger.debug("fetchPatient : This is a debug message without patientId");
        return "method: fetchPatient - Successfully set the logging level to INFO";
    }
    @Override
    public String getPatient() {
        logger.error("getPatient: This is an error message without patientId");
        logger.info("getPatient: This is an info message without patientId");
        logger.debug("getPatient: This is a debug message without patientId");
        return "method: getPatient - Successfully set the logging level to INFO";
    }
}

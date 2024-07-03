package com.ayushi.service;

import org.springframework.stereotype.Service;

@Service
public interface LoggingService {
    String getPatient();
    String addPatient(String patientId);
    String fetchPatient();
}
